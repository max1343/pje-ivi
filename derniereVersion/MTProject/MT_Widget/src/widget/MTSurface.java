package widget;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import event.BlobQueue;
import event.ChangeSideEvent;
import event.ChangeSideEventListener;
import event.ComponentMap;
import event.DiscreteEvent;
import event.DiscreteEventListener;
import mygeom.Point2;
import tuio.MTedt;

public class MTSurface extends JPanel {
	MTedt m ;
	BlobQueue bq;
	MTContainer mtc;
	ComponentMap cm;
	protected  EventListenerList listenerList;
	protected ChangeSideEvent csEvent;

	
	public MTSurface() {
		super();
		cm = new ComponentMap();
		m = new MTedt(this);
		bq = new BlobQueue();
		mtc = new MTContainer();
		listenerList = new EventListenerList();
	}
	
	public void addChangeSideListener(ChangeSideEventListener csel){
		listenerList.add(ChangeSideEventListener.class, csel);
	}
	
	protected void fireChangeSidePerformed() {
	     // Guaranteed to return a non-null array
	     Object[] listeners = listenerList.getListenerList();
	     // Process the listeners last to first, notifying
	     // those that are interested in this event
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==ChangeSideEventListener.class) {
	             // Lazily create the event:
	             if (csEvent == null)
	                 csEvent = new ChangeSideEvent(this);
	             ((ChangeSideEventListener)listeners[i+1]).gesturePerformed(csEvent);
	         }
	     }
	 }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// drawing instructions with g2.
		bq.drawAllPath(g2);
		mtc.draw(g2);
	}

	public MTedt getMTedt(){
		return this.m;
	}
	
	public void add(MTComponent comp){
		mtc.add(comp);
	}


	public synchronized void addCursor(int id, Point2 p){
		System.out.println("id "+ id+ "coordonn�es x "+ p.getX() + "y "+ p.getY());
		p.setX(p.getX()*500);
		p.setY(p.getY()*500);
		bq.addBlob(id, p);
		repaint();
	}

	public synchronized void updateCursor(int id, Point2 p){
		System.out.println("id "+ id+ "coordonn�es x "+ p.getX() + "y "+ p.getY());
		p.setX(p.getX()*500);
		p.setY(p.getY()*500);
		bq.updateBlob(id, p);
		repaint();

	}
	
	
	public synchronized void removeCursor(int id, Point2 p){
		System.out.println("id "+ id+ "coordonn�es x "+ p.getX() + "y "+ p.getY());
		p.setX(p.getX()*500);
		p.setY(p.getY()*500);
		bq.removeBlob(id, p);
		repaint();
	}
	
}
