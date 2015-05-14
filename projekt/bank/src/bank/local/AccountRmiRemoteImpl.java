package bank.local;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import bank.Account;
import bank.AccountRmiRemote;
import bank.InactiveException;
import bank.OverdrawException;

public class AccountRmiRemoteImpl  
	extends UnicastRemoteObject
	implements AccountRmiRemote {
	private final Account account;
	
	public AccountRmiRemoteImpl(Account a) throws RemoteException {
		this.account = a;
	}

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
	}

	public void withdraw(double amount) throws IOException,
			IllegalArgumentException, OverdrawException, InactiveException {
		account.withdraw(amount);
	}

	public double getBalance() throws IOException {
		return account.getBalance();
	}
	
}
