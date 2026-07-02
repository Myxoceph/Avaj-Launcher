package utils;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aircraft.AircraftFactory;
import simulation.Flyable;
import aircraft.Coordinates;
import exception.InvalidScenarioException;

public class Parser
{
	private String scenarioFile;
	private int simulationCycles;
	private List<Flyable> aircraftList = new ArrayList<>();

	public Parser(String scenarioFile)
	{
		this.scenarioFile = scenarioFile;
		checkFile();
	}

	public int getSimulationCycles()
	{
		return simulationCycles;
	}

	public List<Flyable> getAircraftList()
	{
		return aircraftList;
	}

	private void checkFile()
	{
		if (this.scenarioFile == null || this.scenarioFile.isEmpty())
			throw new InvalidScenarioException("Scenario file path is null or empty.");

		File file = new File(this.scenarioFile);
		if (!file.exists() || !file.isFile())
			throw new InvalidScenarioException("Scenario file does not exist or is not a valid file.");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(this.scenarioFile)))
		{
			String line;
			line = reader.readLine();
			if (line == null || line.trim().isEmpty() || !line.trim().matches("\\d+"))
				throw new InvalidScenarioException("First line of scenario file must be a positive integer representing the number of simulation cycles.");
			try
			{
				simulationCycles = Integer.parseInt(line.trim());
			}
			catch (NumberFormatException e)
			{
				throw new InvalidScenarioException("Simulation cycles count is too large.");
			}
			if (simulationCycles <= 0 || simulationCycles > 1000)
				throw new InvalidScenarioException("Number of simulation cycles must be a positive integer less than or equal to 1000.");
			while ((line = reader.readLine()) != null)
			{
				line = line.trim();
				if (line.isEmpty())
					throw new InvalidScenarioException("Empty line found in scenario file.");
				String[] parts = line.split("\\s+");
				if (parts.length != 5)
					throw new InvalidScenarioException("Invalid aircraft description: " + line);
				String type = parts[0];
				if (!type.equals("Balloon") && !type.equals("JetPlane") && !type.equals("Helicopter"))
					throw new InvalidScenarioException("Invalid aircraft type: " + type);
				String name = parts[1];
				int longitude, latitude, height;
				try
				{
					longitude = Integer.parseInt(parts[2]);
					latitude = Integer.parseInt(parts[3]);
					height = Integer.parseInt(parts[4]);
					if (longitude < 0 || latitude < 0 || height < 0)
						throw new InvalidScenarioException("Coordinates must be non-negative integers in line: " + line);
					if (height > 100)
						height = 100; 
					parse(type, name, longitude, latitude, height);
				}
				catch (NumberFormatException e)
				{
					throw new InvalidScenarioException("Invalid coordinate values in line: " + line);
				}
			}
		}
		catch (IOException e)
		{
			throw new InvalidScenarioException("Error reading scenario file: " + e.getMessage());
		}

	}

	public void parse(String type, String name, int longitude, int latitude, int height)
	{
		Coordinates coordinates = Coordinates.create(longitude, latitude, height);
		Flyable aircraft = AircraftFactory.getAircraftFactory().newAircraft(type, name, coordinates);
		if (aircraft == null)
			throw new InvalidScenarioException("Failed to create aircraft of type: " + type);
		aircraftList.add(aircraft);
	}

}
