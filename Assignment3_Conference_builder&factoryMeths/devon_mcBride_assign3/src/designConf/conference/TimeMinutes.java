
package designConf.conference;
import designConf.conference.Time;
import designConf.conference.TimeMinutes;
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
 * This class represents time as minutes.  It is considered
 * the default way of representing time, though it is not a
 * base class.  The base class that this class implements is
 * the Time class. 
 * 
 */
public class TimeMinutes implements Time
{
	private int minutes;
	
	/** Constructor which should be called by a UnitFactory. 
	 * 
	 * --but since Time hasn't been fully implemented yet
	 * in the UnitFactory this class is simply called by each 
	 * class that needs a time class.  
	 * 
  	 * @param cost  -- the cost of the conference	 
  	 * @param currency -- the currency to use toString (in parent)
     */
	public TimeMinutes(int minutes)
	{
		this.minutes = minutes;
	}

	@Override
	public String toString()
	{
		return (minutes + " minutes");
	}
}