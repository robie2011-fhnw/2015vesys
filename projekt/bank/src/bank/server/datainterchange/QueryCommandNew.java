package bank.server.datainterchange;

import java.io.Serializable;

import bank.IBank;

public class QueryCommandNew<TResult> implements Serializable {
	ICommandNew<TResult> command;

	public QueryCommandNew(ICommandNew<TResult> cmd){
		this.command = cmd;
	}
		
	public QueryResult<TResult> execute(IBank bank){
		TResult result = null;
		Exception exception = null;
		try{
			result = this.command.run(bank);
		}catch(Exception e){
			exception = e;
		}
		
		return new QueryResult<TResult>(result, exception);
	}		
}
