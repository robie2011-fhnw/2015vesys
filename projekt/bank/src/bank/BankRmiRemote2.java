package bank;

import java.rmi.RemoteException;


public interface BankRmiRemote2 extends BankRmiRemote {
	void registerUpdateHandler(RemoteUpdateHandler handler) throws RemoteException;
}
