import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ammo
{
	BufferedImage theImage;
	public static final int XSIZE = 20;
	public static final int YSIZE = 20;
	int xVelocity, yVelocity;
	Point theLocation;
	level theLevel;
	public Ammo(level l)
	{
		try
		{
			theImage = ImageIO.read(new File("////.jpg"));
		}
		catch(IOException e){}
		theLocation = new Point(50,50);
		xVelocity = 0;
		yVelocity = 0;
		theLevel = l;

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
	public void explode()
	{
		Rectangle ammorect = new Rectangle((int)theLocation.getX() - 25, (int)theLocation.getY() - 25, 50,50);
		ArrayList<Grassfro> grassfros = theLevel.getGrassfro(); //Gets all grassfros in level
		for (Grassfro grass : grassfros)
		{
			if (ammorect.intersects(grass.getRect()))
			{
				grass.explode();
			}
		}
	}

}
