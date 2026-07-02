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
				this.conditionMessage("SUN", this);
				break;
			case "RAIN":
				newLongitude += 5;
				this.conditionMessage("RAIN", this);
				break;
			case "FOG":
				newLongitude += 1;
				this.conditionMessage("FOG", this);
				break;
			case "SNOW":
				newHeight -= 12;
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
