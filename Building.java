import java.awt.*;

public class Building extends Structure
{
	public Building(int x, int y, Image i, Dimension d)
	{
		super(x, y, i, d);
	}
	public void explode ()
	{
	}
	public void draw (Graphics2D g)
	{
		g.drawImage(i, x, y, (int) d.getWidth(), (int) d.getHeight(), null);
	}
}
