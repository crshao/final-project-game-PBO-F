package com.stg.bcp.GameObject.object;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.object.Bullet_Player;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.gfx.Assets;

public class Player extends Object{
	
	private Game game;
	private int cooldown, weaponSlot;
	private float power;
	private static final int
		borderUp=0,
		borderDown=560,
		borderLeft=0,
		borderRight=496;
	private List<Bullet> bullets;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
		
		initPlayer();
	}
	
	private void initPlayer() {
		bullets = new ArrayList<>();
		cooldown = 0;
		weaponSlot = 2;
		power = (float) 2.9;
	}
	
	public List<Bullet> getBullets(){
		return bullets;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up && (int) y > borderUp)
			y -= 3;
		if(game.getKeyManager().down && (int) y < borderDown)
			y += 3;
		if(game.getKeyManager().left && (int) x > borderLeft)
			x -= 3;
		if(game.getKeyManager().right && (int) x < borderRight)
			x += 3;
		if(game.getKeyManager().fire) {
			if(weaponSlot == 1) {
				bullets.add(new Bullet_Player(x, y-5));
				if((int) power >= 1) {
					bullets.add(new Bullet_Player(x-6, y-5));
					bullets.add(new Bullet_Player(x+6, y-5));
				}
				if((int) power >= 2) {
					bullets.add(new Bullet_Player(x-16, y+16));
					bullets.add(new Bullet_Player(x+16, y+16));
				}
			}
			if(weaponSlot == 2) {
				bullets.add(new Bullet_PlayerFireball(x, y-5));
			}
		}
			
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
	}
	
}
