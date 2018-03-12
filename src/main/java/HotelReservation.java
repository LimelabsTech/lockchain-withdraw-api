
import java.io.BufferedWriter;
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import com.withdraw.api.*;
import org.web3j.*;

public class HotelReservation {

	//The same configuration as the rest-api, except this should be the withdrawer user
	static String jsonString = "{ \"version\": 3, \"id\": \"1ddf0087-79e0-48d9-a84b-5d364075a804\", \"address\": \"627306090abab3a6e1400e9345bc60c78a8bef57\", \"Crypto\": { \"ciphertext\": \"6d845d338f2cfc526adc5d49b5f95c13690b59ef56c9eb2c79e4ff7740adcc77\", \"cipherparams\": { \"iv\": \"f506358d43a8cd8bea70b34b3bd97190\" }, \"cipher\": \"aes-128-ctr\", \"kdf\": \"scrypt\", \"kdfparams\": { \"dklen\": 32, \"salt\": \"e15ccf22e4e35a5a321885c562e265d9fd7d0fbede7894e9195108bbf40563a2\", \"n\": 1024, \"r\": 8, \"p\": 1 }, \"mac\": \"2295347e6e31672df9e9e651f6d6593d769c848e9ceb2b15dd5e09fd2aaa4992\" } }";
	static String password = "123456789";
	//This is the address of teh contract when deployed
	static String iHotelReservationFactoryProxyAddress = "0xeec918d74c746167564401103096d45bbd494b74";
	// This should be changed for different environments, can be used with a config file. This is the same as the ress-api
	static Web3j web3 = Web3j.build(new HttpService());
	static int cylcesCount;
	static int hotelReservationsSize;
	static List<String> hotelReservationsForWithdrawTotal = new ArrayList<>();

	//Method for creating the creadentials for interacting with the contract
	public static Credentials createCredentials() throws IOException, CipherException {

		File tempWalletFile = File.createTempFile("temp-wallet-file", ".tmp");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempWalletFile));
		writer.write(jsonString);
		writer.close();
		tempWalletFile.deleteOnExit();

		Credentials credentials = WalletUtils.loadCredentials(password, tempWalletFile);
		return credentials;
	}

	//This is called by the owner of the contract to set the withdrawer user
	public static TransactionReceipt setWithdrawer() throws IOException, CipherException, HotelReservationException {
		IHotelReservationFactory hotelReservationFactory = IHotelReservationFactory.load(
				iHotelReservationFactoryProxyAddress, web3, createCredentials(), ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		TransactionReceipt setWithdrawer = null;
		try {
			setWithdrawer = hotelReservationFactory.setWithdrawerAddress("0x627306090abab3a6e1400e9345bc60c78a8bef57")
					.send();
		} catch (Exception e) {
			throw new HotelReservationException("Setting the withdrawer address failed");
		}
		return setWithdrawer;
	}
	
	//This is called by the owner to set the withdrawer destination address (to whom the money should be withdrawn)
	public static TransactionReceipt setWithdrawerDestinationAddress()
			throws IOException, CipherException, HotelReservationException {
		IHotelReservationFactory hotelReservationFactory = IHotelReservationFactory.load(
				iHotelReservationFactoryProxyAddress, web3, createCredentials(), ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		TransactionReceipt setWithdrawerDestinationAddress = null;
		try {
			setWithdrawerDestinationAddress = hotelReservationFactory
					.setWithdrawDestinationAddress("0xf17f52151EbEF6C7334FAD080c5704D77216b732").send();
		} catch (Exception e) {
			throw new HotelReservationException("Setting the withdrawer destination address failed");
		}
		return setWithdrawerDestinationAddress;
	}

	//This is called by the owner, to set the max number for withdraws at the same time
	public static TransactionReceipt setMaxAllowedCyclesCount()
			throws HotelReservationException, IOException, CipherException {
		IHotelReservationFactory hotelReservationFactory = IHotelReservationFactory.load(
				iHotelReservationFactoryProxyAddress, web3, createCredentials(), ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		TransactionReceipt cyclesCount = null;
		BigInteger cycles = BigInteger.valueOf(50);

		try {
			cyclesCount = hotelReservationFactory.setmaxAllowedWithdrawCyclesCount(cycles).send();
			System.out.println(cyclesCount);
		} catch (Exception e) {
			throw new HotelReservationException("Setting the cycles count failed");
		}
		return cyclesCount;
	}
	
	
	public static void withdrawAll() throws Exception {

		hotelReservationsForWithdrawTotal = prepareArrayForWithdraw();

		while (hotelReservationsForWithdrawTotal.size() > 0) {
			withdraw();
		}

	}

	//This functions prepares the array of reservations that should be withdrawn. All single validations should pass the validation of the contract
	public static List<String> prepareArrayForWithdraw() throws HotelReservationException {

		IHotelReservationFactory hotelReservationFactory = null;
		try {
			hotelReservationFactory = IHotelReservationFactory.load(iHotelReservationFactoryProxyAddress, web3,
					createCredentials(), ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CipherException e) {
			e.printStackTrace();
		}

		BigInteger activeReservationsCount = null;
		try {
			activeReservationsCount = hotelReservationFactory.getHotelReservationsCount().send();
		} catch (Exception e1) {
			throw new HotelReservationException("Getting the reservations count failed");

		}

		List<String> hotelReservationsForWithdraw = new ArrayList<>();

		for (int i = 0; i < activeReservationsCount.intValue(); i++) {

			BigInteger reservationId = BigInteger.valueOf(i);
			byte[] hotelReservationId = null;
			try {
				
				hotelReservationId = hotelReservationFactory.getHotelReservationId(reservationId).send();
		
			} catch (Exception e) {
				throw new HotelReservationException("Getting the Reservation ID failed");
			}

			String hotelReservationAddress = null;
			try {
				hotelReservationAddress = hotelReservationFactory.getHotelReservationContractAddress(hotelReservationId)
						.send();
			} catch (Exception e) {
				throw new HotelReservationException("Getting the hotel reservation address failed");
			}
			List<String> hotelReservations = new ArrayList<>();
			hotelReservations.add(new String(hotelReservationAddress));
			Boolean validateWithdrawSingle = false;
			try {
				validateWithdrawSingle = hotelReservationFactory.validateWithdraw(hotelReservations).send();
				
			} catch (Exception e) {
			}
			if (validateWithdrawSingle) {
				hotelReservationsForWithdraw.add(new String(hotelReservationAddress));
			}
		}

		try {
			
			hotelReservationFactory.validateWithdraw(hotelReservationsForWithdraw).send();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HotelReservationException("The validation for the whole withdraw has failed");
		}
		return hotelReservationsForWithdraw;
	}

	public static TransactionReceipt withdraw() throws HotelReservationException {

		IHotelReservationFactory hotelReservationFactory = null;
		try {
			hotelReservationFactory = IHotelReservationFactory.load(iHotelReservationFactoryProxyAddress, web3,
					createCredentials(), ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CipherException e) {
			e.printStackTrace();
		}

		BigInteger maxCyclesCount = null;
		try {
			
			maxCyclesCount = hotelReservationFactory.getmaxAllowedWithdrawCyclesCount().send();
		} catch (Exception e) {
			throw new HotelReservationException("Getting the max allowed cycles count failed");
		}
		cylcesCount = maxCyclesCount.intValue();

		if (maxCyclesCount.intValue() > hotelReservationsForWithdrawTotal.size()) {
			cylcesCount = hotelReservationsForWithdrawTotal.size();
		}
		List<String> totalReservaationsForWithdraw = new ArrayList<>();
		for (int i = 0; i < cylcesCount; i++) {
			String hotelReservation = hotelReservationsForWithdrawTotal.get(i);
			totalReservaationsForWithdraw.add(hotelReservation);
			hotelReservationsForWithdrawTotal.remove(i);
		}

		TransactionReceipt result;
		try {
			
			result = hotelReservationFactory.withdraw(totalReservaationsForWithdraw).send();
		} catch (Exception e) {
			throw new HotelReservationException("The withdraw has failed");
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		setWithdrawer();
		setWithdrawerDestinationAddress();
		setMaxAllowedCyclesCount();
		withdrawAll();
	}
}
