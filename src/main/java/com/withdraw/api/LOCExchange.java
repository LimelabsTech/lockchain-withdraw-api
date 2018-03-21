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
public class LOCExchange extends Contract {
    private static final String BINARY = "0x60606040526002805460a060020a60ff0219169055341561001f57600080fd5b604051604080611133833981016040528080519190602001805160028054600160a060020a03191633600160a060020a03908116919091179091559092508391506000908216151561007057600080fd5b5060038054600160a060020a031916600160a060020a038316908117909155819063c885cc866000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15156100e657600080fd5b6102c65a03f115156100f757600080fd5b50505060405180519050151561010c57600080fd5b505060048054600160a060020a031916600160a060020a039290921691909117905550610ff58061013e6000396000f3006060604052600436106101195763ffffffff60e060020a600035041663218ab80b811461013257806321f222dd146101575780632c4e722e1461016a5780633f4ba83a1461017d5780634fc557cd14610190578063509e004e146101bf5780635c975abb146101d55780637adbf973146101fc57806383197ef01461021b57806383f94db71461022e5780638456cb591461024d578063893d20e8146102605780638da5cb5b146102735780638fdc7c2e146102865780639464d5fd1461029c5780639e72370b146102b2578063aaf10f42146102c5578063b1787609146102d8578063b3feeac3146102ee578063e1c7392a14610301578063f14210a614610314578063f2fde38b1461032a578063f5074f4114610349575b60025460a060020a900460ff161561013057600080fd5b005b341561013d57600080fd5b610145610368565b60405190815260200160405180910390f35b341561016257600080fd5b6101456103fa565b341561017557600080fd5b61014561045c565b341561018857600080fd5b6101306104be565b341561019b57600080fd5b6101a361053d565b604051600160a060020a03909116815260200160405180910390f35b34156101ca57600080fd5b61014560043561054c565b34156101e057600080fd5b6101e86107ad565b604051901515815260200160405180910390f35b341561020757600080fd5b6101e8600160a060020a03600435166107bd565b341561022657600080fd5b610130610905565b341561023957600080fd5b610130600160a060020a036004351661092e565b341561025857600080fd5b6101306109a3565b341561026b57600080fd5b6101a3610a27565b341561027e57600080fd5b6101a3610a36565b341561029157600080fd5b610145600435610a45565b34156102a757600080fd5b610145600435610b55565b34156102bd57600080fd5b6101a3610cc6565b34156102d057600080fd5b6101a3610cd5565b34156102e357600080fd5b610145600435610ce4565b34156102f957600080fd5b6101a3610ddf565b341561030c57600080fd5b610130610dee565b341561031f57600080fd5b610145600435610e2e565b341561033557600080fd5b610130600160a060020a0360043516610ee3565b341561035457600080fd5b610130600160a060020a0360043516610f7e565b60025460009060a060020a900460ff161561038257600080fd5b600454600160a060020a03166370a082313060006040516020015260405160e060020a63ffffffff8416028152600160a060020a039091166004820152602401602060405180830381600087803b15156103db57600080fd5b6102c65a03f115156103ec57600080fd5b505050604051805191505090565b60025460009060a060020a900460ff161561041457600080fd5b600354600160a060020a03166321f222dd6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156103db57600080fd5b60025460009060a060020a900460ff161561047657600080fd5b600354600160a060020a0316632c4e722e6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156103db57600080fd5b60025433600160a060020a039081169116146104d957600080fd5b60025460a060020a900460ff1615156104f157600080fd5b6002805474ff0000000000000000000000000000000000000000191690557f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b600354600160a060020a031681565b600254600090819060a060020a900460ff161561056857600080fd5b30600160a060020a0316632c4e722e6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156105ae57600080fd5b6102c65a03f115156105bf57600080fd5b505050604051805184101590506105d557600080fd5b600454600160a060020a03166323b872dd33308660006040516020015260405160e060020a63ffffffff8616028152600160a060020a0393841660048201529190921660248201526044810191909152606401602060405180830381600087803b151561064157600080fd5b6102c65a03f1151561065257600080fd5b50505060405180519050151561066457fe5b30600160a060020a0316638fdc7c2e8460006040516020015260405160e060020a63ffffffff84160281526004810191909152602401602060405180830381600087803b15156106b357600080fd5b6102c65a03f115156106c457600080fd5b5050506040518051915050600160a060020a03331681156108fc0282604051600060405180830381858888f19350505050151561070057600080fd5b7f12bbb09248841a291ce08790742591dbaa310c95ccf518fdc9e1b0683f333a66838230600160a060020a0316632c4e722e6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561076957600080fd5b6102c65a03f1151561077a57600080fd5b5050506040518051905060405180848152602001838152602001828152602001935050505060405180910390a192915050565b60025460a060020a900460ff1681565b6002546000908190819033600160a060020a039081169116146107df57600080fd5b60025460a060020a900460ff16156107f657600080fd5b600160a060020a038416151561080b57600080fd5b83915081600160a060020a031663c885cc866000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561085457600080fd5b6102c65a03f1151561086557600080fd5b50505060405180519050151561087a57600080fd5b5060038054600160a060020a0385811673ffffffffffffffffffffffffffffffffffffffff19831617909255167fc45544b7ac4a92c3899899340285a02bb5fee150e7b5ff75dbdcba7cea40ae7a818533604051600160a060020a03938416815291831660208301529091166040808301919091526060909101905180910390a15060019392505050565b60025433600160a060020a0390811691161461092057600080fd5b600154600160a060020a0316ff5b60025433600160a060020a0390811691161461094957600080fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383169081179091557fbb0e7ec411133f2e650f59a5c752be1a0f548c2140421e80171b2f9b1ff833a960405160405180910390a250565b60025433600160a060020a039081169116146109be57600080fd5b60025460a060020a900460ff16156109d557600080fd5b6002805474ff0000000000000000000000000000000000000000191660a060020a1790557f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b600254600160a060020a031690565b600254600160a060020a031681565b60025460009081908190819060a060020a900460ff1615610a6557600080fd5b30600160a060020a0316632c4e722e6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610aab57600080fd5b6102c65a03f11515610abc57600080fd5b5050506040518051935050600160a060020a0330166321f222dd6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610b0d57600080fd5b6102c65a03f11515610b1e57600080fd5b5050506040518051905091508285811515610b3557fe5b0490508285811515610b4357fe5b0615610b4d576001015b029392505050565b60025460009060a060020a900460ff1615610b6f57600080fd5b60025433600160a060020a03908116911614610b8a57600080fd5b6004548290600160a060020a03166370a082313060006040516020015260405160e060020a63ffffffff8416028152600160a060020a039091166004820152602401602060405180830381600087803b1515610be557600080fd5b6102c65a03f11515610bf657600080fd5b5050506040518051905010151515610c0d57600080fd5b600454600160a060020a031663a9059cbb338460006040516020015260405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b1515610c6c57600080fd5b6102c65a03f11515610c7d57600080fd5b505050604051805190501515610c8f57fe5b7f0252a0fbcdcaf341ee7e342a80efad0972c20350a45a36d5bf6bd7e809af113a8260405190815260200160405180910390a15090565b600054600160a060020a031681565b600054600160a060020a031690565b600254600090819060a060020a900460ff1615610d0057600080fd5b30600160a060020a03166321f222dd6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610d4657600080fd5b6102c65a03f11515610d5757600080fd5b5050506040518051905083811515610d6b57fe5b049050610dd88130600160a060020a0316632c4e722e6000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610db857600080fd5b6102c65a03f11515610dc957600080fd5b50505060405180519050610fa5565b9392505050565b600454600160a060020a031681565b600154600160a060020a031615610e0457600080fd5b6001805473ffffffffffffffffffffffffffffffffffffffff191633600160a060020a0316179055565b60025460009060a060020a900460ff1615610e4857600080fd5b60025433600160a060020a03908116911614610e6357600080fd5b600160a060020a0330163182901015610e7b57600080fd5b600160a060020a03331682156108fc0283604051600060405180830381858888f193505050501515610eac57600080fd5b7f1f3aa65e09102ce65e7cfa3838f7bc642cfc2882fc576a5bf6c5b4488464d8858260405190815260200160405180910390a15090565b60025433600160a060020a03908116911614610efe57600080fd5b600160a060020a0381161515610f1357600080fd5b600254600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36002805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b60025433600160a060020a03908116911614610f9957600080fd5b80600160a060020a0316ff5b6000828202831580610fc15750828482811515610fbe57fe5b04145b1515610dd857fe00a165627a7a7230582006ef9623e9ea253b569670b55faf416c04faaa60175094b09510524f0c78a8bc0029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    protected LOCExchange(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LOCExchange(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogLocExchangedEventResponse> getLogLocExchangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogLocExchanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogLocExchangedEventResponse> responses = new ArrayList<LogLocExchangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogLocExchangedEventResponse typedResponse = new LogLocExchangedEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.locWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.ethWei = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.rate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogLocExchangedEventResponse> logLocExchangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogLocExchanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogLocExchangedEventResponse>() {
            @Override
            public LogLocExchangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogLocExchangedEventResponse typedResponse = new LogLocExchangedEventResponse();
                typedResponse.log = log;
                typedResponse.locWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.ethWei = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.rate = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<LogLocWithdrawalEventResponse> getLogLocWithdrawalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogLocWithdrawal", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogLocWithdrawalEventResponse> responses = new ArrayList<LogLocWithdrawalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogLocWithdrawalEventResponse typedResponse = new LogLocWithdrawalEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.locWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogLocWithdrawalEventResponse> logLocWithdrawalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogLocWithdrawal", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogLocWithdrawalEventResponse>() {
            @Override
            public LogLocWithdrawalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogLocWithdrawalEventResponse typedResponse = new LogLocWithdrawalEventResponse();
                typedResponse.log = log;
                typedResponse.locWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<LogETHWithdrawalEventResponse> getLogETHWithdrawalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogETHWithdrawal", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogETHWithdrawalEventResponse> responses = new ArrayList<LogETHWithdrawalEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogETHWithdrawalEventResponse typedResponse = new LogETHWithdrawalEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.ethWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogETHWithdrawalEventResponse> logETHWithdrawalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogETHWithdrawal", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogETHWithdrawalEventResponse>() {
            @Override
            public LogETHWithdrawalEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogETHWithdrawalEventResponse typedResponse = new LogETHWithdrawalEventResponse();
                typedResponse.log = log;
                typedResponse.ethWei = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<LOGLOCOracleSetEventResponse> getLOGLOCOracleSetEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LOGLOCOracleSet", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LOGLOCOracleSetEventResponse> responses = new ArrayList<LOGLOCOracleSetEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LOGLOCOracleSetEventResponse typedResponse = new LOGLOCOracleSetEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse.oldOracle = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newOracle = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.changer = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LOGLOCOracleSetEventResponse> lOGLOCOracleSetEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LOGLOCOracleSet", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LOGLOCOracleSetEventResponse>() {
            @Override
            public LOGLOCOracleSetEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LOGLOCOracleSetEventResponse typedResponse = new LOGLOCOracleSetEventResponse();
                typedResponse.log = log;
                typedResponse.oldOracle = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newOracle = (String) eventValues.getNonIndexedValues().get(1).getValue();
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

    public List<UpgradedContractEventResponse> getUpgradedContractEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("UpgradedContract", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UpgradedContractEventResponse> responses = new ArrayList<UpgradedContractEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UpgradedContractEventResponse typedResponse = new UpgradedContractEventResponse();
//            typedResponse.log = eventValues.getLog();
            typedResponse._newImpl = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UpgradedContractEventResponse> upgradedContractEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("UpgradedContract", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UpgradedContractEventResponse>() {
            @Override
            public UpgradedContractEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UpgradedContractEventResponse typedResponse = new UpgradedContractEventResponse();
                typedResponse.log = log;
                typedResponse._newImpl = (String) eventValues.getIndexedValues().get(0).getValue();
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

    public RemoteCall<BigInteger> rate() {
        final Function function = new Function("rate", 
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

    public RemoteCall<String> LOCOracle() {
        final Function function = new Function("LOCOracle", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function("paused", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> setOracle(String newOracle) {
        final Function function = new Function(
                "setOracle", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOracle)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> destroy() {
        final Function function = new Function(
                "destroy", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> upgradeImplementation(String _newImpl) {
        final Function function = new Function(
                "upgradeImplementation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newImpl)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<String> contractImplementation() {
        final Function function = new Function("contractImplementation", 
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

    public RemoteCall<String> LOCTokenContract() {
        final Function function = new Function("LOCTokenContract", 
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

    public RemoteCall<TransactionReceipt> destroyAndSend(String _recipient) {
        final Function function = new Function(
                "destroyAndSend", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_recipient)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<LOCExchange> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String initialOracle, String locTokenContractAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(initialOracle), 
                new org.web3j.abi.datatypes.Address(locTokenContractAddress)));
        return deployRemoteCall(LOCExchange.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<LOCExchange> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String initialOracle, String locTokenContractAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(initialOracle), 
                new org.web3j.abi.datatypes.Address(locTokenContractAddress)));
        return deployRemoteCall(LOCExchange.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<BigInteger> weiToLocWei(BigInteger weiAmount) {
        final Function function = new Function("weiToLocWei", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(weiAmount)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> locWeiToWei(BigInteger locWeiAmount) {
        final Function function = new Function("locWeiToWei", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(locWeiAmount)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> exchangeLocWeiToEthWei(BigInteger locWei) {
        final Function function = new Function(
                "exchangeLocWeiToEthWei", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(locWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawLOC(BigInteger locWeiWithdrawAmount) {
        final Function function = new Function(
                "withdrawLOC", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(locWeiWithdrawAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawETH(BigInteger weiWithdrawAmount) {
        final Function function = new Function(
                "withdrawETH", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(weiWithdrawAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getLocBalance() {
        final Function function = new Function("getLocBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static LOCExchange load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LOCExchange(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static LOCExchange load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LOCExchange(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LogLocExchangedEventResponse {
        public Log log;

        public BigInteger locWei;

        public BigInteger ethWei;

        public BigInteger rate;
    }

    public static class LogLocWithdrawalEventResponse {
        public Log log;

        public BigInteger locWei;
    }

    public static class LogETHWithdrawalEventResponse {
        public Log log;

        public BigInteger ethWei;
    }

    public static class LOGLOCOracleSetEventResponse {
        public Log log;

        public String oldOracle;

        public String newOracle;

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

    public static class UpgradedContractEventResponse {
        public Log log;

        public String _newImpl;
    }
}
