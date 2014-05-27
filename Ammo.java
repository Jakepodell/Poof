import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
public class Ammo
{
	BufferedImage theImage;
	int xSize,ySize, xVelocity, yVelocity;
	Point theLocation;
	public Ammo(BufferedImage im, Point loc, int xS,int yS)
	{
		theImage = im;
		theLocation = loc;
		xSize = xS;
		ySize = yS;
		xVelocity = 0;
		yVelocity = 0;

	}
	public void draw(Graphics2D g)
	{
		g.drawImage(theImage, (int)theLocation.getX(), (int)theLocation.getY(), xSize, ySize, null);
	}
	public void launch(int xVel, int yVel)
	{
		xVelocity = xVel;
		yVelocity = yVel;
	}
	public void move()
	{
		yVelocity -= 10;
		theLocation.setLocation(theLocation.getX() + xVelocity,theLocation.getY() + yVelocity);
	}
	public Point getLocation()
	{
		return theLocation;
	}

}
