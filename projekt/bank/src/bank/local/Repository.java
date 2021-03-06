package bank.local;

import java.io.IOException;
import java.util.Set;

import bank.Account;
import bank.Bank;
import bank.Connection;
import bank.InactiveException;
import bank.OverdrawException;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public class Repository {
	private Connection connection;
	public Repository(Connection con){
		try{
			this.connection = con;
		}catch(Exception e){ 
			e.printStackTrace();
		}
		System.out.println("repository created");
	}
		
	<TResult>
	QueryResult<TResult>
	executeRemoteQuery(QueryCommand<TResult> query){
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
			QueryCommand<String> query 
				= new QueryCommand<String>(bank -> bank.createAccount(owner));
			
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public boolean closeAccount(String number) throws IOException {
			System.out.println("remote call closeAccount");
			QueryCommand<Boolean> query 
				= new QueryCommand<Boolean>(bank -> bank.closeAccount(number));
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public Set<String> getAccountNumbers() throws IOException {
			System.out.println("remote call getAccountNumbers");
			QueryCommand<Set<String>> query 
				= new QueryCommand<Set<String>>(bank -> bank.getAccountNumbers());
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public Account getAccount(String number) throws IOException {
			System.out.println("remote call getAccount");
			QueryCommand<Account> query 
				= new QueryCommand<Account>(bank -> bank.getAccount(number));
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
			
			QueryCommand<Boolean> query = new QueryCommand<Boolean>(bank -> {
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
			QueryCommand<Boolean> query 
				= new QueryCommand<Boolean>(bank -> bank.getAccount(accountNr).isActive());
			
			return executeRemoteQuery(query).getResult();
		}

		@Override
		public void deposit(double amount) throws IOException,
				IllegalArgumentException, InactiveException {
			System.out.println("client/account: remote call deposite()");

			String accountNr = getNumber();
			QueryCommand<Boolean> query 
				= new QueryCommand<Boolean>(bank -> {
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
				
				throw (RuntimeException) exception;
			}
		}

		@Override
		public void withdraw(double amount) throws IOException,
				IllegalArgumentException, OverdrawException, InactiveException {
			
			String accountNr = getNumber();
			QueryCommand<Boolean> query 
				= new QueryCommand<Boolean>(bank -> {
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
				}else{
					throw (RuntimeException) exception;
				}				
			}
		}

		@Override
		public double getBalance() throws IOException {
			System.out.println("client/account: remote call getBalance()");
			String accountNr = getNumber();
			QueryCommand<Double> query 
				= new QueryCommand<Double>(bank -> bank.getAccount(accountNr).getBalance());
			
			return executeRemoteQuery(query).getResult();
		}
		
	}

	
}
