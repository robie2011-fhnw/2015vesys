package bank.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import bank.server.datainterchange.*;


public class ServerApplication {
	
	

	public static void main(String[] args) {
		System.out.println("STARTING SERVER APPLICATION");
		
		Bank bank = new Bank();
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(9999);
			while(true){
				
				Socket socket = serverSocket.accept();
				new Thread( () -> handlingConnection(socket,bank) ).start();;
				//handlingConnection(socket,bank);
			
			}
			//serverSocket.close(); // tbd
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void handlingConnection(Socket socket, Bank bank){
		System.out.println("");
		System.out.println("socket created");
		System.out.println("===================================");
		
		
		try{
				while(!socket.isClosed()
						&& !socket.isInputShutdown()
						&& socket.isConnected()){
						System.out.println("getting inputstream");
						ObjectInputStream oostream 
							= new ObjectInputStream(socket.getInputStream());
								
						System.out.println("reading from objectIntputStream");
						QueryCommandNew query = (QueryCommandNew) oostream.readObject();
						System.out.println("Object received");
						
						if(query == null) {
							System.out.println("server: nullobject received. exit loop");
							break;
						}
						
						
						System.out.println("Writing response");
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
						QueryResult result = query.execute(bank);
						out.writeObject(result);
						out.flush();
				}
			}catch(Exception ex){
				ex.printStackTrace();
				System.out.println("closing server socket");
			}
		
	}

}
