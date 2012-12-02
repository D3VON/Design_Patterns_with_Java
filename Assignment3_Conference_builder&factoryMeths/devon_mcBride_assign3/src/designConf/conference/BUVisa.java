
package designConf.conference;
import designConf.conference.CreditCard;
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
 * This class extends the CreditCard class and inherits that 
 * class's toString.  This class instantiates a Cost instance, 
 * and has a name (String).
 * 
 */
public class BUVisa extends CreditCard
{
	/** Constructor which is called by the driver.
	 * 
	 * A discount is calculated when this credit card object is used. 
	 *  
  	 * @param cost  -- the cost of the conference	 
  	 * @param currency -- the currency to use toString (in parent)
     */
	public BUVisa(double cost, String currency)
	{		
		double discount = 10.0;		
		
		cost *= ((100.0 - discount) / 100.0);

		// parameter is always in dollars, to be converted
		// by whatever Cost subclass is instantiated. 
		if(currency.equals("Dollars"))
			this.cost = new CostDollar(cost);
		else if (currency.equals("Euros"))
			this.cost = new CostEuro(cost);
		
		name = "BU Alumni Platinum Visa";
	}

    /**
     *  toString 
     */
	///////////DO NOT OVERRIDE! Rely on Abstract parent's toString. 
}