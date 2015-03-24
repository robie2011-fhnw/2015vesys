package bank.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.local.Bank;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

// does not work; Uebung 01
public class HttpObjectExchangeServlet extends HttpServlet {
	Bank bank = new Bank();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		QueryCommand query = null;
		try {
			query = (QueryCommand)  new ObjectInputStream(req.getInputStream()).readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Object received");
		QueryResult result = query.execute(bank);
		System.out.println("Writing response");
		ObjectOutputStream out = new ObjectOutputStream(resp.getOutputStream());
		out.writeObject(result);
	}
}
