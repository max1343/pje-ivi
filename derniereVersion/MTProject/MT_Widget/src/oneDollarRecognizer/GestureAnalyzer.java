package oneDollarRecognizer;

import event.BlobQueue;
import mygeom.Point2;
import widget.MTComponent;

public class GestureAnalyzer {

	
	public void analyse(MTComponent mtc, BlobQueue bq, String state, String id, int p, Point2 p2){
		switch(state){
			case "add": 
				
				break;
			case "update": break;
			case "remove":
				mtc.fireGesturePerformed();
				break;
		}
	}
}
