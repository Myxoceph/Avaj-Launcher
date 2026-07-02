package main;

import java.util.List;
import java.io.PrintStream;
import java.io.File;

import simulation.Flyable;
import utils.Parser;
import utils.Colors;
import weather.WeatherTower;
import exception.InvalidScenarioException;

public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println(Colors.RED + "Error: " + Colors.WHITE + "Invalid number of arguments. " + Colors.GREEN + "Usage: java -cp bin main.Main <scenario_file>" + Colors.RESET);
			return;
		}

		PrintStream originalOut = System.out;
		try
		{
			Parser parser = new Parser(args[0]);
			int simulationCycles = parser.getSimulationCycles();
			List<Flyable> aircraftList = parser.getAircraftList();
			WeatherTower weatherTower = new WeatherTower();

			try (PrintStream fileOut = new PrintStream(new File("simulation.txt")))
			{
				System.setOut(fileOut);

				for (Flyable aircraft : aircraftList)
					aircraft.registerTower(weatherTower);

				for (int i = 0; i < simulationCycles; i++)
					weatherTower.changeWeather();
			}
		}
		catch (InvalidScenarioException e)
		{
			System.setOut(originalOut);
			System.out.println(Colors.RED + "Error: " + Colors.WHITE + e.getMessage() + Colors.RESET);
		}
		catch (Exception e)
		{
			System.setOut(originalOut);
			System.out.println(Colors.RED + "An unexpected error occurred: " + Colors.WHITE + e.getMessage() + Colors.RESET);
		}
	}
}
