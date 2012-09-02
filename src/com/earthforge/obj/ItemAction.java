package com.earthforge.obj;

public interface ItemAction extends Action {
	
	public void performLocationAction(int x, int y);
	public boolean hasLocationAction();
	
}
