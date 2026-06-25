public class avaj
{
	public static void main(String[] args)
	{

	}
}

class WeatherTower
{
	public string getWeather(Coordinates p_coordinates)
	{

	}
	public void changeWeather()
	{

	}
}

class Tower
{
	private List<Flyable*> observers;
	public void register(Flyable* p_flyable)
	{

	}
	public void unregister(Flyable* p_flyable)
	{

	}
	protected void conditionsChanged()
	{

	}
}

abstract class Flyable
{
	public abstract void updateConditions();
	public void registerTower(WeatherTower* p_tower);
}

