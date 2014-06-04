import java.awt.*;
import java.awt.Toolkit;

public abstract class Structure
{
  int x, y;
  Image i;
  Dimension d;

  public Structure (int px, int py, String imageName, Dimension pd) //p for parameter
  {
	  x = px;
	  y = py;
	  i = Toolkit.getDefaultToolkit().getImage(imageName);
	  d = pd;
  }

  public abstract void draw (Graphics2D g);

  public abstract void explode ();
}
