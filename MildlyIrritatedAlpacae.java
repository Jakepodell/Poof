
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MildlyIrritatedAlpacae extends JApplet implements ActionListener, MouseListener{
	public static final Dimension FRAMESIZE = new Dimension(800,800);
	Timer t = new Timer(100,this);
	Alpaca ari;
	CopyOnWriteArrayList<Ammo> pellets = new CopyOnWriteArrayList<Ammo>();
	Ground gr;
	ParticleEngine pe;
	public MildlyIrritatedAlpacae(){
		t.start();
		setSize(FRAMESIZE);
		setVisible(true);
		setContentPane(new drawingPanel());
		ari = new Alpaca(3,"Ari.png","Ari Alpaca Mouth.png",this);
		setSize(FRAMESIZE);
		addMouseListener(this);
		gr = Ground.getGround();
		pe = new ParticleEngine();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Particle p : ParticleEngine.getParticleList())
			p.tick();
		ParticleEngine.removeOffScreenParticles();	
		repaint();
	}
	public class drawingPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			ari.draw(g2);
			g2.drawRect((int)ari.getMouseLoc().getX(), (int)ari.getMouseLoc().getY(),10,10);
			for(Ammo a: pellets){
				a.draw(g2);
				a.checkCollision(gr);
				if(a.isDead()){
					pe.explodeFire(a.getX(),a.getY());
					pellets.remove(a);
				}
			}
			pe.draw(g2);;
			g2.setColor(Color.black);
			g2.draw(gr);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		pellets.add(ari.launch());
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
