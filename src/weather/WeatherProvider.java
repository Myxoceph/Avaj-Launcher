package weather;
import aircraft.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider()
	{

	}

	public static WeatherProvider getProvider() // not implemented in UML diagram but needed to get the weatherProvider instance
	{
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates p_coordinates)
	{
		return weather[(p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4];
	}
}
