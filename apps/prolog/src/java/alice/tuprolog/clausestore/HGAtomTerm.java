package alice.tuprolog.clausestore;

import java.util.AbstractMap;
import java.util.List;

import org.hypergraphdb.HGHandle;
import org.hypergraphdb.util.HGUtils;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import alice.tuprolog.Var;
import alice.tuprolog.lib.InvalidObjectIdException;
import alice.tuprolog.lib.JavaLibrary;

public class HGAtomTerm extends Term
{
	private static final long serialVersionUID = -1;
	
	private HyperGraphClauseStore store;
	private HGHandle handle;
	
	public HGAtomTerm(HyperGraphClauseStore store, HGHandle handle)
	{
		this.store = store;
		this.handle = handle;
	}
	
	public String toString()
	{
		return "hgatom(" + store.getGraph().getPersistentHandle(handle) + ")";
	}
	
	public HGHandle getHandle()
	{
		return handle;
	}
	
	public Object deref()
	{
		return store.getGraph().get(handle);
	}
	
	@Override
	public boolean isEqual(Term t)
	{
		t = t.getTerm();
		if (t instanceof HGAtomTerm)
			return handle.equals(((HGAtomTerm)t).getHandle());
		else if (t instanceof Struct)
		{
			JavaLibrary jl = (JavaLibrary)
				store.getProlog().getLibraryManager().getLibrary("alice.tuprolog.lib.JavaLibrary");
			Struct s = (Struct)t;
			if (!s.isGround()) // until we start storing prolog term in HGDB, only ground Struct can be handled
				return false;
			Object other = null;
			try
			{
				other = jl.getRegisteredObject((Struct)t);
				if (other == null)
					other = jl.getRegisteredDynamicObject((Struct)t);
				Object x = deref();
				if (other != null)
					return HGUtils.eq(other, x);
				else if (x instanceof String)
					return x.equals(alice.util.Tools.removeApices(s.toString()));
				else
					return false;
			}
			catch (InvalidObjectIdException ex)
			{
				return false;
			}			
		}
		else if (t instanceof alice.tuprolog.Number)
		{
			Object x = deref();
			if (x instanceof java.lang.Number)
				return ((java.lang.Number)x).doubleValue() == ((alice.tuprolog.Number)t).doubleValue();
			else 
				return false;
		}
		return false;
	}
	
	@Override
	public boolean unify(List varsUnifiedArg1, List varsUnifiedArg2, Term t)
	{
		if (t instanceof Var)
			t.unify(varsUnifiedArg1, varsUnifiedArg2, this);
		return isEqual(t);
	}
	
	@Override
	public Term copy(AbstractMap map, int idExecCtx)
	{
		return this;
	}

	@Override
	public Term copy(AbstractMap map, AbstractMap substMap)
	{
		return this;
	}


	@Override
	public long resolveTerm(long count)
	{
		return count;
	}
	
	@Override
	public void free()
	{
	}

	@Override
	public Term getTerm()
	{
		return this;
	}

	@Override
	public boolean isAtom()
	{
		return false;
	}

	@Override
	public boolean isAtomic()
	{
		return true;
	}

	@Override
	public boolean isCompound()
	{
		return false;
	}

	@Override
	public boolean isEmptyList()
	{
		return false;
	}

	@Override
	public boolean isGreater(Term t)
	{
		return false;
	}

	@Override
	public boolean isGround()
	{
		return true;
	}

	@Override
	public boolean isList()
	{
		return false;
	}

	@Override
	public boolean isNumber()
	{
		throw new UnsupportedOperationException("This method is deprecated.");		
	}

	@Override
	public boolean isStruct()
	{
		throw new UnsupportedOperationException("This method is deprecated.");
	}

	@Override
	public boolean isVar()
	{
		throw new UnsupportedOperationException("This method is deprecated.");
	}
}