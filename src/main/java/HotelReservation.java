
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

import com.withdraw.api.IHotelReservationFactory;

public class HotelReservation {

	//The same configuration as the rest-api, except this should be the withdrawer user
	static String jsonString = "{\"version\":3,\"id\":\"d44f162d-1f91-4ade-9d5f-414661295df0\",\"address\":\"b63df2068d209f8ff3925c4c9dbbabfd31301825\",\"Crypto\":{\"ciphertext\":\"2d40317fc74b4ea71930a0a6681507addc103e127e65a663cf731537ef79726d\",\"cipherparams\":{\"iv\":\"f90df4df3a67d85e7e34f84a7c0b15fd\"},\"cipher\":\"aes-128-ctr\",\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"salt\":\"473b462c67127e8260fea0ff7fe716d17b6792278160937a29d8875294d0f92a\",\"n\":8192,\"r\":8,\"p\":1},\"mac\":\"b94eada113e11314895cb559bd79e72c0dc27eb15ed4ebb666ffb80977859f13\"}}";
	static String password = "123456789";
	//This is the address of teh contract when deployed
	static String iHotelReservationFactoryProxyAddress = "0xb9652eea9e4733ae3d0711e58037d4e8abd4c6d9";
	// This should be changed for different environments, can be used with a config file. This is the same as the ress-api
	static Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/Up5uvBHSCSqtOmnlhL87"));
//	static Web3j web3 = Web3j.build(new HttpService());
	static int cylcesCount;
	static int hotelReservationsSize;
	static List<String> hotelReservationsForWithdrawTotal = new ArrayList<>();
	
	static HttpService gasStation = new HttpService("https://ethgasstation.info/json/ethgasAPI.json");
	
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
	public static TransactionReceipt setWithdrawer() throws IOException, CipherException, SmartContractException {
		IHotelReservationFactory hotelReservationFactory = IHotelReservationFactory.load(
				iHotelReservationFactoryProxyAddress, web3, createCredentials(), ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		TransactionReceipt setWithdrawer = null;
		System.out.println(hotelReservationFactory);
		try {
			setWithdrawer = hotelReservationFactory.setWithdrawerAddress("0xb63df2068d209f8ff3925c4c9dbbabfd31301825")
					.send();
		} catch (Exception e) {
			throw new SmartContractException("Setting the withdrawer address failed");
		}
		System.out.println( setWithdrawer + "WITHDRAWE");
		return setWithdrawer;
	}
	
	//This is called by the owner to set the withdrawer destination address (to whom the money should be withdrawn)
	public static TransactionReceipt setWithdrawerDestinationAddress()
			throws IOException, CipherException, SmartContractException {
		IHotelReservationFactory hotelReservationFactory = IHotelReservationFactory.load(
				iHotelReservationFactoryProxyAddress, web3, createCredentials(), ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		TransactionReceipt setWithdrawerDestinationAddress = null;
		try {
			setWithdrawerDestinationAddress = hotelReservationFactory
					.setWithdrawDestinationAddress("0xb63df2068d209f8ff3925c4c9dbbabfd31301825").send();
		} catch (Exception e) {
			throw new SmartContractException("Setting the withdrawer destination address failed");
		}
		System.out.println( setWithdrawerDestinationAddress + "WITHDRAWE DESTINATION");
		return setWithdrawerDestinationAddress;
	}

	//This is called by the owner, to set the max number for withdraws at the same time
	public static TransactionReceipt setMaxAllowedCyclesCount()
			throws SmartContractException, IOException, CipherException {
		IHotelReservationFactory hotelReservationFactory = IHotelReservationFactory.load(
				iHotelReservationFactoryProxyAddress, web3, createCredentials(), ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT);
		TransactionReceipt cyclesCount = null;
		BigInteger cycles = BigInteger.valueOf(50);

		try {
			cyclesCount = hotelReservationFactory.setmaxAllowedWithdrawCyclesCount(cycles).send();
		} catch (Exception e) {
			throw new SmartContractException("Setting the cycles count failed");
		}
		System.out.println(cyclesCount + "CYCLES COUNT");
		return cyclesCount;
	}
	
	
	public static void withdrawAll() throws Exception {

		hotelReservationsForWithdrawTotal = prepareArrayForWithdraw();
		System.out.println(hotelReservationsForWithdrawTotal + "ARAY TO WITHDRAW TOTAL");
		while (hotelReservationsForWithdrawTotal.size() > 0) {
			withdraw();
		}

	}

	//This functions prepares the array of reservations that should be withdrawn. All single validations should pass the validation of the contract
	public static List<String> prepareArrayForWithdraw() throws SmartContractException {

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
			System.out.println(hotelReservationFactory.getHotelReservationsCount().send());
			activeReservationsCount = hotelReservationFactory.getHotelReservationsCount().send();
		} catch (Exception e1) {
			System.out.println(e1);
			throw new SmartContractException("Getting the reservations count failed");

		}

		List<String> hotelReservationsForWithdraw = new ArrayList<>();

		for (int i = 0; i < activeReservationsCount.intValue(); i++) {

			BigInteger reservationId = BigInteger.valueOf(i);
			byte[] hotelReservationId = null;
			try {
				
				hotelReservationId = hotelReservationFactory.getHotelReservationId(reservationId).send();
				System.out.println(hotelReservationId + "HOTEL RESERVAION ID");
		
			} catch (Exception e) {
				throw new SmartContractException("Getting the Reservation ID failed");
			}

			String hotelReservationAddress = null;
			try {
				hotelReservationAddress = hotelReservationFactory.getHotelReservationContractAddress(hotelReservationId)
						.send();
			} catch (Exception e) {
				throw new SmartContractException("Getting the hotel reservation address failed");
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
			throw new SmartContractException("The validation for the whole withdraw has failed");
		}
		return hotelReservationsForWithdraw;
	}

	public static TransactionReceipt withdraw() throws SmartContractException {

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
			throw new SmartContractException("Getting the max allowed cycles count failed");
		}
		cylcesCount = maxCyclesCount.intValue();

		if (maxCyclesCount.intValue() > hotelReservationsForWithdrawTotal.size()) {
			cylcesCount = hotelReservationsForWithdrawTotal.size();
		}
		System.out.println(cylcesCount + "THE CYCLES COUNT");
		List<String> totalReservaationsForWithdraw = new ArrayList<>();
		for (int i = 0; i < cylcesCount; i++) {
			System.out.println(hotelReservationsForWithdrawTotal);
			System.out.println(i);
			String hotelReservation = hotelReservationsForWithdrawTotal.get(0);
			totalReservaationsForWithdraw.add(hotelReservation);
			hotelReservationsForWithdrawTotal.remove(0);
		}

		TransactionReceipt result;
		try {
			System.out.println(totalReservaationsForWithdraw);
			result = hotelReservationFactory.withdraw(totalReservaationsForWithdraw).send();
		} catch (Exception e) {
			throw new SmartContractException("The withdraw has failed");
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) throws Exception {
//		setWithdrawer();
//		setWithdrawerDestinationAddress();
//		setMaxAllowedCyclesCount();
//		withdrawAll();
	}
}
