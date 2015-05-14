package bank.server.datainterchange;

import java.io.Serializable;

import bank.Bank;

@FunctionalInterface
public interface Command<TResult> extends Serializable{
	TResult run(Bank bank) throws Exception;
}
