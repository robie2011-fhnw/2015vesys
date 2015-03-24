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
	public abstract void connect(String[] args);

	@Override
	public abstract void disconnect();

	@Override
	public abstract IBank getBank();

	abstract IConnection getTransmitter();
}
