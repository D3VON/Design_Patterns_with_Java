
package threadPools.threadPoolLibrary;

/**
 * @author      Devon McBride <dmcbrid1@binghamton.edu> 
 *                            <devonmcb@yahoo.com>
 *                                                        
 * @since       1.6.0_16
 * 
 * ...for Assignment 2, cs342, Program Design Patterns
 *  
 * This code shamelessly (and gratefully) lifted directly 
 * from LiteratePrograms at the following web site:
 * 
 * http://en.literateprograms.org/Miller-Rabin_primality_test_(Java)#def:32-bit modular exponentiation function
 * 
 * NOTE: we studied this algorithm in cs458 Computer Security
 *       (Fall 2010)
 * 
 * */
public class MillerRabin32 {
		
	//public MillerRabin32(){}
		
   private static int modular_exponent_32(int base, int power, int modulus) {
       long result = 1;
       for (int i = 31; i >= 0; i--) {
           result = (result*result) % modulus;
           if ((power & (1 << i)) != 0) {
               result = (result*base) % modulus;
           }
       }
       return (int)result; // Will not truncate since modulus is an int
   }

   private static boolean miller_rabin_pass_32(int a, int n) {
	   int d = n - 1;
	   int s = Integer.numberOfTrailingZeros(d);
	   d >>= s;
       int a_to_power = modular_exponent_32(a, d, n);
       if (a_to_power == 1) return true;
       for (int i = 0; i < s-1; i++) {
           if (a_to_power == n-1) return true;
           a_to_power = modular_exponent_32(a_to_power, 2, n);
       }
       if (a_to_power == n-1) return true;
       return false;
   }

   public static boolean miller_rabin_32(int n) {
       if (n <= 1) return false;
       else if (n == 2) return true;
       else if (miller_rabin_pass_32( 2, n) &&
           (n <= 7  || miller_rabin_pass_32( 7, n)) &&
           (n <= 61 || miller_rabin_pass_32(61, n)))
           return true;
       else
           return false;
   }

   /*
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(miller_rabin_32(n) ? "PRIME" : "COMPOSITE");
    }
    */

	
   /**
    *  toString method returns a string containing all the data 
    *  members of this class with clear descriptions.
    */
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class MillerRabin32 only processes data passed to it. \n";
		objectState += "------------Thank you------------";
		return objectState;
	}	
   
}
