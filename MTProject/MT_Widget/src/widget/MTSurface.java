package widget;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import mygeom.BlobQueue;
import mygeom.Path;
import mygeom.Point2;
import tuio.MTedt;

public class MTSurface extends JPanel {
	
	MTedt mte;
	Path path;
	BlobQueue queue;
	
	public MTSurface() {
		super();
		mte =  new MTedt(this);
		queue = new BlobQueue();
		path = new Path();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		queue.draw(g2);
	}
	
	public synchronized void addCursor(int id, Point2 p){
		System.out.print("Add:  id: " + id);
		System.out.println("coordonnées: X:" + p.getX() + " Y:" + p.getY());
		if(id == 0){
			p.setX(p.getX()*900);
			p.setY(p.getY()*900);
			path.add(p);
		}
		queue.addCursor(id, path);
		repaint();
	}
	
	public synchronized void updateCursor(int id, Point2 p){
		System.out.print("Update:  id: " + id);
		System.out.println("coordonnées: X:" + p.getX() + " Y:" + p.getY());
		if(id == 0){
			p.setX(p.getX()*900);
			p.setY(p.getY()*900);
			path.add(p);
		}
		queue.updateCursor(id, path);
		repaint();
	}

	public synchronized void removeCursor(int id, Point2 p){
		System.out.println("Remove:  id: " + id);
		System.out.println("coordonnées: X:" + p.getX() + " Y:" + p.getY());
		path.clear();
		queue.removeCursor(id);
		repaint();
	}
}
