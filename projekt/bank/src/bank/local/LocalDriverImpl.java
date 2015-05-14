/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.local;

// Test Implementation. Use local bank
public class LocalDriverImpl implements bank.BankDriver {
	private bank.Bank bank = null;

	@Override
	public void connect(String[] args) {				
		bank = new BankImpl();		
	}

	@Override
	public void disconnect() {
		bank = null;			
		System.out.println("disconnected...");
	}

	@Override
	public bank.Bank getBank() {
		return bank;
	}

}


