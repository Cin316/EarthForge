package com.earthforge.code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.earthforge.control.KeyController;
import com.earthforge.obj.*;
import com.earthforge.objSpec.*;
import com.earthforge.code.*;
import com.utilis.game.gui.*;
import com.utilis.game.obj.Entity;
import com.utilis.game.obj.Screen;
import com.utilis.game.obj.ScrollingEntity;
import com.utilis.Utilis;

public class Execute {
	
	public static final String version = "v. Alpha 0.1.1";
	
	public static void main(String[] args) {
		
		System.out.println("EarthForge " + version + ".");
		displayWindowWithWorld();
	}
	
	public static void displayWindowWithWorld(){
		int[] nums = TerrainGen.generateHeights(new Grasslands(1.1, 0.2), GameConstants.worldWidth, GameConstants.worldHeight);
		World world = TerrainGen.generateWorldWithDirt(nums);
		ScrollingCanvas c = new ScrollingCanvas(world);
		Window frame = new Window(c);
		ScrollingEntity person = new ScrollingEntity(readImageFromCodebase("/images/Dirt.png"));
		Dimension size = new Dimension( (GameConstants.worldHeight*GameConstants.tileHeight), (world.getNumOfTilesX()*GameConstants.tileWidth)); 
		KeyController kc = new KeyController(c);
		
		frame.setVisible(false);
		
		frame.addKeyListener(kc);
		
		frame.setSize( GameConstants.tileWidth*GameConstants.windowWidth, (GameConstants.tileHeight*GameConstants.windowHeight) - 10 );
		frame.setPreferredSize(size);
		frame.setResizable(false);
		c.setMinimumSize(size);
		c.setMaximumSize(size);
		c.setPreferredSize(size);
		
		c.setBackground(Color.cyan);
		
		c.setCenterEntity(person);
		//person.setRealX( (frame.getWidth()-person.getWidth()) /2);
		//person.setRealY( (frame.getHeight()-person.getHeight()) /2);
		person.setX(0);
		person.setY(0);
		
		frame.setVisible(true);
		
		while(true){
			Utilis.delay(10);
			c.repaint();
		}
		
	}
	
	public static Image readImageFromCodebase(String imageName){
		
		//Gets and creates image object.
		try {
			ImageIcon image = new ImageIcon(Execute.class.getResource(imageName));
			//Image image = ImageIO.read(img1);
			return image.getImage();
		}catch (Exception e) {
			//Error message
			JOptionPane.showMessageDialog(null, "There was an error: \n"+e, "Error!", 1);
			e.printStackTrace();
			return null;
		}
		
	}
	
}
