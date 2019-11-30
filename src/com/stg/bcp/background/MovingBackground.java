package com.stg.bcp.background;

import java.awt.image.BufferedImage;

public class MovingBackground extends Background {
	
	private int moveSpeed;
	
	public MovingBackground(int x, int y, 
			int moveSpeed, BufferedImage image) {
		super(x, y, image);
		this.moveSpeed = moveSpeed;
	}

	@Override
	public void tick() {
		y -= moveSpeed;
		if(y <= -864) {
			y = -48;
		}
	}
}
