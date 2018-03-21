
import java.io.BufferedWriter;
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeZone;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.utils.Numeric;

import com.withdraw.api.ExchangeOracle;
import com.withdraw.api.LOCExchange;

public class LocExchange {

	// The same configuration as the rest-api, except this should be the withdrawer
	// user
	static String jsonString = "{\"version\":3,\"id\":\"d44f162d-1f91-4ade-9d5f-414661295df0\",\"address\":\"b63df2068d209f8ff3925c4c9dbbabfd31301825\",\"Crypto\":{\"ciphertext\":\"2d40317fc74b4ea71930a0a6681507addc103e127e65a663cf731537ef79726d\",\"cipherparams\":{\"iv\":\"f90df4df3a67d85e7e34f84a7c0b15fd\"},\"cipher\":\"aes-128-ctr\",\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"salt\":\"473b462c67127e8260fea0ff7fe716d17b6792278160937a29d8875294d0f92a\",\"n\":8192,\"r\":8,\"p\":1},\"mac\":\"b94eada113e11314895cb559bd79e72c0dc27eb15ed4ebb666ffb80977859f13\"}}";
	static String password = "123456789";
	// This is the address of teh contract when deployed
	static String locExchangeContractAddress = "0x99c9c310d8810e703512a115de8accf077bb51d9";
	static String owner = "0xb63df2068d209f8ff3925c4c9dbbabfd31301825";

	static String exchangeOracleContractAddress = "0xdcd50ed649f65f15d5e6da63ed1c535b6cf2c0a0";
	// This should be changed for different environments, can be used with a config
	// file. This is the same as the rest-api
	static Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/Up5uvBHSCSqtOmnlhL87"));
	// static Web3j web3 = Web3j.build(new HttpService()); 

	public static Credentials createCredentials() throws IOException, CipherException {

		File tempWalletFile = File.createTempFile("temp-wallet-file", ".tmp");
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempWalletFile));
		writer.write(jsonString);
		writer.close();
		tempWalletFile.deleteOnExit();

		Credentials credentials = WalletUtils.loadCredentials(password, tempWalletFile);
		return credentials;
	}

	public static TransactionReceipt withdrawLoc() throws SmartContractException, IOException, CipherException {

		LOCExchange locExchangeContract = LOCExchange.load(locExchangeContractAddress, web3, createCredentials(),
				ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		BigInteger amount = new BigInteger("400000000000000000");
		TransactionReceipt withdrawnLoc = null;
		try {
			withdrawnLoc = locExchangeContract.withdrawLOC(amount).send();
		} catch (Exception e) {
			throw new SmartContractException("Withdrawing the LOC failed");
		}

		return withdrawnLoc;
	}

	// Setting/ Changing the rate of the ExchangeOracle contract
	public static TransactionReceipt setRate() throws SmartContractException, IOException, CipherException {

		ExchangeOracle exchangeOracleContract = ExchangeOracle.load(exchangeOracleContractAddress, web3,
				createCredentials(), ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		TransactionReceipt newRate = null;
		try {
			newRate = exchangeOracleContract.setRate(BigInteger.valueOf(5000)).send();
		} catch (Exception e) {
			throw new SmartContractException("Setting the rate failed");
		}
		return newRate;
	}

	// Getting the rate of the ExchangeOracle contract
	public static BigInteger getRate() throws SmartContractException, IOException, CipherException {
		ExchangeOracle exchangeOracleContract = ExchangeOracle.load(exchangeOracleContractAddress, web3,
				createCredentials(), ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT);

		BigInteger newRate;
		try {
			newRate = exchangeOracleContract.rate().send();
		} catch (Exception e) {
			throw new SmartContractException("Getting the rate failed");
		}
		return newRate;
	}

	// Send Ether to the Exchange contract
	public static String sendEther()
			throws InterruptedException, IOException, TransactionException, CipherException, SmartContractException {
		// The amount the user wants to send to the contract
		String amount = "3000000000000000000";

		EthGetTransactionCount ethGetTransactionCount = web3
				.ethGetTransactionCount(owner, DefaultBlockParameterName.PENDING).send();
		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
		RawTransaction sendEther = RawTransaction.createEtherTransaction(nonce, ManagedTransaction.GAS_PRICE,
				Contract.GAS_LIMIT, locExchangeContractAddress, new BigInteger(amount));
		byte[] signedMessage = TransactionEncoder.signMessage(sendEther, createCredentials());
		String hexValue = Numeric.toHexString(signedMessage);
		EthSendTransaction ethSendTransaction;
		try {
			ethSendTransaction = web3.ethSendRawTransaction(hexValue).sendAsync().get();
		} catch (ExecutionException e) {
			throw new SmartContractException("Sending ether to the smart contract failed");
		}
		String transactionHash = ethSendTransaction.getTransactionHash();
		return transactionHash;
	}

	public static void main(String[] args) throws Exception {
		setRate();
		getRate();
		withdrawLoc();
		sendEther();
	}

}
