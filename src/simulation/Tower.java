package simulation;
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
			System.out.printf("Tower says: %s registered to weather tower.\n", p_flyable.toString());
		}
		else
			System.out.printf("Tower says: %s is already registered to weather tower.\n", p_flyable.toString());
	}
	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
		System.out.printf("Tower says: %s unregistered from weather tower.\n", p_flyable.toString());
	}
	protected void conditionChanged()
	{
		List<Flyable> observersCopy = new ArrayList<>(observers);
		for (Flyable flyable : observersCopy)
			flyable.updateConditions();
	}
}
