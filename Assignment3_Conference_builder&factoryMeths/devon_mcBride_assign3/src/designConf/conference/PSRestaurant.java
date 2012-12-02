
package designConf.conference;
import designConf.conference.Restaurant;
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
 * This class extends Restaurant, and is a concrete representation
 * of a restaurant.  This class sets the name, 
 * time, and carbon footprint, and cost of the restaurant.
 * 
 */
public class PSRestaurant extends Restaurant
{	
	/** Constructor which is called by the driver. 
  	 * @param currency -- the currency to use toString (in parent)
     */
	public PSRestaurant(String currency)
	//public PSRestaurant()
	{
		name = "P.S. Restaurant";
		cfp = new CFPTons(0.0007);
		cost = new CostDollar(50);

		// parameter is always in dollars, to be converted
		// by whatever Cost subclass is instantiated. 
		if(currency.equals("Dollars"))
			cost = new CostDollar(50);
		else if (currency.equals("Euros"))
			cost = new CostEuro(50);
			
		time = new TimeMinutes(95);
	}

    /**
     *  toString 
     */
	///////////DO NOT OVERRIDE! Rely on Abstract parent's toString. 
}