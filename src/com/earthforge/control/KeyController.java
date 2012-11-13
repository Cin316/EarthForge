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
			scroll.getCenterEntity().moveUp(Execute.tileHeight);
		}else if (k.getKeyCode()==KeyEvent.VK_S){
			scroll.getCenterEntity().moveDown(Execute.tileHeight);
		}else if (k.getKeyCode()==KeyEvent.VK_A){
			scroll.getCenterEntity().moveLeft(Execute.tileWidth);
		}else if (k.getKeyCode()==KeyEvent.VK_D){
			scroll.getCenterEntity().moveRight(Execute.tileWidth);
		}

	}

	public void keyReleased(KeyEvent k) {
		

	}

	public void keyTyped(KeyEvent k) {
		

	}

}
