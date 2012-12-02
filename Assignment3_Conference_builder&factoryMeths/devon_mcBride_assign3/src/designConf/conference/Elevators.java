
package designConf.conference;
import designConf.conference.Transport;
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
 * This class extends the Transport class and inherits that 
 * class's toString.  This class has a CarbonFootPrint instance, 
 * a Time instance, and a name (String). 
 * 
 */
public class Elevators extends Transport
{
	/** Constructor which is called by the driver. 
	 *  Sets cfp, time, and name.
     */
	public Elevators()
	{
		name = "elevators & tunnels";
		time = new TimeMinutes(12);
		cfp = new CFPTons(0.0001);
	}

    /**
     *  toString 
     */
	///////////DO NOT OVERRIDE! Rely on Abstract parent's toString. 
}