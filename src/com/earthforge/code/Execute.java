package com.earthforge.code;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.earthforge.obj.*;
import com.earthforge.objSpec.*;
import com.utilis.game.gui.*;
import com.utilis.game.obj.Entity;
import com.utilis.game.obj.Screen;
import com.utilis.game.obj.ScrollingEntity;
import com.utilis.Utilis;

public class Execute {
	
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	public static final int worldHeight = 15;
	public static final String version = "v. Alpha 0.1";
	
	public static void main(String[] args) {
		
		System.out.println("EarthForge " + version + ".");
		displayWindowWithWorld();
	}
	
	public static void displayWindowWithWorld(){
		int[] nums = TerrainGen.generateHeights(new Grasslands(1.1, 0.2), 10, worldHeight);
		World world = TerrainGen.generateWorldWithDirt(nums);
		Canvas c = new Canvas(world);
		Window frame = new Window(c);
		//frame.setBackground(Color.cyan);
		frame.pack();
		frame.setSize( tileWidth*10, (tileHeight*worldHeight) );
		c.setSize(frame.getSize());
		c.repaint();
		
	}
	
	public static Image readImageFromCodebase(String imageName){
		
		//Gets and creates image object.
		try {
			//Finds location of were the program is running and sets codeBase to it.
			String path = Execute.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			//Removes "/bin" from path.
			path = path.substring(0, (path.length()-1) - 4 );
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			//Creates image using decodePath.
			File img1 = new File(decodedPath+imageName);
			Image image = ImageIO.read(img1);
			//Put image in JLabel.
			return image;
		}catch (Exception e) {
			//Error message
			JOptionPane.showMessageDialog(null, "There was an error: \n"+e, "Error!", 1);
			e.printStackTrace();
			return null;
		}
		
	}
	
}
