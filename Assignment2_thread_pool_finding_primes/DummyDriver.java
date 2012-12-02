import DataInAndOut;

public class DummyDriver 
{
	public static void main(String[] args) 
	{

      int dummyInt = 0;

      DataInAndOut waitingRoom = DataInAndOut.getInstance();
		System.out.println("got singleton instance");
      System.out.println("worked on so far: " + getWorkerProcessedCount());

      sitAndWait(11556688);
      sitAndWait(3);
      sitAndWait(187699);


      System.out.println("Here's a number: " + yourTheNextContestant());
      System.out.println("worked on so far: " + getWorkerProcessedCount());
      System.out.println("Here's a number: " + yourTheNextContestant());
      System.out.println("worked on so far: " + getWorkerProcessedCount());
      System.out.println("Here's a number: " + yourTheNextContestant());
      System.out.println("worked on so far: " + getWorkerProcessedCount());
      System.out.println("----what's gonna happen here?----");
      System.out.println("Here's a number: " + yourTheNextContestant());
      System.out.println("worked on so far: " + getWorkerProcessedCount());


		System.out.println("G'bye World!");
	}
}
/*******

I switched over and implemented this in eclipse instead. Look in the eclipse workspace for it. 


*******/