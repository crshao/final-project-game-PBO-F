package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Object{
	
	protected Random rand = new Random();
	protected int actTime;
	protected boolean isMove, fire;
	
	public Enemy(float x, float y, int moveX, int moveY, BufferedImage image, int health) {
		super(x, y, moveX, moveY, image, health);
	}
	
	public void setFire(boolean fire) {
		this.fire = fire;
	}
	
	public boolean getFire() {
		return fire;
	}
	
	@Override
	protected void moveVertical() {
		y += moveY;
	}
}
