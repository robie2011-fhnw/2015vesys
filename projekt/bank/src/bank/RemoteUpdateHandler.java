package bank;

import java.rmi.Remote;

import bank.BankDriver2.UpdateHandler;

public interface RemoteUpdateHandler extends UpdateHandler, Remote {

}
