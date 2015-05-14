package bank.local;

import java.rmi.RemoteException;

import bank.Account;
import bank.BankRmiRemote;

public class BankRmiRemoteImpl 
	extends BankImpl 
	implements BankRmiRemote {

	@Override
	public AccountRmiRemoteImpl getAccount(String number) {
		try {
			Account a = super.getAccount(number);
			if(a == null){
				return null;
			}else{
				return new AccountRmiRemoteImpl(a);
			}
		} catch (RemoteException e) { e.printStackTrace(); }
		return null;
	}
	
}
