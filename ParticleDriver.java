import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParticleDriver extends JApplet implements MouseListener
{
	DrawingPanel dp;
	ParticleEngine pe;

	public void init()
	{
		setSize(500, 500);
		pe = new ParticleEngine(this);
		dp = new DrawingPanel();
		setContentPane(dp);
		addMouseListener(this);

	}

	public void mousePressed(MouseEvent e)
	{
		ParticleEngine.explodeRandomColors(e.getX(), e.getY());
	}

	public void mouseClicked(MouseEvent e) {}
 	public void mouseReleased(MouseEvent e){}
 	public void mouseEntered(MouseEvent e) {}
 	public void mouseExited(MouseEvent e) {}
 	
	public class DrawingPanel extends JPanel
	{
		public void paintComponent (Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			ParticleEngine.draw(g2);
		}
	}

}
