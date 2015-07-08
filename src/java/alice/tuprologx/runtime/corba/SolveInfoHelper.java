package alice.tuprologx.runtime.corba;


abstract public class SolveInfoHelper
{
  private static String  _id = "IDL:org/alice/tuprologx/runtime/corba/SolveInfo:1.0";

  public static void insert (org.omg.CORBA.Any a, alice.tuprologx.runtime.corba.SolveInfo that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static alice.tuprologx.runtime.corba.SolveInfo extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[0] = new org.omg.CORBA.StructMember (
            "success",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "solution",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[2] = new org.omg.CORBA.StructMember (
            "halt",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[3] = new org.omg.CORBA.StructMember (
            "haltCode",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (alice.tuprologx.runtime.corba.SolveInfoHelper.id (), "SolveInfo", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static alice.tuprologx.runtime.corba.SolveInfo read (org.omg.CORBA.portable.InputStream istream)
  {
    alice.tuprologx.runtime.corba.SolveInfo value = new alice.tuprologx.runtime.corba.SolveInfo ();
    value.success = istream.read_boolean ();
    value.solution = istream.read_string ();
    value.halt = istream.read_boolean ();
    value.haltCode = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, alice.tuprologx.runtime.corba.SolveInfo value)
  {
    ostream.write_boolean (value.success);
    ostream.write_string (value.solution);
    ostream.write_boolean (value.halt);
    ostream.write_long (value.haltCode);
  }

}
