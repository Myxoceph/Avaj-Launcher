package weather;

import java.util.Random;

import aircraft.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider()
	{

	}

	public static WeatherProvider getProvider()
	{
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates p_coordinates)
	{
		long seed = (long) p_coordinates.getLongitude() * 31 
				+ (long) p_coordinates.getLatitude() * 17 
				+ (long) p_coordinates.getHeight() * 13;

		seed ^= (seed >>> 33);
		seed *= 0xff51afd7ed558ccdL;
		seed ^= (seed >>> 33);
		seed *= 0xc4ceb9fe1a85ec53L;
		seed ^= (seed >>> 33);

		Random random = new Random(seed);
		return weather[random.nextInt(4)];
	}
}
