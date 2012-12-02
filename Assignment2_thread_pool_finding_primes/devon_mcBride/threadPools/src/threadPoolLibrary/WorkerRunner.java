
package threadPools.threadPoolLibrary;

import threadPools.threadPoolLibrary.DataInAndOut;
import threadPools.threadPoolLibrary.MillerRabin32;
import threadPools.threadPoolLibrary.Results;

import threadPools.util.Debug;

import java.util.EmptyStackException;
/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 * creates runnables to generate random numbers.  
 * When the runnables create random numbers, 
 * they store them into the singleton object 
 * named DataInAndOut. 
 */
public class WorkerRunner implements Runnable{

	private int           SIZE = 0; // total number to process
	private int             WW = 0; // thread ID
	private int howManyRandoms = 0;  // how many runnables to make

	/**
	 * The constructor
	 * @param SIZE            total number to process
	 * @param WW              thread ID
	 * @param howManyRandoms  how many runnables to make
	 */
	public WorkerRunner(int SIZE, int WW, int howManyRandoms)
	{
		this.SIZE           = SIZE;
		this.WW             = WW;
		this.howManyRandoms = howManyRandoms;
	}	
	
	/**
	 * this Runnable will grab integers that have been stored in 
	 * DataInAndOut data structure, and evaluate whether it's 
	 * prime or composite.  It will store primes into the
	 * Results data structure.  
	 */
	public void run() {
		try 
		{			
		
	   	if (Debug.DEBUG_VALUE > 2) {
	   		say("---------->in Worker Runnable thread " + WW);
	   		say("---------->SIZE (Overall # randoms to check) is " + SIZE);
	   		say("---------->This thread will check " + howManyRandoms+ " randoms.");
	   	}
	   	int aResult;
		while(SIZE>DataInAndOut.getWorkerProcessedCount())
		{
			for(int i=0; i<howManyRandoms; i++)
			{
				// use no arg. constructor to rely on system time for seed.
				
				if(!DataInAndOut.isEmpty())
				{
						aResult = DataInAndOut.popOut();
												
						if (Debug.DEBUG_VALUE > 3)say(""+DataInAndOut.getWorkerProcessedCount());
						//try { Thread.sleep(250); } catch (InterruptedException x) {  }
												
						if (Debug.DEBUG_VALUE > 3) 
							say("thread "+WW+" has this result: "+aResult);
						
						boolean isPrime = MillerRabin32.miller_rabin_32(aResult);
						
						if(isPrime)
						{
							Results.storeResult(aResult);// store only if prime
							if (Debug.DEBUG_VALUE > 3) 
								say(aResult + " is prime!");
						}
						else
						{
							if (Debug.DEBUG_VALUE > 3) 
								say(aResult + " is composite.");
						}					
				}
				//sleep a bit because Random class uses system time as seed.
				try { Thread.sleep(25); } catch (InterruptedException x) {  }
			}
		}
		if (Debug.DEBUG_VALUE > 3) say(toString());
		} 
		catch(Exception e) 
		{
		      System.err.println("run() terminating in WorkerRunner with exception:");
		      System.err.println(e);
		      System.exit(1);
		}
	}
		
	// I got this idea from: 
	// http://www.javapractices.com/topic/TopicAction.do?Id=62
	/**
	 * This makes it so the programmer doesn't have to bloat 
	 * code with the awkward & messy-looking "System.out.println"
	 * 
	 * @param a String to be printed to std out. 
	 */
	private static void say(String message){
	    System.out.println(message);
	}
		
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class WorkerRunner's data members: \n";
		objectState += "            WW = " + WW + "\n";
		objectState += "howManyRandoms = " + howManyRandoms + "\n";
		objectState += "------------Thank you------------";
		return objectState;
	}	
}
