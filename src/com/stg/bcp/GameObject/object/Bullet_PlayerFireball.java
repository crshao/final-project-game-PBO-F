package com.stg.bcp.GameObject.object;

import java.awt.Graphics;

import com.stg.bcp.gfx.Assets;

public class Bullet_PlayerFireball extends Bullet {
	
	private float moveX, moveY;
	
	public Bullet_PlayerFireball(float x, float y, float moveX, float moveY) {
		super(x, y);
		this.moveX = moveX;
		this.moveY = moveY;
	}

	@Override
	public void tick() {
		y -= moveY;
		x += moveX;
		if(y < -48)
			exist = false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.fireball, (int) x, (int) y, null);
	}

}
