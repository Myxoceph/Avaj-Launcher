package simulation;

import utils.Colors;
import java.util.List;
import java.util.ArrayList;

public class Tower
{
	private List<Flyable> observers = new ArrayList<Flyable>();
	public void register(Flyable p_flyable)
	{
		if (!observers.contains(p_flyable))
		{
			observers.add(p_flyable);
			System.out.printf(Colors.GREEN + "Tower says: " + Colors.WHITE + "%s" + Colors.GREEN + " registered to weather tower.\n" + Colors.RESET, p_flyable.toString());
		}
		else
			System.out.printf(Colors.RED + "Tower says: " + Colors.WHITE + "%s" + Colors.RED + " is already registered to weather tower.\n" + Colors.RESET, p_flyable.toString());
	}
	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
		System.out.printf(Colors.GREEN + "Tower says: " + Colors.WHITE + "%s" + Colors.GREEN + " unregistered from weather tower.\n" + Colors.RESET, p_flyable.toString());
	}
	protected void conditionChanged()
	{
		List<Flyable> observersCopy = new ArrayList<>(observers);
		for (Flyable flyable : observersCopy)
			flyable.updateConditions();
	}
}
