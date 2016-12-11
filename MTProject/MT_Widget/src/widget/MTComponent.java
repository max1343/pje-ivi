package widget;

import java.awt.Graphics2D;

import javax.swing.JComponent;

import mygeom.Point2;

public abstract class MTComponent extends JComponent{
	protected Point2 taille;
	protected Point2 pos;
	
	public MTComponent(){
		taille = new Point2();
		pos = new Point2();
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
}
