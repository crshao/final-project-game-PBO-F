package com.stg.bcp.background;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingBackground extends Background {
	
	private int moveY;
	
	public MovingBackground(int x, int y, 
			int moveY, BufferedImage image) {
		super(x, y, image);
		this.moveY = moveY;
	}

	@Override
	public void tick() {
		y -= moveY;
		if(y <= -864) {
			y = -48;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	
}
