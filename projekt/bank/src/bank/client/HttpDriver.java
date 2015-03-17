package bank.client;

import bank.local.RepositoryNew;

public class HttpDriver implements bank.BankDriver {
	private bank.Bank bank = null;
	private RepositoryNew repository;

	@Override
	public void connect(String[] args) {
		repository = new RepositoryNew(new HttpConnection());		
		bank = repository.getBank();		
	}

	@Override
	public void disconnect() {
		bank = null;		
		System.out.println("disconnected...");
	}

	@Override
	public bank.Bank getBank() {
		return bank;
	}

}