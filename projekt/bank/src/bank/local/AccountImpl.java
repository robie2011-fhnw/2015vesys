package bank.local;

import java.io.Serializable;

import bank.InactiveException;
import bank.OverdrawException;

public class AccountImpl implements bank.Account, Serializable {
	private String number;
	private String owner;
	private double balance;
	private boolean active = true;

	AccountImpl(String owner, String number) {
		this.owner = owner;
		this.number = number;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getOwner() {
		return owner;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void deposit(double amount) throws InactiveException {
		if(!isActive()) throw new InactiveException();
		if(amount<0) throw new IllegalArgumentException("amount can not be negativ");
		
		balance += amount;
	}

	@Override
	public void withdraw(double amount) throws InactiveException, OverdrawException {
		if(!isActive()) throw new InactiveException();
		if(getBalance()<amount) throw new OverdrawException();
		if(amount<0) throw new IllegalArgumentException("amount can not be negativ");
		
		balance -= amount;
	}
	
	void makeInactive(){
		this.active = false;
	}
}