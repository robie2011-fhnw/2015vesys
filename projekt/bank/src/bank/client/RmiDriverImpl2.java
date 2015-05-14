package bank.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import bank.Bank;
import bank.BankDriver2;
import bank.BankRmiRemote2;

public class RmiDriverImpl2 implements BankDriver2 {
	BankRmiRemote2 bank;
	
	@Override
	public void connect(String[] args) throws IOException {
		String uri = "rmi://localhost/BankService2";
		if(args.length>0){
			uri = args[0];
		}
		
		try {
			bank = (BankRmiRemote2) Naming.lookup(uri);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect() throws IOException {
		bank = null;
	}

	@Override
	public Bank getBank() {
		return bank;
	}

	@Override
	public void registerUpdateHandler(UpdateHandler handler) throws IOException {
		RemoteUpdateHandlerImpl remoteHandler = new RemoteUpdateHandlerImpl(handler);
		
		bank.registerUpdateHandler(remoteHandler);
	}
	
	class RemoteUpdateHandlerImpl extends UnicastRemoteObject implements bank.RemoteUpdateHandler
	{
		private final UpdateHandler updateHandler;
		public RemoteUpdateHandlerImpl(UpdateHandler updateHandler) throws RemoteException {
			super();
			this.updateHandler = updateHandler;
		}

		public void accountChanged(String id) throws IOException {
			updateHandler.accountChanged(id);
		}
	}
}

