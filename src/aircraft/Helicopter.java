package aircraft;

class Helicopter extends Aircraft
{
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
			System.out.printf("Helicopter#%s(%d): It's sunny.\n", this.name, this.id);
		}
		else if (weather.equals("RAIN"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
			System.out.printf("Helicopter#%s(%d): It's raining.\n", this.name, this.id);
		}
		else if (weather.equals("FOG"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
			System.out.printf("Helicopter#%s(%d): It's foggy.\n", this.name, this.id);
		}
		else if (weather.equals("SNOW"))
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
			System.out.printf("Helicopter#%s(%d): It's snowing.\n", this.name, this.id);
			if (this.coordinates.getHeight() <= 0)
			{
				System.out.printf("Helicopter#%s(%d): Landing due to low altitude.\n", this.name, this.id);
				this.weatherTower.unregister(this);
			}
		}
	}
}
