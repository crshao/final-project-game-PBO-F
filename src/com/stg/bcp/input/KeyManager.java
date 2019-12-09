package com.stg.bcp.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean
		up, up2,
		down, down2,
		left, left2,
		right, right2,
		fire, change, enter;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
			up2 = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S];
			down2 = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_A];
			left2 = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_D];
			right2 = keys[KeyEvent.VK_RIGHT];
		
		fire = keys[KeyEvent.VK_CONTROL];
		change = keys[KeyEvent.VK_E];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}