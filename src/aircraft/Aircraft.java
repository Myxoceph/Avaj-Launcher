package aircraft;

import simulation.Flyable;
import utils.Colors;

abstract class Aircraft extends Flyable
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	public void conditionMessage(String weather, Aircraft aircraft)
	{
		switch(weather)
		{
			case "SUN":
				System.out.printf(Colors.YELLOW + "%s: Damn you Arabia Fats and your Stand, The Sun! This intense heat is blinding, but at least we can track their position!\n" + Colors.RESET, aircraft);
				break;
			case "RAIN":
				System.out.printf(Colors.BLUE + "%s: Out of my way, Weather Report! This heavy downpour is destroying our altitude!\n" + Colors.RESET, aircraft);
				break;
			case "FOG":
				System.out.printf(Colors.GRAY + "%s: Curse you Enya and your Justice! This fog is everywhere, we are drifting blindly!\n" + Colors.RESET, aircraft);
				break;
			case "SNOW":
				System.out.printf(Colors.CYAN + "%s: Get away from us, Ghiaccio! White Album is freezing the entire balloon!\n" + Colors.RESET, aircraft);
				break;
			case "LANDING":
				System.out.printf(Colors.PURPLE + "%s: OH MY GOD!! Joseph Joestar is piloting the " + Colors.RED + "landing?! " + Colors.PURPLE + "Brace yourselves and prepare for impact!!!\n" + Colors.RESET, aircraft);
				break;
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s#%s(%d)", this.getClass().getSimpleName(), this.name, this.id);
	}
}
