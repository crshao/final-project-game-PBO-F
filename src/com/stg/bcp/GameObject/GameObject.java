package com.stg.bcp.GameObject;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected float x,y;
	
	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
