
package designConf.conference;
import designConf.conference.Presentation;
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
 * This class extends Presentation, and is a concrete representation
 * of a presentation in a conference.  This class sets the name, 
 * time, and carbon footprint of the presentation.
 * 
 */
public class FactoryMethod extends Presentation
{
	/** Constructor which is called by the driver. 
	 *  Sets cfp, time, and name.
     */
	public FactoryMethod()
	{
		name = "Factory Method Pattern Presentation";
		time = new TimeMinutes(120);
		cfp = new CFPTons(0.0008);
	}

    /**
     *  toString 
     */
	///////////DO NOT OVERRIDE! Rely on Abstract parent's toString. 
}