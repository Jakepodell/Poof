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
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	int xVelocity, yVelocity;
	private int x;
	private int y;
	Point theLocation;
	private final double COEFFICIENT_OF_FRICTION = 0.4;
	private boolean bouncing; //determines if the move method still needs to be called
	public Ammo(int xVel, int yVel)
	{
		try
		{
			theImage = ImageIO.read(new File("Pellet.png"));
		}
		catch(IOException e){}
		theLocation = new Point(50,50);
		x = (int) Alpaca.MOUTHLOC.getX();
		y = (int) Alpaca.MOUTHLOC.getY();
		theLocation = new Point(x,y);
		xVelocity=xVel;
		yVelocity=yVel;
		bouncing=true;

	}
	public void draw(Graphics2D g)
	{
		g.drawImage(theImage, x, y, null);
		move();
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Rectangle getRect()
	{
		return (new Rectangle (x, y, WIDTH, HEIGHT));
	}
	public void checkCollision(Ground g){
		if(y+HEIGHT>=g.getY()){
			y=(int) g.getY()-HEIGHT;
			if(bouncing){
				yVelocity-=10;
				yVelocity=-yVelocity;
				if(Math.abs(yVelocity)<=10){
					yVelocity=0;
					bouncing =false;
					System.out.println("died");
				}
			}
			xVelocity*=COEFFICIENT_OF_FRICTION;
			if(Math.abs(xVelocity)<1)xVelocity=0;
		}
	}
	public void checkCollision(Building b){
		if(getRect().intersects(b.getRect()))
		{
			if(bouncing){
				xVelocity*=(COEFFICIENT_OF_FRICTION / 1.5);
				xVelocity=-xVelocity;
				x=b.getX()-WIDTH;
			}
		}
	}

	public boolean isDead(){
		return(xVelocity==0&&yVelocity==0);
	}
	public void launch(int xVel, int yVel)
	{
		xVelocity = xVel;
		yVelocity = yVel;
	}
	public void move()
	{
		if(bouncing){
			yVelocity += 5;
			y+=yVelocity;
		}
		x+=xVelocity;

	}
	public Point getLocation()
	{
		return theLocation;
	}
	public void explode()
	{
		Rectangle ammorect = new Rectangle((int)theLocation.getX() - 25, (int)theLocation.getY() - 25, 50,50);
	/*	ArrayList<Grassfro> grassfros = level.getGrassfro(); //Gets all grassfros in level
		for (Grassfro grass : grassfros)
		{
			if (ammorect.intersects(grass.getRect()))
			{
				grass.explode();
			}
		}*/
	}

}
