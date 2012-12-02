
package threadPools.threadPoolLibrary;

import java.util.EmptyStackException;
import java.util.Stack;
//---------------------------------------------------------------------
//This code is adapted from Eric freeman & Elisabeth Freeman,
//"Head First Design Patterns," pg. 182, October, 2004, OReilly
//---------------------------------------------------------------------

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 * The class Results is of the singleton pattern.  It is meant
 * to provide a buffer that instances of the MasterWorker class
 * can use to store integers.  This class is synchronized to ensure 
 * orderly storage in a multi-threaded environment. 
 * 
 * Methods available in this class:
 *    
 *   getInstance()      --creates/returns the Singleton instance
 *   storeResult(int x) --puts int into stack
 *   getResult()        --pops int from stack
 *   anyLeft()          --true if stack not empty
 *
 */
public class Results {
	// static b.c. there will only be one instance
	// volatile so threads initialize the obj. w/out race condit.
	private volatile static Results uniqueInstance;
	 
	//prefered stack because of it's very simple, non-fussy API
	private static Stack<Integer> stack = new Stack<Integer>();
	
	/**
	 * constructor 
	 */ 
	private Results() {}
	
	/**
	 * @return a synchronized (for thread access) instance of 
	 *         this static object
	 */
	public static Results getInstance() // don't synchronize here.
	{  
		if (uniqueInstance == null) 
		{  // only synchronize at 1st instantiation                      
			synchronized (Results.class) { 
	            if (uniqueInstance == null)
	            {  // with 2 if's it's called "double-checked locking"
	               uniqueInstance = new Results();
	            } 
			}
		}
		return uniqueInstance;
	}
	
	/**
	 * Store the random number that was produced by the thread.
	 * @param x, an integer (from the random generator)
	 */			
	public static void storeResult(int x)
	{
	   stack.push(new Integer(x));
	}
	
	/**
	 * @return a random number that was produced by the thread.
	 */ 
	public static int getResult()
	{
		int result = 0;
		try 
		{
			result = stack.pop();
		} 
		catch (EmptyStackException e) 
		{
			System.err.println("Stack pop problem with the Results data, with exception:");
			System.err.println(e);
			System.exit(-1);
		}
		return result;
	}
	
	/**
	 * @return a boolean indicating whether the stack has any values.
	 */ 
	public static boolean anyLeft()
	{
	   return stack.empty();
	}
		
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class Results's data members: \n";
		objectState += "            stack = " + stack + "\n";
		objectState += "------------Thank you------------";
		return objectState;
	}	
	
}