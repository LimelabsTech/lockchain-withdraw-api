package com.withdraw.api;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class HotelReservationFactoryProxy extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6040516020806101a98339810160405280805160008054600160a060020a03909216600160a060020a03199092169190911790555050610155806100546000396000f3006060604052600436106100405763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416639e72370b8114610096575b600080546100949173ffffffffffffffffffffffffffffffffffffffff9091169036806020601f820181900481020160405190810160405281815292919060208401838380828437506100d2945050505050565b005b34156100a157600080fd5b6100a961010d565b60405173ffffffffffffffffffffffffffffffffffffffff909116815260200160405180910390f35b813b80156100df576100e4565b600080fd5b50600080825160208401856127105a03f43d604051816000823e828015610109578282f35b8282fd5b60005473ffffffffffffffffffffffffffffffffffffffff16815600a165627a7a72305820854148f2a935be9d1b8e465741d101d936ce4823b97f2f514fb6984b3f5478e60029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected HotelReservationFactoryProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HotelReservationFactoryProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> contractImplementation() {
        final Function function = new Function("contractImplementation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<HotelReservationFactoryProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String initialImplementation) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(initialImplementation)));
        return deployRemoteCall(HotelReservationFactoryProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<HotelReservationFactoryProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String initialImplementation) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(initialImplementation)));
        return deployRemoteCall(HotelReservationFactoryProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static HotelReservationFactoryProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HotelReservationFactoryProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static HotelReservationFactoryProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HotelReservationFactoryProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
