package bank.server.datainterchange;

import java.io.Serializable;

import bank.Bank;

@FunctionalInterface
public interface ICommandNew<TResult> extends Serializable{
	TResult run(Bank bank) throws Exception;
}
