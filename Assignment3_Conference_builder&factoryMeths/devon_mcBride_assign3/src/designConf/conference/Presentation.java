
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
 * representations of presentations.  That is to say, each child class
 * represents a different presentation.  A presentation has a name
 * (as a String), and both CarbonFootPrint and Time objects. 
 * 
 */
public abstract class Presentation
{
	protected CarbonFootPrint cfp;
	protected Time time;
	protected String name;

	@Override
	public String toString()
	{
		return ("You have chosen to attend " 
				+ name + ",\n......................which will take "
				+ time.toString() + ",\n......................and have a cfp of "
				+ cfp.toString() + ".\n");
	}
}