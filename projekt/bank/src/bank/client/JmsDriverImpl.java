package bank.client;
import java.io.IOException;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import bank.BankDriver2;
import bank.Connection;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public class JmsDriverImpl extends AbstractDriver implements BankDriver2 {
	private Context jndiContext;
	private ConnectionFactory factory;
	private Queue queue;
	private Topic topic;
	private TemporaryQueue tempQueue;
	private JMSProducer sender;
	private JMSConsumer receiver;
	private JMSContext context;
	
	@Override
	public void connect(String[] args){
		try {
			jndiContext = new InitialContext();
			factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
			queue = (Queue) jndiContext.lookup("/queue/BANK");
			topic = (Topic) jndiContext.lookup("/topic/BANK");
			
			context = factory.createContext();
			context.setClientID(Double.toString(Math.random()));
			tempQueue = context.createTemporaryQueue();
			sender = context.createProducer().setJMSReplyTo(tempQueue);
			receiver = context.createConsumer(tempQueue);
			
			
			super.connect(args);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	Connection getTransmitter() {
		System.out.println("getting Transmitter");
		return new Connection() {
			
			@SuppressWarnings("unchecked")
			@Override
			public <TResult> QueryResult<TResult> executeRemoteQuery(
					QueryCommand<TResult> query) {
				sender.send(queue, query);
				return (QueryResult<TResult>) 
						receiver.receiveBody(QueryResult.class);
			}
		};
	}

	@Override
	public void registerUpdateHandler(UpdateHandler handler) throws IOException {
		JMSConsumer subscriber = this.context.createDurableConsumer(topic, "subscriber");
		subscriber.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				try {
					handler.accountChanged(message.getBody(String.class));
				} catch (IOException | JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void disconnect() {
		super.disconnect();
		//context.unsubscribe("subscriber");
	}
}
