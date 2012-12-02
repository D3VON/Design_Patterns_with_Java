package headfirst.singleton.threadsafe;

public class Singleton {
   // static b.c. there will only be one instance
	private static Singleton uniqueInstance;
 

 	// other useful instance variables here
 





   // only Singleton class can call constructor
   // and really, it's only called once. 
	private Singleton() {}
 
   // static so we can call the method like x = Singleton.getInstance();
   // static methods are class methods, use class name to reference
   // synchronized so threads don't make a mess. 
	public static synchronized Singleton getInstance() {  // synchronized can
		if (uniqueInstance == null) {                      // decrease performnc
			uniqueInstance = new Singleton();               // by a factor of 100
		}
		return uniqueInstance;
	}
 

	// other useful methods here
   // like handling the Result ArrayList or Array
   // because threads will be writing to it, and reading from it














}
