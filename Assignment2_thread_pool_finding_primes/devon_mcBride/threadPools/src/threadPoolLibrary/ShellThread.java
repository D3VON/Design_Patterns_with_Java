
package threadPools.threadPoolLibrary;

import threadPools.threadPoolLibrary.GeneratorPool;
import threadPools.threadPoolLibrary.WorkerPool;
import threadPools.threadPoolLibrary.MasterGenerator;
import threadPools.threadPoolLibrary.MasterWorker;
import threadPools.threadPoolLibrary.MasterGenerator;
import threadPools.threadPoolLibrary.RandProducer;
import threadPools.threadPoolLibrary.ThreadObjectPool;

import threadPools.util.Debug;

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
 * This is the "shell" thread that handles:
 * 1. detecting if there is a runnable that wants to run
 * 2. waiting if there isn't a runnable wanting to run
 * 3. running the runnables
 * 
 */
public class ShellThread extends Thread{
		
	private ThreadObjectPool owner;
	
	/**
	 * @param ThreadObjectPool, which is the interface, so this 
	 *        constructor can take various types of ThreadObjectPools
	 *        --in this Assignment 2, that's both worker and generator
	 */
	public ShellThread(ThreadObjectPool thePool)
	{
		owner = thePool;
	}
	
	/**
	 * This is the **heart** of the thread pool.  getAssignment()
	 * checks the assignments array for any Runnables to run.  
	 * If not, that method will wait.  When a Runnable is
	 * available, getAssignment() will return it here and 
	 * run it.   
	 * 
	 * Each thread is of type ShellThread, and so each one is
	 * always waiting for assignments to show up, so they can
	 * run them. 
	 * 
	 */
	public void run()
	{
		Runnable target = null;
		
		do
		{               // getAssignment waits until assignment shows up.
			target = owner.getAssignment(); 
			if (target != null)
			{
				if (Debug.DEBUG_VALUE > 1) 
					System.out.println(">>>>>>The run() method of a thread has been called.<<<<<");
				target.run(); 
			}
		} while(target != null);
	}
	
	
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class ShellThread's data members: \n";
		objectState += "         owner = " + owner + "\n";
		objectState += "------------Thank you------------";
		return objectState;
	}	
}
