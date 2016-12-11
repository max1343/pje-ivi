package mygeom;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Path {
	private ArrayList<Point2> points;
	
	
	public Path(){
		points = new ArrayList<Point2>();
	}
	
	public void add(Point2 p){
		points.add(p);
		//afficherListe();
	}
	
	public void clear(){
		points.clear();
	}
	
	public void afficherListe(){
		for(Point2 p : points){
			System.out.println("Point: " + p.getX() +":"+ p.getY());
		}
	}
	
	public void draw(Graphics2D g2){
		if(points.size() > 0){
			GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, points.size());
			polyline.moveTo (points.get(0).getX(), points.get(0).getY());
			System.out.println("X: "+ points.get(0).getX()+ "Y: "+ points.get(0).getY());
			for(int i=0; i < points.size()-1; i++){
				 polyline.lineTo(points.get(i).getX(), points.get(i).getY());
			}
			g2.draw(polyline);
			
			//à faire: dessiner l'isobarycentre
		}
	}
	
	public Tuple2 getIsobarycentre(){
		double x = 0.00, y = 0.00;
		for(Point2 p: points){
			x += p.getX();
			y += p.getY();
		}
		return new Tuple2(x/points.size(), y/points.size());
	}
}