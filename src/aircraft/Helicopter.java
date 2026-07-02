package aircraft;

class Helicopter extends Aircraft
{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		int newLongitude = this.coordinates.getLongitude();
		int newLatitude = this.coordinates.getLatitude();
		int newHeight = this.coordinates.getHeight();

		switch (weather)
		{
			case "SUN":
				newLongitude += 10;
				newHeight += 2;
				System.out.printf("%s: This is hot.\n", this);
				break;
			case "RAIN":
				newLongitude += 5;
				System.out.printf("%s: Rain is pouring down, hope the rotors don't fail!\n", this);
				break;
			case "FOG":
				newLongitude += 1;
				System.out.printf("%s: Can't see the ground, relying on instruments!\n", this);
				break;
			case "SNOW":
				newHeight -= 12;
				System.out.printf("%s: My rotor is going to freeze!\n", this);
				break;
		}

		this.coordinates = new Coordinates(newLongitude, newLatitude, newHeight);

		if (this.coordinates.getHeight() <= 0)
		{
			System.out.printf("%s landing.\n", this);
			this.weatherTower.unregister(this);
		}
	}
}

