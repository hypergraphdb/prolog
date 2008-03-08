package alice.tuprolog.clausestore;

import org.hypergraphdb.HGLink;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;

public class HGAtomClauseInfo extends FactClauseInfo
{
	private HGLink atom;
	private HyperGraphClauseStore store;
	private Struct clause;
	
	public HGAtomClauseInfo(HyperGraphClauseStore store, HGLink atom)
	{
		this.atom = atom;
		this.store = store;
	}
	
	public Struct getClause()
	{
		if (clause == null)
		{
			Term [] args = new Term[atom.getArity()];
			for (int i = 0; i < atom.getArity(); i++)
			{
				args[i] = store.toTerm(atom.getTargetAt(i));				
			}
			clause = new Struct(store.getPredicateName(), args);
		}
		return clause;
	}
}