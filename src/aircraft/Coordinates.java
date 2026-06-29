package aircraft;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int p_longitude, int p_latitude, int p_height) // Constructor but fancy. Its called Package-Private Constructor. It is only accessible within the same package.
	{

	}
	public int getLongitude()
	{
		return longitude;
	}
	public int getLatitude()
	{
		return latitude;
	}
	public int getHeight()
	{
		return height;
	}
}
