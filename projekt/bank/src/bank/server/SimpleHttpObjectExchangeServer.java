package bank.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;

import bank.local.BankImpl;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class SimpleHttpObjectExchangeServer {
	public static void main(String[] args) throws IOException {
		System.out.println("starting SimpleHttpServer");
		BankImpl bank = new BankImpl();
		
		HttpServer s = HttpServer.create(new InetSocketAddress(9999), 0);
		HttpContext context = s.createContext("/httpServletObjectExchange/oex", new BankHandler(bank));
		System.out.println("/bank registred");		
		s.start();
	}
	
	static class BankHandler implements HttpHandler{

		private BankImpl bank;

		public BankHandler(BankImpl b){
			this.bank = b;
			System.out.println("bankhandler init");
		}
		
		@SuppressWarnings("rawtypes")
		@Override
		public void handle(HttpExchange arg0) throws IOException {
			arg0.getResponseHeaders().add("Content-Type", "application/x-bank");
			arg0.sendResponseHeaders(200, 0);
			System.out.println("call handle");
			System.out.println(arg0.getRequestMethod());
			/*
			System.out.println(arg0.getRequestHeaders().size());
			arg0.getRequestHeaders().forEach((x,s) -> System.out.println(x+"/"+s));
			*/
				
			

			ObjectInputStream objectInputStream = new ObjectInputStream(arg0.getRequestBody());
			
			QueryCommand query = null;
			try {
				query = (QueryCommand) objectInputStream.readObject();
				System.out.println("Object received");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			System.out.println("Writing response");
			ObjectOutputStream out = new ObjectOutputStream(arg0.getResponseBody());
			
			QueryResult result = null;
			if(query != null) result = query.execute(bank);
			
			out.writeObject(result);
			out.close();
			
		}
		
	}
}



