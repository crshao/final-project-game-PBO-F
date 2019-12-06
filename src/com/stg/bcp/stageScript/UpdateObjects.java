package com.stg.bcp.stageScript;

import java.util.List;

import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Enemy;

public interface UpdateObjects {
	
	default void updateEnemy(List<Enemy> enemies) {
		for(int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if(!enemy.isExist()){
				enemies.remove(i);
			}
		}
	}
	
	default void updateBullet(List<Bullet> bullets) {
		for(int i=0; i< bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if (!bullet.isExist())
				bullets.remove(i);
		}
	}
	
}
