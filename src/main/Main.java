package main;

import java.util.List;

import simulation.Flyable;
import weather.WeatherTower;
import exception.InvalidScenarioException;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Error: Invalid number of arguments. Usage: java -cp bin Main <scenario_file>");
			return;
		}
		try
		{
			Parser parser = new Parser(args[0]);
			int simulationCycles = parser.getSimulationCycles();
			List<Flyable> aircraftList = parser.getAircraftList();
			WeatherTower weatherTower = new WeatherTower();

			for (Flyable aircraft : aircraftList)
				aircraft.registerTower(weatherTower);

			for (int i = 0; i < simulationCycles; i++)
				weatherTower.changeWeather();
		}
		catch (InvalidScenarioException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println("An unexpected error occurred: " + e.getMessage());
		}
	}
}
