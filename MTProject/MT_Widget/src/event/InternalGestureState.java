package event;

import widget.MTComponent;
import mygeom.OBB;
import mygeom.Vector2;

public class InternalGestureState {
	// position d'une OBB
	OBB oldOBB,currentOBB;

	// états du curseur pour la translation simple
	Vector2 oldPos, currentPos;

	/*public InternalGestureState(MTComponent c) {
		// le currentOBB sera une référence sur l'OBB de c
		// donc : lorsque currentOBB est modifié, cela modifie l'OBB de c (pas de new pour currentOBB !!!!!)
	    oldPos=new Vector2(); // pour mémoriser la position précédente du curseur
	    currentPos=new Vector2();
	    oldOBB = new OBB(); // pour mémoriser la position précédente, si besoin
	    currentOBB = c.obb(); // référence sur l'obb du composant

	  }
*/
}