package com.acv.buycoffee;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
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
import org.web3j.abi.datatypes.DynamicArray;
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
public class BuyMeACoffee extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610c39806100606000396000f3fe60806040526004361061003f5760003560e01c80631fadea1314610044578063204206e11461006d5780633aaa74b214610089578063865c5172146100a0575b600080fd5b34801561005057600080fd5b5061006b600480360381019061006691906107e4565b6100cb565b005b6100876004803603810190610082919061082d565b6100ce565b005b34801561009557600080fd5b5061009e610256565b005b3480156100ac57600080fd5b506100b56102b6565b6040516100c29190610a77565b60405180910390f35b50565b60003411610111576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161010890610af6565b60405180910390fd5b600160405180608001604052803373ffffffffffffffffffffffffffffffffffffffff16815260200142815260200184815260200183815250908060018154018082558091505060019003906000526020600020906004020160009091909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506020820151816001015560408201518160020190805190602001906101e0929190610499565b5060608201518160030190805190602001906101fd929190610499565b5050503373ffffffffffffffffffffffffffffffffffffffff167fc56140e05f516509ae28110e0f72e17558a7561630dad2647c3ae87d986e365c42848460405161024a93929190610b5e565b60405180910390a25050565b60008054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc479081150290604051600060405180830381858888f193505050506102b457600080fd5b565b60606001805480602002602001604051908101604052809291908181526020016000905b8282101561049057838290600052602060002090600402016040518060800160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020016001820154815260200160028201805461036d90610bd2565b80601f016020809104026020016040519081016040528092919081815260200182805461039990610bd2565b80156103e65780601f106103bb576101008083540402835291602001916103e6565b820191906000526020600020905b8154815290600101906020018083116103c957829003601f168201915b505050505081526020016003820180546103ff90610bd2565b80601f016020809104026020016040519081016040528092919081815260200182805461042b90610bd2565b80156104785780601f1061044d57610100808354040283529160200191610478565b820191906000526020600020905b81548152906001019060200180831161045b57829003601f168201915b505050505081525050815260200190600101906102da565b50505050905090565b8280546104a590610bd2565b90600052602060002090601f0160209004810192826104c7576000855561050e565b82601f106104e057805160ff191683800117855561050e565b8280016001018555821561050e579182015b8281111561050d5782518255916020019190600101906104f2565b5b50905061051b919061051f565b5090565b5b80821115610538576000816000905550600101610520565b5090565b6000604051905090565b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b61059e82610555565b810181811067ffffffffffffffff821117156105bd576105bc610566565b5b80604052505050565b60006105d061053c565b90506105dc8282610595565b919050565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610611826105e6565b9050919050565b61062181610606565b811461062c57600080fd5b50565b60008135905061063e81610618565b92915050565b6000819050919050565b61065781610644565b811461066257600080fd5b50565b6000813590506106748161064e565b92915050565b600080fd5b600080fd5b600067ffffffffffffffff82111561069f5761069e610566565b5b6106a882610555565b9050602081019050919050565b82818337600083830152505050565b60006106d76106d284610684565b6105c6565b9050828152602081018484840111156106f3576106f261067f565b5b6106fe8482856106b5565b509392505050565b600082601f83011261071b5761071a61067a565b5b813561072b8482602086016106c4565b91505092915050565b60006080828403121561074a57610749610550565b5b61075460806105c6565b905060006107648482850161062f565b600083015250602061077884828501610665565b602083015250604082013567ffffffffffffffff81111561079c5761079b6105e1565b5b6107a884828501610706565b604083015250606082013567ffffffffffffffff8111156107cc576107cb6105e1565b5b6107d884828501610706565b60608301525092915050565b6000602082840312156107fa576107f9610546565b5b600082013567ffffffffffffffff8111156108185761081761054b565b5b61082484828501610734565b91505092915050565b6000806040838503121561084457610843610546565b5b600083013567ffffffffffffffff8111156108625761086161054b565b5b61086e85828601610706565b925050602083013567ffffffffffffffff81111561088f5761088e61054b565b5b61089b85828601610706565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b6108da81610606565b82525050565b6108e981610644565b82525050565b600081519050919050565b600082825260208201905092915050565b60005b8381101561092957808201518184015260208101905061090e565b83811115610938576000848401525b50505050565b6000610949826108ef565b61095381856108fa565b935061096381856020860161090b565b61096c81610555565b840191505092915050565b600060808301600083015161098f60008601826108d1565b5060208301516109a260208601826108e0565b50604083015184820360408601526109ba828261093e565b915050606083015184820360608601526109d4828261093e565b9150508091505092915050565b60006109ed8383610977565b905092915050565b6000602082019050919050565b6000610a0d826108a5565b610a1781856108b0565b935083602082028501610a29856108c1565b8060005b85811015610a655784840389528151610a4685826109e1565b9450610a51836109f5565b925060208a01995050600181019050610a2d565b50829750879550505050505092915050565b60006020820190508181036000830152610a918184610a02565b905092915050565b600082825260208201905092915050565b7f63616e27742062757920636f6666656520666f72206672656521000000000000600082015250565b6000610ae0601a83610a99565b9150610aeb82610aaa565b602082019050919050565b60006020820190508181036000830152610b0f81610ad3565b9050919050565b610b1f81610644565b82525050565b6000610b30826108ef565b610b3a8185610a99565b9350610b4a81856020860161090b565b610b5381610555565b840191505092915050565b6000606082019050610b736000830186610b16565b8181036020830152610b858185610b25565b90508181036040830152610b998184610b25565b9050949350505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680610bea57607f821691505b602082108103610bfd57610bfc610ba3565b5b5091905056fea2646970667358221220d2ed7ffdb10011de9a257b740b3ce7da9ce95849d120da44f7f206341bcb616c64736f6c634300080e0033";

    public static final String FUNC_GETMEMOS = "getMemos";

    public static final String FUNC_BUYCOFFEE = "buyCoffee";

    public static final String FUNC_WITHDRAWTIPS = "withdrawTips";

    public static final String FUNC_SETFOO = "setFoo";

    public static final Event NEWMEMO_EVENT = new Event("NewMemo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected BuyMeACoffee(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BuyMeACoffee(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BuyMeACoffee(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BuyMeACoffee(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<NewMemoEventResponse> getNewMemoEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWMEMO_EVENT, transactionReceipt);
        ArrayList<NewMemoEventResponse> responses = new ArrayList<NewMemoEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewMemoEventResponse typedResponse = new NewMemoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewMemoEventResponse> newMemoEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewMemoEventResponse>() {
            @Override
            public NewMemoEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWMEMO_EVENT, log);
                NewMemoEventResponse typedResponse = new NewMemoEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewMemoEventResponse> newMemoEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWMEMO_EVENT));
        return newMemoEventFlowable(filter);
    }

    public RemoteFunctionCall<List> getMemos() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETMEMOS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Memo>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> buyCoffee(String _name, String _message) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BUYCOFFEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_message)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawTips() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAWTIPS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setFoo(Memo _toSet) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETFOO, 
                Arrays.<Type>asList(_toSet), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BuyMeACoffee load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BuyMeACoffee(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BuyMeACoffee load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BuyMeACoffee(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BuyMeACoffee load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BuyMeACoffee(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BuyMeACoffee load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BuyMeACoffee(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BuyMeACoffee> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BuyMeACoffee.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<BuyMeACoffee> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BuyMeACoffee.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BuyMeACoffee> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BuyMeACoffee.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BuyMeACoffee> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BuyMeACoffee.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class Memo extends DynamicStruct {
        public String from;

        public BigInteger timestamp;

        public String name;

        public String message;

        public Memo(String from, BigInteger timestamp, String name, String message) {
            super(new org.web3j.abi.datatypes.Address(from),new org.web3j.abi.datatypes.generated.Uint256(timestamp),new org.web3j.abi.datatypes.Utf8String(name),new org.web3j.abi.datatypes.Utf8String(message));
            this.from = from;
            this.timestamp = timestamp;
            this.name = name;
            this.message = message;
        }

        public Memo(Address from, Uint256 timestamp, Utf8String name, Utf8String message) {
            super(from,timestamp,name,message);
            this.from = from.getValue();
            this.timestamp = timestamp.getValue();
            this.name = name.getValue();
            this.message = message.getValue();
        }
    }

    public static class NewMemoEventResponse extends BaseEventResponse {
        public String from;

        public BigInteger timestamp;

        public String name;

        public String message;
    }
}
