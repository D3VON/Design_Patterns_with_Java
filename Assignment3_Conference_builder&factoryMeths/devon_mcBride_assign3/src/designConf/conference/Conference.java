
package designConf.conference;
import designConf.conference.Activities;
import designConf.conference.BUActivities;
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
 * This is the abstract base class for the conference.  It implements
 * the methods: getFee(), clearSchedule(), printSchedule(), and getters
 * and setters for the data members: currency, carbon, time.  
 * 
 */
public abstract class Conference
{
	protected String currency;
	private String carbon;
	private String time;
	protected Cost confCost;
	protected String schedule;

	public abstract void setupSchedule(Activities activities);

	/**
	 * self explanatory
	 */
	public void clearSchedule()
	{
		schedule = "\n";
	}

	/**
	 * @return the cost of the conference; set in the class implementing this class.
	 */
	public double getFee()
	{
		return confCost.getCost();
	}

	public void printSchedule()
	{
		if (Debug.DEBUG_VALUE > 0) System.out.println(schedule);
	}

	/**
	 * @param time the time units to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the time units
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param carbon the carbon measurement to set
	 */
	public void setCarbon(String carbon) {
		this.carbon = carbon;
	}

	/**
	 * @return the carbon measurement
	 */
	public String getCarbon() {
		return carbon;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return this.currency;
	}

}