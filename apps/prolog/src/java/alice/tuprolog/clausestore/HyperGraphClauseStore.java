package alice.tuprolog.clausestore;

import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGLink;
import org.hypergraphdb.HGSearchResult;
import org.hypergraphdb.HyperGraph;

import alice.tuprolog.ClauseInfo;
import alice.tuprolog.ClauseStore;
import alice.tuprolog.Prolog;
import alice.tuprolog.Term;

public class HyperGraphClauseStore implements ClauseStore
{
	private Prolog engine;
	private HyperGraph graph;
	private String predicateName;
	private int arity;
	private HGSearchResult<?> rs = null;
	
	public HyperGraphClauseStore(Prolog engine, 
								 HyperGraph graph, 
								 String predicateName, 
								 int arity, 
								 HGSearchResult<?> rs)
	{
		this.engine = engine;
		this.predicateName = predicateName;
		this.arity = arity;
		this.graph = graph;
		this.rs = rs;		
	}	
	
	public void close() 
	{  
		try { rs.close(); }
		catch (Throwable t) { t.printStackTrace(System.err); }
	}
	
	public Prolog getProlog()
	{
		return engine;
	}
	
	public HyperGraph getGraph()
	{
		return graph;
	}
	
	public String getPredicateName()
	{
		return predicateName;
	}
	
	public int getArity()
	{
		return arity;
	}
	
	public ClauseInfo fetch()
	{
		if (!rs.hasNext())
			return null;
		else
		{
			// for now, assume the result set returns handles to links.
			HGLink l = graph.get((HGHandle)rs.next());
			return new HGAtomClauseInfo(this, l);
		}
	}

	public boolean hasCompatibleClause()
	{
		return rs.hasNext();
	}

	public boolean haveAlternatives()
	{
		return rs.hasNext();
	}
	
	public Term toTerm(HGHandle h)
	{
		return new HGAtomTerm(this, h);
	}
}