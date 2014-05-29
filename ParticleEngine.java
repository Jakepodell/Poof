import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ParticleEngine implements ActionListener
{
	static Timer t;
	static JApplet app;
	static ArrayList<Particle> particleList;
	final static int TOTAL_PARTICLES = 100;
	static Image img;
	static Random r;
	
	public ParticleEngine (JApplet pApp)
	{
		t = new Timer(30, this);
		t.addActionListener(this);
		app = pApp;
		particleList = new ArrayList<Particle>();
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
		t.start();
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
		t.start();
	}

	public void actionPerformed (ActionEvent e)
	{
		for (Particle p : particleList)
			p.tick();
		app.repaint();
	}
	
	public static void draw(Graphics2D g)
	{
		for (Particle p : particleList)
			p.draw(g);
	}

}
