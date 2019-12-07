package com.stg.bcp.GameObject.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.stg.bcp.GameObject.GameObject;

public abstract class Object extends GameObject{
	
	protected int moveX, moveY, health;
	protected BufferedImage image;
	protected boolean exist;
	
	public Object(int x, int y, int width, int height,
			BufferedImage image) {
		super(x, y, width, height);
		this.image = image;
		health = 10;
	}
	
	public Object(int x, int y, int width, int height,
			BufferedImage image, int health) {
		super(x, y, width, height);
		this.image = image;
		this.health = health;
		exist = true;
	}
	
	public Object(int x, int y, int width, int height,
			int xBound, int yBound, BufferedImage image, int health) {
		super(x, y, width, height, xBound, yBound);
		this.image = image;
		this.health = health;
		exist = true;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void damageHealth(int damage) {
		health -= damage;
	}
	
	public boolean isExist() {
		return exist;
	}
	
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	
	protected void move() {
		x += moveX;
		y -= moveY;
	}
	
	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}
	
	public int getMoveX() {
		return moveX;
	}
	
	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}
	
	public int getMoveY() {
		return moveY;
	}
	
	protected void determineExist() {
		if(((int) y < -60 || (int) y > 560) ||
				((int) x < -50) || (int) x > 560 ||
				health < 1)
			exist = false;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}
}
