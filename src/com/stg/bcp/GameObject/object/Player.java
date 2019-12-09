package com.stg.bcp.GameObject.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.gfx.Assets;

public class Player extends Object{
	
	private Game game;
	private int delay, power, fireball, weaponSlot, score;
	private boolean buttonPressed, shotDelayed;
	private static final int
		borderUp=0,
		borderDown=560,
		borderLeft=0,
		borderRight=496,
		maxPower = 100, maxFireball = 180;
	private List<Bullet> bullets;
	
	public Player(Game game, int x, int y, int width, int height,
			BufferedImage image) {
		super(x, y, width, height, image);
		this.game = game;
		
		initPlayer();
	}
	
	private void initPlayer() {
		bullets = new ArrayList<>();
		score = 0;
		weaponSlot = 1;
		delay = 0;
		power = 0; fireball = maxFireball;
		buttonPressed = false; shotDelayed = false;
	}
	
	public List<Bullet> getBullets(){
		return bullets;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public int getPower() {
		return power;
	}
	
	public void addPower(int power) {
		if(this.power < maxPower)
			this.power += power;
	}
	
	public int getFireball() {
		return fireball;
	}

	@Override
	public void tick() {
		// Input Movement
		getMovement();
		move();
		if((!game.getKeyManager().fire || weaponSlot == 1) && fireball < maxFireball)
			fireball++;
		// Input Shoot
		if(game.getKeyManager().fire) {
			if(weaponSlot == 1) {
				bullets.add(new Bullet(x+8, y-4, Assets.bullet_01, 0, 16, "b1"));
				if(power >= 50) {
					bullets.add(new Bullet(x, y-2, Assets.bullet_01, 0, 16, "b1"));
					bullets.add(new Bullet(x+16, y-2, Assets.bullet_01, 0, 16, "b1"));
				}
				if(power >= 100) {
					bullets.add(new Bullet(x-12, y, Assets.bullet_01, 0, 16, "b1"));
					bullets.add(new Bullet(x+28, y, Assets.bullet_01, 0, 16, "b1"));
				}
			}
			
			if(weaponSlot == 2 && !shotDelayed && fireball > 2) {
				fireball -= 6;
				bullets.add(new Bullet(x+8, y-8, 8, 8, Assets.bullet_02, 0, 8, "b2"));
				bullets.add(new Bullet(x, y-8, 8, 8, Assets.bullet_02, -1, 8, "b2"));
				bullets.add(new Bullet(x+16, y-8, 8, 8, Assets.bullet_02, 1, 8, "b2"));
				bullets.add(new Bullet(x-4, y+8, 8, 8, Assets.bullet_02, -2, 8, "b2"));
				bullets.add(new Bullet(x+20, y+8, 8, 8, Assets.bullet_02, 2, 8, "b2"));
			}
			if(!shotDelayed) {
				delay++;
				if(delay == 6) {
					shotDelayed = true;
				}
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
	
	private void getMovement() {
		moveX = 0;
		moveY = 0;
		if((game.getKeyManager().up || game.getKeyManager().up2)
				&& (int) y > borderUp)
			moveY += 3;
		if((game.getKeyManager().down || game.getKeyManager().down2)
				&& (int) y < borderDown)
			moveY -= 3;
		if((game.getKeyManager().left || game.getKeyManager().left2)
				&& (int) x > borderLeft)
			moveX -= 3;
		if((game.getKeyManager().right || game.getKeyManager().right2)
				&& (int) x < borderRight)
			moveX += 3;
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		for(Bullet bullet: bullets)
			bullet.render(g);
	}
}
