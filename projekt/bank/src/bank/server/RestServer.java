package bank.server;

import java.io.IOException;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;
import bank.local.BankImpl;

@Path("/accounts")
public class RestServer {
	private static Bank bank = new BankImpl();
	
	@POST
	public String createAccount(String owner) 
			throws IOException {
		return bank.createAccount(owner);
	}

	@GET
	public Set<String> getAccountNumbers() 
			throws IOException {
		return bank.getAccountNumbers();
	}
	
	@DELETE
	@Path("{number}")
	public boolean closeAccount(@PathParam("{number}") String number) 
			throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@GET
	@Path("{number}")
	public Account getAccount(@PathParam("number") String number) 
			throws IOException {
		// TODO Auto-generated method stub
		// inkl. alle metainformationen
		return null;
	}

	@POST
	@Path("{numberA}/transfer/{numberB}/{amount}")
	public void transfer(@PathParam("{numberA}") Account a, 
						 @PathParam("{numberB}") Account b, 
						 @PathParam("{amount}") double amount)
			throws IOException, IllegalArgumentException, OverdrawException,
			InactiveException {
		// TODO Auto-generated method stub

	}

	
	// ----- accounts ----------
	
	
	@HEAD
	@Path("{number}")
	public boolean isActive(@PathParam("{nmber}") String number) 
			throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@POST
	@Path("{number}/deposit/{amount}")
	public void deposit(@PathParam("{number}") String number, 
						@PathParam("{amount}") double amount) 
		throws IOException, IllegalArgumentException, InactiveException {
		// TODO Auto-generated method stub
		
	}

	@POST
	@Path("{number}/withdraw/{amount}")
	public void withdraw(@PathParam("{number}") String number,
						 @PathParam("{amount}") double amount) 
		 throws IOException, IllegalArgumentException, OverdrawException, InactiveException {
		// TODO Auto-generated method stub
		
	}

	public static class AccountInformation{
		public final String owner, number;
		public final double balance;
		public final boolean isActive;
		
		public AccountInformation(String owner, String number, double balance, boolean isActive){
			this.owner = owner;
			this.number = number;
			this.balance = balance;
			this.isActive = isActive;
		}
	}
}
