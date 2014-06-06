import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.*;

public class Ground{

	ArrayList<Rectangle> theGrounds;
	Image groundImage;
	public Ground(ArrayList<Rectangle> theRects, Image img)
	{
		theGrounds = theRects;
		groundImage = img;
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
