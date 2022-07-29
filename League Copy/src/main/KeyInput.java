package main;

import java.awt.event.*;

public class KeyInput implements KeyListener {

	public boolean up, down, left, right;

	@Override
	public void keyTyped(KeyEvent e) {
	        
	}

	@Override
	public void keyPressed(KeyEvent e) {
	        
	    //returns the integer key code of the key pressed
		int code = e.getKeyCode();
	
	    if (code == KeyEvent.VK_W) {
	        up = true;
	    } else if (code == KeyEvent.VK_S) {
	        down = true;
	    } else if (code == KeyEvent.VK_A) {
	        left = true;
	    } else if (code == KeyEvent.VK_D) {
	        right = true;
	    }

	}

	@Override
	public void keyReleased(KeyEvent e) {
    
		//returns the integer key code of the key pressed
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = false;
        } else if (code == KeyEvent.VK_S) {
            down = false;
        } else if (code == KeyEvent.VK_A) {
            left = false;
        } else if (code == KeyEvent.VK_D) {
            right = false;
        }
    }
	    
}

