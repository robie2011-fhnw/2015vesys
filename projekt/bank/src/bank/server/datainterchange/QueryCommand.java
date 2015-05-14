package bank.server.datainterchange;

import java.io.Serializable;
import bank.Bank;

public class QueryCommand<TResult> implements Serializable {
	Command<TResult> command;

	public QueryCommand(Command<TResult> cmd){
		this.command = cmd;
	}
		
	public QueryResult<TResult> execute(Bank bank){
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
