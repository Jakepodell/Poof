import java.awt.*;

public class Grassfro extends Structure
{
	boolean exploded = false;
	
	public Grassfro (int x, int y, Image i, Dimension d)
	{
		super(x, y, i, d);
	}

	public void draw (Graphics2D g)
	{
		if (exploded == false)
			g.drawImage(i, x, y, (int) d.getWidth(), (int) d.getHeight(), null);
	}

	public void explode ()
	{
		exploded = true;
		x = 0;
		y = 0;
		i = null;
		d = null;
	}
}
