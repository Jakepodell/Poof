
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;

import javax.swing.JApplet;

public class Alpaca implements MouseMotionListener{
	
	private int power;
	private double theta;
	private int ammo;
	private Image i;
	private Image mouth;
	private Point mousePoint;
	
	public Alpaca(int ammoAmount, String s, String mouthS, JApplet parent){
		i = Toolkit.getDefaultToolkit().getImage(s);
		mouth = Toolkit.getDefaultToolkit().getImage(mouthS);
		ammo=ammoAmount;
		mousePoint = new Point(0,0);
		parent.addMouseMotionListener(this);
	}
	
	public void draw(Graphics2D g){
		calcTheta();
		AffineTransform transform = new AffineTransform();
		AffineTransform old = g.getTransform();
		transform.rotate(theta, MOUTHLOC.getX(), MOUTHLOC.getY());
		g.transform(transform);
		g.drawImage(mouth,MOUTHLOC.x,MOUTHLOC.y,null); 
		g.transform(old);
		g.drawImage(i,ARILOC.x,ARILOC.y,null);
	}
	public void drawArrow(Graphics2D g){
		
	}
	public void rorateMouth(){
		  
	}
	public void fluctuatePower(){
		  
	}
	public Ammo launch(){
		  return(new Ammo());
	}
	  
	public static final Point ARILOC = new Point(50,200);
	public static final int HEIGHT = 300;
	public static final int WIDTH = 100;
	public static final Point MOUTHLOC = new Point(ARILOC.x+100,ARILOC.y+125);

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePoint = e.getPoint();
		
	}
	public Point getMouseLoc(){
		return mousePoint;
	}
	private void calcTheta(){
		double x =  mousePoint.getX()-MOUTHLOC.getX();
		double y =  mousePoint.getY()-MOUTHLOC.getY();
		double angle = Math.atan(y/x);
		theta= angle;
	}
}
