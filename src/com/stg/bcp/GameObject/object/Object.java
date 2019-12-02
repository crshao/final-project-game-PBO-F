package com.stg.bcp.GameObject.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.stg.bcp.GameObject.GameObject;

public abstract class Object extends GameObject{
	
	protected int moveX, moveY, health;
	protected BufferedImage image;
	protected boolean exist;
	
	public Object(float x, float y) {
		super(x, y);
		health = 10;
	}
	
	public Object(float x, float y, int moveX, int moveY, BufferedImage image) {
		super(x, y, 8, 12);
		this.moveX = moveX;
		this.moveY = moveY;
		this.image = image;
		exist = true;
		health = 1;
	}
	
	public Object(float x, float y, int moveX, int moveY, BufferedImage image, int health) {
		super(x, y);
		this.moveX = moveX;
		this.moveY = moveY;
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
	
	public boolean getExist() {
		return exist;
	}
	
	public void setExist(boolean exist) {
		this.exist = exist;
	}
	
	protected void moveHorizontal() {
		x += moveX;
	}
	
	protected void moveVertical() {
		y -= moveY;
	}
	
	protected void move() {
		moveHorizontal();
		moveVertical();
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
		g.drawImage(image, (int) x, (int) y, null);
	}
}
