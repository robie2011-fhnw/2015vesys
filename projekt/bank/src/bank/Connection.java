package bank;

import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public abstract class Connection {	
	@SuppressWarnings("unchecked")
	public abstract <TResult> QueryResult<TResult>
		executeRemoteQuery(QueryCommand<TResult> query);
}
