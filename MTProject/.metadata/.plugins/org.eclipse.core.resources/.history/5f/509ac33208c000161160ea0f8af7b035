package widget;

import java.awt.Component;
import java.awt.Graphics2D;
import java.util.ArrayList;

import mygeom.Point2;

public class MTContainer extends MTComponent {
	private ArrayList<MTComponent> components;

	public MTContainer(){
		components = new ArrayList<MTComponent>();
	}
	
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		for (MTComponent c : components){
			c.draw(g);
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

}
