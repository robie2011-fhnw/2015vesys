package bank.client;

import bank.IBank;
import bank.IConnection;
import bank.client.jaxws.SimpleBankAccess;
import bank.client.jaxws.SimpleBankAccessService;
import bank.client.soap.Bank2SimpleBankAccessMapper;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public class SoapBankServiceDriver extends AbstractDriver {

	@Override
	public void disconnect() { }

	@Override
	public IBank getBank() {
		return bank;
	}

	@Override
	IConnection getTransmitter() {
		SimpleBankAccess simpleBankAccess = new SimpleBankAccessService().getSimpleBankAccessPort();
		bank = new Bank2SimpleBankAccessMapper(simpleBankAccess);
		
		return new IConnection() {
			
			@Override
			public <TResult> QueryResult<TResult> 
			executeRemoteQuery( QueryCommand<TResult> query) { 
				return query.execute(bank);
				}
		};
	}

}
