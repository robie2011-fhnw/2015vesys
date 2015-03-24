package bank.server;

import javax.xml.ws.Endpoint;

import bank.local.Bank;
import bank.local.SimpleBankAccess;

public class SimpleBankAccessWSDLServicePublisher {
	public static void main(String[] args) {
		SimpleBankAccess.bank = new Bank();
		SimpleBankAccess simpleBankAccess = new SimpleBankAccess();
		
		String url = "http://127.0.0.1:8888/bank";
		Endpoint.publish(url , simpleBankAccess);
		System.out.println("service published on " + url);
	}
}
