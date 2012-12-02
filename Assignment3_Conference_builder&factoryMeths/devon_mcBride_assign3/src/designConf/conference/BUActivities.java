
package designConf.conference;
import designConf.conference.Activities;
import designConf.conference.CreditCard;
import designConf.conference.Visa;
import designConf.conference.MasterCard;
import designConf.conference.BUVisa;
import designConf.conference.Amex;
import designConf.conference.Lab;
import designConf.conference.LibraryGroundLab;
import designConf.conference.EngineeringLab;
import designConf.conference.AcademicAPod;
import designConf.conference.Transport;
import designConf.conference.Walking;
import designConf.conference.Elevators;
import designConf.conference.Campusbus;
import designConf.conference.Restaurant;
import designConf.conference.PSRestaurant;
import designConf.conference.No5Restaurant;
import designConf.conference.LemongrassRestaurant;
import designConf.conference.Presentation;
import designConf.conference.State;
import designConf.conference.Observer;
import designConf.conference.FactoryMethod;
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
 * This class implements Activities.  It is intended as a "carrier" 
 * of other classes, and is used as a parameter to Conference object.  
 * It is an integral part of the builder pattern. 
 * 
 */
public class BUActivities implements Activities
{
	protected CreditCard card;
	protected Lab lab;
	protected Presentation presentation;
	protected Transport transport;
	protected Restaurant restaurant;

	/** Constructor which is called by the driver. 
	 *  @param a CreditCard object (output used by builder to assemble schedule)
	 *  @param a Lab object (output used by builder to assemble schedule)
	 *  @param a Presentation object (output used by builder to assemble schedule)
	 *  @param a Transport object (output used by builder to assemble schedule)
	 *  @param a Restaurant object (output used by builder to assemble schedule) 
     */
	public BUActivities(CreditCard card, Lab lab, Presentation presentation, 
						Transport transport, Restaurant restaurant)
	{
		this.card 		  = card;
		this.presentation = presentation;
		this.transport 	  = transport;
		this.lab 		  = lab;
		this.restaurant   = restaurant;
	}

	/**
	 * @return the finished registration information as a String
	 */
	@Override
	public String register()
	{
		return card.toString();
	}

	/**
	 * @return the finished presentation information as a String
	 */
	@Override
	public String presentationChoice() 
	{
		return presentation.toString();
	}

	/**
	 * @return the finished transportation information as a String
	 */
	@Override
	public String transportChoice() 
	{
		return transport.toString();
	}

	/**
	 * @return the finished lab/competition information as a String
	 */
	@Override
	public String labChoice()
	{
		return lab.toString();
	}

	/**
	 * @return the finished restaurant information as a String
	 */
	@Override
	public String restaurantChoice()
	{
		return restaurant.toString();
	}		
	
    /**
     *  toString method returns a string containing all the data 
     *  members of this class with clear descriptions.
     */
	@Override
	public String toString() {
		String objectState = null; //return all data members
		objectState  = "----------------------------------\n";
		objectState += "class BUActivities's data members: \n";
		objectState += "   CreditCard class    \n";
		objectState += "   Lab class           \n";
		objectState += "   Presentation class  \n";
		objectState += "   Transport class     \n";
		objectState += "   Restaurant class    \n";
		objectState += "----------------------------------";
		return objectState;
	}	
}