package com.earthforge.obj;

import java.util.ArrayList;
import com.utilis.game.obj.*;

import com.earthforge.code.*;

public class World extends Screen {
	
	protected ArrayList<Biome> biomes;
	protected ArrayList<Integer> biomeLength;
	protected int numOfBiomes = 1;
	
	public World(int length) {
		super(length, GameConstants.worldHeight, GameConstants.tileHeight, GameConstants.tileWidth);
		
		biomes = new ArrayList<Biome>(numOfBiomes);
		biomeLength = new ArrayList<Integer>(numOfBiomes);
	}

}
