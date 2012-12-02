
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
 * This is the abstract (interface) base class for various
 * representations of labs.  That is to say, each child class
 * represents a different lab.  A lab has a name
 * (as a String), and both CarbonFootPrint and Time objects. 
 * 
 */
public abstract class Lab
{	
	protected CarbonFootPrint cfp;
	protected Time time;
	protected String name;

	@Override
	public String toString()
	{
		return ("The programming contest you chose is at " 
				+ name + ",\n...................... and will take "
				+ time.toString() + ",\n......................and has a cfp of "
				+ cfp.toString() + ".\n");
	}
}