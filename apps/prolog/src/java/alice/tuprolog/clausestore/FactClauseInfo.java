package alice.tuprolog.clausestore;

import alice.tuprolog.ClauseInfo;
import alice.tuprolog.Struct;
import alice.tuprolog.SubGoalTree;

public abstract class FactClauseInfo implements ClauseInfo
{
	private static final SubGoalTree empty_body = new SubGoalTree();
	
	public SubGoalTree getBody()
	{
		return empty_body;
	}

	public SubGoalTree getBodyCopy()
	{
		return empty_body;
	}

	public Struct getHead()
	{
		return getClause();
	}

	public Struct getHeadCopy()
	{
		return getHead();
	}

	public String getLibName()
	{
		return null;
	}

	public void performCopy(int idExecCtx)
	{
		// TODO...
	}
}