package com.stg.bcp.GameObject.object;

import java.awt.Graphics;

import com.stg.bcp.gfx.Assets;

public class Bullet_PlayerFireball extends Bullet {
	
	private int lifetime;
	
	public Bullet_PlayerFireball(float x, float y) {
		super(x, y);
		lifetime = 20;
	}

	@Override
	public void tick() {
		y -= 1;
		lifetime--;
		if(lifetime < 0)
			exist = false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.fireball, (int) x, (int) y, null);
	}

}
