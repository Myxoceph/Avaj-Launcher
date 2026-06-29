package aircraft;
import simulation.Flyable;

public class AircraftFactory
{
	private static AircraftFactory aircraftFactory = new AircraftFactory();

	Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{

	}
	public static AircraftFactory getFactory() // not implemented in UML diagram but needed to get the aircraftFactory instance
	{
		return aircraftFactory;
	}
}
