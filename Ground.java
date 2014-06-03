import java.awt.Rectangle;


public class Ground extends Rectangle {
	public Ground(int x, int y, int width, int height){
		super(x,y,width,height);
	}
	
	public static Ground getGround(){
		return new Ground(10,550,1300,75);
	}
}
