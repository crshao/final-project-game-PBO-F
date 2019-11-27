package com.stg.bcp.GameObject.object;

import java.awt.Graphics;

import com.stg.bcp.gfx.Assets;

public class Bullet_PlayerFireball extends Bullet {
	
	private int lifetime;
	
	public Bullet_PlayerFireball(float x, float y) {
		super(x, y);
		lifetime = 5;
	}
	
	public int getLifetime() {
		return lifetime;
	}
	
	public void setLifetime(int lifetime) {
		this.lifetime = lifetime-1;
	}

	@Override
	public void tick() {
		y -= 1;
		
		if(lifetime < 0 || y < -48)
			exist = false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.fireball, (int) x, (int) y, null);
	}

}
