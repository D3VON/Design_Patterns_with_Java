
package toyThreads.primeFactors;

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
 * Implement runnable threads to find all factors for a given positive 
 * integer, but between only the given start and end values 
 * (startVal & endVal).
 */
public class Factorizer implements Runnable {

    private int myID;
    private int numberToFactorize;
    private int startValue;
    private int endValue;

    
    // FIXME done: define an explicit value constructor that initializes 
    // all the data members
    public Factorizer(int threadID, int theNumber, int startVal, int endVal){
        myID = threadID;
        numberToFactorize =theNumber;
        startValue = startVal;
        endValue = endVal;
    }
   
    /**
     *  implementation of Runnable's run method
     */
    public void run() {

	    // no need to catch InterruptedException as there is no 
        // Threads.sleep(100) call here;
	    if (Debug.DEBUG_VALUE >= 7) {
			// the toString(...) method will be called to print "this"
			System.out.println("Work started by factorizer thread: " + this);
	    }
	    
        // FIXME done: check for factors from startValue to endValue 
        // for numberToFactorize
		while ( (startValue < endValue) ){
			if( (numberToFactorize % startValue) == 0 ){
				
                // FIXME done: if a factor is found, add it the 
                // ArrayList in the Results class
                if (startValue > 1) // Madhu wants neither 1, nor the
                {                   // given number, so keep them out.
                   Results.addFactor(startValue);
                   Results.addFactor(numberToFactorize/startValue);
                }
			}
			if (startValue >= numberToFactorize/startValue) break;

			startValue++;
			endValue--;
		}
	    if (Debug.DEBUG_VALUE >= 7) {
			System.out.println("Work finished by factorizer thread: " + myID);
	    }
    } // end run(...)

    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
    public String toString() {
		String objectState = null;
        // FIXME done: add all the data members to a String, 
        // & return that string
		objectState  = "\n";
		objectState += "class Factorizer's data members: \n";
		objectState += "         threadID = " + myID + "\n";
		objectState += "numberToFactorize = " + numberToFactorize + "\n";
		objectState += "       startValue = " + startValue + "\n";
		objectState += "         endValue = " + endValue + "\n";		
		
		return objectState;
    }

} // end class WorkerThread

