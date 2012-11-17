package com.earthforge.code;

import com.utilis.*;
import java.awt.*;

import com.earthforge.obj.*;
import com.earthforge.objSpec.*;

public class TerrainGen {
	
	public static int[] generateHeights(Biome b, int length, int height){
		int currentHeight = RandomHelper.randomInt(0, height);
		int[] heightNums =  new int[length];
		double realHeight = currentHeight;
		double changeRate = 0;
		int direction = 0;
		boolean continueDirection = false;
		for(int i=0; i<length; i++){
			if (!continueDirection){
				//Checks if current height is equal to the height.
				if(currentHeight>=height){
					int direction1 = RandomHelper.randomInt(0,1);
					if(direction1==0){
						direction = 0;
					}else if (direction1==1){
						direction = 2;
					}
				}else{
					direction = RandomHelper.randomInt(0,2);
				}
			}
			if(direction==0){
				//Go straight.
				realHeight = java.lang.Math.round(realHeight); //Brings realHeight to a .0 value.
				currentHeight = (int) realHeight;
			}else if(direction==1){
				//Go up.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight - changeRate;
				currentHeight = (int) java.lang.Math.ceil(realHeight);
			}else if (direction==2){
				//Go down.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight + changeRate;
				currentHeight = (int) java.lang.Math.floor(realHeight);
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
				realHeight = java.lang.Math.round(realHeight); //Brings realHeight to a .0 value.
				currentHeight = (int) realHeight;
			}else if(direction==1){
				//Go down.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight - changeRate;
				currentHeight = (int) java.lang.Math.ceil(realHeight);
			}else if (direction==2){
				//Go up.
				if (!continueDirection){
					changeRate = RandomHelper.randomDouble(b.getMaximumChange(), b.getMinimumChange());
				}
				realHeight = realHeight + changeRate;
				currentHeight = (int) java.lang.Math.floor(realHeight);
			}
			heightNums[i] = currentHeight; //Adds the currentValue to the array of ints.
			//Determine whether to continue the direction of change direction.
			continueDirection = RandomHelper.randomInt(0, 9)<2;//20% chance to change directions, 80% chance to continue.
			
		}
		return heightNums;
	}
	
	public static World generateWorldWithDirt(int[] i){
		
		World world = new World(i.length);
		
		for(int x=0; x<i.length; x++){
			for(int y=0; y<GameConstants.worldHeight; y++){
				if(y > i[x]){
					world.setTile(x, y, new Dirt(x*GameConstants.tileWidth, y*GameConstants.tileHeight));
				}else if(y == i[x]){
					world.setTile(x, y, new Grass(x*GameConstants.tileWidth, y*GameConstants.tileHeight));
				}else if(y < i[x]){
					world.setTile(x, y, new Air(x*GameConstants.tileWidth, y*GameConstants.tileHeight));
				}
			}
		}
		
		return world;
	}
	
}
