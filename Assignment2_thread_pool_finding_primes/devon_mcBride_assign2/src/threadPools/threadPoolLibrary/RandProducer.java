
package threadPools.threadPoolLibrary;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 * This is an interface for:
 * 
 * Dividing work for different threads to do.
 * Making runnable objects for those threads. 
 * Sending runnable objects to the threads.
 *
 */
public interface RandProducer {

	// seeds for the random generators of each thread
	final long[] seeds = {101,2058,32,44,5595,666,70857958};

	final int[] knownPrimes = { 7,   // Place one of these
								17,  // into each thread
								13,  // so it can put it
								3,   // among its results
								23,  // to ensure that
								31,  // each thread produces
								37,  // at least one number
								41,  // known to be prime.
								43,  // among its results
								51,  // to ensure that	
							  };	
	/* some bigger primes
	  143701463,  // among its results
	  174550297,  // to ensure that
	  73300001,   // each thread produces
	  8200691,    // at least one number
	  2951287,    // known to be prime.
	  50321,
	  909575063
	};	
	*/
	
	/**
	 * make runnables (that make random numbers),
	 * then assign runnables to be run in the Generator pool 
	 */
	public void doRunnables();
	
	/**
	 * @return the seeds
	 */
	public long getSeed(int s);

	/**
	 * @param  index of chunkArray to get chunk info from
	 * @return chunk of total number of threads to do
	 **/
	public int getChunk(int c);

	/**
	 * @param  index number
	 * @return a known prime from the hard-coded array
	 */
	public int getKnownPrime(int x);

	
}







