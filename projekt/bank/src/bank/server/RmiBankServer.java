package bank.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import bank.BankRmiRemote;
import bank.local.BankRmiRemoteImpl;

public class RmiBankServer {
	
	public static void main(String[] args) 
		throws 	MalformedURLException, 
				RemoteException, 
				AlreadyBoundException {
		

		BankRmiRemote bank = new BankRmiRemoteImpl();
		UnicastRemoteObject.exportObject(bank,0);
		
		// rmi registry service hast to be started in bin\ working directory
		// default port: 1099
		Naming.rebind("BankService", bank);
	}

}
