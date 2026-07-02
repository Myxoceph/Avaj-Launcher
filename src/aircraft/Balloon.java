package aircraft;

class Balloon extends Aircraft
{
	public Balloon(long p_id, String p_name, Coordinates p_coordinate)
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
				newLongitude += 2;
				newHeight += 4;
				System.out.printf("%s: Let's enjoy the good weather and take some pics.\n", this);
				break;
			case "RAIN":
				newHeight -= 5;
				System.out.printf("%s: Damn you rain! You messed up my balloon.\n", this);
				break;
			case "FOG":
				newHeight -= 3;
				System.out.printf("%s: Fog everywhere, we are drifting blindly.\n", this);
				break;
			case "SNOW":
				newHeight -= 15;
				System.out.printf("%s: It's snowing. We're gonna crash.\n", this);
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

