import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.*;

public class Ground{

	ArrayList<Rectangle> theGrounds;
	Image groundImage;
	public Ground(int levelNumber, Image img)
	{
		groundImage = img;
		if (levelNumber == 1)
		{
			theGrounds.add(new Rectangle(0,600,500,100));
			theGrounds.add(new Rectangle(500,690,100,10));
			theGrounds.add(new Rectangle(600,600,400,100));

		}
		else if (levelNumber == 2)
		{
			theGrounds.add(new Rectangle(0,800,400,100));
			theGrounds.add(new Rectangle(400,850,100,50));
			theGrounds.add(new Rectangle(500,800,700,100));
			theGrounds.add(new Rectangle(1000,500,75,300));
		}
		else if (levelNumber == 3)
		{
			theGrounds.add(new Rectangle(0,800,500,100));
			theGrounds.add(new Rectangle(500,890,200,10));
			theGrounds.add(new Rectangle(700,800,900,100));
			theGrounds.add(new Rectangle(1200,400,100,400));
		}
	}
	public void draw(Graphics2D g)
	{
		for (Rectangle rect : theGrounds)
			g.drawImage(groundImage, (int)rect.getX(), (int)rect.getY(), (int) rect.getWidth(), (int)rect.getHeight(),null);
	}
	public ArrayList<Rectangle> getRectangles()
	{
		return theGrounds;
	}
}
