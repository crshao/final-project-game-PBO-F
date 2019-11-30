package com.stg.bcp.stageScript;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.GameObject.object.Player;

public abstract class StageScript {
	
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
	
	public abstract void tick(); 
	
	public void render(Graphics g) {
		for(Enemy enemy: enemies)
			enemy.render(g);
		
		for(Bullet bullet: bullets)
			bullet.render(g);
	}
}
