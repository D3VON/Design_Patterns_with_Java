
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
 * This is the abstract base class that declares the objects
 * to be assembled by the child class. 
 * 
 */
public interface Activities
{
	public String register();
	public String presentationChoice();
	public String transportChoice();
	public String labChoice();
	public String restaurantChoice();
}


