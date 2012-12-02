
package threadPools.threadPoolLibrary;

import threadPools.threadPoolLibrary.GeneratorPool;
import threadPools.threadPoolLibrary.RandProducer;
import threadPools.threadPoolLibrary.RandomRunner;
import threadPools.threadPoolLibrary.ThreadObjectPool;

import threadPools.util.Debug;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 * Divide's work for different threads to do.
 * Makes runnable objects for those threads. 
 * Sends runnable objects to the threads.
 * 
 */
public class MasterGenerator implements RandProducer
{
	private ThreadObjectPool genPool;

	// seeds for the random generators of each thread
	//private long[] seeds = {101,2058,32,44,5595,666,70857958};


	// array holds num randoms each thread is to generate
    private int[] chunkArray; 
	
	/*private int[] knownPrimes = { 7,  // Place one of these
								  17,  // into each thread
								  13,  // so it can put it
								  143701463,  // among its results
								  174550297,  // to ensure that
								  73300001,   // each thread produces
								  8200691,    // at least one number
								  2951287,    // known to be prime.
								  50321,
								  909575063
								};*/
	private int MM = 0;
	// only used in constructor as parameter to constructor: private int SIZE = 0;

	/**
	 *  Constructor MasterGenerator() receives set-up data from driver
	 *  to set up Runnables to run in GeneratorPool object. 
	 *  
	 *  @param SIZE        total number of random numbers to make.  
	 *  @param MM          how many threads to use/make to produce those random numbers.
	 *  @param genPool     a reference to the generatorPool that has threads waiting. 
	 */	
	public MasterGenerator(int SIZE, int MM, ThreadObjectPool g){
		
		//if (Debug.DEBUG_VALUE > 3) say("MM (num of threads to make) is "+MM);		
		     this.MM = MM;
		this.genPool = g;
		// array holds num randoms each thread has to generate
	    this.chunkArray = new int[MM]; 
	    // extra for the last thread to handle
        int remainder = SIZE%MM;
       	//if (Debug.DEBUG_VALUE > 3) say("remainder: " + remainder);
        // fill chunkArray if num threads don't divide num rands evenly
        if(remainder>0)
        {
        	int evenly = SIZE - remainder;
           	//if (Debug.DEBUG_VALUE > 3) say("evenly: " + evenly);
        	int chunk = evenly/MM;
        	for(int i=0; i<MM-1; i++)
        	{
               	//if (Debug.DEBUG_VALUE > 3) say("chunk: " + chunk);
        		chunkArray[i]=chunk;
        	}
        	chunkArray[MM-1]=chunk+remainder; // this is the last chunk 
           	//if (Debug.DEBUG_VALUE > 3) say("chunk: " + chunkArray[MM-1]);
        }
        else
        {
        	int chunk = SIZE/MM;
           	//if (Debug.DEBUG_VALUE > 3) say("CHUNK SIZE IS "+ chunk);
        	for(int i=0; i<MM; i++)
        	{
               	//if (Debug.DEBUG_VALUE > 3) say("i is: " + i);
               	//if (Debug.DEBUG_VALUE > 3) say("make: " + MM+" chunks");
               	//if (Debug.DEBUG_VALUE > 3) say("chunk: " + chunk);
        		chunkArray[i]=chunk;
        	}
        }
       	//if (Debug.DEBUG_VALUE > 3) say("CHUNK SIZE IS " + chunkArray[0] + " AND " + chunkArray[MM-1]);
	}

    	
	/**
	 * make runnables (that make random numbers),
	 * then assign runnables to be run in the Generator pool 
	 * 
	 * MM is the number of Runnables to make
	 * 
	 */
	public void doRunnables()
	{	
		for(int i = 0; i<MM; i++)
		{
			genPool.assign(new RandomRunner(getSeed(i),i,getKnownPrime(i),getChunk(i)));
		}			
	}
	
	/**
	 * @param an integer which is the element number in the array
	 * @return the seeds
	 */
	public synchronized long getSeed(int s) {
		return seeds[s];
	}

	/**
	 * @param  index of chunkArray to get chunk info from
	 * @return chunk of total number of threads to do
	 **/
	public synchronized int getChunk(int c) {
		return chunkArray[c];
	}

	/**
	 * @param  index number
	 * @return a known prime from the hard-coded array
	 */
	public synchronized int getKnownPrime(int x) {
		return knownPrimes[x];
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
		objectState += "class MasterGenerator's data members: \n";
		objectState += "                   MM = " + MM + "\n";
		// next one isn't going to be prety output
		objectState += "    knownPrimes array = " + knownPrimes + "\n";
		// next one isn't going to be prety output
		objectState += "          seeds array = " + seeds + "\n";
		
		return objectState;
    }

		
}
