package bank.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import bank.BankRmiRemote2;
import bank.local.BankRmiRemoteImpl2;

public class RmiBankServer2 {

	public static void main(String[] args) 	
			throws 	MalformedURLException, 
			RemoteException, 
			AlreadyBoundException {
		
		BankRmiRemote2 bank = new BankRmiRemoteImpl2();

		
		// rmi registry service hast to be started in bin\ working directory
		// default port: 1099
		Naming.rebind("BankService2", bank);
	}

}
