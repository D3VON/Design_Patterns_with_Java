
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
 * This is the abstract (interface) base class for various
 * representations of time.  That is to say, each child class
 * represents a different unit of time, e.g., minutes (the 
 * default), hours, seconds, etc...
 * 
 */
public interface Time
{
	public String toString();
}