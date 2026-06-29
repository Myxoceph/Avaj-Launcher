package simulation;
import weather.WeatherTower;

abstract class Flyable
{
	public abstract void updateConditions();
	public abstract void registerTower(WeatherTower p_tower);
}
