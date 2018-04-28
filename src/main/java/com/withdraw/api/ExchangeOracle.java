package com.withdraw.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class ExchangeOracle extends Contract {
    private static final String BINARY = "0x60606040526000805460a060020a61ffff02191675010000000000000000000000000000000000000000001781556001556103e8600255341561004157600080fd5b6040516020806106698339810160405280805160008054600160a060020a03191633600160a060020a03161781559092508211905061007f57600080fd5b6001556105d8806100916000396000f3006060604052600436106100ae5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166321f222dd81146100b35780632c4e722e146100d857806334fcf437146100eb5780633f4ba83a146101155780635c975abb1461012a5780638456cb591461013d578063893d20e8146101505780638da5cb5b1461017f578063c885cc8614610192578063ebbe05d0146101a5578063f2fde38b146101bb575b600080fd5b34156100be57600080fd5b6100c66101da565b60405190815260200160405180910390f35b34156100e357600080fd5b6100c66101e0565b34156100f657600080fd5b610101600435610210565b604051901515815260200160405180910390f35b341561012057600080fd5b6101286102c5565b005b341561013557600080fd5b610101610355565b341561014857600080fd5b610128610376565b341561015b57600080fd5b61016361041c565b604051600160a060020a03909116815260200160405180910390f35b341561018a57600080fd5b61016361042b565b341561019d57600080fd5b61010161043a565b34156101b057600080fd5b61010160043561045c565b34156101c657600080fd5b610128600160a060020a0360043516610511565b60025481565b6000805474010000000000000000000000000000000000000000900460ff161561020957600080fd5b5060015490565b60008054819033600160a060020a0390811691161461022e57600080fd5b60005474010000000000000000000000000000000000000000900460ff161561025657600080fd5b6000831161026357600080fd5b5060018054908390557f1add11389052ad288243d81652af9f037bb5e3dcdd3b45705c02a99d0734469e8184336040519283526020830191909152600160a060020a03166040808301919091526060909101905180910390a150600192915050565b60005433600160a060020a039081169116146102e057600080fd5b60005474010000000000000000000000000000000000000000900460ff16151561030957600080fd5b6000805474ff0000000000000000000000000000000000000000191690557f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b60005474010000000000000000000000000000000000000000900460ff1681565b60005433600160a060020a0390811691161461039157600080fd5b60005474010000000000000000000000000000000000000000900460ff16156103b957600080fd5b6000805474ff00000000000000000000000000000000000000001916740100000000000000000000000000000000000000001790557f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b600054600160a060020a031690565b600054600160a060020a031681565b6000547501000000000000000000000000000000000000000000900460ff1681565b60008054819033600160a060020a0390811691161461047a57600080fd5b60005474010000000000000000000000000000000000000000900460ff16156104a257600080fd5b600083116104af57600080fd5b5060028054908390557f22654461af63e066463493e0acb56570d6877a0a2243bc5ee3256c590333a3c18382336040519283526020830191909152600160a060020a03166040808301919091526060909101905180910390a150600192915050565b60005433600160a060020a0390811691161461052c57600080fd5b600160a060020a038116151561054157600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911790555600a165627a7a72305820d1aa4b633f915ac9164aec031433c350b9ee24099e433bad8c3446d4ff8a690c0029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected ExchangeOracle(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ExchangeOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogRateChangedEventResponse> getLogRateChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogRateChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogRateChangedEventResponse> responses = new ArrayList<LogRateChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogRateChangedEventResponse typedResponse = new LogRateChangedEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.oldRate = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newRate = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.changer = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogRateChangedEventResponse> logRateChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogRateChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogRateChangedEventResponse>() {
            @Override
            public LogRateChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogRateChangedEventResponse typedResponse = new LogRateChangedEventResponse();
                typedResponse.log = log;
                typedResponse.oldRate = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newRate = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.changer = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<LogMinWeiAmountChangedEventResponse> getLogMinWeiAmountChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogMinWeiAmountChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogMinWeiAmountChangedEventResponse> responses = new ArrayList<LogMinWeiAmountChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogMinWeiAmountChangedEventResponse typedResponse = new LogMinWeiAmountChangedEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.oldMinWeiAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newMinWeiAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.changer = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogMinWeiAmountChangedEventResponse> logMinWeiAmountChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogMinWeiAmountChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogMinWeiAmountChangedEventResponse>() {
            @Override
            public LogMinWeiAmountChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogMinWeiAmountChangedEventResponse typedResponse = new LogMinWeiAmountChangedEventResponse();
                typedResponse.log = log;
                typedResponse.oldMinWeiAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newMinWeiAmount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.changer = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<PauseEventResponse> getPauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PauseEventResponse> responses = new ArrayList<PauseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PauseEventResponse typedResponse = new PauseEventResponse();
//            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PauseEventResponse> pauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PauseEventResponse>() {
            @Override
            public PauseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PauseEventResponse typedResponse = new PauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public List<UnpauseEventResponse> getUnpauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UnpauseEventResponse> responses = new ArrayList<UnpauseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UnpauseEventResponse typedResponse = new UnpauseEventResponse();
//            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnpauseEventResponse>() {
            @Override
            public UnpauseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UnpauseEventResponse typedResponse = new UnpauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> minWeiAmount() {
        final Function function = new Function("minWeiAmount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> unpause() {
        final Function function = new Function(
                "unpause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function("paused", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> pause() {
        final Function function = new Function(
                "pause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function("getOwner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isLocOracle() {
        final Function function = new Function("isLocOracle", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<ExchangeOracle> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialRate) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialRate)));
        return deployRemoteCall(ExchangeOracle.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<ExchangeOracle> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialRate) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialRate)));
        return deployRemoteCall(ExchangeOracle.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<BigInteger> rate() {
        final Function function = new Function("rate", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setRate(BigInteger newRate) {
        final Function function = new Function(
                "setRate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newRate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setMinWeiAmount(BigInteger newMinWeiAmount) {
        final Function function = new Function(
                "setMinWeiAmount", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newMinWeiAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static ExchangeOracle load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExchangeOracle(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ExchangeOracle load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ExchangeOracle(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LogRateChangedEventResponse {
        public Log log;

        public BigInteger oldRate;

        public BigInteger newRate;

        public String changer;
    }

    public static class LogMinWeiAmountChangedEventResponse {
        public Log log;

        public BigInteger oldMinWeiAmount;

        public BigInteger newMinWeiAmount;

        public String changer;
    }

    public static class PauseEventResponse {
        public Log log;
    }

    public static class UnpauseEventResponse {
        public Log log;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
