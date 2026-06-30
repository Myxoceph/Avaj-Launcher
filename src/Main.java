public class Main
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Error: Invalid number of arguments. Usage: java -cp bin Main <scenario_file>");
			return;
		}
		try(Parser parser = new Parser(args[0]))
		{
			
		}
		catch (InvalidScenarioException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
