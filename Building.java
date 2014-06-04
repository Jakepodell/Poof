import java.awt.*;


public class Building extends Structure
{
	public Building(int x, int y, String imageName, Dimension d)
	{
		super(x, y, imageName, d);
	}
	public void explode ()
	{

	}

	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}

	public Rectangle getRect()
	{
		return (new Rectangle (x, y, (int) d.getWidth(), (int) d.getHeight()));
	}
	public void draw (Graphics2D g)
	{
		g.drawImage(i, x, y, (int) d.getWidth(), (int) d.getHeight(), null);
	}
}
