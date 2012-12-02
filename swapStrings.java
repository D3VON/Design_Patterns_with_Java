/* 
Write Java code to swap two strings
   Do not attempt to access the internals of the string class


This program does the following:
   ACCEPTS COMMAND LINE ARGUMENTS
   HAS A GENERIC TRY/CATCH BLOCK
   DEMONSTRATES THAT JAVA DOESN'T PASS BY REFERENCE,
      BUT RATHER PASSES ADDRESSES BY VALUE
      AND WORKS ON A LOCAL COPY OF WHATEVER'S AT THAT ADDRESS

   Madhu gave us about a minute and a half, all the while with him being 
   irritated and critical about every thing he saw someone write on paper. 

   After that minute and a half, he showed this slide:

   Did you accept the two strings from the command line?
   Did you perform an error-check when you read the two strings from the command line?
   Did you throw/catch exceptions?
   Did you actually test the program against the requirements?

USAGE: java swapStrings string1 string1

EXAMPLE: java swapStrings woof meow

...if two args aren't entered on command line, program will
hardcode in "woof" and "meow" into the two strings

*/

class swapStrings
{
   public static void swap(String a, String b)
   {
		System.out.println("Start of method------");
      System.out.println("Dogs say: " + a);
      System.out.println("Cats say: " + b);

      String temp = a;
      a = b;
      b = temp;

		System.out.println("Finishing method------");

      System.out.println("Dogs say: " + a);
      System.out.println("Cats say: " + b);
   }
	
   public static void main(String[] args) 
	{
      String doggy; // = "woof";
      String kitty; // = "meow";
      try 
      {
         doggy =args[0];
         kitty =args[1];
   	} 
      catch(Exception e) 
      {
         System.out.println("Caught Exception");
         System.out.println(
           "e.getMessage(): " + e.getMessage());
         System.out.println(
           "e.toString(): " + e.toString());
         System.out.println("e.printStackTrace():");
         e.printStackTrace();
            // if we're in catch, then the variables haven't been set right. 
            doggy = "woof";
            kitty = "meow";
            
      }
   //      finally
     //    {
            // if we're in catch, then the variables haven't been set right. 
           // doggy = "woof";
           // kitty = "meow";
         //}

		System.out.println("Original------");
		System.out.println("Dogs say: " + doggy);
		System.out.println("Cats say: " + kitty);

      swap(doggy, kitty);
      
      
		System.out.println("Start doing it in main------");
		System.out.println("Dogs say: " + doggy);
		System.out.println("Cats say: " + kitty);
      
      String temp = doggy;
      doggy = kitty;
      kitty = temp;
      
		System.out.println("After swapping in main------");
		System.out.println("Dogs say: " + doggy);
		System.out.println("Cats say: " + kitty);
	}
}
