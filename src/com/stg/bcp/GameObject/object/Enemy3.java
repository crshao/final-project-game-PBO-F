package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Enemy3 extends Enemy{
	
	public Enemy3(float x, float y, BufferedImage image) {
		super(x, y, 2, 1, image, 150);
		initEnemy();
	}

	private void initEnemy() {
		actTime = rand.nextInt(30) + 50;
		fire = false;
	}
	
	@Override
	public void tick() {
		if((int) x < 20 || (int) x > 500)
			moveX *= -1;
		
		if((int) y < 350)
			move();
		else
			moveHorizontal();
		
		actTime--;
		if(actTime == 0) {
			fire = true;
			actTime = rand.nextInt(60) + 30;
		}
		
		determineExist();
	}
}	

