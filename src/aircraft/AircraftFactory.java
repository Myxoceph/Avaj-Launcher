package aircraft;

import simulation.Flyable;

public class AircraftFactory
{
	private static AircraftFactory aircraftFactory = new AircraftFactory();
	private static long idCounter = 0;

	private AircraftFactory()
	{
		
	}

	public static AircraftFactory getAircraftFactory()
	{
		return aircraftFactory;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		long nextId = ++idCounter; 

		return switch (p_type.toLowerCase()) {
			case "helicopter" -> new Helicopter(nextId, p_name, p_coordinates);
			case "jetplane" -> new JetPlane(nextId, p_name, p_coordinates);
			case "balloon" -> new Balloon(nextId, p_name, p_coordinates);
			default -> throw new IllegalArgumentException("Invalid aircraft type: " + p_type);
		};
	}
}
