package alice.tuprolog.hgdb;

import java.util.List;
import java.util.concurrent.Callable;
import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGQuery.hg;
import org.hypergraphdb.HGSearchResult;
import org.hypergraphdb.HGValueLink;
import org.hypergraphdb.HyperGraph;
import org.hypergraphdb.HyperNode;
import org.hypergraphdb.IncidenceSet;
import org.hypergraphdb.handle.HGLiveHandle;
import org.hypergraphdb.query.HGQueryCondition;
import org.hypergraphdb.transaction.TxCacheMap;

import alice.tuprolog.Struct;
import alice.tuprolog.Term;

public class PrologNode implements HyperNode
{
    private HyperGraph graph;
    // A separate atom cache is needed here because of the "auto-boxing" of
    // Json instances into HGValueLinks. The HGDB cache itself only keeps the
    // HGValueLink instances.
    private TxCacheMap<Object, HGLiveHandle> atomsTx = null;

    public PrologNode(HyperGraph graph)
    {
        this.graph = graph;
    }
    
    public <T> T get(final HGHandle handle)
    {
        return graph.getTransactionManager().ensureTransaction(new Callable<T>() {
            @SuppressWarnings("unchecked")
            public T call()
            {
                Object x = graph.get(handle);
                if (x instanceof HGValueLink)
                {
                    Object y = ((HGValueLink)x).getValue();
                    if (y instanceof Struct)
                    {
                        x = y;
                        atomsTx.put(x, graph.getCache().get(handle.getPersistent()));
                    }
                }
                graph.getTransactionManager().commit();
                return (T)x;
            }
        });
    }

    public HGHandle add(final Object atom)
    {
        return graph.getTransactionManager().ensureTransaction(new Callable<HGHandle>(){
           @SuppressWarnings("deprecation")
        public HGHandle call()
           {
               if (! (atom instanceof Term) )
                   return graph.add(atom);
               Term t = (Term)atom;
               if (!t.isStruct())
                   return hg.assertAtom(graph, t);
               Struct s = (Struct)atom;
               HGHandle [] targets = new HGHandle[s.getArity()];
               for (int i = 0; i < targets.length; i++)
                   targets[i] = add(s.getArg(i));
               return hg.addUnique(graph, s, hg.and(hg.eq("name", s.getName()),hg.orderedLink(targets)));               
           }
        });
    }
    
    public HGHandle add(Object atom, HGHandle type, int flags)
    {
        return graph.add(atom, type, flags);
    }

    public void define(HGHandle handle, HGHandle type, Object instance, int flags)
    {
        graph.define(handle, type, instance, flags);
    }

    public boolean remove(HGHandle handle)
    {
        return graph.remove(handle);
    }

    public boolean replace(HGHandle handle, Object newValue, HGHandle newType)
    {
        return graph.replace(handle, newValue, newType);
    }

    public HGHandle getType(HGHandle handle)
    {
        return graph.getType(handle);
    }

    public IncidenceSet getIncidenceSet(HGHandle handle)
    {
        return graph.getIncidenceSet(handle);
    }

    public <T> T findOne(HGQueryCondition condition)
    {
        return graph.findOne(condition);
    }

    public <T> HGSearchResult<T> find(HGQueryCondition condition)
    {
        return graph.find(condition);
    }

    public <T> T getOne(HGQueryCondition condition)
    {
        return graph.getOne(condition);
    }

    public <T> List<T> getAll(HGQueryCondition condition)
    {
        return graph.getAll(condition);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(HGQueryCondition condition)
    {
        return (List<T>)graph.findAll(condition);
    }

    public long count(HGQueryCondition condition)
    {
        return graph.count(condition);
    }
}