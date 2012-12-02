
package toyThreads.driver;

import toyThreads.primeFactors.Factorizer;
import toyThreads.util.Debug;
import toyThreads.primeFactors.Results;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                         or <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 1, cs342, Program Design Patterns
 * 
 * Code template provided by Professor Madhusudan Govindaraju
 * 
 * Driver (main) program for finding all factors for a given positive 
 * integer. Work is broken up into threads.  The number of threads is 
 * specified by the user. 
 *
 * Usage: ant compile [PRIME_NUMBER] [NUMBER_OF_THREADS] [DEBUG_LEVEL}
 */
public class Driver {

    public static void main(String args[]) {

        int primeToTest=0, numberOfThreads=0, debugValue=0;	
        if (args.length != 3) {
            System.err.println("Usage is: ant compile [PRIME_NUMBER] [NUMBER_OF_THREADS] [DEBUG_LEVEL] \n"); 
            System.exit(-1);
        } // end args check

        try {
            primeToTest= Integer.parseInt(args[0]);
            numberOfThreads = Integer.parseInt(args[1]);
            debugValue = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("All argument must be integers");
            System.exit(1);
        }

        if (primeToTest < 1)
        {
            System.err.println("The number to test must be a positive integer.");
            System.exit(1);
        }        

        // FIXME done: set the DEBUG_VALUE in Debug.java 
        Debug.DEBUG_VALUE = debugValue;
        if (Debug.DEBUG_VALUE > 2){
            System.out.println("Debug value is " + Debug.DEBUG_VALUE);
        }

        // FIXME done:
        // if DEBUG_LEVEL > 2, print all the argument received
        if (Debug.DEBUG_VALUE > 2){
            System.out.print("Arguments are: " + primeToTest + " ");
            System.out.println(numberOfThreads + " " + debugValue);
        }


        // FIXME done: create numberOfThreads and to each thread pass 
        // an instance of Factorizer as argument
/*******************************/
/* SET UP THREADS AND RUN THEM */
/*******************************/
        //declare array of IMPLEMENTED runnable objs (instantiate later)
		Runnable[] rArr = new Factorizer[numberOfThreads];

        //declare array of threads  (instantiate later)
		Thread[] tArr = new Thread[numberOfThreads];
		
		// setup chunks of primeToTest to give to threads, 
		// and the startVal and endVal associated with each chunk		
		int chunkSize = primeToTest/2/numberOfThreads;
		
		if (Debug.DEBUG_VALUE >= 9){
			System.out.print("Size of chunks given to threads are: " + chunkSize);
		}
		
		// initialize values so the appropriate chunks 
		// of the primeToTest are worked on by each thread
		int startVal = 1 - chunkSize; 
		int endVal = 0;
							
	    // instantiate runnables, then threads 
	    // (threads impregnated with the just-instantiated runnable)
		for (int e = 0; e < numberOfThreads; e++){	
			startVal += chunkSize;
			endVal   += chunkSize;	
			rArr[e]   = new Factorizer(e,primeToTest,startVal,endVal);
			tArr[e]   = new Thread(rArr[e]);
			
			if (Debug.DEBUG_VALUE >= 9){
				System.out.print("Thread number " + e + " starts at " + startVal + " and ends at " + endVal);
			}			
		}
		
        // start all threads
		for (Thread i : tArr){
			i.start();		

		}
/****************************************/
/* SET-UP FINISHED, THREADS ARE RUNNING */
/****************************************/
		
        try {
        // FIXME done: wait for the threads to get done
            // adjust this sleep duration as needed
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // interruption of the main thread is fatal, so exit
            ie.printStackTrace();
            System.exit(-1);
        }

        // FIXME done; print factors using the printFactors() method
        // of the Results class
	    Results.printFactors();

        System.out.println("\n Good Bye \n");

    } // end main(...)
}
