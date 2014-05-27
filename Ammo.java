import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.imageio.ImageIO;
import java.io.*;

public class Ammo
{
	BufferedImage theImage;
	public static final int XSIZE = 20;
	public static final int YSIZE = 20;
	int xVelocity, yVelocity;
	Point theLocation;
	public Ammo()
	{
		try
		{
			theImage = ImageIO.read(new File("////.jpg"));
		}
		catch(IOException e){}
		theLocation = new Point(50,50);
		xVelocity = 0;
		yVelocity = 0;

	}
	public void draw(Graphics2D g)
	{
		g.drawImage(theImage, (int)theLocation.getX(), (int)theLocation.getY(), XSIZE, YSIZE, null);
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
