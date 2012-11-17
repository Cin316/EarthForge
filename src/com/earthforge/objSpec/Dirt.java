package com.earthforge.objSpec;

import com.utilis.game.obj.*;
import java.awt.*;

import com.earthforge.code.*;
import com.earthforge.obj.*;

public class Dirt extends Block {
	
	private long timeDiff = 0L;
	private long startTime = 0L;
	
	//Image is of dirt.
	public static Image image = Execute.readImageFromCodebase("/images/Dirt.png");
	//CollisionBox is completely full.
	public static CollisionBox collide = new CollisionBox(GameConstants.tileWidth, GameConstants.tileHeight, true);
	//How long it takes to destroy Dirt.  Measured in milliseconds.
	public static long destroyTime = 400;
	
	public Dirt(int x, int y) {
		super(image, collide, x, y);
		hasAction = true;
	}


	@Override
	public void performAction() {
		if (startTime == 0L){
			startTime = System.currentTimeMillis();
		}
		long time = System.currentTimeMillis();
		timeDiff = time - startTime;
		if (timeDiff >= destroyTime){
			BlockDestroyer.destroy(this, null); //Add Dirt entity. in place of null.
		}
	}
	//Do this if destroy key is up.
	public void resetTime(){
		timeDiff = 0L;
		startTime = 0L;
	}
	
	
}
