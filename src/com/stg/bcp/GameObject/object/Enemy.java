package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Object{
	
	protected Random rand = new Random();
	protected int actTime;
	protected boolean isMove, fire, fire1, fire2;
	
	public Enemy(float x, float y, int moveX, int moveY, BufferedImage image, int health) {
		super(x, y, moveX, moveY, image, health);
	}
	
	public void setFire(boolean fire) {
		this.fire = fire;
	}
	
	public boolean getFire() {
		return fire;
	}
	
	public void setFire1(boolean fire1) {
		this.fire1 = fire1;
	}
	
	public boolean getFire1() {
		return fire1;
	}
	
	
	public void setFire2(boolean fire2) {
		this.fire2 = fire2;
	}
	public boolean getFire2() {
		return fire2;
	}
	
	@Override
	protected void moveVertical() {
		y += moveY;
	}
}
