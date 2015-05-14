package bank.local;

import java.io.IOException;
import java.util.Set;
import javax.jws.WebService;
import bank.Account;
import bank.Bank;
import bank.SimpleBankAccess;
import bank.InactiveException;
import bank.OverdrawException;

@WebService
public class SimpleBankAccessImpl implements SimpleBankAccess {
	
	public static Bank bank;

	//public SimpleBankAccess(IBank bank){ this.bank = bank; }
	/**
	 * Exception
	 * Inner classes annotation javax.jws.WebService must be static. Class: bank.local.SimpleBankAccess
	 * 	WHY?!
	 */
	
	@Override
	public String createAccount(String owner) throws IOException {
		return bank.createAccount(owner);
	}

	@Override
	public boolean closeAccount(String number) throws IOException {
		return bank.closeAccount(number);
	}

	@Override
	public String[] getAccountNumbers() throws IOException {
		Set<String> accounts = bank.getAccountNumbers();
		return accounts.toArray(new String[accounts.size()]);
	}

	@Override
	public boolean accountExists(String number) throws IOException {
		Account account = bank.getAccount(number);
		return account != null;
	}

	@Override
	public void transfer(String a, String b, double amount) throws IOException,
			IllegalArgumentException, OverdrawException, InactiveException {
		Account accountA = bank.getAccount(a);
		Account accountB = bank.getAccount(b);
		bank.transfer(accountA,accountB, amount);
	}

	// ==============================================================
	// Account
	
	@Override
	public String getNumber(String accountNr) throws IOException {
		return bank.getAccount(accountNr).getNumber();
	}

	@Override
	public String getOwner(String accountNr) throws IOException {
		return bank.getAccount(accountNr).getOwner();
	}

	@Override
	public boolean isActive(String accountNr) throws IOException {
		return bank.getAccount(accountNr).isActive();
	}

	@Override
	public void deposit(String accountNr, double amount) throws IOException,
			IllegalArgumentException, InactiveException {
		bank.getAccount(accountNr).deposit(amount);
	}

	@Override
	public void withdraw(String accountNr, double amount) throws IOException,
			IllegalArgumentException, OverdrawException, InactiveException {
		bank.getAccount(accountNr).withdraw(amount);
	}

	@Override
	public double getBalance(String accountNr) throws IOException {
		return bank.getAccount(accountNr).getBalance();
	}


}
