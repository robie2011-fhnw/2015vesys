package bank.client;

import bank.IBank;
import bank.IConnection;
import bank.local.Repository;

public abstract class AbstractDriver implements bank.IBankDriver {
	protected bank.IBank bank = null;
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

	public IBank getBank(){
		return bank;
	}

	abstract IConnection getTransmitter();
}
