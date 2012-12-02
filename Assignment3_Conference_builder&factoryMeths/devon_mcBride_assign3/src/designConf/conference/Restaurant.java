
package designConf.conference;
import designConf.conference.Time;
import designConf.conference.TimeMinutes;
import designConf.conference.CarbonFootPrint;
import designConf.conference.CFPTons;
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
 * This is the abstract (interface) base class for various
 * representations of restaurants.  That is to say, each child class
 * represents a different restaurant, each with its own Cost, Time, 
 * CarbonFootPrint objects, as well as a name of the restaurant
 * (as a String). 
 * 
 */
public abstract class Restaurant
{
	protected CarbonFootPrint cfp;
	protected Cost cost;
	protected Time time;
	protected String name;

	@Override
	public String toString()
	{
		return ("Your dinner at " + name + " will cost "
				+ cost.toString() + ",\n......................and will take " + time.toString()
				+ ",\n......................and has a cfp of "
				+ cfp.toString() + ".\n");
	}
}