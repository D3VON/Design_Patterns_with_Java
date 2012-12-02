
package threadPools.threadPoolLibrary;

import threadPools.threadPoolLibrary.ShellThread;
import threadPools.threadPoolLibrary.ThreadObjectPool;

import threadPools.util.Debug;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
/*---------------------------------------------------------------------
 * This code has been adapted from Jeff Heaton,
 * "Creating a Thread Pool with Java" (Jan 10, 2003), InformIT Network
 * The code has been substantially modified to fit this assignment.
/*---------------------------------------------------------------------*/
/**
 * WorkerPool, a Java thread object pool
 * 
 * This class tries to be an object pool containing threads. 
 * It is only able to instantiate empty threads (without 
 * runnable implemented), and hand them out.  It has no 
 * ability to reclaim a thread, so when a thread finished
 * it dies.  
 * 
 * The constructor will fill an array with "empty" threads. 
 * 
 * The getThread() method will pass a thread as long as
 * there are any left.  There is no checking to see if 
 * any threads remain. 
 * 
 * A finalize method can be called to make null any unused
 * threads. 
 * 
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 **/ 
public class WorkerPool extends ThreadObjectPool {
	
	/**
	 * Array to hold refs. to the threads in the pool.
	 */
	protected Thread threads[] = null;
	
	/**
     * Holding area for assignments waiting for a thread.
     * These are Runnable objects that can have run() do
     * whatever they want to do.
     */
    private static List<Runnable> assignments = new ArrayList<Runnable>();

    /**
     * The constructor.
     * 
     * @param SIZE  How many threads in the thread pool.
     */
    public WorkerPool(int SIZE)
    {
    	// ShellThread has run() defined to grab "real" run() objects from the assignments list. 
        threads = new ShellThread[SIZE]; 
        
        for (int i=0;i<SIZE;i++) {
            threads[i] = new ShellThread(this); // Note to self: each thread 
            									// has access to methods in 
            									// this class & other methods
            									// ShellThread class.
            threads[i].start();
        }
    }

    /**
     * Add a "real" run() to the assignments waiting to run. 
     * Any class that implements the Runnable interface
     * can run in these threads.
     * 
     * Design principle: Program to an interface,
     *                   not to an implementation.
     *                   
     * @param r   An obj that implements the Runnable interface
     */
    public synchronized void assign(Runnable r)
    {
        assignments.add(r);
        notify();
    }

    /**
     * Called from class ShellThread's run().  When called, 
     * it will get a Runnable stored in the assignments list,
     * if there is any.  But first it will wait until notified
     * by the assign() method that there is something in the 
     * assignments list.  If so, it will remove the assignment
     * and return it (to the ShellThread object). 
     * 
     * @return the next available Runnable
     */
    public synchronized Runnable getAssignment()
    {     //synch'd so many threads have orderly access to list
        try {
            while ( !assignments.iterator().hasNext() )
               wait();

            Runnable r = (Runnable)assignments.iterator().next();
            assignments.remove(r);
            return r;
        } catch (InterruptedException e) {
		      System.err.println("getAssignment() terminating in WorkerPool with exception:");
		      System.err.println(e);
		      // System.exit(1); COMPILER SQUALS IF NOTHING RETURNED
		      return null;
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
		objectState += "class WorkerPool's data members: \n";
		objectState += "        threads array = " + threads + "\n";
		objectState += "assignments ArrayList = " + assignments + "\n";
		
		return objectState;
    }

    /* gracefully kill all threads */
    public void finalize()  
    {
        for (int i=0;i<threads.length;i++) {
            threads[i].interrupt();     // throws SecurityException()
            threads[i] = null;
        }
    }
}