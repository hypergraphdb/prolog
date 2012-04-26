package alice.tuprologx.runtime.corba;


public abstract class _PrologImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements alice.tuprologx.runtime.corba.Prolog, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _PrologImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("clearTheory", new java.lang.Integer (0));
    _methods.put ("getTheory", new java.lang.Integer (1));
    _methods.put ("setTheory", new java.lang.Integer (2));
    _methods.put ("solve", new java.lang.Integer (3));
    _methods.put ("hasOpenAlternatives", new java.lang.Integer (4));
    _methods.put ("solveNext", new java.lang.Integer (5));
    _methods.put ("solveHalt", new java.lang.Integer (6));
    _methods.put ("solveEnd", new java.lang.Integer (7));
    _methods.put ("loadLibrary", new java.lang.Integer (8));
    _methods.put ("unloadLibrary", new java.lang.Integer (9));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get (method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // org/alice/tuprologx/runtime/corba/Prolog/clearTheory
       {
         this.clearTheory ();
         out = rh.createReply();
         break;
       }

       case 1:  // org/alice/tuprologx/runtime/corba/Prolog/getTheory
       {
         String __result = null;
         __result = this.getTheory ();
         out = rh.createReply();
         out.write_string (__result);
         break;
       }

       case 2:  // org/alice/tuprologx/runtime/corba/Prolog/setTheory
       {
         String theory = in.read_string ();
         this.setTheory (theory);
         out = rh.createReply();
         break;
       }

       case 3:  // org/alice/tuprologx/runtime/corba/Prolog/solve
       {
         String g = in.read_string ();
         alice.tuprologx.runtime.corba.SolveInfo __result = null;
         __result = this.solve (g);
         out = rh.createReply();
         alice.tuprologx.runtime.corba.SolveInfoHelper.write (out, __result);
         break;
       }

       case 4:  // org/alice/tuprologx/runtime/corba/Prolog/hasOpenAlternatives
       {
         boolean __result = false;
         __result = this.hasOpenAlternatives ();
         out = rh.createReply();
         out.write_boolean (__result);
         break;
       }

       case 5:  // org/alice/tuprologx/runtime/corba/Prolog/solveNext
       {
         alice.tuprologx.runtime.corba.SolveInfo __result = null;
         __result = this.solveNext ();
         out = rh.createReply();
         alice.tuprologx.runtime.corba.SolveInfoHelper.write (out, __result);
         break;
       }

       case 6:  // org/alice/tuprologx/runtime/corba/Prolog/solveHalt
       {
         this.solveHalt ();
         out = rh.createReply();
         break;
       }

       case 7:  // org/alice/tuprologx/runtime/corba/Prolog/solveEnd
       {
         this.solveEnd ();
         out = rh.createReply();
         break;
       }

       case 8:  // org/alice/tuprologx/runtime/corba/Prolog/loadLibrary
       {
         String className = in.read_string ();
         this.loadLibrary (className);
         out = rh.createReply();
         break;
       }

       case 9:  // org/alice/tuprologx/runtime/corba/Prolog/unloadLibrary
       {
         String className = in.read_string ();
         this.unloadLibrary (className);
         out = rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/alice/tuprologx/runtime/corba/Prolog:1.0"};

  public String[] _ids ()
  {
    return __ids;
  }


} // class _PrologImplBase
