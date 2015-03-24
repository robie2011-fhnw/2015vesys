package bank;

import java.io.IOException;

import javax.jws.WebService;

@WebService
public interface ISimpleBankAccess {
	// ====================================================
	// bank interface
	String createAccount(String owner) throws IOException;
	
	boolean closeAccount(String number) throws IOException;
	
	String[] getAccountNumbers() throws IOException;
	
	boolean accountExists(String number) throws IOException;
	
	void transfer(String a, String b, double amount) 
			throws  IOException, 
					IllegalArgumentException, 
					OverdrawException,
					InactiveException;
	
	// ====================================================
	// Account interface
	String getNumber(String accountNr) throws IOException;
	String getOwner(String accountNr) throws IOException;
	boolean isActive(String accountNr) throws IOException;
	
	void deposit(String accountNr, double amount) throws IOException,
			IllegalArgumentException, InactiveException;
	
	void withdraw(String accountNr, double amount) throws IOException,
			IllegalArgumentException, OverdrawException, InactiveException;
	
	double getBalance(String accountNr) throws IOException;
}
