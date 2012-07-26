package com.earthforge.code;

import com.utilis.game.obj.*;
import java.awt.*;

public class Dirt extends Tile {
	
	//Image is of dirt.
	public static Image image = Execute.readImageFromCodebase("dirt.png");
	//CollisionBox is completely full.
	public static CollisionBox collide = new CollisionBox(Execute.tileWidth, Execute.tileHeight, true);
	
	
	public Dirt(int x, int y) {
		super(image, collide, x, y);
	}
	
	
	
}
