
package toyThreads.primeFactors;

import toyThreads.util.Debug;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                         or <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 1, cs342, Program Design Patterns
 * 
 * Code template provided by Professor Madhusudan Govindaraju
 * 
 * This is an uninstantiable class to store values produced by threads 
 * into static variables.  Also with accessor (very narrowly defined) 
 * and mutator methods.  
 */
public class Results {

    // FIXME done: instantiate the arrayList here, instead of setting 
    // it to null;
    //ORIGINAL: private static ArrayList<Integer> factorsFound = null;
    private static ArrayList<Integer> factorsFound = new ArrayList<Integer>();

			 // sorry for all the notes: I had to study this stuff. 
		    /* ORACLE SAYS:  If multiple threads access an ArrayList 
           * instance concurrently, and at least one of the threads 
           * modifies the list structurally, it must be synchronized 
           * externally...the list should be "wrapped" using the 
           * Collections.synchronizedList method. This is best done at 
           * creation time, to prevent accidental unsynchronized access 
           * to the list.
		     */
	 // note to self: also has to be static like the thing we're 
    // trying to wrap


    static List<Integer> synchedFactors = Collections.synchronizedList(factorsFound);
	

    // FIXME done: change this to a private constructor
    private Results() {}

    // FIXME done: make this method thread-safe
    //        -- already fixed because it's a synchronized arraylist

   /**
    * Mutator method: to add a factor (an int) to the array
    * which holds them.
    * 
    * @param  an integer (int) which was found to be a factor of the 
    * given number. 
    */
    public static void addFactor(int newFactor) {
        synchedFactors.add(newFactor);    	
    }
    
    /**
     * Accessor method: print out what's in the array of factors. 
     */
    public static void printFactors() {
    // FIXME done: all factors in the ArrayList should be printed here    
    
	 // I shouldn't need to make a synchronized block to iterate over 
    // the list because all threads should be finished by the time I 
    // need to do that. 

        Collections.sort(synchedFactors); // wow, that's dead easy to sort.

        Iterator<Integer> itr = synchedFactors.iterator();
        while (itr.hasNext()) {      
            Integer element = itr.next();
            System.out.print(element + " ");   
        }
    	
    }
}
