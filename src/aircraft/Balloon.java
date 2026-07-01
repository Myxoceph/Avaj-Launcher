package aircraft;

class Balloon extends Aircraft
{
	public Balloon(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}
	public void updateConditions()
	{
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN"))
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
			this.coordinates.setHeight(this.coordinates.getHeight() + 4);
			System.out.printf("Balloon#%s(%d): It's sunny.\n", this.name, this.id);
		}
		else if (weather.equals("RAIN"))
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 5);
			System.out.printf("Balloon#%s(%d): It's raining.\n", this.name, this.id);
		}
		else if (weather.equals("FOG"))
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 3);
			System.out.printf("Balloon#%s(%d): It's foggy.\n", this.name, this.id);
		}
		else if (weather.equals("SNOW"))
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 15);
			System.out.printf("Balloon#%s(%d): It's snowing.\n", this.name, this.id);
			if (this.coordinates.getHeight() <= 0)
			{
				System.out.printf("Balloon#%s(%d): Landing due to low altitude.\n", this.name, this.id);
				this.weatherTower.unregister(this);
			}
		}
	}
}
