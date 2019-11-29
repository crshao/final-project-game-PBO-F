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
	private int delay, weaponSlot;
	private float power;
	private boolean buttonPressed, shotDelayed;
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
		delay = 0;
		weaponSlot = 1;
		power = (float) 3.9;
		buttonPressed = false;
		shotDelayed = false;
	}
	
	public List<Bullet> getBullets(){
		return bullets;
	}

	@Override
	public void tick() {
		// Input Movement
		if((game.getKeyManager().up || game.getKeyManager().up2)
				&& (int) y > borderUp)
			y -= 3;
		if((game.getKeyManager().down || game.getKeyManager().down2)
				&& (int) y < borderDown)
			y += 3;
		if((game.getKeyManager().left || game.getKeyManager().left2)
				&& (int) x > borderLeft)
			x -= 3;
		if((game.getKeyManager().right || game.getKeyManager().right2)
				&& (int) x < borderRight)
			x += 3;
		
		// Input Shoot
		if(game.getKeyManager().fire) {
			if(weaponSlot == 1) {
				bullets.add(new Bullet_Player(x, y-4));
				if((int) power >= 1) {
					bullets.add(new Bullet_Player(x-6, y-4));
					bullets.add(new Bullet_Player(x+6, y-4));
				}
				if((int) power >= 2) {
					bullets.add(new Bullet_Player(x-16, y+16));
					bullets.add(new Bullet_Player(x+16, y+16));
				}
			}
			
			if(weaponSlot == 2 && !shotDelayed) {
				bullets.add(new Bullet_PlayerFireball(x, y-8, 0, 8));
				bullets.add(new Bullet_PlayerFireball(x-8, y-8, -1, 8));
				bullets.add(new Bullet_PlayerFireball(x+8, y-8, 1, 8));
				bullets.add(new Bullet_PlayerFireball(x-8, y+8, -3, 8));
				bullets.add(new Bullet_PlayerFireball(x+8, y+8, 3, 8));
			}
			if(!shotDelayed) {
				delay++;
				if(delay == 3)
					shotDelayed = true;
			}
		}
		
		// Change Shot type
		if(game.getKeyManager().change && !buttonPressed) {
			if(weaponSlot == 1)
				weaponSlot = 2;
			else if(weaponSlot == 2)
				weaponSlot = 1;
			buttonPressed = true;
		}
		else if(!game.getKeyManager().change)
			buttonPressed = false;
		
		// Fireball's Delay
		if(shotDelayed) {
			delay--;
			if(delay == 0)
				shotDelayed = false;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
	}
	
}
