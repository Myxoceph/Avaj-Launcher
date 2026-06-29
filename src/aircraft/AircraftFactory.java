package aircraft;

public class AircraftFactory
{
	private static AircraftFactory aircraftFactory = new AircraftFactory();

	Flyable newAircraft(string p_type, string p_name, Coordinates p_coordinates)
	{

	}
	public static AircraftFactory getFactory() // not implemented in UML diagram but needed to get the aircraftFactory instance
	{
		return aircraftFactory;
	}
}
