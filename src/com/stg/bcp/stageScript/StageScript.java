package com.stg.bcp.stageScript;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Enemy1;
import com.stg.bcp.GameObject.object.Enemy2;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.gfx.Assets;

public abstract class StageScript implements instantiateObject{
	protected List<Enemy> enemies;
	protected List<Bullet> bullets;
	protected Player player;
	
	public StageScript(List<Enemy> enemies, List<Bullet> bullets, Player player) {
		this.enemies = enemies;
		this.bullets = bullets;
		this.player = player;
	}
	
	public void checkCollision(Object collision) {
		Rectangle r1 = collision.getBounds();
		
		for(Enemy enemy: enemies) {
			Rectangle r2 = enemy.getBounds();
			if(r1.intersects(r2)) {
				collision.damageHealth(1);
				if(collision instanceof Player)
					enemy.damageHealth(3000);
				else {
					if(((Bullet)collision).getTag() == "b1")
						enemy.damageHealth(2);
					if(((Bullet)collision).getTag() == "b2")
						enemy.damageHealth(12);
				}
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
	
	protected void updateEnemy(List<Enemy> enemies) {
		for(Enemy enemy: enemies) {
			enemy.tick();
			if(enemy.isFire())
				enemyFire(enemy);
		}
		for(int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if(!enemy.isExist()){
				if(enemy instanceof Enemy1)
					player.addScore(5);
				if(enemy instanceof Enemy2)
					player.addScore(20);
				player.addPower(1);
				enemies.remove(i);
			}
		}
	}
	
	protected void updateBullet(List<Bullet> bullets) {
		for(Bullet bullet: bullets)
			bullet.tick();
		for(int i=0; i< bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
				if (!bullet.isExist())
					bullets.remove(i);
		}
	}
	
	protected void updatePlayer() {
		player.tick();
		checkCollision(player);
		for(Bullet bullet: player.getBullets()) {
			bullet.tick();
			checkCollision(bullet);
		}
		for(int i=0; i<player.getBullets().size(); i++) {
			Bullet bullet = player.getBullets().get(i);
			if(!bullet.isExist())
				player.getBullets().remove(i);
		}
	}
	
	protected void enemyFire(Enemy enemy) {
		if(enemy instanceof Enemy1)
			bullets.add(new Bullet(enemy.getX()+8, enemy.getY()+16, Assets.bullet_02, 0, -2, null));
		if(enemy instanceof Enemy2)
			bullets.add(new Bullet(enemy.getX()+8, enemy.getY()+16, Assets.bullet_03, 0, -2, null));
		enemy.setFire(false);
	}
	
	public Player getPlayer() {
		return player;
	}

	public abstract void tick(); 
	
	public abstract void render(Graphics g);
}
