package bank.server.datainterchange;

import java.io.Serializable;

import bank.IBank;

@FunctionalInterface
public interface ICommandNew<TResult> extends Serializable{
	TResult run(IBank bank) throws Exception;
}
