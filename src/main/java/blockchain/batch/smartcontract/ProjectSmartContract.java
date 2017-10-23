package blockchain.batch.smartcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.1.
 */
public final class ProjectSmartContract extends Contract {
    private static final String BINARY = "606060405260646007556001600855341561001957600080fd5b60405160408061060c8339810160405280805191906020018051600754909250821115905061004757600080fd5b6005805460010190556000600381905562015180929092026004556002558054600160a060020a03191633600160a060020a03161781556009805460ff1916905561057490819061009890396000f300606060405236156100f95763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631865c57d81146100fe578063245c7c6014610135578063332730281461015a57806336c483fc1461016f5780633e11fe791461018257806341955ac4146101b957806341c0e1b5146101cc57806358e47271146101d457806370eac62e146101ea5780638a529499146101fd5780639d2c111d14610210578063a38beb2414610223578063ad2e8c9b1461022b578063d321fe291461023e578063dada4e0a14610251578063e245daf214610264578063e2ef414914610277578063f7b6f6501461028a575b600080fd5b341561010957600080fd5b61011161029d565b6040518082600381111561012157fe5b60ff16815260200191505060405180910390f35b341561014057600080fd5b6101486102a6565b60405190815260200160405180910390f35b341561016557600080fd5b61016d6102ac565b005b341561017a57600080fd5b6101486102f8565b341561018d57600080fd5b6101a1600160a060020a03600435166102fe565b60405191825260208201526040908101905180910390f35b34156101c457600080fd5b61016d610317565b61016d61035e565b34156101df57600080fd5b61016d6004356103c0565b34156101f557600080fd5b610148610449565b341561020857600080fd5b610148610468565b341561021b57600080fd5b61016d61046e565b61016d61049d565b341561023657600080fd5b61014861050e565b341561024957600080fd5b610148610514565b341561025c57600080fd5b61014861051a565b341561026f57600080fd5b610148610520565b341561028257600080fd5b610148610526565b341561029557600080fd5b61014861052c565b60095460ff1690565b60045481565b60005433600160a060020a039081169116146102c757600080fd5b600160095460ff1660038111156102da57fe5b14156102f657600980546002919060ff19166001835b02179055505b565b60035481565b6006602052600090815260409020805460019091015482565b60005433600160a060020a0390811691161461033257600080fd5b600060095460ff16600381111561034557fe5b14156102f657600980546001919060ff191682806102f0565b60005433600160a060020a0390811691161461037957600080fd5b600054600354600160a060020a039091169080156108fc0290604051600060405180830381858888f1935050505015156103b257600080fd5b600054600160a060020a0316ff5b60005433600160a060020a039081169116146103db57600080fd5b600260095460ff1660038111156103ee57fe5b1480156103ff575060025460035410155b151561040a57600080fd5b600380548290039055600054600160a060020a031681156108fc0282604051600060405180830381858888f19350505050151561044657600080fd5b50565b600160a060020a03331660009081526006602052604090206001015490565b60025490565b60005433600160a060020a0390811691161461048957600080fd5b600980546003919060ff19166001836102f0565b600160095460ff1660038111156104b057fe5b14156102f6576003805434908101909155600580546001908101909155600160a060020a033316600090815260066020526040902080548201815501805482019055600254106102f657600980546002919060ff19166001836102f0565b60045490565b60035490565b60025481565b60055490565b60055481565b600160a060020a033316600090815260066020526040902054905600a165627a7a723058200740948253d2a76fa1a04fbcfdec9c185e552411ebe8e5f324906a2ea0b79b450029";

    private ProjectSmartContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private ProjectSmartContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<Uint8> getState() {
        Function function = new Function("getState", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> _duration() {
        Function function = new Function("_duration", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> projectReached() {
        Function function = new Function("projectReached", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> _amountTotal() {
        Function function = new Function("_amountTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<List<Type>> Amounts(Address param0) {
        Function function = new Function("Amounts", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> enableProject() {
        Function function = new Function("enableProject", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> kill(BigInteger weiValue) {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function, weiValue);
    }

    public Future<TransactionReceipt> askForPayment(Uint256 value) {
        Function function = new Function("askForPayment", Arrays.<Type>asList(value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getAmountDonation() {
        Function function = new Function("getAmountDonation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getAmountWanted() {
        Function function = new Function("getAmountWanted", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> desactiveContract() {
        Function function = new Function("desactiveContract", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> depositMoneyToSmartContract(BigInteger weiValue) {
        Function function = new Function("depositMoneyToSmartContract", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function, weiValue);
    }

    public Future<Uint256> getDuration() {
        Function function = new Function("getDuration", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getAmount() {
        Function function = new Function("getAmount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> _amountWanted() {
        Function function = new Function("_amountWanted", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getNbDonationTotal() {
        Function function = new Function("getNbDonationTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> _nbDonationTotal() {
        Function function = new Function("_nbDonationTotal", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getNbDonation() {
        Function function = new Function("getNbDonation", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<ProjectSmartContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 duration, Uint256 amountWanted) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(duration, amountWanted));
        return deployAsync(ProjectSmartContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<ProjectSmartContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 duration, Uint256 amountWanted) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(duration, amountWanted));
        return deployAsync(ProjectSmartContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static ProjectSmartContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectSmartContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ProjectSmartContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ProjectSmartContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
