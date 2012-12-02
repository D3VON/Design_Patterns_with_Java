
package designConf.conference;
import designConf.conference.Time;
import designConf.conference.TimeMinutes;
import designConf.conference.CarbonFootPrint;
import designConf.conference.CFPTons;
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
 * This class is an interface for various kinds of transportation. 
 * It has a CarbonFootPrint instance, a Time instance, and a name (String).
 */
public abstract class Transport
{
	protected CarbonFootPrint cfp;
	protected Time time;
	protected String name;

	@Override
	public String toString()
	{
		return ("Going by " + name + " will take " + time.toString()
				+ "\n......................and have a cfp of "
				+ cfp.toString() + ".\n");
	}
}