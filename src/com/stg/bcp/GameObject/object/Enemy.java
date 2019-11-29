package com.stg.bcp.GameObject.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Object{
	
	private Random rand = new Random();
	private int actTime, moveX, moveY;
	private boolean isMove;
	private BufferedImage image;
	
	public Enemy(float x, float y, int health, BufferedImage image) {
		super(x, y, health);
		this.image = image;
		
		initEnemy();
	}
	
	private void initEnemy() {
		actTime = rand.nextInt(90);
		updateMoveSpeed();
		isMove = false;
	}
	
	private void updateMoveSpeed() {
		moveX = rand.nextInt(2) - 1;
		moveY = rand.nextInt(2) - 1;
	}
	
	@Override
	public void tick() {
		if(isMove) {
			x += moveX;
			y -= moveY;
		}
		
		actTime--;
		if(actTime == 0) {
			actTime = rand.nextInt(90);
			if(isMove)
				isMove = false;
			else {
				updateMoveSpeed();
				isMove = true;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, null);
	}
}
