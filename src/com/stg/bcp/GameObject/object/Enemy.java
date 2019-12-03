package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Object{
	
	protected Random rand = new Random();
	protected int actTime;
	protected boolean isMove, fire1, fire2, fire3;
	
	public Enemy(float x, float y, int moveX, int moveY, BufferedImage image, int health) {
		super(x, y, moveX, moveY, image, health);
	}
	
	public boolean isFire1() {
		return fire1;
	}

	public void setFire1(boolean fire1) {
		this.fire1 = fire1;
	}

	public boolean isFire2() {
		return fire2;
	}

	public void setFire2(boolean fire2) {
		this.fire2 = fire2;
	}

	public boolean isFire3() {
		return fire3;
	}

	public void setFire3(boolean fire3) {
		this.fire3 = fire3;
	}

	@Override
	protected void moveVertical() {
		y += moveY;
	}
}
