/*
package bank.server.datainterchange.converter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;
import bank.server.datainterchange.AccountTarget;
import bank.server.datainterchange.IExecutionTarget;
import bank.server.datainterchange.QueryCommandBase;

public class Converter {
	private QueryCommandBase query;

	public Converter(QueryCommandBase query){
		this.query = query;
	}
	
	public String toJSON(){
		IExecutionTarget executionTarget = query.getExecutionTarget();
		if(executionTarget instanceof AccountTarget){
			ConverterAccountTarget converterAccountTarget 
				= new ConverterAccountTarget( (AccountTarget) executionTarget);
			
			query.execute(converterAccountTarget);
			
			StringBuilder builder = new StringBuilder();
			converterAccountTarget.getInvocations().forEach( inv -> builder.append(inv+";"));		
			return builder.toString();
		}
		throw new NotImplementedException();
	}
	
	interface IConverterTargets{
		LinkedList<String> invocations = new LinkedList<String>();
		default LinkedList<String> getInvocations() { return invocations; }
	}
	
	static class ConverterAccountTarget implements Account, IConverterTargets{
		private String accountNumber;

		public ConverterAccountTarget(AccountTarget accountTarget) {
			this.accountNumber = accountTarget.getNumber();
		}
		
		@Override
		public String getNumber() throws IOException {
			invocations.add(String.format("/Account/%s/getNumber",accountNumber));
			return null;
		}

		@Override
		public String getOwner() throws IOException {
			invocations.add(String.format("/Account/%s/getOwner",accountNumber));
			return null;
		}

		@Override
		public boolean isActive() throws IOException {
			invocations.add(String.format("/Account/%s/isActive",accountNumber));
			return false;
		}

		@Override
		public void deposit(double amount) throws IOException,
				IllegalArgumentException, InactiveException {
			invocations.add(String.format("/Account/%s/deposit/%s",accountNumber,amount));
		}

		@Override
		public void withdraw(double amount) throws IOException,
				IllegalArgumentException, OverdrawException, InactiveException {
			invocations.add(String.format("/Account/%s/withdraw/%s",accountNumber,amount));
		}

		@Override
		public double getBalance() throws IOException {
			invocations.add(String.format("/Account/%s/getBalance",accountNumber));
			return 0;
		}
		
	}
	
	static class ConverterBankTarget implements Bank, IConverterTargets{

		@Override
		public String createAccount(String owner) throws IOException {
			invocations.add(String.format("/Bank/createAccount/%s", owner));
			return null;
		}

		@Override
		public boolean closeAccount(String number) throws IOException {
			invocations.add(String.format("/Bank/closeAccount/%s", number));
			return false;
		}

		@Override
		public Set<String> getAccountNumbers() throws IOException {
			invocations.add(String.format("/Bank/getAccountNumbers"));
			return null;
		}

		@Override
		public Account getAccount(String number) throws IOException {
			invocations.add(String.format("/Bank/getAccount/%s", number));
			return null;
		}

		@Override
		public void transfer(Account a, Account b, double amount)
				throws IOException, IllegalArgumentException,
				OverdrawException, InactiveException {
			invocations.add(String.format("/Bank/transfer/%s/%s/%s", a.getNumber(), b.getNumber(), amount));
		}
		
	}

}

*/
