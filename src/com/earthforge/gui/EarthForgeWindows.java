package com.earthforge.gui;

import com.earthforge.obj.World;
import com.utilis.game.gui.Window;

public class EarthForgeWindows {
	
	public static void setWindowToWorld(Window w, World wrld){
		w.getCanvas().setScreen(wrld);
	}
	
}
