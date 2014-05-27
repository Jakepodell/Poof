import java.awt.*;

public abstract class Structure
{
  int x, y;
  Image i;
  Dimension d;

  public Structure (int px, int py, Image pi, Dimension pd) //p for parameter
  {
	  x = px;
	  y = py;
	  i = pi;
	  d = pd;
  }

  public abstract void draw (Graphics2D g);

  public abstract void explode ();
}
