package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Bullet extends Object{
	
	private String tag;
	
	public Bullet(int x, int y, BufferedImage image,
			int moveX, int moveY, String tag) {
		super(x, y, 16, 16, 8, 12, image, 1);
		this.moveX = moveX;
		this.moveY = moveY;
		this.tag = tag;
	}
	
	public Bullet(int x, int y, int xBound, int yBound,
			BufferedImage image,
			int moveX, int moveY, String tag) {
		super(x, y, 16, 16, xBound, yBound, image, 1);
		this.moveX = moveX;
		this.moveY = moveY;
		this.tag = tag;
	}
	
	public String getTag() {
		return tag;
	}

	@Override
	public void tick() {
		move();
		determineExist();
	}

}