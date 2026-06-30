public class Parser
{
	private String scenarioFile;

	Parser(String scenarioFile)
	{
		this.scenarioFile = scenarioFile;
		checkFile();
	}

	private void checkFile()
	{
		if (this.scenarioFile == null || this.scenarioFile.isEmpty())
			throw new InvalidScenarioException("Scenario file path is null or empty.");

		File file = new File(this.scenarioFile);
		if (!file.exists() || !file.isFile())
			throw new InvalidScenarioException("Scenario file does not exist or is not a valid file.");
		
		
	}
}
