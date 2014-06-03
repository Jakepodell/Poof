import java.util.ArrayList;
public class Level
{
	ArrayList<Grassfro> theGrassFros;
	Alpaca theAlpaca;
	ArrayList<GlassBuilding> theGlassBuildings;
	ArrayList<SoildBuilding> theSolidBuildings;
	public level(ArrayList<Grassfro> grfo, ArrayList<GlassBuilding> GlB, ArrayList<SoildBuilding> SolB, int ammoAmt, String s, String mouthS, JApplet parent)
	{
		theAlpaca = new Alpaca(ammoAmt, s, mouthS, parent);
		theGrassFros = grfo;
		theGlassBuildings = GlB;
		theSolidBuildings = SolB;
	}
	public ArrayList<Grassfro> getGrassfro()
	{
		return theGrassFros;
	}
	public void draw(Graphics2D g)
	{
		theAlpaca.draw(g);
		for (Grassfro gf : theGrassFros)
			gf.draw(g);
		for (GlassBuilding gb : theGlassBuildings)
			gb.draw(g);
		for (SoildBuilding solB : theSolidBuildings)
			solB.draw(g);
	}
}
