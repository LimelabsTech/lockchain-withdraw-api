package com.withdraw.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class IHotelReservationFactory extends Contract {
    private static final String BINARY = "0x";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected IHotelReservationFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IHotelReservationFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogCreateHotelReservationEventResponse> getLogCreateHotelReservationEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogCreateHotelReservation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogCreateHotelReservationEventResponse> responses = new ArrayList<LogCreateHotelReservationEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogCreateHotelReservationEventResponse typedResponse = new LogCreateHotelReservationEventResponse();
//            typedResponse.log = eventValues.getLog();
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
            public LogCreateHotelReservationEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogCancelHotelReservationEventResponse> responses = new ArrayList<LogCancelHotelReservationEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogCancelHotelReservationEventResponse typedResponse = new LogCancelHotelReservationEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._locRefundsRemainder = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogCancelHotelReservationEventResponse> logCancelHotelReservationEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogCancelHotelReservation", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogCancelHotelReservationEventResponse>() {
            public LogCancelHotelReservationEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogCancelHotelReservationEventResponse typedResponse = new LogCancelHotelReservationEventResponse();
                typedResponse.log = log;
                typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._customerAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._locRefundsRemainder = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<LogWithdrawalEventResponse> getLogWithdrawalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogWithdrawal", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogWithdrawalEventResponse> responses = new ArrayList<LogWithdrawalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogWithdrawalEventResponse typedResponse = new LogWithdrawalEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._withdrawnAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogWithdrawalEventResponse> logWithdrawalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogWithdrawal", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogWithdrawalEventResponse>() {
            public LogWithdrawalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogWithdrawalEventResponse typedResponse = new LogWithdrawalEventResponse();
                typedResponse.log = log;
                typedResponse._hotelReservationId = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._withdrawnAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<byte[]> hotelReservationIds(BigInteger param0) {
        final Function function = new Function("hotelReservationIds", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> implContract() {
        final Function function = new Function("implContract", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> upgradeImplementation(String _newImpl) {
        final Function function = new Function(
                "upgradeImplementation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newImpl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> locRefundsRemainder() {
        final Function function = new Function("locRefundsRemainder", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteCall<String> withdrawDestinationAddress() {
        final Function function = new Function("withdrawDestinationAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> withdrawerAddress() {
        final Function function = new Function("withdrawerAddress", 
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

    public RemoteCall<BigInteger> maxAllowedWithdrawCyclesCount() {
        final Function function = new Function("maxAllowedWithdrawCyclesCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setImplAddress(String implAddress) {
        final Function function = new Function(
                "setImplAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(implAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getImplAddress() {
        final Function function = new Function("getImplAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createHotelReservation(byte[] _hotelReservationId, BigInteger _reservationCostLOC, BigInteger _reservationStartDate, BigInteger _reservationEndDate, BigInteger _daysBeforeStartForRefund, BigInteger _refundPercentage, byte[] _hotelId, byte[] _roomId, BigInteger _numberOfTravelers) {
        final Function function = new Function(
                "createHotelReservation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_hotelReservationId), 
                new org.web3j.abi.datatypes.generated.Uint256(_reservationCostLOC), 
                new org.web3j.abi.datatypes.generated.Uint256(_reservationStartDate), 
                new org.web3j.abi.datatypes.generated.Uint256(_reservationEndDate), 
                new org.web3j.abi.datatypes.generated.Uint256(_daysBeforeStartForRefund), 
                new org.web3j.abi.datatypes.generated.Uint256(_refundPercentage), 
                new org.web3j.abi.datatypes.generated.Bytes32(_hotelId), 
                new org.web3j.abi.datatypes.generated.Bytes32(_roomId), 
                new org.web3j.abi.datatypes.generated.Uint256(_numberOfTravelers)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<byte[]> getHotelReservationId(BigInteger index) {
        final Function function = new Function("getHotelReservationId", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> getHotelReservationContractAddress(byte[] _hotelReservationId) {
        final Function function = new Function("getHotelReservationContractAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_hotelReservationId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getHotelReservationsCount() {
        final Function function = new Function("getHotelReservationsCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setLOCTokenContractAddress(String locTokenContractAddress) {
        final Function function = new Function(
                "setLOCTokenContractAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(locTokenContractAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> cancelHotelReservation(byte[] _hotelReservationId) {
        final Function function = new Function(
                "cancelHotelReservation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_hotelReservationId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdraw(List<String> _hotelReservations) {
        final Function function = new Function(
                "withdraw", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_hotelReservations, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getLocRemainderAmount() {
        final Function function = new Function("getLocRemainderAmount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setWithdrawDestinationAddress(String _withdrawDestinationAddress) {
        final Function function = new Function(
                "setWithdrawDestinationAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_withdrawDestinationAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setWithdrawerAddress(String _withdrawerAddress) {
        final Function function = new Function(
                "setWithdrawerAddress", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_withdrawerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getWithdrawerAddress() {
        final Function function = new Function("getWithdrawerAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getWithdrawDestinationAddress() {
        final Function function = new Function("getWithdrawDestinationAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setmaxAllowedWithdrawCyclesCount(BigInteger _maxAllowedWithdrawCyclesCount) {
        final Function function = new Function(
                "setmaxAllowedWithdrawCyclesCount", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_maxAllowedWithdrawCyclesCount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getmaxAllowedWithdrawCyclesCount() {
        final Function function = new Function("getmaxAllowedWithdrawCyclesCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> validateWithdraw(List<String> _hotelReservations) {
        final Function function = new Function("validateWithdraw", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_hotelReservations, org.web3j.abi.datatypes.Address.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<IHotelReservationFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IHotelReservationFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IHotelReservationFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IHotelReservationFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static IHotelReservationFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IHotelReservationFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IHotelReservationFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IHotelReservationFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

        public BigInteger _locRefundsRemainder;
    }

    public static class LogWithdrawalEventResponse {
        public Log log;

        public byte[] _hotelReservationId;

        public BigInteger _withdrawnAmount;
    }
}
