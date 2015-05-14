package bank.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import bank.Bank;
import bank.Connection;
import bank.local.Repository;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public class SocketDriverImpl extends AbstractDriver {
	Socket socket;
	ObjectOutputStream objectOutputStream;
	ObjectInputStream objectInputStream;
	
	@Override
	public void connect(String[] args) {
		args = getDefaultParams(args);
		try {
			socket = new Socket(args[0], Integer.parseInt(args[1]));
			repository = new Repository(getTransmitter());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getTransmitter(){
		return new Connection() {					
			
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public <TResult> QueryResult<TResult> executeRemoteQuery(
					QueryCommand<TResult> query) {
				try {
					
					System.out.println("Client write object into socket");
					if(objectOutputStream == null)
						objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
										
					objectOutputStream.writeObject(query);
					
					System.out.println("Client read object from socket");
					if(objectInputStream == null)
						objectInputStream = new ObjectInputStream(socket.getInputStream());
					
					QueryResult result = (QueryResult) objectInputStream.readObject();
					return result;
					
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
	}
	
	@Override
	public void disconnect() {
		try {
			objectOutputStream.writeObject(null);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Bank getBank() {
		return repository.getBank();
	}

}
