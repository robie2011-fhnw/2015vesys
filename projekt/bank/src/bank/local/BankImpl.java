package bank.local;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import bank.InactiveException;
import bank.OverdrawException;


public class BankImpl implements bank.Bank, Serializable {
	private int lastAccountId = 0;
	
	private final Map<String, AccountImpl> accounts = new HashMap<>();

	private synchronized int getNewAccountNumber(){
		return ++lastAccountId;
	}
	
	@Override
	public Set<String> getAccountNumbers() {			
		HashSet<String> numbers = new HashSet<String>();
		
		for(AccountImpl account : accounts.values()){
			if(account.isActive()){
				numbers.add(account.getNumber());
			}
		}
								
		return numbers;
	}

	@Override
	public String createAccount(String owner) {
		String newAccountNumber = Integer.toString(getNewAccountNumber());
		AccountImpl newAccount = new AccountImpl(owner, newAccountNumber); 
		
		accounts.put(newAccountNumber , newAccount);
		return newAccountNumber;
	}

	@Override
	public boolean closeAccount(String number) {
		AccountImpl account = accounts.get(number);
		
		if(account == null 
			|| !account.isActive() 
			|| account.getBalance() != 0) {				
			
			return false;
		}
		
		account.makeInactive();
		return true;
	}

	@Override
	public bank.Account getAccount(String number) {
		return accounts.get(number);
	}
	
	@Override
	public void transfer(bank.Account from, bank.Account to, double amount)
			throws IOException, InactiveException, OverdrawException {
		
		if(!from.isActive() || !to.isActive()) throw new InactiveException();
		if(from.getBalance() < amount) throw new OverdrawException();
		if(amount<0) throw new OverdrawException("amount can not be negativ");
		
		from.withdraw(amount);
		to.deposit(amount);
	}

}

