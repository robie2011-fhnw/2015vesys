package bank.local;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Set;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;

public class BankImpl2 implements Bank, Serializable {
	private Bank bank = new BankImpl();
	private LinkedList<AccountChangeListener> listeners = 
			new LinkedList<AccountChangeListener>();
	
	public String createAccount(String owner) throws IOException {
		String number = bank.createAccount(owner);
		notifyAccountChange(number);
		return number;
	}

	public boolean closeAccount(String number) throws IOException {
		boolean result = bank.closeAccount(number);
		notifyAccountChange(number);
		return result;
	}

	public Set<String> getAccountNumbers() throws IOException {
		return bank.getAccountNumbers();
	}

	public Account getAccount(String number) throws IOException {
		Account account = bank.getAccount(number);
		if(account == null) return null;
		return new AccountExtended(bank.getAccount(number));
	}

	public void transfer(Account a, Account b, double amount)
			throws IOException, IllegalArgumentException, OverdrawException,
			InactiveException {
		bank.transfer(a, b, amount);
		notifyAccountChange(a.getNumber());
		notifyAccountChange(b.getNumber());
	}
	
	void notifyAccountChange(String accountNumber)
	{
		for(AccountChangeListener listener : listeners)
			listener.accountChanged(accountNumber);
	}
	
	public void addChangeListener(AccountChangeListener handler)
	{
		this.listeners.add(handler);
	}
	
	
	@FunctionalInterface
	public interface AccountChangeListener extends Serializable
	{
		void accountChanged(String number);
	}
	
	public class AccountExtended implements Account, Serializable
	{
		private Account account;
		public String getNumber() throws IOException {
			return account.getNumber();
		}
		public String getOwner() throws IOException {
			return account.getOwner();
		}
		public boolean isActive() throws IOException {
			return account.isActive();
		}
		public void deposit(double amount) throws IOException,
				IllegalArgumentException, InactiveException {
			account.deposit(amount);
			notifyAccountChange(getNumber());
		}
		public void withdraw(double amount) throws IOException,
				IllegalArgumentException, OverdrawException, InactiveException {
			account.withdraw(amount);
			notifyAccountChange(getNumber());
		}
		public double getBalance() throws IOException {
			return account.getBalance();
		}
		public AccountExtended(Account a) {
			this.account = a;
		}
	}
}
