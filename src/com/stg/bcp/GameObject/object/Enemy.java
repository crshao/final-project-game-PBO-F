package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Object{

	protected Random rand = new Random();
	protected int actTime;
	protected boolean isMove, fire;
	
	public Enemy(int x, int y, int width, int height,
			BufferedImage image, int health) {
		super(x, y, width, height, image, health);
	}
	
	public Enemy(int x, int y, int width, int height,
			int xBound, int yBound, BufferedImage image, int health) {
		super(x, y, width, height, xBound, yBound, image, health);
	}
	
	protected void setSpeed(int moveX, int moveY) {
		this.moveX = moveX;
		this.moveY = moveY;
	}
	
	protected void setSpeed(int minX, int maxX, int minY, int maxY) {
		if(minX == 0 && maxX == 0)
			moveX = 0;
		else
			moveX = rand.nextInt(maxX) + minX;

		if(minY == 0 && maxY == 0)
			moveY = 0;
		else
			moveY = rand.nextInt(maxY) + minY;
	}
	
	public boolean isFire() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

	@Override
	protected void move() {
		x += moveX;
		y += moveY;
	}
}
