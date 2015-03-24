/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.local;

// Test Implementation. Use local bank
public class Driver implements bank.IBankDriver {
	private bank.IBank bank = null;

	@Override
	public void connect(String[] args) {				
		bank = new Bank();		
	}

	@Override
	public void disconnect() {
		bank = null;			
		System.out.println("disconnected...");
	}

	@Override
	public bank.IBank getBank() {
		return bank;
	}

}


