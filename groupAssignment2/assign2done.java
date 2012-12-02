// Seth Engel
// Chris Ellsworth
// Devon McBride
// John Thorsen

/******************************************************************************/
/******************************************************************************/

public interface Subject
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

/******************************************************************************/
/******************************************************************************/
public interface Observer
{
	public void update(); // No need for any arguments as each cell keeps a list of dependencies
}

/******************************************************************************/
/******************************************************************************/
public interface DisplayElement
{
	public void display();
}

/******************************************************************************/
/******************************************************************************/
public class Cell implements Subject, Observer, DisplayElement
{
	               // list of observers (cells dependent on this one)
	private ArrayList observers;

	               // list of cells **this** cell is dependent on
                  // (dependencies = subjects this sell is observing)
	private ArrayList dependencies;
	
                  /* formula is a string entered in the formula bar 
                   * 
                   * "Formula" (as a class) also has 
                   * some other methods like getDependencies() - returns 
                   * a list of dependencies (like B1 and C4)
                   */
   private Formula formula;

                  // Value is a class  that can store the "real" value 
                  // (it's the result of the formula)
   private Value value;  

   public Cell()  //<-------------CONSTRUCTOR----------------------------------
   {
      formula = new Formula();
      value = new Value(); 
      observers = new ArrayList();
      dependencies = new ArrayList();
   }
                  
   public void setFormula(String newFormula)
   {      
      // The formula is being clobbered with something new, 
      // so be a good observer, and remove this cell 
      // from other cell's observers lists
      // **************(dependencies = subjects this sell is observing)
      for( Cell c : dependencies )
      {
         c.removeObserver(this);
      }
      
      // **************(dependencies = subjects this sell is observing)
      dependencies.clear(); // Empty the list of dependencies
                                             
      formula.parseFormula(newFormula);

      // looking for dependencies in the new formula
      // **************(dependencies = subjects this sell is observing)
      if(formula.containsDependencies())
          dependencies = formula.getDependencies();
                                                            
      // Register as an observer to dependencies
      // ***************(dependencies = subjects this sell is observing)
      for( Cell c : dependencies )
      {
         c.registerObserver(this);
      }

                                                              
      /*
         CHECK FOR CYCLES   CHECK FOR CYCLES   CHECK FOR CYCLES   (SEE FUNCTION)
         CHECK FOR CYCLES   CHECK FOR CYCLES   CHECK FOR CYCLES   (SEE FUNCTION)  
      */
      calculateValue(); // This method will set the value, check for cycles, 
                        // and notify observers of the change
   }

   public Formula getFormula()
   {
         return formula;
   }
                                                                
   // This doubles as a setter for value since we will only update it 
   // directly through the formula bar or indirectly by dependencies.
   public void calculateValue()
   {
      // This method gets the values of it's dependencies and in the 
      // process checks for cycles.  Once it has these values it uses 
      // the equation from the formula string to calculate the value
      // the value member is set.
                      
     notifyObservers(); // Now that the value changed, notify cells 
                        // that depend on this one
   }
                                                                 
   public Value getValue()
   {
      return value;
   }

   public void registerObserver(Observer o)
   {
      if(!observers.contains(o))
      observers.add(o);
   }

   public void removeObserver(Observer o)
   {
      observers.remove(o);
   }

   public void notifyObservers()
   {
      for(Observer o: observers)
      {
         o.update();
      }
   }

   public void update()
   {
      calculateValue();
   }

   public void display()
   {
      // can also call calculateValue() here for a more lazy evaluation.
      System.out.println(value); // Assume value overloads toString()
   }
}









abstract class SummaryFactory
{
	// Document is a made up data structure that holds "Text"
	public final Document createSummary();
	{
		Document summary = new Document();
		summary.add(this.extractHypothesis());
		summary.add(this.extractConclusions());
		summary.add(this.extractExperiments());
		return summary;
	}

	abstract Text extractHypothesis();
	abstract Text extractExperiments();
	abstract Text extractConclusions();
}

/******************************************************************************/
class PDFSummaryFactory extends SummaryFactory
{
	// another made up data structure representing a PDF file
	private PDF file;

	public PDFSummaryFactory(PDF input)
	{
		file = input;
	}
		
	Text extractHypothesis()
	{
		// do stuff to get this section out of the PDF file
	}

	Text extractExperiments()
	{
		// do stuff to get this section out of the PDF file
	}

	Text extractConclusions()
	{
		// do stuff to get this section out of the PDF file
	}
}

/******************************************************************************/
public static void main(String args[])
{
	PDF someFile = args[0];
	SummaryFactory factory = new PDFSummaryFactory(someFile);
	Document summary = factory.createSummary();
}