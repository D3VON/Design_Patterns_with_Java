
package designConf.driver;
import designConf.conference.Activities;
import designConf.conference.BUActivities;
import designConf.conference.Conference;
import designConf.conference.BUConference;
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
 *  @since      1.6.0_16
 * 
 *  ...for Assignment 3, cs342, Program Design Patterns
 * 
 *  Driver (main) program for demonstrating software that can be used
 *  by each attendee of a Design Patterns Conference at Binghamton 
 *  University. The attendees of the conference have the following 
 *  activities during the conference: register for the conference, 
 *  visit one of 3 labs to work on a programming contest, decide 
 *  which of the 6 presentation sessions to attend (all 6 sessions 
 *  will be going on at the same time), and decide which of the 
 *  3 restaurants to visit for a working-dinner. Each attendee 
 *  will complete all these activities during the conference. The 
 *  attendee's choices will result in a different time (in minutes), 
 *  cost (in dollars), and carbon-footprint (in tons of CO2). 
 *
 *  Usage: ant compile | java DriverOfConference [0|1|2|3|4]
 */
public class DriverOfConference
{
	public static void main(String args[]) 
	{
		
/* ********************************
 * 	Handle debugging argument	
 * ********************************/
		
        int debugValue = 0;	
        if (args.length != 1) 
        {
            System.err.println("Usage is: ant compile [DEBUG_LEVEL] \n"); 
            System.exit(-1);
        } // end args check

        try 
        {
            debugValue = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argument must be an integer.");
            System.exit(1);
        }
        
        if ((debugValue < 0) || (debugValue > 4))
        {
            System.out.println("Debug value must be between 0 and 4.");
        }  

        // set the DEBUG_VALUE in Debug.java 
        Debug.DEBUG_VALUE = debugValue;

/* **********************************
 * 	Done handling debugging argument	
 * **********************************/		
				
		/*
		 * A web-based registration would generate an object 
		 * to wrap these parameters.  Due to time constraints
		 * (and pain thresholds), we've given these parameters
		 * simply as strings. 
		 * 
		 * These parameters are used by the factory methods to
		 * instantiate the appropriate objects. 
		 * 
		 */
		String currency = "Euros";	// This simulates data passed in
									// by a web-based registration form. 
		                            // (Would be enum for typesafeness.)
							        // Other units (CarbonFootPrint 
									// units, and Time units) would be 
									// handled similarly. This value is
		                            // eventually passed to a factory
		               				// method to create the Cost object.
		//String carbon = "Tons";
		//String time = "Minutes";
		
//===================================================================
//	ATTENDEE #1	
//===================================================================
		
		// this is the builder object
		Conference buConf = new BUConference(currency);
		
		if (Debug.DEBUG_VALUE > 1) System.out.println(buConf.toString());
				
		if (Debug.DEBUG_VALUE > 1) System.out.println(buConf.getCurrency());
		

		// activity choices.  Not quite factory method, but instantiation 
		// is delegated to subclasses nonetheless. 
		CreditCard card           = new BUVisa(buConf.getFee(), currency); 
		Presentation presentation = new FactoryMethod();
		Transport transport       = new Campusbus();
		Lab lab                   = new AcademicAPod();
		Restaurant restaurant     = new PSRestaurant(currency);

		// the hard-coded choices stored "in an elegant way"
		Activities activities = new BUActivities(card, lab, presentation,
											     transport, restaurant);
		
		if (Debug.DEBUG_VALUE > 2) System.out.println(activities.toString());
		if (Debug.DEBUG_VALUE > 3) {
			System.out.println(card.toString()         );
			System.out.println(lab.toString()          );
			System.out.println(presentation.toString() );
			System.out.println(transport.toString()    );
			System.out.println(restaurant.toString()   );
		}
		
		buConf.setupSchedule(activities);
		buConf.printSchedule();

		buConf.clearSchedule();// in real life, 
		                       // would be sent to web browser,
		                       // or stored in a database

//===================================================================
//			ATTENDEE #2	
//===================================================================		
		currency = "Dollars"; 	// This simulates data passed in
								// by a web-based registration form. 
								// (Would be enum for typesafeness.)
						        // Other units (CarbonFootPrint 
								// units, and Time units) would be 
								// handled similarly. This value is
						        // eventually passed to a factory
								// method to create the Cost object.
		
		buConf.setCurrency(currency);
		// choose different activities
		card = new Amex(buConf.getFee(), currency);
		presentation = new State();
		transport = new Elevators();
		lab = new EngineeringLab();
		restaurant = new No5Restaurant(currency);

		activities = new BUActivities(card, lab, presentation,
									  transport, restaurant);

		buConf.setupSchedule(activities);
		buConf.printSchedule();

		buConf.clearSchedule();

//===================================================================
//		ATTENDEE #3	
//===================================================================		
		
		currency = "Euros";  	// This simulates data passed in
								// by a web-based registration form. 
								// (Would be enum for typesafeness.)
						        // Other units (CarbonFootPrint 
								// units, and Time units) would be 
								// handled similarly. This value is
						        // eventually passed to a factory
								// method to create the Cost object.
		buConf.setCurrency(currency);
		
		card = new MasterCard(buConf.getFee(), currency);
		presentation = new Observer();
		transport = new Walking();
		lab = new AcademicAPod();
		restaurant = new LemongrassRestaurant(currency);

		activities = new BUActivities(card, lab, presentation,
									  transport, restaurant);
		
		
		

		buConf.setupSchedule(activities);
		buConf.printSchedule();

		
//===================================================================
//							FREE UP MEMORY
//===================================================================
				
		card = null;
		presentation = null;
		transport = null;
		lab = null;
		restaurant = null;
		buConf = null;
	}

    /**
     *  toString 
     */
	///////////Unnecessary: this is the driver. 
}