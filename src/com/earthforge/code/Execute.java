package com.earthforge.code;

import java.awt.Image;
import java.io.File;
import java.net.URLDecoder;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.earthforge.obj.Biome;
import com.utilis.Utilis;

public class Execute {
	
	public static int tileWidth = 32;
	public static int tileHeight = 32;
	
	public static void main(String[] args) {
		
		System.out.println("EarthForge");
		
	}
	
	public static Image readImageFromCodebase(String imageName){
		
		//Gets and creates image object.
		try {
			//Finds location of were the program is running and sets codeBase to it.
			String path = Utilis.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decodedPath = URLDecoder.decode(path, "UTF-8");
			//Creates image using decodePath.
			File img1 = new File(decodedPath+imageName);
			Image image = ImageIO.read(img1);
			//Put image in JLabel.
			return image;
		}catch (Exception e) {
			//Error message
			JOptionPane.showMessageDialog(null, "There was an error: \n"+e, "Error!", 1);
			return null;
		}
		
	}
	
}
