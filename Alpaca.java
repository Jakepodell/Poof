package poof;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class Alpaca{
	
	private int power;
	private int theta;
	private int ammo;
	private Image i;
	private Image mouth;
	
	public Alpaca(int ammoAmount, String s, String mouthS){
		i = Toolkit.getDefaultToolkit().getImage(s);
		mouth = Toolkit.getDefaultToolkit().getImage(mouthS);
		ammo=ammoAmount;
	}
	
	public void draw(Graphics2D g){
		  g.drawImage(i,ARILOC.x,ARILOC.y,null);
		  g.drawImage(mouth,MOUTHLOC.x,MOUTHLOC.y,null);
		  
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
	public static final Point MOUTHLOC = new Point(ARILOC.x+WIDTH/2,ARILOC.y+HEIGHT/2);
}
