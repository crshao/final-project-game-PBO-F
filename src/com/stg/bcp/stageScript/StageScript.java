package com.stg.bcp.stageScript;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Enemy1;
import com.stg.bcp.GameObject.object.Enemy2;
import com.stg.bcp.GameObject.object.Enemy3;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.gfx.Assets;

public abstract class StageScript implements UpdateObjects{
	
	protected List<Enemy> enemies;
	protected List<Bullet> bullets;
	
	public StageScript(List<Enemy> enemies, List<Bullet> bullets) {
		this.enemies = enemies;
		this.bullets = bullets;
	}
	
	public void checkCollision(Object collision) {
		Rectangle r1 = collision.getBounds();
		
		for(Enemy enemy: enemies) {
			Rectangle r2 = enemy.getBounds();
			
			if(r1.intersects(r2)) {
				collision.damageHealth(1);
				if(collision instanceof Player)
					enemy.damageHealth(1000);
				else
					enemy.damageHealth(1);
			}
		}
		
		if(collision instanceof Player) {
			for(Bullet bullet: bullets) {
				Rectangle r2 = bullet.getBounds();
				
				if(r1.intersects(r2)) {
					collision.damageHealth(1);
					bullet.damageHealth(1);
				}
			}
		}
	}
	
	protected void enemyFire(Enemy enemy) {
		if(enemy instanceof Enemy1)
			bullets.add(new Bullet(enemy.getX(), enemy.getY(), 0, -2, Assets.bullet_02));
		if(enemy instanceof Enemy2)
			bullets.add(new Bullet(enemy.getX(), enemy.getY(), 0, -2, Assets.bullet_03));
		if(enemy instanceof Enemy3)
			bullets.add(new Bullet(enemy.getX(), enemy.getY(), 0, -3, Assets.beam1));
		enemy.setFire(false);
	}
	
	public abstract void tick(); 
	
	public void render(Graphics g) {
		for(Enemy enemy: enemies)
			enemy.render(g);
		
		for(Bullet bullet: bullets)
			bullet.render(g);
	}
}
