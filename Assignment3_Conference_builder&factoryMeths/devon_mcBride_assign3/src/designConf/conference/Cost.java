
package designConf.conference;
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
 * This class is an interface which represents the cost of anything.  
 * Its children are implemented to represent various currencies. 
 * 
 */
public interface Cost
{
	public double getCost();
	public void setCost(double cost);
	public String toString();
}