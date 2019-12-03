package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Enemy2 extends Enemy{

	public Enemy2(float x, float y, BufferedImage image) {
		super(x, y, 1, 1, image, 180);

		initEnemy();
	}

	private void initEnemy() {
		actTime = rand.nextInt(60) + 60;
		fire = false;
	}
	
	@Override
	public void tick() {
		if((int) x < 16 || (int) x > 496)
			moveX *= -1;
		
		if((int) y < 256)
			move();
		else
			moveHorizontal();
		
		actTime--;
		if(actTime == 0) {
			fire = true;
			actTime = rand.nextInt(75) + 45;
		}
		
		determineExist();
	}

}
