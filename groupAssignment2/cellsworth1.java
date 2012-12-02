public interface Subject{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

public interface Observer{
	public void update(Cell cell);
}

public interface DisplayElement{
	public void display();
}

public class Cell implements Subject, Observer, DisplayElement{
	private ArrayList<Observer> observers;
	private ArrayList<Cell> dependencies;

	// some made up data structure to represent the contents of a cell
	private Formula contents;

	public Cell()	{
		contents = new Contents(0);
		observers = new ArrayList<Observer>();
		dependencies = new ArrayList<Cell>();
	}
	
	public void setValue(Formula newValue)	{
		contents = newValue;

		// do a cycle check here?
		if(contents.containsDependencies())
			dependencies.add(contents.getDependencies());

		notifyObservers();
	}

	public Formula getValue()	{
		return contents;
	}

	public void registerObserver(Observer o)	{
		if(!observers.contains(o))
			observers.add(o);
	}

	public void removeObserver(Observer o)	{
		observers.remove(o);
	}

	public void notifyObservers()	{
		for(Observer o: observers)
		{
			o.update(this);
		}
	}

	public void update(Cell cell)	{
		// do some kind of cycle check here
		// compute the new value
		contents = newValue;
	}

	public void display()	{
		// show the new value
		System.out.println(contents.toValue());
	}
}
