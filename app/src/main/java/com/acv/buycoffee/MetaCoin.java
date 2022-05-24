package com.acv.buycoffee;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicStruct;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class MetaCoin extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b506103cf806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80632cf073951461003b57806337ec42c314610057575b600080fd5b61005560048036038101906100509190610265565b610073565b005b610071600480360381019061006c9190610350565b610076565b005b50565b50565b6000604051905090565b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6100db82610092565b810181811067ffffffffffffffff821117156100fa576100f96100a3565b5b80604052505050565b600061010d610079565b905061011982826100d2565b919050565b600080fd5b600080fd5b600080fd5b600067ffffffffffffffff821115610148576101476100a3565b5b61015182610092565b9050602081019050919050565b82818337600083830152505050565b600061018061017b8461012d565b610103565b90508281526020810184848401111561019c5761019b610128565b5b6101a784828561015e565b509392505050565b600082601f8301126101c4576101c3610123565b5b81356101d484826020860161016d565b91505092915050565b6000604082840312156101f3576101f261008d565b5b6101fd6040610103565b9050600082013567ffffffffffffffff81111561021d5761021c61011e565b5b610229848285016101af565b600083015250602082013567ffffffffffffffff81111561024d5761024c61011e565b5b610259848285016101af565b60208301525092915050565b60006020828403121561027b5761027a610083565b5b600082013567ffffffffffffffff81111561029957610298610088565b5b6102a5848285016101dd565b91505092915050565b6000819050919050565b6102c1816102ae565b81146102cc57600080fd5b50565b6000813590506102de816102b8565b92915050565b6000604082840312156102fa576102f961008d565b5b6103046040610103565b90506000610314848285016102cf565b600083015250602082013567ffffffffffffffff8111156103385761033761011e565b5b610344848285016101af565b60208301525092915050565b60006020828403121561036657610365610083565b5b600082013567ffffffffffffffff81111561038457610383610088565b5b610390848285016102e4565b9150509291505056fea26469706673582212209f9b228cfdecb5e28793a857c09f005c2b62d79c355803ff559990ca89402c0c64736f6c634300080e0033";

    public static final String FUNC_SETFOO = "setFoo";

    public static final String FUNC_SETBAR = "setBar";

    public static final Event EVENT_EVENT = new Event("Event", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Foo>() {}, new TypeReference<Bar>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected MetaCoin(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MetaCoin(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MetaCoin(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MetaCoin(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<EventEventResponse> getEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EVENT_EVENT, transactionReceipt);
        ArrayList<EventEventResponse> responses = new ArrayList<EventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EventEventResponse typedResponse = new EventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._foo = (Foo) eventValues.getNonIndexedValues().get(0);
            typedResponse._bar = (Bar) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EventEventResponse> eventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EventEventResponse>() {
            @Override
            public EventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EVENT_EVENT, log);
                EventEventResponse typedResponse = new EventEventResponse();
                typedResponse.log = log;
                typedResponse._address = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._foo = (Foo) eventValues.getNonIndexedValues().get(0);
                typedResponse._bar = (Bar) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Flowable<EventEventResponse> eventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EVENT_EVENT));
        return eventEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> setFoo(Foo _toSet) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETFOO, 
                Arrays.<Type>asList(_toSet), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBar(Bar _toSet) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBAR, 
                Arrays.<Type>asList(_toSet), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MetaCoin load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MetaCoin(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MetaCoin load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MetaCoin(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MetaCoin load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MetaCoin(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MetaCoin load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MetaCoin(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MetaCoin> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MetaCoin.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MetaCoin> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MetaCoin.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MetaCoin> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MetaCoin.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MetaCoin> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MetaCoin.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class Foo extends DynamicStruct {
        public String id;

        public String name;

        public Foo(String id, String name) {
            super(new org.web3j.abi.datatypes.Utf8String(id),new org.web3j.abi.datatypes.Utf8String(name));
            this.id = id;
            this.name = name;
        }

        public Foo(Utf8String id, Utf8String name) {
            super(id,name);
            this.id = id.getValue();
            this.name = name.getValue();
        }
    }

    public static class Bar extends DynamicStruct {
        public BigInteger id;

        public String data;

        public Bar(BigInteger id, String data) {
            super(new org.web3j.abi.datatypes.generated.Uint256(id),new org.web3j.abi.datatypes.Utf8String(data));
            this.id = id;
            this.data = data;
        }

        public Bar(Uint256 id, Utf8String data) {
            super(id,data);
            this.id = id.getValue();
            this.data = data.getValue();
        }
    }

    public static class EventEventResponse extends BaseEventResponse {
        public String _address;

        public Foo _foo;

        public Bar _bar;
    }
}
