package alice.tuprologx.runtime.corba;



abstract public class PrologHelper
{
  private static String  _id = "IDL:org/alice/tuprologx/runtime/corba/Prolog:1.0";

  public static void insert (org.omg.CORBA.Any a, alice.tuprologx.runtime.corba.Prolog that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static alice.tuprologx.runtime.corba.Prolog extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (alice.tuprologx.runtime.corba.PrologHelper.id (), "Prolog");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static alice.tuprologx.runtime.corba.Prolog read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_PrologStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, alice.tuprologx.runtime.corba.Prolog value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static alice.tuprologx.runtime.corba.Prolog narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof alice.tuprologx.runtime.corba.Prolog)
      return (alice.tuprologx.runtime.corba.Prolog)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      return new alice.tuprologx.runtime.corba._PrologStub (delegate);
    }
  }

}
