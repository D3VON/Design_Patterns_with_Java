public abstract class ManualFactory
{
	public final Manual writeManual(String manualType)
	{
		Manual manual;
		manual = createManual(manualType);
		manual.setPageNumbers();
		manual.setTableOfContents();
		manual.setFigures();
		manual.setIndex();
		return manual;
	}
	
	abstract Manual createManual(String manualType);
}

public class KeyboardManualFactory extends ManualFactory
{
	Manual createManual(String manualType)
	{
		// do stuff
	}
}

public class MouseManualFactory extends ManualFactory
{
	Manual createManual(String manualType)
	{
		// do stuff
	}
}

public static void main(String args[])
{
	ArrayList<Component> components = new ArrayList<Component>();
	
	ManualFactory keyboardManualFactory = new KeyboardManualFactory("keyboardFactory");
	Component keyboard = keyboardManualFactory.createManual("Logitech");
	components.add(keyboard);
	
	ManualFactory mouseManualFactory = new MouseManualFactory("mouseFactory");
	Component mouse = keyboardManualFactory.createManual("Microsoft");
	components.add(mouse);
	
	Manual theWholeManual = new Manual();
	
	for(Component comp : components)
	{
		theWholeManual.add(comp.writeManual);
	}
}