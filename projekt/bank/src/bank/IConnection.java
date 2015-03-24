package bank;

import bank.server.datainterchange.QueryCommand;
import bank.server.datainterchange.QueryResult;

public abstract class IConnection {	
	@SuppressWarnings("unchecked")
	public abstract <TResult> QueryResult<TResult>
		executeRemoteQuery(QueryCommand<TResult> query);
}
