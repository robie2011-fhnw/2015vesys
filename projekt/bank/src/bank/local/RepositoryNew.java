package bank.local;

import java.io.IOException;
import java.util.Set;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;
import bank.client.IConnection;
import bank.server.datainterchange.QueryCommandNew;
import bank.server.datainterchange.QueryResult;

public class RepositoryNew {
	private IConnection connection;
	public RepositoryNew(IConnection con){
		try{
			this.connection = con;
		}catch(Exception e){ 
			e.printStackTrace();
		}
		System.out.println("repository created");
	}
		
	<TResult>
	QueryResult<TResult>
	executeRemoteQuery(QueryCommandNew<TResult> query){
		System.out.println("execute remote query");		
		return connection.executeRemoteQuery(query);
	}
	
	public Bank getBank(){
		return new RemoteBank();
	}

	
	class RemoteBank implements bank.Bank{

		@Override
		public String createAccount(String owner) throws IOException {
			System.out.println("remote call createAccount");
			QueryCommandNew<String> query 
				= new QueryCommandNew<String>(bank -> bank.createAccount(owner));
			
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public boolean closeAccount(String number) throws IOException {
			System.out.println("remote call closeAccount");
			QueryCommandNew<Boolean> query 
				= new QueryCommandNew<Boolean>(bank -> bank.closeAccount(number));
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public Set<String> getAccountNumbers() throws IOException {
			System.out.println("remote call getAccountNumbers");
			QueryCommandNew<Set<String>> query 
				= new QueryCommandNew<Set<String>>(bank -> bank.getAccountNumbers());
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public Account getAccount(String number) throws IOException {
			System.out.println("remote call getAccount");
			QueryCommandNew<Account> query 
				= new QueryCommandNew<Account>(bank -> bank.getAccount(number));
			Account account = executeRemoteQuery(query).getResult();
			if(account == null) return null;
			return new RemoteAccount(account);
		}

		@Override
		public void transfer(Account a, Account b, double amount)
									throws IOException, IllegalArgumentException,
									OverdrawException, InactiveException {
			System.out.println("remote call transfer");

			String accountA, accountB;
			accountA = a.getNumber();
			accountB = b.getNumber();
			
			QueryCommandNew<Boolean> query = new QueryCommandNew<Boolean>(bank -> {
				Account tmpA = bank.getAccount(accountA);
				Account tmpB = bank.getAccount(accountB);
				bank.transfer(tmpA, tmpB, amount);
				return false;
			});
			
			
			QueryResult<Boolean> result = executeRemoteQuery(query);
			Exception exception = result.getException();
			if(exception == null){
				return;
			}else{
				if(exception instanceof InactiveException){
					throw (InactiveException) exception;
				}else if(exception instanceof IllegalArgumentException){
					throw (IllegalArgumentException) exception;
				}else if(exception instanceof IOException){
					throw (IOException) exception;
				}else if(exception instanceof OverdrawException){
					throw (OverdrawException) exception;
				}
			}
		}
									
	}
	
	class RemoteAccount implements bank.Account{
		bank.Account account;		
		
		public RemoteAccount(bank.Account account) {
			this.account = account;
		}

		@Override
		public String getNumber() throws IOException {
			return account.getNumber();
		}

		@Override
		public String getOwner() throws IOException {
			return account.getOwner();
		}

		@Override
		public boolean isActive() throws IOException {
			System.out.println("client/account: remote call isActive()");
			String accountNr = getNumber();
			QueryCommandNew<Boolean> query 
				= new QueryCommandNew<Boolean>(bank -> bank.getAccount(accountNr).isActive());
			
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public void deposit(double amount) throws IOException,
				IllegalArgumentException, InactiveException {
			System.out.println("client/account: remote call deposite()");

			String accountNr = getNumber();
			QueryCommandNew<Boolean> query 
				= new QueryCommandNew<Boolean>(bank -> {
							bank.getAccount(accountNr)
								.deposit(amount);
							return true;
						});
						
			QueryResult<Boolean> result = executeRemoteQuery(query);
			Exception exception = result.getException();
			if(exception == null){
				return;
			}else{
				if(exception instanceof InactiveException){
					throw (InactiveException) exception;
				}else if(exception instanceof IllegalArgumentException){
					throw (IllegalArgumentException) exception;
				}else if(exception instanceof IOException){
					throw (IOException) exception;
				}
			}
		}

		@Override
		public void withdraw(double amount) throws IOException,
				IllegalArgumentException, OverdrawException, InactiveException {
			
			String accountNr = getNumber();
			QueryCommandNew<Boolean> query 
				= new QueryCommandNew<Boolean>(bank -> {
							bank.getAccount(accountNr)
								.withdraw(amount);
							return true;
						});
			
			QueryResult<Boolean> result = executeRemoteQuery(query);			
			Exception exception = result.getException();			
			if(exception == null){
				return;
			}else{
				if(exception instanceof InactiveException){
					throw (InactiveException) exception;
				}else if(exception instanceof IllegalArgumentException){
					throw (IllegalArgumentException) exception;
				}else if(exception instanceof IOException){
					throw (IOException) exception;
				}else if(exception instanceof OverdrawException){
					throw (OverdrawException) exception;
				}
			}
		}

		@Override
		public double getBalance() throws IOException {
			System.out.println("client/account: remote call getBalance()");
			String accountNr = getNumber();
			QueryCommandNew<Double> query 
				= new QueryCommandNew<Double>(bank -> bank.getAccount(accountNr).getBalance());
			
			return executeRemoteQuery(query).getResult();
		}
		
	}

	
}
