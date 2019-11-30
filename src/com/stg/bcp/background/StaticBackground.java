package com.stg.bcp.background;

import java.awt.image.BufferedImage;

public class StaticBackground extends Background {
	
	public StaticBackground(int x, int y, BufferedImage image) {
		super(x,y,image);
	}
	
	@Override
	public void tick() {
		
	}
}
