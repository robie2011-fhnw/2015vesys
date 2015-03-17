package bank.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import sun.net.www.protocol.http.HttpURLConnection;
import bank.server.datainterchange.QueryCommandNew;
import bank.server.datainterchange.QueryResult;

public class HttpConnection extends IConnection {

	@Override
	public <TResult> QueryResult<TResult> executeRemoteQuery(
			QueryCommandNew<TResult> query) {
		try{			
			URL url = new URL("http://localhost:8080/httpServletObjectExchange/oex?tmp="+Math.random());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);		
			con.setRequestMethod("POST");
			con.connect();
						
			// writing
			System.out.println("Client write object into socket");
			new ObjectOutputStream(con.getOutputStream()).writeObject(query);			
			
			
			// reading
			System.out.println("Client read object from socket");
			QueryResult<TResult> result 
				= (QueryResult<TResult>) new ObjectInputStream(con.getInputStream()).readObject();

			System.out.println("result received");
			con.disconnect();
			return result;			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
