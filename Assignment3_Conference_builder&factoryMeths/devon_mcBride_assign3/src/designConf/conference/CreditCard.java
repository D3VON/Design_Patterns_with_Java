
package designConf.conference;
import designConf.conference.Cost;
import designConf.conference.CostDollar;
import designConf.conference.CostEuro;
import designConf.util.Debug;

/**
 * @author      Devon McBride       <dmcbrid1@binghamton.edu> 
 * @author      Thomas John Orourke <torourk2@binghamton.edu>
 * @author      Daniel Scott        <dscott5@binghamton.edu>
 * 
 * @since       1.6.0_16
 * 
 * ...for Assignment 3, cs342, Program Design Patterns
 * 
 * This is an Abstract class that implements a toString for
 * its childern to inherit and use.  It has a Cost object and
 * a String, which holds the (child class's) name.  
 * 
 */
public abstract class CreditCard
{
	protected Cost cost;
	protected String name;

	@Override
	public String toString()
	{
		return ("The registration fee is " + cost.toString() + 
				" and you are paying" + "\n......................with your " 
            + name + " card.\n");
	}
}