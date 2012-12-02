import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Reflection
{

public static void main(String args[])
{
	
	String clsName = "java.util.Date";
	Class<?> cls = null;
	try
	{
		cls = Class.forName(clsName);
	}
               catch(ClassNotFoundException exc)
               {
                  System.err.println("class not found");
               }
               assert(cls != null);

	String methodName = "setTime";
	Class<?>[] signature = new Class<?>[1];
	signature[0] = long.class;

	Method meth  = null;
	try
	{
		meth = cls.getMethod(methodName, signature);
	}
               catch(NoSuchMethodException exc)
               {
                  System.err.println("no such method");
               }
               assert(meth != null);

	Object obj = null;
	try
	{
		obj = cls.newInstance();
	}
               catch(InstantiationException exc)
               {
                  System.err.println("couldn't instantiate obj");
               }
               catch(IllegalAccessException exc)
               {
                  System.err.println("couldn't instantiate obj");
               }
               assert(obj != null);

	Object[] params = new Object[1];
	params[0] = 2;

	System.out.println("before: " +obj);

	Object result = null;
	try
	{
		result = meth.invoke(obj, params);
	}
               catch(IllegalAccessException exc)
               {
                  System.err.println("couldn't invoke method");
               }
               catch(InvocationTargetException exc)
               {
                  System.err.println("couldn't invoke method");
               }	

	System.out.println("after: "+obj);
}

}
