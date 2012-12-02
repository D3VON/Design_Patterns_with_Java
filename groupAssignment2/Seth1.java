// Seth's version

/*

Ah I see now.  I got a bit confused because formula changes 
from the formula to the actual value, I guess.  I made a 
different copy.  I'm not sure if you'd want to keep all the 
changes.  It is definitely not efficient because when it 
calculates the cell's value I re-trace all the dependencies, 
rather than just the one that changed.  To rectify this we'd 
have to have some way of determining which Cell in the dependency 
list corresponds to the one passed to the update method.  In mine, 
I just assumed (as I said) that we could recheck all the dependencies 
so it doesn't pass an argument, but then again Madhu will probably 
be looking for args.  I also separated the value from the formula, 
and added calculateValue which calculates the value while checking 
for cycles.  Update only has to calculateValue since the dependencies 
don't change, so no need to re-parse the formula.  

One thing I think we definitely need to include is the code to 
remove the current cell from another's observer list, when it 
stops depending on that cell. In my code, that is in the setFormula 
method before I clear the dependencies.


On Tue, Mar 8, 2011 at 10:06 PM, Chris Ellsworth <cellswo1@binghamton.edu> wrote:

Seth:


Thanks for the detailed evaluation. Good catch with the redundant 
dependency check. Maybe to allow the updates to propagate thoroughly, 
we should keep a list of dependents (in addition to dependencies), 
which could be update()'ed when one cell's update() is called? I 
think this may be what you are alluding to on line 46?


John:


I agree that a getter method is probably a good idea, plus, Madhu 
really likes getters and setters. The logic behind update() might 
have been unclear too in the first place so I think I clarified 
it a bit (see attached).


Chris


On Mar 8, 2011, at 7:22 PM, Seth F Engel wrote:

Hey Chris,
Thanks for your attempts.  I've been quite busy the last few 
days so I really appreciate your hard work :)


I think you addressed a lot of the big things he was looking 
for in the first question.  I think the main thing he wanted 
us to notice was that Cells are Observers _and_ Subjects so 
they must implement both interfaces. I also agree on cycle 
check placement within setValue.  Nice job.  


Some thoughts:
I don't think you need to check for cycles directly in the 
update method.  I think you could just call:
setValue(this.contents); 
This would cause the Observer cell to re-evaluate its dependencies 
based on the contents variable.  Even though the its contents 
variable didn't change, it should still pick up the subject's 
changes during the cycle check in setValue.  As your code now 
stands, I don't think it would even have cycles at all since 
the subject cell calls update, and update only notify's the 
first layer of observers (because it only changes the contents 
variable).  The only problem is that there would have to be 
more methods to check if the dependency is unique


I also think the cycle detection could also take place in the 
display method, but this is basically they difference between 
lazy and immediate evaluation.  There really isn't a difference, 
just pointing it out.  Maybe adding that in the comments could 
score us some extra points, lol.


For part 2, I think your design is really neat.  I didn't think 
of that immediately but it seems to me like it works perfectly.  
Really cool!


I've attached some the changes to the first question.  It was 
kind of a fast remake, so look it over and tell me if anything 
seems odd.

Regards,
Seth

*/


public interface Subject
{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

public interface Observer
{
	public void update(Cell cell);
}

public interface DisplayElement
{
	public void display();
}

public class Cell implements Subject, Observer, DisplayElement
{
	private ArrayList<Observer> observers;
	private ArrayList<Cell> dependencies;

	// some made up data structure to represent the contents of a cell
	private Formula contents;

	public Cell()
	{
		contents = new Contents(0);
		observers = new ArrayList<Observer>();
		dependencies = new ArrayList<Cell>();
	}
	
	public void setValue(Formula newValue)
	{
		dependencies.clear(); // A new formula brings new dependencies I think
		
		contents = newValue;

		// Just parsing out the dependencies from the formula, no need for cycle check yet.
		if(contents.containsDependencies())
			dependencies.add(contents.getDependencies());

		// do a cycle check here among the dependencies
		
		// Add this cell to the obersver list of the cell that it is observing, so that cell can update it.
		for( Cell c : dependencies )
		{
			c.registerObserver(this);
		}

		notifyObservers(); // each observer dependent on this cell will perform a cycle check on its dependencies
	}

	public Formula getValue()
	{
		return contents;
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
			o.update(this);
		}
	}

	public void update(Cell cell)
	{
		setValue(this.contents);
	}

	public void display()
	{
		// show the new value - can also check for cycles here for lazy evaluation
		System.out.println(contents.toValue());
	}
}
