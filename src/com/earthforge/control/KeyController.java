package com.earthforge.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.earthforge.code.Execute;
import com.earthforge.code.GameConstants;
import com.utilis.game.gui.ScrollingCanvas;

public class KeyController implements KeyListener {
	
	ScrollingCanvas scroll;
	
	public KeyController(ScrollingCanvas sc){
		scroll = sc;
	}
	
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode()==KeyEvent.VK_W){
			if( (scroll.getCenterEntity().getY()>0) ){
				scroll.getCenterEntity().moveUp(GameConstants.tileHeight);
			}
		}else if (k.getKeyCode()==KeyEvent.VK_S){
			if( !( (scroll.getCenterEntity().getY()) + (GameConstants.windowHeight*GameConstants.tileHeight) == GameConstants.worldHeight*GameConstants.tileHeight) ){
				scroll.getCenterEntity().moveDown(GameConstants.tileHeight);
			}
		}else if (k.getKeyCode()==KeyEvent.VK_A){
			if( (scroll.getCenterEntity().getX()>0) ){
				scroll.getCenterEntity().moveLeft(GameConstants.tileWidth);
			}
		}else if (k.getKeyCode()==KeyEvent.VK_D){
			if( !( (scroll.getCenterEntity().getX()) + (GameConstants.windowWidth*GameConstants.tileWidth) == GameConstants.worldWidth*GameConstants.tileWidth) ){
				scroll.getCenterEntity().moveRight(GameConstants.tileWidth);
			}
		}
		
	}

	public void keyReleased(KeyEvent k) {
		

	}

	public void keyTyped(KeyEvent k) {
		

	}

}
