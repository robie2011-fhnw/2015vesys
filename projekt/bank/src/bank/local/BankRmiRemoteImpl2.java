package bank.local;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Set;

import bank.Account;
import bank.Bank;
import bank.BankDriver2.UpdateHandler;
import bank.AccountRmiRemote;
import bank.BankRmiRemote;
import bank.BankRmiRemote2;
import bank.InactiveException;
import bank.OverdrawException;
import bank.RemoteUpdateHandler;

public class BankRmiRemoteImpl2 extends UnicastRemoteObject implements BankRmiRemote2 {
	Bank bank = new BankImpl();
	LinkedList<RemoteUpdateHandler> updateHandlers = new LinkedList<RemoteUpdateHandler>();

	public BankRmiRemoteImpl2() throws RemoteException{
		super();
	}
	
	public BankRmiRemoteImpl2(int port) throws RemoteException{
		super(port);
	}

	public String createAccount(String owner) throws IOException {
		String accountNr = bank.createAccount(owner);
		notifyUpdateHandler(accountNr);
		return accountNr;
	}

	public boolean closeAccount(String number) throws IOException {
		if(bank.closeAccount(number)){
			notifyUpdateHandler(number);
			return true;
		}
		return false;
	}

	public Set<String> getAccountNumbers() throws IOException {
		return bank.getAccountNumbers();
	}

	public Account getAccount(String number) throws IOException {
		try {
			Account a = bank.getAccount(number);
			if(a == null){
				return null;
			}else{
				return new AccountRmiRemoteImpl2(a);
			}
		} catch (RemoteException e) { e.printStackTrace(); }
		return null;
	}

	public void transfer(Account a, Account b, double amount)
			throws IOException, IllegalArgumentException, OverdrawException,
			InactiveException {
		bank.transfer(a, b, amount);
		notifyUpdateHandler(a.getNumber());
		notifyUpdateHandler(b.getNumber());
	}

	@Override
	public void registerUpdateHandler(RemoteUpdateHandler handler) {
		System.out.println("register handler");
		updateHandlers.add(handler);
	}
	
	private void notifyUpdateHandler(String changedAccount){
		if(updateHandlers.size() == 0) {
			System.out.println("exit notification because no observers");
			return;
		}
		System.out.println("do notify");
		
		try {
			for(UpdateHandler u : updateHandlers) 
				u.accountChanged(changedAccount);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public class AccountRmiRemoteImpl2 
	 extends UnicastRemoteObject 
	 implements AccountRmiRemote {
		
		private Account account;
		public AccountRmiRemoteImpl2(Account a) throws RemoteException {
			super();
			this.account = a;
		}
		
		private void notifyBank() throws IOException{
			BankRmiRemoteImpl2.this.notifyUpdateHandler(account.getNumber());
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
			notifyBank();
		}
		public void withdraw(double amount) throws IOException,
				IllegalArgumentException, OverdrawException, InactiveException {
			account.withdraw(amount);
			notifyBank();
		}
		public double getBalance() throws IOException {
			return account.getBalance();
		}
	}
}
