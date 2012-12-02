import java.util.Stack;


/* I finished implementing this in the Eclipse workspace.  look there instead of here. 



//---------------------------------------------------------------------
// This code is adapted from Eric freeman & Elisabeth Freeman,
// "Head First Design Patterns," pg. 182, October, 2004, OReilly
//---------------------------------------------------------------------


/**
 * The class DataInAndOut is of the singleton pattern.  It is meant
 * to provide a buffer that instances of the MasterGenerator class and 
 * MasterWorker class can use to store or remove integers.  This class
 * is synchronized to ensure orderly storage and retrieval in a  
 * multithreaded environment. 
 * 
 * @author Devon McBride
 * @version: 0.1
 *
 *
 * Methods available in this class:
 *    
 *   getInstance()             --creates/returns the Singleton instance
 *   sitAndWait(int x)         --puts int into stack
 *   yourTheNextContestant()   --pops int from stack
 *   getWorkerProcessedCount() --count of how many processed by workers
 *
 */
public class DataInAndOut{
   // static b.c. there will only be one instance
   // volatile so threads initialize the obj. w/out race condit.
	private volatile static DataInAndOut uniqueInstance;
 
 	// workerProcessedCount = SIZE (in driver) means all are processed
   private int workerProcessedCount = 0;

   //prefered stack because of it's very simple, non-fussy API
    private Stack waitingRoom = new Stack();
 
   // only Singleton class can call constructor
   // and really, it's only called once. 
	private DataInAndOut() {}
 
   // static so we can call the method like x = Singleton.getInstance();
   // static methods are class methods, use class name to reference
	public static DataInAndOut getInstance() // don't synchronize here.
   {  
		if (uniqueInstance == null) 
      {  // only synchronize at 1st instantiation                      
			synchronized (DataInAndOut.class) { 
            if (uniqueInstance == null)
            {  // with 2 if's it's called "double-checked locking"
               uniqueInstance = new DataInAndOut();
            } 
         }
		}
		return uniqueInstance;
	}

    /*/ PUT INTO PRODUCER
    /*  PUT INTO PRODUCER
    /*  PUT INTO PRODUCER
    /*  PUT INTO PRODUCER
    /*  PUT INTO PRODUCER
    /*  PUT INTO PRODUCER
    /*  PUT INTO PRODUCER
    /* 
    private int[] sevenPrimes = 
      {2789, 4001, 53309, 101573, 151901, 851881, 2901499};

   int nextElement = 0;

   public int getKnownPrime()
   {
		something =sevenPrimes[nextElement];
      if(nextElement == length.sevenPrimes) nextElement = 0;
      else nextElement++;
	}


*/

    /*/ PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    /* / PUT INTO CONSUMER SIDE -- linkedlist isn't synchronized 
    private LinkedList results = new LinkedList();
    */
    
   public void sitAndWait(int x)
   {
      waitingRoom.push(x)
   }


   public int yourTheNextContestant()
   {
      if (!waitingRoom.empty())
      {
         workerProcessedCount++; // to check vs. original SIZE (in driver)
         return waitingRoom.pop()
      }
      else
      {
         System.out.println("wow, it's empty.  What are we gonna do?");
      }
   }


   public int getWorkerProcessedCount()
   {
      return workerProcessedCount;
   }


  }
}

