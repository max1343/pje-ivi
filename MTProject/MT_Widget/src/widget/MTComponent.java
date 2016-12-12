package widget;

import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.event.EventListenerList;

import event.DiscreteEvent;
import event.DiscreteEventListener;
import event.SRTEvent;
import event.SRTEventListener;
import mygeom.OBB;
import mygeom.Point2;
import mygeom.Vector2;

public abstract class MTComponent extends JComponent{
	protected Point2 taille;
	protected Point2 pos;
	protected  EventListenerList listenerList;
	protected DiscreteEvent disEvent;
	protected SRTEvent srtEvent;
	protected OBB obb;
	
	public MTComponent(){
		taille = new Point2();
		pos = new Point2();
		listenerList = new EventListenerList();
	}
	
	public void setPosition(double angle, Vector2 origine, double h, double w){
		obb.setAngle(angle);
		obb.setOrigine(origine);
		obb.setHeight(h);
		obb.setWidth(w);
	}
	
	public void addSTEventListener(SRTEventListener srtl){
		listenerList.add(SRTEventListener.class, srtl);
	}
	
	public void addDiscreteEventListener(DiscreteEventListener disl){
		listenerList.add(DiscreteEventListener.class, disl);
	}
	
	 protected void fireDiscretePerformed() {
	     // Guaranteed to return a non-null array
	     Object[] listeners = listenerList.getListenerList();
	     // Process the listeners last to first, notifying
	     // those that are interested in this event
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==DiscreteEventListener.class) {
	             // Lazily create the event:
	             if (disEvent == null)
	                 disEvent = new DiscreteEvent(this);
	             ((DiscreteEventListener)listeners[i+1]).gesturePerformed(disEvent);
	         }
	     }
	 }
	 
	 protected void fireSRTPerformed() {
	     // Guaranteed to return a non-null array
	     Object[] listeners = listenerList.getListenerList();
	     // Process the listeners last to first, notifying
	     // those that are interested in this event
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==SRTEventListener.class) {
	             // Lazily create the event:
	             if (srtEvent == null)
	                 srtEvent = new SRTEvent(this);
	             ((SRTEventListener)listeners[i+1]).gesturePerformed(srtEvent);
	         }
	     }
	 }
	 
	public void draw(Graphics2D g) {
		
	}



	public Point2 getTaille() {
		return taille;
	}



	public void setTaille(Point2 taille) {
		this.taille = taille;
	}



	public Point2 getPos() {
		return pos;
	}

	public void setPos(Point2 pos) {
		this.pos = pos;
	}

	public boolean isInside(Point2 p){
		if( p.getX() < (pos.getX() + taille.getX()) && p.getX() > pos.getX()){
			if( p.getY() < (pos.getY() + taille.getY()) && p.getY() > pos.getY()){
				return true;
			}
		}
		return false;
	}

	public boolean isInside(Vector2 p){
		if( p.getX() < (obb.getOrigine().getX() +  taille.getX()) && p.getX() > obb.getOrigine().getX()){
			if( p.getY() < (obb.getOrigine().getY() + taille.getY()) && p.getY() > obb.getOrigine().getY()){
				return true;
			}
		}
		return false;
	}
	
	public void updatePosition(Vector2 t,double angle,double k){ 
		obb.setHeight(k*obb.getHeight());
		obb.setWidth(k*obb.getWidth());
		obb.setAngle(angle+obb.getAngle());
		double x = obb.getOrigine().getX() + t.getX();
		double y = obb.getOrigine().getX() + t.getY();
		Vector2 v = new Vector2(x,y);
		obb.setOrigine(v);
	}
}
