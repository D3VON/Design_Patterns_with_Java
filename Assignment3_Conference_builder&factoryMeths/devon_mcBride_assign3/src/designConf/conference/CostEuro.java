
package designConf.conference;
import designConf.conference.Cost;
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
 * This is an implementation of the Cost class that specifically 
 * handles the currency "Euros", and its exchange rate.  
 * 
 */
public class CostEuro implements Cost
{
	private double cost;

	/** Constructor which is called by a UnitFactory. 
	 *  
  	 * @param cost  -- the cost of the conference	 
     */
	public CostEuro(double cost)
	{
		// a class should be implemented to get exchange rates thusly:
		//this.cost = cost * Currency.getExchangeRate("Euro");
		this.cost = cost * .75;
	}

	@Override
	public double getCost()
	{
		return cost;
	}

	@Override
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	@Override
	public String toString()
	{
		return (cost + " Euros");
	}
}