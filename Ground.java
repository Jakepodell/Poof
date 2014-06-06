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
			theGrounds.add(new Rectangle(0,800,500,200));
			theGrounds.add(new Rectangle(600,800,200,200));
		}
		if (levelNumber == 2)
		{
			theGrounds.add(new Rectangle(0,800,100,200));
			theGrounds.add(new Rectangle(100,800,100,100));
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
