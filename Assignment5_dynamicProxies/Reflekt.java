import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Reflekt
{
   public static void say(String s)
   {
      System.out.println(s);
   }

   public static void reflektMethod()
   {
      say("this is a method in Reflekt.java");
   }

public static void main(String args[])
{
   // used composition in order to exercise some other methods
   VolcanoRobot robby = new VolcanoRobot("exploring",5,200);

   Class wutzit = robby.getClass();
   //Class wutzit = VolcanoRobot.class; // alternative way
   String wutzitsName = wutzit.getName();
   say("---------> This one is of class type: " + wutzitsName);
   
   Class<?> c = null;
   try { 
      c = Class.forName(wutzitsName); 
               }catch(ClassNotFoundException exc){
                  System.err.println("class not found");
               }
               assert(c != null);

   try{ 
      // show the methods in the class
      Method methods[] = c.getDeclaredMethods(); 
      for (Method m: methods )
      {
         System.out.println(m.toString()); 
            
         // show parameters of the method, if any
         Class paramList[] = m.getParameterTypes(); 
         int x = 0;
         for(Class param : paramList)
            say("param " + x++ + " is: " + param);
      } 

      // getting fields in the class
      Field fieldlist[] = c.getDeclaredFields(); 
      for (Field f: fieldlist) 
      {
         System.out.print("name = " + f.getName());
         say(", type = " + f.getType());
      }
               }catch (Throwable e){ 
                  System.err.println(e); 
                  // take care of the exception 
               } 
     
   Class<?>[] signature = new Class<?>[1];
   signature[0] = Integer.class; 

   String methodName = "getSpeed";
   Method meth = null;
   try{
      meth  = c.getMethod(methodName, signature); 
               }catch(NoSuchMethodException exc){
                  System.err.println("no such method '"+methodName+"'");
               }
               assert(meth != null);
    
	Object obj = null;
	try{
		obj = c.newInstance();
               }catch(InstantiationException exc){
                  System.err.println("can't instantiate that class");
               }catch(IllegalAccessException exc){
                  System.err.println("can't instantiate that class");
               }
               assert(obj != null);

	Object[] params = new Object[1]; 
	params[0] = new Integer(7); 

	Object result = null;
	try{
      result = meth.invoke(obj, params); 
               }catch(IllegalAccessException exc){
                  System.err.println("can't invoke that method");
               }catch(InvocationTargetException exc){
                  System.err.println("can't invoke that method");
               }	

	System.out.println("The robot's speed is: "+ result);
}
}

/* OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT 
bingsuns2% java Reflekt
Hello World! I'm a newly created robot.
---------> This one is of class type: VolcanoRobot
public int VolcanoRobot.getSpeed(java.lang.Integer)
param 0 is: class java.lang.Integer
public int VolcanoRobot.getPower()
public java.lang.String VolcanoRobot.getStatus()
name = status, type = class java.lang.String
name = speed, type = int
name = power, type = int
Hello World! I'm a newly created robot.
The robot's speed is: 12
*/