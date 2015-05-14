package bank.server;

import javax.xml.ws.Endpoint;

import bank.local.BankImpl;
import bank.local.SimpleBankAccessImpl;

public class SimpleBankAccessWSDLServicePublisher {
	public static void main(String[] args) {
		SimpleBankAccessImpl.bank = new BankImpl();
		SimpleBankAccessImpl simpleBankAccess = new SimpleBankAccessImpl();
		
		String url = "http://127.0.0.1:8888/bank";
		Endpoint.publish(url , simpleBankAccess);
		System.out.println("service published on " + url);
	}
}
