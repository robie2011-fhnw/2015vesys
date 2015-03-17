package playground;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

import javax.management.Query;

import bank.Bank;
import bank.client.HttpConnection;
import bank.client.IConnection;
import bank.local.RepositoryNew;
import bank.server.datainterchange.QueryCommandNew;
import bank.server.datainterchange.QueryResult;
import sun.net.www.protocol.http.HttpURLConnection;

public class WebclientHttp1 {

	public static void main(String[] args) throws IOException {
		//URL url = new URL("http://localhost:8080/httpServletObjectExchange/oex");
		//HttpURLConnection con = (HttpURLConnection) url.openConnection();
		//con.connect();
		
		
//		RepositoryNew repositoryNew = new RepositoryNew(con.getOutputStream(), con.getInputStream());
//		
//		Bank b = repositoryNew.getBank();
//		b.getAccountNumbers();
		b();
		System.out.println("done");
		
	}
	
	public static void simpleString(HttpURLConnection con) throws IOException{
		con.setDoOutput(true);
		con.setDoInput(true);		
		con.setRequestMethod("POST");
		con.connect();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(con.getOutputStream());
		objectOutputStream.writeObject(new String("halloo welt"));
		
		ObjectInputStream objectInputStream = new ObjectInputStream(con.getInputStream());
		try {
			@SuppressWarnings("unused")
			String rs = (String) objectInputStream.readObject();
			System.out.println("Result: "  +rs);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void b() throws IOException{
//		con.setDoOutput(true);
//		con.setDoInput(true);		
//		con.setRequestMethod("POST");
//		con.connect();
		

		RepositoryNew repositoryNew = new RepositoryNew( new HttpConnection());
		
		Bank b = repositoryNew.getBank();
		b.createAccount("gsdfb");
		
		Set<String> accountNumbers = b.getAccountNumbers();
		accountNumbers.forEach(s -> System.out.println(s));
		/*
		 ObjectOutputStream objectOutputStream = new ObjectOutputStream(con.getOutputStream());
		 objectOutputStream.writeObject(new QueryCommandNew<>( b -> b.createAccount("rob") ));
		 
		
		ObjectInputStream objectInputStream = new ObjectInputStream(con.getInputStream());
		try {
			@SuppressWarnings("unused")
			QueryResult<String> rs = (QueryResult<String>) objectInputStream.readObject();			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
		
}
