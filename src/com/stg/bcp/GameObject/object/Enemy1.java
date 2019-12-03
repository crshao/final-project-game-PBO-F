package com.stg.bcp.GameObject.object;

import java.awt.image.BufferedImage;

public class Enemy1 extends Enemy{
	
	private boolean behavior1;
	
	public Enemy1(float x, float y, BufferedImage image) {
		super(x, y, 0, 2, image, 100);
		
		initEnemy();
	}

	private void initEnemy() {
		actTime = rand.nextInt(60)+30;
		fire1 = false;
		behavior1 = true;
	}
	
	@Override
	public void tick() {
		if(behavior1) {
			moveVertical();
			actTime--;
			if(actTime == 0) {
				fire1 = true;
				actTime = 90;
				isMove = false;
				behavior1 = false;
			}
		}
		else {
			if(isMove) {
				moveHorizontal();
				if((int) x < 0 || (int) x > 512)
					moveX *= -1;
				actTime--;
				if(actTime == 0) {
					fire1 = true;
					actTime = 90;
					isMove = false;
				}
			}
			else {
				actTime--;
				if(actTime == 0) {
					actTime = 30;
					moveX = rand.nextInt(4) - 2;
					if(moveX == 0)
						moveX = 1;
					isMove = true;
				}
			}
		}
		
		determineExist();
	}
}
