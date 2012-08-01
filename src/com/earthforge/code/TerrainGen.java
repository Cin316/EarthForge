package com.earthforge.code;

import com.utilis.*;
import java.awt.*;

import com.earthforge.obj.Biome;

public class TerrainGen {
	
	public static int[] generateTerrain(Biome b, int length, int height){
		int currentHeight = RandomHelper.randomInt(1, height);
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
	public static int[] generateTerrain(Biome b, int length, int height, int startValue){
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
	
}
