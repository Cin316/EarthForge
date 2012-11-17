package com.earthforge.objSpec;

import java.awt.Image;

import com.earthforge.code.BlockDestroyer;
import com.earthforge.code.Execute;
import com.earthforge.code.GameConstants;
import com.earthforge.obj.Block;
import com.utilis.game.obj.CollisionBox;

public class Grass extends Block{
	
	private long timeDiff = 0L;
	private long startTime = 0L;
	
	//Image is of grass.
	public static Image image = Execute.readImageFromCodebase("/images/Grass.png");
	//CollisionBox is completely full.
	public static CollisionBox collide = new CollisionBox(GameConstants.tileWidth, GameConstants.tileHeight, true);
	//How long it takes to destroy Grass.  Measured in milliseconds.
	public static long destroyTime = 380;
	
	public Grass(int x, int y) {
		super(image, collide, x, y);
		hasAction = true;
	}
	
	public void performAction() {
		if (startTime == 0L){
			startTime = System.currentTimeMillis();
		}
		long time = System.currentTimeMillis();
		timeDiff = time - startTime;
		if (timeDiff >= destroyTime){
			BlockDestroyer.destroy(this, null); //Add Grass entity. in place of null.
		}
	}
	
	public void resetTime(){
		timeDiff = 0L;
		startTime = 0L;
	}
	
}
