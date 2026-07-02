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
				this.conditionMessage("SUN", this);
				break;
			case "RAIN":
				newHeight -= 5;
				this.conditionMessage("RAIN", this);
				break;
			case "FOG":
				newHeight -= 3;
				this.conditionMessage("FOG", this);
				break;
			case "SNOW":
				newHeight -= 15;
				this.conditionMessage("SNOW", this);
				break;
		}

		this.coordinates = new Coordinates(newLongitude, newLatitude, newHeight);

		if (this.coordinates.getHeight() <= 0)
		{
			this.conditionMessage("LANDING", this);
			this.weatherTower.unregister(this);
		}
	}
}
