package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Enemy2 extends Enemy{
	
	private int limitY;
	private boolean behavior;
	
	public Enemy2(int x, int y, BufferedImage image) {
		super(x, y, 32, 32, 20, 20, image, 550);
		
		initEnemy();
	}

	private void initEnemy() {
		actTime = rand.nextInt(60) + 60;
		fire = false;
		limitY = rand.nextInt(64) + 64;
		behavior = false;
		setSpeed(rand.nextInt(4) - 2, 1);
	}
	
	@Override
	public void tick() {
		if((int) x < 16 || (int) x > 496)
			moveX *= -1;
		
		if((int) y >= limitY && !behavior) {
			if(moveX == 0)
				setSpeed(-2, 0);
			else
				setSpeed(moveX, 0);
			behavior = true;
		}
		
		move();
		actTime--;
		if(actTime == 0) {
			fire = true;
			actTime = rand.nextInt(75) + 45;
		}
		
		determineExist();
	}

}
