
package designConf.conference;
import designConf.conference.CarbonFootPrint;
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
 * This class represents a carbon footprint in tons.  It is considered
 * the default way of representing a carbon footprint, though it is 
 * not a base class.  The base class that this class implements is
 * the CarbonFootPrint class. 
 * 
 */
public class CFPTons implements CarbonFootPrint
{
	private double carbonFootPrint;

	/** Constructor which should be called by a UnitFactory. 
	 * 
	 * --but since CarbonFootPrint hasn't been fully implemented yet
	 * in the UnitFactory, this class is simply called by each 
	 * class that needs a CarbonFootPrint object.  
	 * 
  	 * @param carbonFootPrint  carbonFootPrint in tons 
     */
	public CFPTons(double carbonFootPrint)
	{
		this.carbonFootPrint = carbonFootPrint;
	}

	@Override
	public String toString()
	{
		return (carbonFootPrint + " tons of CO2");
	}
}