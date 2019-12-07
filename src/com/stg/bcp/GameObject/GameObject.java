package com.stg.bcp.GameObject;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y, width, height, xBound, yBound;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		xBound = width / 2;
		yBound = height / 2;
	}
	
	public GameObject(int x, int y, int width, int height,
			int xBound, int yBound) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.xBound = xBound;
		this.yBound = yBound;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, xBound, yBound);
	}
}
