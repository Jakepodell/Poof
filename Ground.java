import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Ground extends Rectangle {
	public Ground(int x, int y, int width, int height)
	{
		super(x,y,width,height);
	}
/*	public static Ground getGround(){
//		return new Ground(10,550,1300,75);
	}*/
	public void draw(Graphics2D g)
	{
		g.drawRect(this);
	}
}
