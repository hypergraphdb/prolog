package alice.tuprologx.runtime.corba;


public class _PrologStub extends org.omg.CORBA.portable.ObjectImpl implements alice.tuprologx.runtime.corba.Prolog
{
  // Constructors
  // NOTE:  If the default constructor is used, the
  //        object is useless until _set_delegate (...)
  //        is called.
  public _PrologStub ()
  {
    super ();
  }

  public _PrologStub (org.omg.CORBA.portable.Delegate delegate)
  {
    super ();
    _set_delegate (delegate);
  }

  public void clearTheory ()
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("clearTheory", true);
       _in = _invoke (_out);
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       clearTheory ();
    } finally {
        _releaseReply (_in);
    }
  } // clearTheory

  public String getTheory ()
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("getTheory", true);
       _in = _invoke (_out);
       String __result = _in.read_string ();
       return __result;
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       return getTheory ();
    } finally {
        _releaseReply (_in);
    }
  } // getTheory

  public void setTheory (String theory)
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("setTheory", true);
       _out.write_string (theory);
       _in = _invoke (_out);
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       setTheory (theory);
    } finally {
        _releaseReply (_in);
    }
  } // setTheory

  public alice.tuprologx.runtime.corba.SolveInfo solve (String g)
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("solve", true);
       _out.write_string (g);
       _in = _invoke (_out);
       alice.tuprologx.runtime.corba.SolveInfo __result = alice.tuprologx.runtime.corba.SolveInfoHelper.read (_in);
       return __result;
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       return solve (g);
    } finally {
        _releaseReply (_in);
    }
  } // solve

  public boolean hasOpenAlternatives ()
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("hasOpenAlternatives", true);
       _in = _invoke (_out);
       boolean __result = _in.read_boolean ();
       return __result;
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       return hasOpenAlternatives ();
    } finally {
        _releaseReply (_in);
    }
  } // hasOpenAlternatives

  public alice.tuprologx.runtime.corba.SolveInfo solveNext ()
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("solveNext", true);
       _in = _invoke (_out);
       alice.tuprologx.runtime.corba.SolveInfo __result = alice.tuprologx.runtime.corba.SolveInfoHelper.read (_in);
       return __result;
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       return solveNext ();
    } finally {
        _releaseReply (_in);
    }
  } // solveNext

  public void solveHalt ()
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("solveHalt", true);
       _in = _invoke (_out);
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       solveHalt ();
    } finally {
        _releaseReply (_in);
    }
  } // solveHalt

  public void solveEnd ()
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("solveEnd", true);
       _in = _invoke (_out);
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       solveEnd ();
    } finally {
        _releaseReply (_in);
    }
  } // solveEnd

  public void loadLibrary (String className)
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("loadLibrary", true);
       _out.write_string (className);
       _in = _invoke (_out);
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       loadLibrary (className);
    } finally {
        _releaseReply (_in);
    }
  } // loadLibrary

  public void unloadLibrary (String className)
  {
    org.omg.CORBA.portable.InputStream _in = null;
    try {
       org.omg.CORBA.portable.OutputStream _out = _request ("unloadLibrary", true);
       _out.write_string (className);
       _in = _invoke (_out);
    } catch (org.omg.CORBA.portable.ApplicationException _ex) {
       _in = _ex.getInputStream ();
       String _id = _ex.getId ();
       throw new org.omg.CORBA.MARSHAL (_id);
    } catch (org.omg.CORBA.portable.RemarshalException _rm) {
       unloadLibrary (className);
    } finally {
        _releaseReply (_in);
    }
  } // unloadLibrary

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:org/alice/tuprologx/runtime/corba/Prolog:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s)
  {
     try
     {
       String str = s.readUTF ();
       org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init ().string_to_object (str);
       org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
       _set_delegate (delegate);
     } catch (java.io.IOException e) {}
  }

  private void writeObject (java.io.ObjectOutputStream s)
  {
     try
     {
       String str = org.omg.CORBA.ORB.init ().object_to_string (this);
       s.writeUTF (str);
     } catch (java.io.IOException e) {}
  }
} // class _PrologStub
