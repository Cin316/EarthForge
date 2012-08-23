package com.earthforge.code;

import com.utilis.game.obj.*;
import com.earthforge.obj.*;
import com.earthforge.objSpec.Air;

public class BlockDestroyer {
	
	public static void destroy(Block b, Entity drop){
		b = new Air(b.getX(), b.getY());
		if(!(drop == null)){
			//Spawn drop.
		}
	}
	
}
