
package threadPools.threadPoolLibrary;

import threadPools.threadPoolLibrary.ThreadObjectPool;
import threadPools.threadPoolLibrary.WorkerPool;

import threadPools.util.Debug;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 * This class, MasterWorker, obtains values from a singleton 
 * object, whose name is hardcoded in as DataInAndOut. 
 * 
 * This class evaluates each value obtained to determine if
 * it is a prime number. 
 * 
 * Divide's work for different threads to do.
 * Makes runnable objects for those threads. 
 * Sends runnable objects to the threads.
 * 
 */
public class MasterWorker extends Thread
{

	private ThreadObjectPool workerPool;

	// array holds num randoms each thread is to generate
    int[] chunkArray; 
	private int WW = 0;
	private int SIZE = 0;
	
	/*
	 *  Constructor MasterWorker() receives set-up data from driver
	 *  to set up Runnables to run in WorkerPool object. 
	 *  
	 *  @param SIZE        total number of random numbers to make.  
	 *  @param WW          how many threads to use/make to produce 
	 *                     those random numbers.
	 *  @param workerPool  a ref. to the WorkerPool that has 
	 *                     threads waiting.
	 */	
	public MasterWorker(int SIZE, int WW, ThreadObjectPool w){
			
		// if (Debug.DEBUG_VALUE > 3) 
		// 	say("--------->WW (num of threads to make) is "+WW);	
	    this.SIZE = SIZE;	
	    this.WW = WW;
		this.workerPool = w;
		
		// array holds num randoms each thread has to evaluate
	    this.chunkArray = new int[WW]; 
	    
	    // extra for the last thread to handle
	    int remainder = SIZE%WW;
	   	//if (Debug.DEBUG_VALUE > 3) say("remainder: " + remainder);
	    // fill chunkArray if num threads don't divide num rands evenly
	    if(remainder>0)
	    {
	      	int evenly = SIZE - remainder;
	       	//if (Debug.DEBUG_VALUE > 3) say("evenly: " + evenly);
	       	int chunk = evenly/WW;
	       	for(int i=0; i<WW-1; i++)
	       	{
	           	//if (Debug.DEBUG_VALUE > 3) say("chunk: " + chunk);
	       		chunkArray[i]=chunk;
	       	}
	       	chunkArray[WW-1]=chunk+remainder; // this is the last chunk 
	       	//if (Debug.DEBUG_VALUE > 3) 
	       	//	say("chunk: " + chunkArray[WW-1]);
	    }
	    else
	    {
	       	int chunk = SIZE/WW;
	       	//if (Debug.DEBUG_VALUE > 3) say("CHUNK SIZE IS "+ chunk);
	       	for(int i=0; i<WW; i++)
	       	{
	           	//if (Debug.DEBUG_VALUE > 3) say("i is: " + i);
	           	//if (Debug.DEBUG_VALUE > 3) say("make: "+WW+" chunks");
	           	//if (Debug.DEBUG_VALUE > 3) say("chunk: " + chunk);
	       		chunkArray[i]=chunk;
	       	}
	    }
	    //if (Debug.DEBUG_VALUE > 3) 
	    //say("CHUNK SIZE IS "+chunkArray[0]+" AND "+chunkArray[WW-1]);
	}

	    	
	/* make runnables (that make random numbers),
	 * then assign runnables to be run in the Generator pool 
	 * 
	 * WW is the number of Runnables to make
	 * 
	 */
	public void run()
	{	
		try {			
			for(int i = 0; i<WW; i++)
			{
				workerPool.assign(new WorkerRunner(SIZE,i,chunkArray[i]));
			}
	      } catch(Exception e) {
	        System.out.println("run() terminating in MasterWorker with exception:");
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
	@SuppressWarnings("unused")
	private static void say(String message){
	    System.out.println(message);
	}
			
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
    public String toString() {
		String objectState = null; //return all data members
		objectState  = "\n";
		objectState += "class MasterWorker's data members: \n";
		objectState += "                   WW = " + WW + "\n";
		return objectState;
    }
			
}
