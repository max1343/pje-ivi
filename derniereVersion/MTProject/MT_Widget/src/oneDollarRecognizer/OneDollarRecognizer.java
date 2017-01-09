package oneDollarRecognizer;

import java.util.ArrayList;
import java.util.Vector;

import mygeom.Point2;
import mygeom.Tuple2;
import widget.MTComponent;

public class OneDollarRecognizer {

	public Point2 resample(ArrayList<Point2> points, int n){
		double i, d, D;
		
		i=path_length(points)/(n-1);
		D=0;
		Point2 temp = new Point2();
		Point2 newPoints;
		newPoints = (points.get(0));
		for (Point2 p : points){
			for (int j=1; j<=points.size();j++){
				d = distance(points.get(j-1),points.get(j));
				if((D+d)>i){
					temp.setX(points.get(j-1).getX() + ((i-D)/d)*(points.get(j-1).getX()-points.get(j).getX()));
					temp.setY(points.get(j-1).getY() + ((i-D)/d)*(points.get(j-1).getY()-points.get(j).getY()));
					//newPoints.append((new Point2(temp));
					newPoints.set(temp.getX(), temp.getY()); 
					points.add(j, temp);
					D = 0;
				}else{
					D += d;
				}
			}
		}
		
		return newPoints;
	}
	
	public double distance(Point2 p1, Point2 p2){
		return Math.sqrt(Math.pow((p2.getX()-p1.getX()),2) + Math.pow((p2.getY()-p1.getY()),2));
		
	}
	
	public double path_length(ArrayList<Point2> A){
		double dist;
		dist = 0;
		for(int i = 1; i<A.size(); i++){
			dist = dist + distance(A.get(i-1),A.get(i));
		}		
		return dist;
	}	
	
	
	public Vector<Tuple2> rotateToZero(Vector<Tuple2> points){
		Point2 c = centroid(points);
		double angle = Math.atan2(c.getY() - points.elementAt(0).getY(), c.getX() - points.elementAt(0).getX());
		Point2 newPoints=rotateBy(points, -angle);
		return newPoints;
	}
	
	
	public ArrayList<Point2> rotateBy(Vector<Tuple2> points, double angle){
		Point2 c = centroid(points);
		Point2 q = new Point2();
		ArrayList<Point2> newPoints= null;
		for(Tuple2 t : points){
			q.setX( ((t.getX()-c.getX())*Math.cos(angle)) - ((t.getY()-c.getY())*Math.sin(angle)) + c.getX());
			q.setY( ((t.getX()-c.getX())*Math.sin(angle)) + ((t.getY()-c.getY())*Math.cos(angle)) + c.getY());
			newPoints.add(q); 
		}
		return newPoints;
	}
	

	
public Point2 centroid(Vector<Tuple2> points)  {
    double centroidX = 0, centroidY = 0;

        for(Tuple2 p : points) {
            centroidX += p.getX();
            centroidY += p.getY();
        }
    return new Point2(centroidX / points.size(), centroidY / points.size());
}


	
}
