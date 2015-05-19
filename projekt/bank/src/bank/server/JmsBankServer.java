package bank.server;

import java.io.Serializable;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;

import bank.local.BankImpl2;
import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public class JmsBankServer {

	private static JMSProducer updatePropagater;
	private static Topic updateTopic;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws NamingException, JMSException {
		BankImpl2 bank = new BankImpl2();
		Context jndiContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("ConnectionFactory");
		Queue queue = (Queue) jndiContext.lookup("/queue/BANK");
		
		try (JMSContext context = factory.createContext()) {
			 JMSConsumer receiver = context.createConsumer(queue);
			 JMSProducer sender = context.createProducer();
			 
			 updateTopic = (Topic) jndiContext.lookup("/topic/BANK");
			 updatePropagater = context.createProducer();
			 
			 bank.addChangeListener(accountNumber -> propagateAccountChange(accountNumber));
			 System.out.println("Server started. Listener registred. Going to waiting loop");
			 
			 while(true) {
				 Message message = receiver.receive();
				 QueryCommand command = message.getBody(QueryCommand.class);
				 QueryResult result = command.execute(bank);
				 Assert.assertTrue(result instanceof Serializable);
				 System.out.println("Message received + processed");
				 Destination destination = message.getJMSReplyTo();
				 sender.send(destination, result);
				 System.out.println("sending result back to client");
			 }
		}
	}
	
	public static void propagateAccountChange(String accountNumber)
	{
		System.out.println("propagate Update");
		updatePropagater.send(updateTopic, accountNumber);
	}

}
