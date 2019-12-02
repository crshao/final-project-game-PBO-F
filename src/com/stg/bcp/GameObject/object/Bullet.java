package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Bullet extends Object{
	
	public Bullet(float x, float y, int moveX, int moveY, BufferedImage image) {
		super(x, y, moveX, moveY, image);
	}
	
	@Override
	public void tick() {
		move();
		determineExist();
	}

}