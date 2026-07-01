package aircraft;

class JetPlane extends Aircraft
{
	public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}
	public void updateConditions()
	{
		weather.WeatherTower weatherTower = new weather.WeatherTower();
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
			System.out.printf("JetPlane#%s(%d): It's sunny.\n", this.name, this.id);
		}
		else if (weather.equals("RAIN"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
			System.out.printf("JetPlane#%s(%d): It's raining.\n", this.name, this.id);
		}
		else if (weather.equals("FOG"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
			System.out.printf("JetPlane#%s(%d): It's foggy.\n", this.name, this.id);
		}
		else if (weather.equals("SNOW"))
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
			System.out.printf("JetPlane#%s(%d): It's snowing.\n", this.name, this.id);
		}
	}
}
