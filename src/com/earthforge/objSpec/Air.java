package com.earthforge.objSpec;

import java.awt.Image;
import java.awt.image.BufferedImage;

import com.earthforge.code.Execute;
import com.earthforge.code.GameConstants;
import com.earthforge.obj.Block;
import com.utilis.game.obj.CollisionBox;

public class Air extends Block {
	
	//Image is blank.
	public static Image image = new BufferedImage(GameConstants.tileWidth, GameConstants.tileHeight, BufferedImage.TYPE_INT_ARGB);
	//CollisionBox is empty.
	public static CollisionBox collide = new CollisionBox(GameConstants.tileWidth, GameConstants.tileHeight, false);
	//How long it takes to destroy Air.  Measured in milliseconds.
	public static long destroyTime = 0;
	
	public Air(int x, int y) {
		super(image, collide, x, y);
		hasAction = false;
	}
	
	public void performAction() {

	}

}
