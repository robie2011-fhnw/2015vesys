package bank.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import sun.net.www.protocol.http.HttpURLConnection;
import bank.local.RepositoryNew;
import bank.server.datainterchange.QueryCommandNew;
import bank.server.datainterchange.QueryResult;

public class HttpDriver extends AbstractDriver {
	String server, port, handler;	
	
	@Override
	public void connect(String[] args) {
		args = getDefaultParams(args);
		server = args[0];
		port = args[1];		
		handler = (args.length>2) ? args[2] : "/httpServletObjectExchange/oex";
		repository = new RepositoryNew(getTransmitter());		
		bank = repository.getBank();		
	}

	@Override
	public void disconnect() {
		bank = null;		
		System.out.println("disconnected...");
	}

	@Override
	public bank.Bank getBank() {
		return bank;
	}

	@Override
	IConnection getTransmitter() {
		return new IConnection() {
			
			@Override
			public <TResult> QueryResult<TResult> executeRemoteQuery(
					QueryCommandNew<TResult> query) {
				try{			
					URL url = new URL("http://" +server +":" +port + handler);
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
		};
	}

}