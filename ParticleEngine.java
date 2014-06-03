import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class ParticleEngine
{

	static CopyOnWriteArrayList<Particle> particleList;
	final static int TOTAL_PARTICLES = 100;
	static Image img;
	static Random r;
	
	public ParticleEngine ()
	{
		particleList = new CopyOnWriteArrayList<Particle>();
		r = new Random();
		
		try
		{
			img = ImageIO.read(new File("banan.png"));
		}

		catch(IOException e){}
	}

	public static void explodeRandomColors (int x, int y)
	{
		for (int i = 0; i < TOTAL_PARTICLES; i++)
		{
			particleList.add(new Particle(x, y, new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256))));
		}
	}
	
	public static void explodeImage (int x, int y)
	{
		for (int i = 0; i < TOTAL_PARTICLES; i++)
		{
			particleList.add(new Particle(x, y, img));
		}
	}
	
	public static void explodeFire (int x, int y)
	{
		for (int i = 0; i < TOTAL_PARTICLES; i++)
		{
			Color assignedColor;
			int randomColor = r.nextInt(4);
			if (randomColor == 0)
				assignedColor = Color.white;
			else if (randomColor == 1)
				assignedColor = Color.yellow;
			else if (randomColor == 2)
				assignedColor = Color.orange;
			else
				assignedColor = Color.red;
			
			particleList.add(new Particle(x, y, assignedColor));
		}
	}

	public static void removeOffScreenParticles() //doesn't work
	{
		//Removes particles from the arraylist if they are off screen.
		for (Particle p : particleList)
			if (p.getX() > ParticleDriver.WIDTH || p.getX() < 0 || p.getY() > ParticleDriver.HEIGHT)
				particleList.remove(p);
		
	}
	
	public static void draw(Graphics2D g)
	{
		for (Particle p : particleList)
			p.draw(g);
	}
	
	public static CopyOnWriteArrayList<Particle> getParticleList ()
	{
		return particleList;
	}

}
