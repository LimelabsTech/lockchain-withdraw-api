package com.withdraw.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class IHotelReservation extends Contract {
    private static final String BINARY = "0x";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    protected IHotelReservation(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IHotelReservation(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogCreateHotelReservationEventResponse> getLogCreateHotelReservationEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogCreateHotelReservation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<LogCreateHotelReservationEventResponse> responses = new ArrayList<LogCreateHotelReservationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogCreateHotelReservationEventResponse typedResponse = new LogCreateHotelReservationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._reservationStartDate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._reservationEndDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogCreateHotelReservationEventResponse> logCreateHotelReservationEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogCreateHotelReservation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogCreateHotelReservationEventResponse>() {
            @Override
            public LogCreateHotelReservationEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                LogCreateHotelReservationEventResponse typedResponse = new LogCreateHotelReservationEventResponse();
                typedResponse.log = log;
                typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._reservationStartDate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse._reservationEndDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public List<LogCancelHotelReservationEventResponse> getLogCancelHotelReservationEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogCancelHotelReservation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<LogCancelHotelReservationEventResponse> responses = new ArrayList<LogCancelHotelReservationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogCancelHotelReservationEventResponse typedResponse = new LogCancelHotelReservationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogCancelHotelReservationEventResponse> logCancelHotelReservationEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogCancelHotelReservation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogCancelHotelReservationEventResponse>() {
            @Override
            public LogCancelHotelReservationEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                LogCancelHotelReservationEventResponse typedResponse = new LogCancelHotelReservationEventResponse();
                typedResponse.log = log;
                typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> upgradeImplementation(String _newImpl) {
        final Function function = new Function(
                "upgradeImplementation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newImpl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function("getOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getImplementation() {
        final Function function = new Function("getImplementation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> init() {
        final Function function = new Function(
                "init", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createHotelReservation(byte[] _hotelReservationId, String customerAddress, BigInteger _reservationCostLOC, BigInteger _reservationStartDate, BigInteger _reservationEndDate, List<BigInteger> _daysBeforeStartForRefund, List<BigInteger> _refundPercentages, byte[] _hotelId, byte[] _roomId, BigInteger _numberOfTravelers) {
        final Function function = new Function(
                "createHotelReservation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_hotelReservationId), 
                new org.web3j.abi.datatypes.Address(customerAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_reservationCostLOC), 
                new org.web3j.abi.datatypes.generated.Uint256(_reservationStartDate), 
                new org.web3j.abi.datatypes.generated.Uint256(_reservationEndDate), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_daysBeforeStartForRefund, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_refundPercentages, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(_hotelId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_roomId), 
                new org.web3j.abi.datatypes.generated.Uint256(_numberOfTravelers)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple11<byte[], String, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<BigInteger>, byte[], byte[], BigInteger, Boolean>> getHotelReservation() {
        final Function function = new Function("getHotelReservation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple11<byte[], String, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<BigInteger>, byte[], byte[], BigInteger, Boolean>>(
                new Callable<Tuple11<byte[], String, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<BigInteger>, byte[], byte[], BigInteger, Boolean>>() {
                    @Override
                    public Tuple11<byte[], String, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<BigInteger>, byte[], byte[], BigInteger, Boolean> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple11<byte[], String, BigInteger, BigInteger, BigInteger, List<BigInteger>, List<BigInteger>, byte[], byte[], BigInteger, Boolean>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                convertToNative((List<Uint256>) results.get(5).getValue()), 
                                convertToNative((List<Uint256>) results.get(6).getValue()), 
                                (byte[]) results.get(7).getValue(), 
                                (byte[]) results.get(8).getValue(), 
                                (BigInteger) results.get(9).getValue(), 
                                (Boolean) results.get(10).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> validateCancelation(String _customerAddress) {
        final Function function = new Function("validateCancelation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_customerAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> validateRefundForCreation(List<BigInteger> _daysBeforeStartForRefund, List<BigInteger> _refundPercentages, BigInteger _startDate) {
        final Function function = new Function("validateRefundForCreation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_daysBeforeStartForRefund, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_refundPercentages, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_startDate)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> getLocToBeRefunded() {
        final Function function = new Function("getLocToBeRefunded", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<String> getCustomerAddress() {
        final Function function = new Function("getCustomerAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> validateReservationForWithdraw() {
        final Function function = new Function("validateReservationForWithdraw", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getLocForWithdraw() {
        final Function function = new Function("getLocForWithdraw", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> getHotelReservationId() {
        final Function function = new Function("getHotelReservationId", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> getHotelReservationCost() {
        final Function function = new Function("getHotelReservationCost", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> validateDispute(String _customerAddress) {
        final Function function = new Function("validateDispute", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_customerAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> getReservationDisputeStatus() {
        final Function function = new Function("getReservationDisputeStatus", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setReservationDisputeStatus(Boolean _isDisputeOpen) {
        final Function function = new Function(
                "setReservationDisputeStatus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(_isDisputeOpen)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<IHotelReservation> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IHotelReservation.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IHotelReservation> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IHotelReservation.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static IHotelReservation load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IHotelReservation(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IHotelReservation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IHotelReservation(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LogCreateHotelReservationEventResponse {
        public Log log;

        public byte[] _hotelReservationId;

        public String _customerAddress;

        public BigInteger _reservationStartDate;

        public BigInteger _reservationEndDate;
    }

    public static class LogCancelHotelReservationEventResponse {
        public Log log;

        public byte[] _hotelReservationId;

        public String _customerAddress;
    }
}
