package com.earthforge.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.earthforge.code.Execute;
import com.utilis.game.gui.ScrollingCanvas;

public class KeyController implements KeyListener {
	
	ScrollingCanvas scroll;
	
	public KeyController(ScrollingCanvas sc){
		scroll = sc;
	}
	
	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode()==KeyEvent.VK_W){
			if( (scroll.getCenterEntity().getY()>0) ){
				scroll.getCenterEntity().moveUp(Execute.tileHeight);
			}
		}else if (k.getKeyCode()==KeyEvent.VK_S){
			if( !( (scroll.getCenterEntity().getY()) + (Execute.windowHeight*Execute.tileHeight) == Execute.worldHeight*Execute.tileHeight) ){
				scroll.getCenterEntity().moveDown(Execute.tileHeight);
			}
		}else if (k.getKeyCode()==KeyEvent.VK_A){
			if( (scroll.getCenterEntity().getX()>0) ){
				scroll.getCenterEntity().moveLeft(Execute.tileWidth);
			}
		}else if (k.getKeyCode()==KeyEvent.VK_D){
			if( !( (scroll.getCenterEntity().getX()) + (Execute.windowWidth*Execute.tileWidth) == Execute.worldWidth*Execute.tileWidth) ){
				scroll.getCenterEntity().moveRight(Execute.tileWidth);
			}
		}
		
	}

	public void keyReleased(KeyEvent k) {
		

	}

	public void keyTyped(KeyEvent k) {
		

	}

}
