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
	public abstract void updateConditions()
	{
		// No body needed for abstract method
	}
	public void registerTower(WeatherTower* p_tower);
	{

	}
}

class Aircraft 
{
	protected long id;
	protected string name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, string p_name, Coordinates p_coordinate)
	{

	}
}

class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) // Constructor but fancy. Its called Package-Private Constructor. It is only accessible within the same package.
	{

	}
	public int getLongitude()
	{

	}
	public int getLatitude()
	{

	}
	public int getHeight()
	{

	}
}

class Helicopter extends Aircraft
{
	public Helicopter(long p_id, string p_name, Coordinates p_coordinate)
	{

	}
	public void updateConditions()
	{

	}
}

class JetPlane extends Aircraft
{
	public JetPlane(long p_id, string p_name, Coordinates p_coordinate)
	{

	}
	public void updateConditions()
	{

	}
}

class Baloon extends Aircraft
{
	public Baloon(long p_id, string p_name, Coordinates p_coordinate)
	{

	}
	public void updateConditions()
	{

	}
}
