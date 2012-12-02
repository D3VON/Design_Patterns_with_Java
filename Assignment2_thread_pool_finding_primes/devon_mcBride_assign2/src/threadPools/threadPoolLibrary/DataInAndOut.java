
package threadPools.threadPoolLibrary;

import threadPools.util.Debug;

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
* The class DataInAndOut is of the singleton pattern.  It is meant
* to provide a buffer that instances of the MasterGenerator class and 
* MasterWorker class can use to store or remove integers.  This class
* is synchronized to ensure orderly storage and retrieval in a  
* multithreaded environment. 
* 
* Methods available in this class:
*    
*   getInstance()             --creates/returns the Singleton instance
*   sitAndWait(int x)         --puts int into stack
*   yourTheNextContestant()   --pops int from stack
*   getWorkerProcessedCount() --count of how many processed by workers
*
*/
public class DataInAndOut {
	// static b.c. there will only be one instance
	// volatile so threads initialize the obj. w/out race condit.
	private volatile static DataInAndOut uniqueInstance;
	 
	// workerProcessedCount = SIZE (in driver) means all are processed
	private static int workerProcessedCount = 0;

	//prefered stack because of it's very simple, non-fussy API
	private static Stack<Integer> stack = new Stack<Integer>();
	 
	// only Singleton class can call constructor
	// and really, it's only called once. 
	private DataInAndOut() {}
	 
	// static so we can call the method like x = Singleton.getInstance();
	// static methods are class methods, use class name to reference
	
	
	
	/**
	 * @return a unique instance of this singleton class
	 */
	public static DataInAndOut getInstance() // don't synchronize here.
	{  
		if (uniqueInstance == null) 
		{  // only synchronize at 1st instantiation                      
			synchronized (DataInAndOut.class) { 
	            if (uniqueInstance == null)
	            {  // with 2 if's it's called "double-checked locking"
	               uniqueInstance = new DataInAndOut();
	            } 
			}
		}
		return uniqueInstance;
	}
	
	/**
	 * @param integer to be stored in the class data structure
	 */	
	public static void storeResult(int x)     
	{
		stack.push(new Integer(x));
	}
	
	/**
	 * @return an integer from the class data structure
	 */	   		   
	public static int popOut() 
	{
		int anInt = 0;
		if(!DataInAndOut.isEmpty())
		{
			try 
			{
				anInt = stack.pop();
				workerProcessedCount++; // to check vs. original SIZE (in driver)
			} 
			catch (EmptyStackException e) 
			{
				System.err.println("");
				System.err.println("Stack pop problem in DataInAndOut with exception: ");
				System.err.println(e);
				System.err.println("Apparently, double-checked locking isn't 100% reliable.");
				System.exit(-1);
			}
		}
	    return anInt;
	}
	
	/**
	 * @param boolean about whether the class data structure is empty
	 */
	public static boolean isEmpty()
	{
	   return stack.empty();
	}

	/**
	 * @param an integer which is a count of the times that
	 *        elements in the class data structure have been
	 *        popped out
	 */
	public static int getWorkerProcessedCount()
	{
	   return workerProcessedCount;
	}

    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class DataInAndOut's data members: \n";
		objectState += "               stack = " + stack + "\n";
		objectState += "workerProcessedCount = " + workerProcessedCount + "\n";
		objectState += "------------Thank you------------";
		return objectState;
	}	
}