package bank.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bank.Bank;

public class RmiDriverImpl extends AbstractDriver {
	
	@Override
	public void connect(String[] args)
	{
		String uri = "rmi://localhost/BankService";
		if(args.length>0){
			uri = args[0];
		}
		
		try {
			bank = (Bank) Naming.lookup(uri);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
