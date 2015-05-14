package bank.client;

import bank.Bank;
import bank.Connection;
import bank.local.Repository;

public abstract class AbstractDriver implements bank.BankDriver {
	protected bank.Bank bank = null;
	protected Repository repository;
	
	public String[] getDefaultParams(String[] args){
		String server = "localhost";
		String port = "9999";
		
		if(args.length<1){
			args = new String[2];
			args[0] = server;
			args[1] = port;
		}		
		return args;
	}
	
	@Override
	public void connect(String[] args){
		System.out.println("connecting client ...");
		repository = new Repository(getTransmitter());
	}

	@Override
	public void disconnect(){ System.out.println("disconnecting client"); }

	public Bank getBank(){
		return bank;
	}

	abstract Connection getTransmitter();
}
