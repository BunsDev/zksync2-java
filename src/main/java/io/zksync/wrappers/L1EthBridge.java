package io.zksync.wrappers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class L1EthBridge extends Contract {
    public static final String BINARY = "0x60a060405234801561001057600080fd5b5060405161116638038061116683398101604081905261002f91610040565b6001600160a01b0316608052610070565b60006020828403121561005257600080fd5b81516001600160a01b038116811461006957600080fd5b9392505050565b6080516110c66100a0600039600081816102ed0152818161045101528181610616015261082701526110c66000f3fe6080604052600436106100555760003560e01c8063439fab911461005a578063772f71281461007c5780637f63f6181461009c578063882f6b96146100c2578063ae1f6aaf146100e2578063f5f151681461011a575b600080fd5b34801561006657600080fd5b5061007a610075366004610b3e565b61013a565b005b34801561008857600080fd5b5061007a610097366004610bf0565b6103a3565b6100af6100aa366004610c79565b61054c565b6040519081526020015b60405180910390f35b3480156100ce57600080fd5b5061007a6100dd366004610ccc565b61072d565b3480156100ee57600080fd5b50600254610102906001600160a01b031681565b6040516001600160a01b0390911681526020016100b9565b34801561012657600080fd5b50610102610135366004610d56565b610927565b6002546001600160a01b03161561015057600080fd5b610158610940565b60408051306020820152600091829101604051602081830303815290604052905060006101858585610991565b90506000631415dae260e01b84836000866040516024016101a99493929190610dc5565b60408051601f19818403018152918152602080830180516001600160e01b03166001600160e01b03199095169490941790935285518684012081517f2020dba91b30cc0006188af794c2fb30dd8520db7e2c088b7fc7c103c00ca494818601523081840152606081018990526080810187905260a0808201929092528251808203909201825260c0019091528051920191909120909150600280546001600160a01b0319166001600160a01b0392909216919091179055604080516001808252818301909252600091602082015b606081526020019060019003908161027757905050905086868080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201829052508551869450909250151590506102d8576102d8610df7565b60209081029190910101526001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001663b4848df561031f6180006006610e23565b84622000008560006040518663ffffffff1660e01b8152600401610347959493929190610e70565b602060405180830381600087803b15801561036157600080fd5b505af1158015610375573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103999190610f01565b5050505050505050565b60008051602061107183398151915254600181146103c057600080fd5b6002600080516020611071833981519152556001600160a01b038716156103e657600080fd5b6001600160a01b03881660009081526001602090815260408083208984529091529020548061041457600080fd5b6000604051806060016040528061800060016104309190610e23565b6001600160a01b031681526020018981526020016000801b815250905060007f00000000000000000000000000000000000000000000000000000000000000006001600160a01b031663ee97667b8989858a8a6040518663ffffffff1660e01b81526004016104a3959493929190610f50565b60206040518083038186803b1580156104bb57600080fd5b505afa1580156104cf573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104f39190610fa4565b9050806104ff57600080fd5b6001600160a01b038b1660009081526001602090815260408083208c845290915281205561052d8b84610a41565b5050506001600080516020611071833981519152555050505050505050565b600080516020611071833981519152546000906001811461056c57600080fd5b6002600080516020611071833981519152556001600160a01b0385161561059257600080fd5b600061059e8534610fc6565b604080513360248201526001600160a01b038a1660448201526000606482018190526084820189905260a060a483015260c48083018290528351808403909101815260e49092019092526020810180516001600160e01b03166333f9ebdf60e21b179052919250906002549091506001600160a01b037f000000000000000000000000000000000000000000000000000000000000000081169163b4848df5918591168462200000600060405190808252806020026020018201604052801561067b57816020015b60608152602001906001900390816106665790505b508b6040518763ffffffff1660e01b815260040161069d959493929190610e70565b6020604051808303818588803b1580156106b657600080fd5b505af11580156106ca573d6000803e3d6000fd5b50505050506040513d601f19601f820116820180604052508101906106ef9190610f01565b336000908152600160208181526040808420858552909152909120979097556000805160206110718339815191529690965550939695505050505050565b600080516020611071833981519152546001811461074a57600080fd5b60026000805160206110718339815191525563ffffffff871660009081526020818152604080832089845290915290205460ff161561078857600080fd5b6040805180820182526002546001600160a01b0316815281516020601f8801819004810282018101909352868152600092808301919089908990819084018382808284376000920182905250939094525050604080516020601f8b01819004810282018101909252898152939450909283925061081f918a908a9081908401838280828437600092019190915250610aa692505050565b9150915060007f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166352390d8d8c8c878b8b6040518663ffffffff1660e01b8152600401610879959493929190610fdd565b60206040518083038186803b15801561089157600080fd5b505afa1580156108a5573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906108c99190610fa4565b9050806108d557600080fd5b63ffffffff8b166000908152602081815260408083208d84529091529020805460ff191660011790556109088383610a41565b5050505060016000805160206110718339815191525550505050505050565b60006001600160a01b03821661093b575060005b919050565b60008051602061107183398151915280546001909155801561098e5760405162461bcd60e51b815260206004820152600260248201526118a160f11b60448201526064015b60405180910390fd5b50565b60008061099f60208461103e565b90506201000081106109d85760405162461bcd60e51b8152602060048201526002602482015261070760f41b6044820152606401610985565b600284846040516109ea929190611060565b602060405180830381855afa158015610a07573d6000803e3d6000fd5b5050506040513d601f19601f82011682018060405250810190610a2a9190610f01565b6001600160f01b031660f09190911b179392505050565b6000826001600160a01b03168260405160006040518083038185875af1925050503d8060008114610a8e576040519150601f19603f3d011682016040523d82523d6000602084013e610a93565b606091505b5050905080610aa157600080fd5b505050565b6000808251603814610ab757600080fd5b60048381015190634417b5cb60e11b6001600160e01b031960e084901b1614610adf57600080fd5b6014940193840151603490940151939492505050565b60008083601f840112610b0757600080fd5b50813567ffffffffffffffff811115610b1f57600080fd5b602083019150836020828501011115610b3757600080fd5b9250929050565b60008060208385031215610b5157600080fd5b823567ffffffffffffffff811115610b6857600080fd5b610b7485828601610af5565b90969095509350505050565b80356001600160a01b038116811461093b57600080fd5b803563ffffffff8116811461093b57600080fd5b60008083601f840112610bbd57600080fd5b50813567ffffffffffffffff811115610bd557600080fd5b6020830191508360208260051b8501011115610b3757600080fd5b600080600080600080600060c0888a031215610c0b57600080fd5b610c1488610b80565b9650610c2260208901610b80565b955060408801359450610c3760608901610b97565b93506080880135925060a088013567ffffffffffffffff811115610c5a57600080fd5b610c668a828b01610bab565b989b979a50959850939692959293505050565b60008060008060808587031215610c8f57600080fd5b610c9885610b80565b9350610ca660208601610b80565b925060408501359150606085013560038110610cc157600080fd5b939692955090935050565b60008060008060008060808789031215610ce557600080fd5b610cee87610b97565b955060208701359450604087013567ffffffffffffffff80821115610d1257600080fd5b610d1e8a838b01610af5565b90965094506060890135915080821115610d3757600080fd5b50610d4489828a01610bab565b979a9699509497509295939492505050565b600060208284031215610d6857600080fd5b610d7182610b80565b9392505050565b6000815180845260005b81811015610d9e57602081850181015186830182015201610d82565b81811115610db0576000602083870101525b50601f01601f19169290920160200192915050565b84815283602082015260ff83166040820152608060608201526000610ded6080830184610d78565b9695505050505050565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b60006001600160a01b03828116848216808303821115610e4557610e45610e0d565b01949350505050565b60038110610e6c57634e487b7160e01b600052602160045260246000fd5b9052565b6001600160a01b038616815260a06020808301829052600091610e9590840188610d78565b86604085015283810360608501528086518083528383019150838160051b84010184890160005b83811015610eea57601f19868403018552610ed8838351610d78565b94870194925090860190600101610ebc565b50508095505050505050610ded6080830184610e4e565b600060208284031215610f1357600080fd5b5051919050565b81835260006001600160fb1b03831115610f3357600080fd5b8260051b8083602087013760009401602001938452509192915050565b63ffffffff8616815284602082015260018060a01b038451166040820152602084015160608201526040840151608082015260c060a08201526000610f9960c083018486610f1a565b979650505050505050565b600060208284031215610fb657600080fd5b81518015158114610d7157600080fd5b600082821015610fd857610fd8610e0d565b500390565b63ffffffff861681528460208201526080604082015260018060a01b03845116608082015260006020850151604060a084015261101d60c0840182610d78565b90508281036060840152611032818587610f1a565b98975050505050505050565b60008261105b57634e487b7160e01b600052601260045260246000fd5b500490565b818382376000910190815291905056fe8e94fed44239eb2314ab7a406345e6c5a8f0ccedf3b600de3d004e672c33abf4a26469706673582212202c2ca0df5fe16e1f24f5b44a6cd8e0c312962248e41cc21559d927f2788dc3cd64736f6c63430008090033";

    public static final String FUNC_CLAIMFAILEDDEPOSIT = "claimFailedDeposit";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_FINALIZEWITHDRAWAL = "finalizeWithdrawal";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_L2BRIDGE = "l2Bridge";

    public static final String FUNC_L2TOKENADDRESS = "l2TokenAddress";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected L1EthBridge(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected L1EthBridge(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected L1EthBridge(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected L1EthBridge(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> claimFailedDeposit(String _depositSender, String _l1Token, byte[] _l2TxHash, BigInteger _l2BlockNumber, BigInteger _l2MessageIndex, List<byte[]> _merkleProof) {
        final Function function = new Function(
                FUNC_CLAIMFAILEDDEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_depositSender), 
                new org.web3j.abi.datatypes.Address(_l1Token), 
                new org.web3j.abi.datatypes.generated.Bytes32(_l2TxHash), 
                new org.web3j.abi.datatypes.generated.Uint32(_l2BlockNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(_l2MessageIndex), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_merkleProof, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(String _l2Receiver, String _l1Token, BigInteger _amount, BigInteger _queueType) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_l2Receiver), 
                new org.web3j.abi.datatypes.Address(_l1Token), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.generated.Uint8(_queueType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, _amount);
    }

    public RemoteFunctionCall<TransactionReceipt> finalizeWithdrawal(BigInteger _l2BlockNumber, BigInteger _l2MessageIndex, byte[] _message, List<byte[]> _merkleProof) {
        final Function function = new Function(
                FUNC_FINALIZEWITHDRAWAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(_l2BlockNumber), 
                new org.web3j.abi.datatypes.generated.Uint256(_l2MessageIndex), 
                new org.web3j.abi.datatypes.DynamicBytes(_message), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(_merkleProof, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(byte[] _l2BridgeBytecode) {
        final Function function = new Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(_l2BridgeBytecode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> l2Bridge() {
        final Function function = new Function(FUNC_L2BRIDGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> l2TokenAddress(String _l1Token) {
        final Function function = new Function(FUNC_L2TOKENADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_l1Token)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static L1EthBridge load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new L1EthBridge(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static L1EthBridge load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new L1EthBridge(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static L1EthBridge load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new L1EthBridge(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static L1EthBridge load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new L1EthBridge(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<L1EthBridge> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _mailbox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mailbox)));
        return deployRemoteCall(L1EthBridge.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<L1EthBridge> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _mailbox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mailbox)));
        return deployRemoteCall(L1EthBridge.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<L1EthBridge> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _mailbox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mailbox)));
        return deployRemoteCall(L1EthBridge.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<L1EthBridge> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _mailbox) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_mailbox)));
        return deployRemoteCall(L1EthBridge.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
