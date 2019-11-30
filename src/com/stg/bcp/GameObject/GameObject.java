package com.stg.bcp.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float x,y;
	protected int width, height;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
		width = 16;
		height = 16;
	}
	
	public GameObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}
