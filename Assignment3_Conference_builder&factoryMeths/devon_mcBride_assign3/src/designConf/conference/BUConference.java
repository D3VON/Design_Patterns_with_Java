
package designConf.conference;
import designConf.conference.Conference;
import designConf.conference.UnitFactory;
import designConf.conference.BUUnitFactory;
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
 * This is the child class of Conference.  It inherits
 * the methods: getFee(), clearSchedule(), printSchedule(), and getters
 * and setters for the data members: currency, carbon, time. 
 * 
 * This class is the BUILDER (pattern) which assembles the outputs
 * of the various objects it has received via the setupSchedule() method
 * which was abstract in the parent class, but implemented here. 
 * 
 */
public class BUConference extends Conference
{	
	/** Constructor which is called by the driver. 
	 *  @param currency, to set the overall currency used by this conference object
     */
	public BUConference(String currency)
	{
		this.currency = currency;
		UnitFactory unitFactory = new BUUnitFactory(this); // set up abstract factory pattern 
														   // to handle instantiating various
		                                                   // "units" subclasses. 
		
		confCost = unitFactory.createCostUnits(100.00); // unfortuantely hard-coded conference fee
		schedule = "\n";
	}
	
	/* The Builder Pattern: receive info about components 
	 * that has been gathered into an intermediate object 
	 * that has stored data about various objects needed 
	 * to be "stitched together"
	 */	
	@Override
	public void setupSchedule(Activities activities)
	{
		// assemble the texts of activities in this order
		// (classic builder pattern)
		schedule += activities.register();
		schedule += activities.presentationChoice();
		schedule += activities.transportChoice();
		schedule += activities.labChoice();
		schedule += activities.restaurantChoice();
	}

	
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	@Override
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class BUConference's data members: \n";
		objectState += "currency = " + currency + "\n";
		objectState += "schedule = " + schedule + "\n";
		objectState += "confCost = " + confCost + "\n";
		objectState += "----------------------------------";
		return objectState;
	}	
}
