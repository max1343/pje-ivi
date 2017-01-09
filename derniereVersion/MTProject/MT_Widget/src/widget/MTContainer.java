package widget;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import mygeom.Point2;
import mygeom.Vector2;

public class MTContainer extends MTComponent {
	private ArrayList<MTComponent> components;

	public MTContainer(){
		components = new ArrayList<MTComponent>();
	}
	
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		AffineTransform save=g.getTransform(); 	
		for (MTComponent c : components){
			g.translate(c.obb.getOrigine().getX(),c.obb.getOrigine().getY());
			g.rotate(c.obb.getAngle());
			c.draw(g);
			g.setTransform(save);
		}
	}
	
	public void add(MTComponent comp) {
		// TODO Auto-generated method stub
		components.add(comp);
	}

	public MTComponent whichIs(Point2 p){
		for (MTComponent c : components){
			if (c.isInside(p))
				return c;
		}
		//le point p n'est dans aucun composant
		return null;
	}

	public MTComponent whichIs(Vector2 p){
		for (MTComponent c: components){
			if(c.isInside(p))
				return c;
		}
		return null;	
	}
	
	
	
	
}
