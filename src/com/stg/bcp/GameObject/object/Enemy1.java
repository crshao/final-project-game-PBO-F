package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Enemy1 extends Enemy{
	
	private boolean behavior;
	
	public Enemy1(int x, int y, BufferedImage image) {
		super(x, y, 32, 32, 20, 20, image, 200);
		
		initEnemy();
	}

	private void initEnemy() {
		actTime = rand.nextInt(60)+30;
		fire = false;
		behavior = true;
		setSpeed(0, 1);
	}
	
	@Override
	public void tick() {
		if(behavior) {
			move();
			actTime--;
			if(actTime == 0) {
				fire = true;
				setSpeed(-2, 4, 0, 0);
				actTime = 90;
				isMove = false;
				behavior = false;
			}
		}
		else {
			if(isMove) {
				move();
				if((int) x < 0 || (int) x > 512)
					moveX *= -1;
				actTime--;
				if(actTime == 0) {
					fire = true;
					actTime = 90;
					isMove = false;
				}
			}
			else {
				actTime--;
				if(actTime == 0) {
					actTime = 30;
					setSpeed(-2, 4, 0, 0);
					if(moveX == 0)
						moveX = 1;
					isMove = true;
				}
			}
		}
		
		determineExist();
	}
}
