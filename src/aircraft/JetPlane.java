package aircraft;

class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
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
				newLatitude += 10;
				newHeight += 2;
				System.out.printf("%s: Full throttle under the beautiful clear sky.\n", this);
				break;
			case "RAIN":
				newLatitude += 5;
				System.out.printf("%s: It's raining. Better watch out for lightings.\n", this);
				break;
			case "FOG":
				newLatitude += 1;
				System.out.printf("%s: Foggy conditions, visibility is low.\n", this);
				break;
			case "SNOW":
				newHeight -= 7;
				System.out.printf("%s: OMG! Winter is coming!\n", this);
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

