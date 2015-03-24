package bank;

import bank.server.datainterchange.QueryCommandNew;
import bank.server.datainterchange.QueryResult;

public abstract class IConnection {	
	@SuppressWarnings("unchecked")
	public abstract <TResult> QueryResult<TResult>
		executeRemoteQuery(QueryCommandNew<TResult> query);
}
