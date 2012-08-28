package com.earthforge.obj;

import java.awt.Image;

import com.utilis.game.obj.CollisionBox;
import com.utilis.game.obj.Tile;

public abstract class Block extends Tile implements Action {
	
	protected boolean hasAction;
	
	public Block(CollisionBox c, int x, int y) {
		super(c, x, y);
	}
	public Block(int width, int height, int x, int y) {
		super(width, height, x, y);
	}
	public Block(Image i, CollisionBox c, int x, int y) {
		super(i, c, x, y);
	}
	
	public boolean getHasAction(){
		return hasAction;
	}
	
}
