package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Bullet extends Object{
	
	private String tag;
	
	public Bullet(float x, float y, int moveX, int moveY, BufferedImage image, String tag) {
		super(x, y, moveX, moveY, image);
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