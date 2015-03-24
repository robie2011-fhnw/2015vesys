
package bank.client.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bank.client.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetOwnerResponse_QNAME = new QName("http://local.bank/", "getOwnerResponse");
    private final static QName _GetNumber_QNAME = new QName("http://local.bank/", "getNumber");
    private final static QName _GetNumberResponse_QNAME = new QName("http://local.bank/", "getNumberResponse");
    private final static QName _TransferResponse_QNAME = new QName("http://local.bank/", "transferResponse");
    private final static QName _CloseAccountResponse_QNAME = new QName("http://local.bank/", "closeAccountResponse");
    private final static QName _WithdrawResponse_QNAME = new QName("http://local.bank/", "withdrawResponse");
    private final static QName _DepositResponse_QNAME = new QName("http://local.bank/", "depositResponse");
    private final static QName _AccountExistsResponse_QNAME = new QName("http://local.bank/", "accountExistsResponse");
    private final static QName _GetOwner_QNAME = new QName("http://local.bank/", "getOwner");
    private final static QName _IsActive_QNAME = new QName("http://local.bank/", "isActive");
    private final static QName _GetBalance_QNAME = new QName("http://local.bank/", "getBalance");
    private final static QName _Transfer_QNAME = new QName("http://local.bank/", "transfer");
    private final static QName _CloseAccount_QNAME = new QName("http://local.bank/", "closeAccount");
    private final static QName _GetAccountNumbers_QNAME = new QName("http://local.bank/", "getAccountNumbers");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://local.bank/", "getBalanceResponse");
    private final static QName _Deposit_QNAME = new QName("http://local.bank/", "deposit");
    private final static QName _Withdraw_QNAME = new QName("http://local.bank/", "withdraw");
    private final static QName _InactiveException_QNAME = new QName("http://local.bank/", "InactiveException");
    private final static QName _CreateAccountResponse_QNAME = new QName("http://local.bank/", "createAccountResponse");
    private final static QName _OverdrawException_QNAME = new QName("http://local.bank/", "OverdrawException");
    private final static QName _IOException_QNAME = new QName("http://local.bank/", "IOException");
    private final static QName _CreateAccount_QNAME = new QName("http://local.bank/", "createAccount");
    private final static QName _IsActiveResponse_QNAME = new QName("http://local.bank/", "isActiveResponse");
    private final static QName _AccountExists_QNAME = new QName("http://local.bank/", "accountExists");
    private final static QName _GetAccountNumbersResponse_QNAME = new QName("http://local.bank/", "getAccountNumbersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bank.client.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DepositResponse }
     * 
     */
    public DepositResponse createDepositResponse() {
        return new DepositResponse();
    }

    /**
     * Create an instance of {@link AccountExistsResponse }
     * 
     */
    public AccountExistsResponse createAccountExistsResponse() {
        return new AccountExistsResponse();
    }

    /**
     * Create an instance of {@link GetOwner }
     * 
     */
    public GetOwner createGetOwner() {
        return new GetOwner();
    }

    /**
     * Create an instance of {@link IsActive }
     * 
     */
    public IsActive createIsActive() {
        return new IsActive();
    }

    /**
     * Create an instance of {@link GetNumber }
     * 
     */
    public GetNumber createGetNumber() {
        return new GetNumber();
    }

    /**
     * Create an instance of {@link GetOwnerResponse }
     * 
     */
    public GetOwnerResponse createGetOwnerResponse() {
        return new GetOwnerResponse();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link GetNumberResponse }
     * 
     */
    public GetNumberResponse createGetNumberResponse() {
        return new GetNumberResponse();
    }

    /**
     * Create an instance of {@link WithdrawResponse }
     * 
     */
    public WithdrawResponse createWithdrawResponse() {
        return new WithdrawResponse();
    }

    /**
     * Create an instance of {@link CloseAccountResponse }
     * 
     */
    public CloseAccountResponse createCloseAccountResponse() {
        return new CloseAccountResponse();
    }

    /**
     * Create an instance of {@link CreateAccountResponse }
     * 
     */
    public CreateAccountResponse createCreateAccountResponse() {
        return new CreateAccountResponse();
    }

    /**
     * Create an instance of {@link InactiveException }
     * 
     */
    public InactiveException createInactiveException() {
        return new InactiveException();
    }

    /**
     * Create an instance of {@link OverdrawException }
     * 
     */
    public OverdrawException createOverdrawException() {
        return new OverdrawException();
    }

    /**
     * Create an instance of {@link IsActiveResponse }
     * 
     */
    public IsActiveResponse createIsActiveResponse() {
        return new IsActiveResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link CreateAccount }
     * 
     */
    public CreateAccount createCreateAccount() {
        return new CreateAccount();
    }

    /**
     * Create an instance of {@link AccountExists }
     * 
     */
    public AccountExists createAccountExists() {
        return new AccountExists();
    }

    /**
     * Create an instance of {@link GetAccountNumbersResponse }
     * 
     */
    public GetAccountNumbersResponse createGetAccountNumbersResponse() {
        return new GetAccountNumbersResponse();
    }

    /**
     * Create an instance of {@link CloseAccount }
     * 
     */
    public CloseAccount createCloseAccount() {
        return new CloseAccount();
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link Transfer }
     * 
     */
    public Transfer createTransfer() {
        return new Transfer();
    }

    /**
     * Create an instance of {@link GetAccountNumbers }
     * 
     */
    public GetAccountNumbers createGetAccountNumbers() {
        return new GetAccountNumbers();
    }

    /**
     * Create an instance of {@link Deposit }
     * 
     */
    public Deposit createDeposit() {
        return new Deposit();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link Withdraw }
     * 
     */
    public Withdraw createWithdraw() {
        return new Withdraw();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOwnerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getOwnerResponse")
    public JAXBElement<GetOwnerResponse> createGetOwnerResponse(GetOwnerResponse value) {
        return new JAXBElement<GetOwnerResponse>(_GetOwnerResponse_QNAME, GetOwnerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getNumber")
    public JAXBElement<GetNumber> createGetNumber(GetNumber value) {
        return new JAXBElement<GetNumber>(_GetNumber_QNAME, GetNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getNumberResponse")
    public JAXBElement<GetNumberResponse> createGetNumberResponse(GetNumberResponse value) {
        return new JAXBElement<GetNumberResponse>(_GetNumberResponse_QNAME, GetNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "transferResponse")
    public JAXBElement<TransferResponse> createTransferResponse(TransferResponse value) {
        return new JAXBElement<TransferResponse>(_TransferResponse_QNAME, TransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "closeAccountResponse")
    public JAXBElement<CloseAccountResponse> createCloseAccountResponse(CloseAccountResponse value) {
        return new JAXBElement<CloseAccountResponse>(_CloseAccountResponse_QNAME, CloseAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "withdrawResponse")
    public JAXBElement<WithdrawResponse> createWithdrawResponse(WithdrawResponse value) {
        return new JAXBElement<WithdrawResponse>(_WithdrawResponse_QNAME, WithdrawResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "depositResponse")
    public JAXBElement<DepositResponse> createDepositResponse(DepositResponse value) {
        return new JAXBElement<DepositResponse>(_DepositResponse_QNAME, DepositResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "accountExistsResponse")
    public JAXBElement<AccountExistsResponse> createAccountExistsResponse(AccountExistsResponse value) {
        return new JAXBElement<AccountExistsResponse>(_AccountExistsResponse_QNAME, AccountExistsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOwner }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getOwner")
    public JAXBElement<GetOwner> createGetOwner(GetOwner value) {
        return new JAXBElement<GetOwner>(_GetOwner_QNAME, GetOwner.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsActive }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "isActive")
    public JAXBElement<IsActive> createIsActive(IsActive value) {
        return new JAXBElement<IsActive>(_IsActive_QNAME, IsActive.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getBalance")
    public JAXBElement<GetBalance> createGetBalance(GetBalance value) {
        return new JAXBElement<GetBalance>(_GetBalance_QNAME, GetBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Transfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "transfer")
    public JAXBElement<Transfer> createTransfer(Transfer value) {
        return new JAXBElement<Transfer>(_Transfer_QNAME, Transfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "closeAccount")
    public JAXBElement<CloseAccount> createCloseAccount(CloseAccount value) {
        return new JAXBElement<CloseAccount>(_CloseAccount_QNAME, CloseAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getAccountNumbers")
    public JAXBElement<GetAccountNumbers> createGetAccountNumbers(GetAccountNumbers value) {
        return new JAXBElement<GetAccountNumbers>(_GetAccountNumbers_QNAME, GetAccountNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getBalanceResponse")
    public JAXBElement<GetBalanceResponse> createGetBalanceResponse(GetBalanceResponse value) {
        return new JAXBElement<GetBalanceResponse>(_GetBalanceResponse_QNAME, GetBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "deposit")
    public JAXBElement<Deposit> createDeposit(Deposit value) {
        return new JAXBElement<Deposit>(_Deposit_QNAME, Deposit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Withdraw }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "withdraw")
    public JAXBElement<Withdraw> createWithdraw(Withdraw value) {
        return new JAXBElement<Withdraw>(_Withdraw_QNAME, Withdraw.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InactiveException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "InactiveException")
    public JAXBElement<InactiveException> createInactiveException(InactiveException value) {
        return new JAXBElement<InactiveException>(_InactiveException_QNAME, InactiveException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "createAccountResponse")
    public JAXBElement<CreateAccountResponse> createCreateAccountResponse(CreateAccountResponse value) {
        return new JAXBElement<CreateAccountResponse>(_CreateAccountResponse_QNAME, CreateAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OverdrawException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "OverdrawException")
    public JAXBElement<OverdrawException> createOverdrawException(OverdrawException value) {
        return new JAXBElement<OverdrawException>(_OverdrawException_QNAME, OverdrawException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "createAccount")
    public JAXBElement<CreateAccount> createCreateAccount(CreateAccount value) {
        return new JAXBElement<CreateAccount>(_CreateAccount_QNAME, CreateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsActiveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "isActiveResponse")
    public JAXBElement<IsActiveResponse> createIsActiveResponse(IsActiveResponse value) {
        return new JAXBElement<IsActiveResponse>(_IsActiveResponse_QNAME, IsActiveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "accountExists")
    public JAXBElement<AccountExists> createAccountExists(AccountExists value) {
        return new JAXBElement<AccountExists>(_AccountExists_QNAME, AccountExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAccountNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://local.bank/", name = "getAccountNumbersResponse")
    public JAXBElement<GetAccountNumbersResponse> createGetAccountNumbersResponse(GetAccountNumbersResponse value) {
        return new JAXBElement<GetAccountNumbersResponse>(_GetAccountNumbersResponse_QNAME, GetAccountNumbersResponse.class, null, value);
    }

}
