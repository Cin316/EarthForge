package com.earthforge.obj;

public class Biome {
	
	private double minimumChange;
	private double maximumChange;
	
	public Biome(double maxChange){
		minimumChange = 0;
		maximumChange = maxChange;
	}
	public Biome(double maxChange, double minChange){
		minimumChange = minChange;
		maximumChange = maxChange;
	}
	
	public double getMinimumChange() {
		return minimumChange;
	}
	public double getMaximumChange() {
		return maximumChange;
	}
	
	public void setMinimumChange(double minimumChange) {
		this.minimumChange = minimumChange;
	}
	public void setMaximumChange(double maximumChange) {
		this.maximumChange = maximumChange;
	}
	
}
