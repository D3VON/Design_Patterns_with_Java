
package designConf.conference;
import designConf.conference.Conference;
import designConf.conference.BUConference;
import designConf.conference.UnitFactory;
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
 * Implements an abstract factory.  Create methods here
 * handle instantiating the various "units" subclasses, 
 * depending on parameters input. 
 * 
 * NOTE: CarbonFootPrint and Time classes
 * only have the "default" children implemented.  
 * 
 */
public class BUUnitFactory implements UnitFactory {
	
	Conference conf;
	
	/** Constructor which is called by a Conference object, 
	 *  e.g., BUConference. 
	 *  
	 *  @param conf -- the Conference object instantiating this class.
     */
	BUUnitFactory(Conference conf){
		this.conf = conf;
	}
		
	/**
	 * This factory method depends on the getCurrency() method
	 * in the Conference object which instantiated this class. 
	 * 
	 * @param fee, a price or cost
	 * @return a cost object
	 */
	@Override
	public Cost createCostUnits(double fee) 
	{
		Cost cost = null;
		
		//System.out.println(this.conf.getCurrency());
	
		if( conf.getCurrency().equals("Dollars") )
		{
			cost = new CostDollar(fee);
		}
		else if (conf.getCurrency() == "Euros")
		{
			cost = new CostEuro(fee);
		}
		
		return cost;
	}
	
	/**
	 * This factory method depends on the getTime() method
	 * in the Conference object which instantiated this class. 
	 * 
	 * @return a Time object
	 */
	@Override
	public Time createTimeUnits() {
		if(conf.getTime().equals("Minutes"))
		{
			return new TimeMinutes(0);
		}
		/* not yet implemented
		else if (conf.getTime().equals("Hours"))
		{
			return new TimeHours(0);
		}
		*/
		else
			return null;
	}
	
	/**
	 * This factory method depends on the getCarbon() method
	 * in the Conference object which instantiated this class. 
	 * 
	 * @return a CarbonFootPrint object
	 */
	@Override
	public CarbonFootPrint createCarbonUnits() {
		if(conf.getCarbon().equals("Tons"))
		{
			return new CFPTons(0);
		}
		/* not yet implemented
		else if (conf.getCarbon().equals("Kilos"))
		{
			return new CFPTons(0);
		}
		*/
		else
			return null;
	}
	
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	@Override
	public String toString(){
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class BUConUnitFactory            \n";
		objectState += "----------------------------------  ";
		return objectState;
	}	
	
	
	

}
