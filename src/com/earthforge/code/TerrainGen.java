package com.earthforge.code;

import com.utilis.*;
import java.awt.*;

import com.earthforge.obj.*;
import com.earthforge.objSpec.*;

public class TerrainGen {
	// TODO Change int[] generation code to stop generating above the height.
	public static int[] generateHeights(Biome b, int length, int height){
		int currentHeight = RandomHelper.randomInt(1, height);
		int[] heightNums =  new int[length];
		double realHeight = currentHeight;
		double changeRate = 0;
		int direction = 0;
		boolean continueDirection = false;
		for(int i=0; i<length; i++){
			if (!continueDirection){
				direction = RandomHelper.randomInt(0,2);
			}
			if(direction==0){
				//Go straight.
				realHeight = Math.round(realHeight); //Brings realHeight to a .0 value.
				currentHeight = (int) realHeight;
			}else if(direction==1){
				//Go down.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight - changeRate;
				currentHeight = (int) Math.ceil(realHeight);
			}else if (direction==2){
				//Go up.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight + changeRate;
				currentHeight = (int) Math.floor(realHeight);
			}
			heightNums[i] = currentHeight; //Adds the currentValue to the array of ints.
			//Determine whether to continue the direction of change direction.
			continueDirection = RandomHelper.randomInt(0, 9)<2;//20% chance to change directions, 80% chance to continue.
			
		}
		return heightNums;
	}
	public static int[] generateHeights(Biome b, int length, int height, int startValue){
		int currentHeight = startValue;
		int[] heightNums =  new int[length];
		double realHeight = currentHeight;
		double changeRate = 0;
		int direction = 0;
		boolean continueDirection = false;
		for(int i=0; i<=length; i++){
			if (!continueDirection){
				direction = RandomHelper.randomInt(0,2);
			}
			if(direction==0){
				//Go straight.
				realHeight = Math.round(realHeight); //Brings realHeight to a .0 value.
				currentHeight = (int) realHeight;
			}else if(direction==1){
				//Go down.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight - changeRate;
				currentHeight = (int) Math.ceil(realHeight);
			}else if (direction==2){
				//Go up.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight + changeRate;
				currentHeight = (int) Math.floor(realHeight);
			}
			heightNums[i] = currentHeight; //Adds the currentValue to the array of ints.
			//Determine whether to continue the direction of change direction.
			continueDirection = RandomHelper.randomInt(0, 9)<2;//20% chance to change directions, 80% chance to continue.
			
		}
		return heightNums;
	}
	
	public static World generateWorldWithHeights(int[] i){
		
		World world = new World(i.length);
		
		for(int x=0; x<i.length; x++){
			for(int y=0; y<Execute.worldHeight; y++){
				if(y > i[x]){
					world.setTile(x, y, new Dirt(x*Execute.tileWidth, y*Execute.tileHeight));
				}else if(y == i[x]){
					world.setTile(x, y, new Grass(x*Execute.tileWidth, y*Execute.tileHeight));
				}else if(y < i[x]){
					world.setTile(x, y, new Air(x*Execute.tileWidth, y*Execute.tileHeight));
				}
			}
		}
		
		return world;
	}
	
}
