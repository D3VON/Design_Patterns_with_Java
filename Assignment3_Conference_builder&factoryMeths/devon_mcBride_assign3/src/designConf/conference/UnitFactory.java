
package designConf.conference;
import designConf.conference.Time;
import designConf.conference.CarbonFootPrint;
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
 * Interface for "abstract factory pattern" which delegates
 * instantiation of three classes to the class which implements
 * this interface. 
 * 
 */
public interface UnitFactory {
	public Cost            createCostUnits(double x);
	public Time            createTimeUnits();
	public CarbonFootPrint createCarbonUnits();
}
