package bank.client.soap;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;
import bank.client.jaxws.IOException_Exception;
import bank.client.jaxws.InactiveException_Exception;
import bank.client.jaxws.OverdrawException_Exception;
import bank.client.jaxws.SimpleBankAccess;

public class Bank2SimpleBankAccessMapper implements Bank {
	private SimpleBankAccess simpleBankAccess;
	
	public Bank2SimpleBankAccessMapper(SimpleBankAccess simpleBankAccess) {
		this.simpleBankAccess = simpleBankAccess;
	}

	@Override
	public String createAccount(String owner) throws IOException {
		try {
			return simpleBankAccess.createAccount(owner);
		} catch (IOException_Exception e) {
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public boolean closeAccount(String number) throws IOException {
		try {
			return simpleBankAccess.closeAccount(number);
		} catch (IOException_Exception e) {
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public Set<String> getAccountNumbers() throws IOException {
		 List<String> accounts;
		try {
			accounts = simpleBankAccess.getAccountNumbers();
		} catch (IOException_Exception e) {
			throw new IOException(e.getMessage());
		}
		return new HashSet<>(accounts);
	}

	@Override
	public Account getAccount(String number) throws IOException {
		try {
			if(!simpleBankAccess.accountExists(number)) return null;
		} catch (IOException_Exception e) {
			throw new IOException(e.getMessage());
		}
		return new Account2SimpleBankAccessMapper(number);
	}

	@Override
	public void transfer(Account a, Account b, double amount)
			throws IOException, IllegalArgumentException, OverdrawException,
			InactiveException {
		try {
			simpleBankAccess.transfer(a.getNumber(), b.getNumber(), amount);
		} catch (IOException_Exception e) {
			throw new IOException(e.getMessage());
		} catch (InactiveException_Exception e) {
			throw new InactiveException(e.getMessage());
		} catch (OverdrawException_Exception e) {
			throw new OverdrawException(e.getMessage());
		}
	}

	
	// ******************************************************************
	public class Account2SimpleBankAccessMapper implements Account {
		final String accountNr;
		
		// not public; should not be created outside of package
		Account2SimpleBankAccessMapper(String number){
			this.accountNr = number;
		}

		@Override
		public String getNumber() throws IOException {
			return this.accountNr;
		}

		@Override
		public String getOwner() throws IOException {
			try {
				return simpleBankAccess.getOwner(accountNr);
			} catch (IOException_Exception e) {
				throw new IOException(e.getMessage());
			}
		}

		@Override
		public boolean isActive() throws IOException {
			try {
				return simpleBankAccess.isActive(accountNr);
			} catch (IOException_Exception e) {
				throw new IOException(e.getMessage());
			}
		}

		@Override
		public void deposit(double amount) throws IOException,
				IllegalArgumentException, InactiveException {
			try {
				simpleBankAccess.deposit(accountNr, amount);
			} catch (IOException_Exception e) {
				throw new IOException(e.getMessage());
			} catch (InactiveException_Exception e) {
				throw new InactiveException(e.getMessage());
			}
		}

		@Override
		public void withdraw(double amount) throws IOException,
				IllegalArgumentException, OverdrawException, InactiveException {
			try {
				simpleBankAccess.withdraw(accountNr, amount);
			} catch (IOException_Exception e) {
				throw new IOException(e.getMessage());
			} catch (InactiveException_Exception e) {
				throw new InactiveException(e.getMessage());
			} catch (OverdrawException_Exception e) {
				throw new OverdrawException(e.getMessage());
			}
		}

		@Override
		public double getBalance() throws IOException {
			try {
				return simpleBankAccess.getBalance(accountNr);
			} catch (IOException_Exception e) {
				throw new IOException(e.getMessage());
			}
		}

	}

}
