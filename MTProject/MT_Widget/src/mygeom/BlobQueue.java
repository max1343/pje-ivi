package mygeom;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class BlobQueue {
	HashMap<Integer,Path> cursor; 
	
	public BlobQueue() {
		cursor=new HashMap<Integer,Path>(); 
	}
	
	public void addCursor(int idCursor, Path p){
		cursor.put(idCursor, p);
	}
	
	public void removeCursor(int idCursor){
		cursor.remove(idCursor);
	}
	
	public void updateCursor(int idCursor, Path p){
		cursor.replace(idCursor, p);
	}
	
	public void draw(Graphics2D g2){
		for (Map.Entry<Integer,Path> e : cursor.entrySet()) {
			e.getValue().draw(g2);
		}
	}
}