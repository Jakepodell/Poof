import java.awt.*;

public class Grassfro extends Structure
{
	public Grassfro (int x, int y, Image i, Dimension d)
	{
		super(x, y, i, d);
	}

	public void draw (Graphics2D g)
	{
		g.drawImage(i, x, y, (int) d.getWidth(), (int) d.getHeight(), null);
	}

	public void explode ()
	{
	}
}
