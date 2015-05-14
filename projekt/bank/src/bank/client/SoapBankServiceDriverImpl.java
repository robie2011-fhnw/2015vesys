package bank.client;

import bank.Bank;
import bank.Connection;
import bank.client.jaxws.SimpleBankAccess;
import bank.client.jaxws.SimpleBankAccessService;
import bank.client.soap.Bank2SimpleBankAccessMapper;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public class SoapBankServiceDriverImpl extends AbstractDriver {

	@Override
	public void disconnect() { }

	@Override
	public Bank getBank() {
		return bank;
	}

	@Override
	Connection getTransmitter() {
		SimpleBankAccess simpleBankAccess = new SimpleBankAccessService().getSimpleBankAccessPort();
		bank = new Bank2SimpleBankAccessMapper(simpleBankAccess);
		
		return new Connection() {
			
			@Override
			public <TResult> QueryResult<TResult> 
			executeRemoteQuery( QueryCommand<TResult> query) { 
				return query.execute(bank);
				}
		};
	}

}
