
package threadPools.threadPoolLibrary;

/*---------------------------------------------------------------------
 * This code has been adapted from Jeff Heaton,
 * "Creating a Thread Pool with Java" (Jan 10, 2003), InformIT Network
 * The code has been substantially modified to fit this assignment.
/*---------------------------------------------------------------------*/

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 * 
 * This is an abstract class for a generic object pool
 * of threads. 
 * 
 * 
 */
public abstract class ThreadObjectPool {
	
	/**
	 * Add a Runnable object to the assignments list. 
	 * Used by the class providing work for the threads in this pool.
	 * notify() any waiting threads that work has arrived. 
	 * 
	 * @param r A Runnable object (implements Runnable interface)
	 */
	public abstract void assign(Runnable r);
	
	/**
	 * Get an assignment (a Runnable) if one exists in the
	 * assignments list.  Called from the run() of a thread.  
	 * If no assignment in list, wait; If assignment is
	 * assigned, notify will un-wait this method. 
	 */
	public abstract Runnable getAssignment();
	
	/**
	 * nullify all threads
	 */
	public abstract void finalize();

}
