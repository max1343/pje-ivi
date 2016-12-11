package event;

import java.util.HashMap;
import java.util.Iterator;

import mygeom.Point2;
import widget.MTComponent;

public class ComponentMap {
	HashMap<MTComponent, BlobQueue> CMap;
	
	public ComponentMap(){
		this.CMap = new HashMap<MTComponent, BlobQueue>();
	}
	
	public void addBlob(MTComponent component, int id, Point2 p){
		CMap.put(component, new BlobQueue(id, p));
	}
	
	public void updateBlob(int id, Point2 p){
		BlobQueue bq;
		for(MTComponent mtc : CMap.keySet()){
			bq = CMap.get(mtc);
			if(bq.checkId(id)){
				CMap.get(mtc).updateBlob(id, p);
				break;
			}
		}
	}
	
	
	public void removeBlob(int id, Point2 p){
		BlobQueue bq;
		for(MTComponent mtc : CMap.keySet()){
			bq = CMap.get(mtc);
			if(bq.checkId(id)){
				CMap.get(mtc).removeBlob(id, p);
				break;
			}
		}
	}
	
	
}
