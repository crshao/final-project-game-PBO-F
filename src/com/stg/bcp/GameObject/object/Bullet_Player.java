package com.stg.bcp.GameObject.object;

import java.awt.Graphics;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.gfx.Assets;

public class Bullet_Player extends Bullet{
	
	public Bullet_Player(float x, float y) {
		super(x, y);
	}
	
	@Override
	public void tick() {
		y -= 16;
		if(y < -48)
			exist = false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bullet_01, (int) x, (int) y, null);
	}
}
