
package threadPools.driver;

import threadPools.threadPoolLibrary.DataInAndOut;
import threadPools.threadPoolLibrary.GeneratorPool;
import threadPools.threadPoolLibrary.MasterGenerator;
import threadPools.threadPoolLibrary.MasterWorker;
import threadPools.threadPoolLibrary.RandProducer;
import threadPools.threadPoolLibrary.Results;
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
 * Driver for the tread object pool classes.  This driver
 * creates two thread pools: one used for threads that 
 * generate random numbers (and stores them into a 
 * singleton data structure) and another that reads
 * from the singleton data structure, evaluates whether
 * they are prime or composite, stores them in another
 * Results singleton data structure, and finally prints
 * which the primes discovered. 
 * 
 * Each thread that runs inserts a known prime into the 
 * initial data structure, to prove that the evaluation
 * threads are able to detect primes. 
 * 
 * The driver accepts the following command line arguments:
 * 1. the value of SIZE (between 100 and 1000)
 * 2. the capacity of the pools > than MM and WW
 * 3. the number of generator threads (MM), from 2 to 5
 * 4. the number of worker threads (WW), from 2 to 5
 * 5. Debug level, from 0 to 4
 * 
 * Debug codes are as follows: 
 * 0: No output should be printed
 * 1: Only ouput from the Driver code should be printed
 * 2: Print that the run() method of a thread has been called
 * 3: Print the arguments used for the Runnable object of each 
 *    thread before it is started
 * 4: Any debug statements that you have placed in the code
 *
 */
public class Driver 
{
	/**
	 * @param command line args
	 */
	public static void main(String[] args) 
	{	    
        int SIZE       =0; // number of integers to generate
        int poolSize   =0; // capacity of pools (same val for both pools)
        int MM         =0; // number of generator threads
        int WW         =0; // number of worker threads
        int debugValue =0;	
        
        if (args.length != 5) 
        {
            System.err.println("Usage is: ant compile [NUMS_TO_GEN] [POOL_CAPACITY]  [NUM_GEN_THREADS] [NUM_WORK_THREADS] [DEBUG_LEVEL] \n"); 
            System.exit(-1);
        } 

        try 
        {
        	SIZE       = Integer.parseInt(args[0]);
        	poolSize   = Integer.parseInt(args[1]);
        	MM         = Integer.parseInt(args[2]);
        	WW         = Integer.parseInt(args[3]);
            debugValue = Integer.parseInt(args[4]);
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("All argument must be integers.  Exception:");
		    System.err.println(e);
            System.exit(1);
        }

        if ((SIZE < 100 ) || (SIZE > 1000 ))
        {
            System.err.println("The number of integers to be generated must be between 100 & 1000.");
            System.exit(1);
        }else if (Debug.DEBUG_VALUE > 3) say("SIZE is " + SIZE);
        
        if ((poolSize < MM) || (poolSize < WW))
        {
            System.err.println("The capacity of the pools should be at least as big as either ");
            System.err.println("the number of generator threads or the number of worker threads.");
            System.exit(1);
        }else if (Debug.DEBUG_VALUE > 3) say("poolSize is " + poolSize);
        
        if ((MM < 2) || (MM > 5))
        {
            System.err.println("The number of generator threads must be between 2 and 5.");
            System.exit(1);
        }else if (Debug.DEBUG_VALUE > 3) say("MM is " + MM);  
        
        if ((WW < 2) || (WW > 5))
        {
            System.err.println("The number of worker threads must be between 2 and 5.");
            System.exit(1);
        }else if (Debug.DEBUG_VALUE > 3) say("WW is " + WW);   
        
        if ((debugValue < 0) || (debugValue > 4))
        {
        	System.err.println("Debug value must be from 0 to 4.");
            System.exit(1);
        }else if (Debug.DEBUG_VALUE > 3) say("debugValue is " + debugValue);  
           
        // set the DEBUG_VALUE in Debug.java 
        Debug.DEBUG_VALUE = debugValue;
        
        if (Debug.DEBUG_VALUE > 3) say("----------------------------------------------------------");
        if (Debug.DEBUG_VALUE > 3) say("Debug value is " + Debug.DEBUG_VALUE);

        // if DEBUG_LEVEL > 3, print all the argument received
        if (Debug.DEBUG_VALUE > 3)
            say("Arguments are: "+SIZE+" "+poolSize+" "+MM+" "+WW+" "+debugValue);
    	
        //if (Debug.DEBUG_VALUE > 0) say("overriding SIZE to be 7 for testing purposes.");
        //SIZE = 7;
		
		if (Debug.DEBUG_VALUE > 3) say("do " + MM + " threads");
		if (Debug.DEBUG_VALUE > 3) say("to make " + SIZE + " rands");
		ThreadObjectPool generator = new GeneratorPool(10);
		ThreadObjectPool worker = new WorkerPool(10);

		// an object, not a thread (don't need to join this one)
		RandProducer mg = new MasterGenerator(SIZE, MM, generator);
		mg.doRunnables();
		
		// this is a thread, because I want 
		// main to join it when it's finished.
		Thread mw = new MasterWorker(SIZE, WW, worker);
		mw.start();// wait for threads to finish
		/*
		 * 2 points if you make at least MasterWorker a thread
		 * so it can be join()ed when it finished...thusly:
		 */
		/* THIS WILL NOT WORK with this implementation because 
		 * there are too many independent threads that have 
		 * been given runnables. And the THREADS DO NOT DIE. 
		try 
		{
			say("Waiting for worker threads to finish.");
			mw.join();
			
			say("joined");
		} catch (InterruptedException e) 
		{
			say("Main thread Interrupted");
	        System.exit(1);
		}		 
				
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) 
			System.out.print("waiting (7 seconds) for threads to finish .");
		if (Debug.DEBUG_VALUE > 0) System.out.print(".");
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) System.out.print(".");
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) System.out.print(".");
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) System.out.print(".");
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) System.out.print(".");
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) System.out.print(".");
		try { Thread.sleep(1000); } catch (InterruptedException x) {  }
		if (Debug.DEBUG_VALUE > 0) say(".");
/**/
		/* THIS WAS THE BEST I COULD DO AT DETECTING 
		 * WHEN THE THREADS WERE FINISHED
		 * --IT WORKS PRETTY WELL: IT DOESN'T WASTE YOUR TIME,
		 * BUT IT TAKES AS MUCH TIME AS IT NEEDS
		 **/
		System.out.print("Running .");
		while(SIZE > DataInAndOut.getWorkerProcessedCount()){
			try { Thread.sleep(500); } catch (InterruptedException x) {  }
			System.out.print(" .");
		}
		say(" .");
		
		if (Debug.DEBUG_VALUE > 0) 
		{	
			say("");
			say("Of the numbers generated, these were prime: ");
			say("");
		    while(!Results.anyLeft())
		    {
		    	if (Debug.DEBUG_VALUE > 0) say("" + Results.getResult());
		    }
		}
		    
		if (Debug.DEBUG_VALUE > 0) say("\nG'bye World!");
		    
	    System.exit(0);
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
	
}
/* ********************************************
 *       HERE BE ADDITIONAL COMMENTS...
 *      NO ACTIVE CODE BEYOND THIS POINT.
 * ********************************************/


/* *****************************************		
		CLOSE ANY REMAINING THREADS WHEN DONE		
		AND ANY "OPEN" STUFF.  LIKE THE WAITINGROOM SINGLETON.		
		THAT DOESN'T NEED TO BE ALIVE WHEN EVERYTHING'S DONE. 		
		IN OTHER WORDS, HAVE A FINALIZE METHOD(S) IN THE OTHER CLASSES
		
		THAT CAN BE CALLED FROM HERE.
		E.G.,
		protected void finalize()  
	    {
	        for (int i=0;i<threads.length;i++) {
	            threads[i].interrupt();
	            threads[i] = null;
	        }
	    }
				
   ****************************************/	
		


