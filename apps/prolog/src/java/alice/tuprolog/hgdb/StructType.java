package alice.tuprolog.hgdb;

import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGHandleFactory;
import org.hypergraphdb.HGPersistentHandle;
import org.hypergraphdb.IncidenceSetRef;
import org.hypergraphdb.LazyRef;
import org.hypergraphdb.type.HGAtomType;
import org.hypergraphdb.type.HGAtomTypeBase;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import alice.tuprolog.clausestore.HGAtomTerm;

public class StructType extends HGAtomTypeBase
{
	public static final HGPersistentHandle HANDLE = HGHandleFactory.makeHandle("53102b6a-2345-470d-9333-1218ddd6f248");
	
	public Object make(HGPersistentHandle handle,
					   LazyRef<HGHandle[]> targetSet, 
					   IncidenceSetRef incidenceSet)
	{
		HGAtomType stringType = graph.getTypeSystem().getAtomType(String.class); 
		String functor_name = (String)stringType.make(handle, null, null);
		HGHandle [] ts = targetSet.deref();
		if (ts == null)
			return new Struct(functor_name);
		Term [] terms = new Term[ts.length];
		for (int i = 0; i < ts.length; i++)
		{
			Object x = graph.get(ts[i]);
			if (x instanceof Term)
				terms[i] = (Term)x;
			else
				terms[i] = new HGAtomTerm(ts[i], graph);
		}
		return null;
	}

	public void release(HGPersistentHandle handle)
	{
		HGAtomType stringType = graph.getTypeSystem().getAtomType(String.class);
		stringType.release(handle);
	}

	public HGPersistentHandle store(Object instance)
	{
		Struct s = (Struct)instance;
		HGAtomType stringType = graph.getTypeSystem().getAtomType(String.class);
		return stringType.store(s.getName());
	}

	public boolean subsumes(Object general, Object specific)
	{
		return false;
	}
}