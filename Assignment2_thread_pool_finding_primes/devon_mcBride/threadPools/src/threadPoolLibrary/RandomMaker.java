
package threadPools.threadPoolLibrary;

import java.util.Random;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 *  a class to make random numbers 
 *  
 */
public class RandomMaker {
	static Random randyGen;
	
	/**
	 * the constructor
	 * 
	 * @param  seed, a long to seed the Random object
	 * 
	 * instantiates a Random object.
	 **/
	public RandomMaker(long seed){
		try
		{
			RandomMaker.randyGen = new Random(seed);
		}
		catch (IllegalArgumentException ex) 
		{
			System.err.println("That was a bad seed.");
		    System.err.println(ex);
            System.exit(1);
		} 
	}
	
	// NOTE: my hard coded seed produces repetitive results. 
	/**
	 * another constructor
	 * instantiates a Random object.
	 **/
	public RandomMaker(){
			// Default seed comes from system time.
			RandomMaker.randyGen = new Random();
	}
	
	/**
	 * @return a large random integer	 * 
	 **/	
	public int getRandy(){
		return randyGen.nextInt();
	}
	
	
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class RandomMaker only has data passed to it.\n";
		objectState += "------------Thank you------------";
		return objectState;
	}	
	
	
}