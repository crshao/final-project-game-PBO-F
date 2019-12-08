package com.stg.bcp.stageScript;

import java.util.List;
import java.util.Random;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Enemy1;
import com.stg.bcp.GameObject.object.Enemy2;
import com.stg.bcp.gfx.Assets;

public interface instantiateObject {
	
	public Random rand = new Random();
	
	public default void spawnEnemy1(List<Enemy> enemies, int counter) {
		for(int i=0; i<counter; i++)
			enemies.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1));
	}
	
	public default void spawnEnemy2(List<Enemy> enemies, int counter) {
		for(int i=0; i<counter; i++)
			enemies.add(new Enemy2(rand.nextInt(256) + 128, -48, Assets.enemy2));
	}
	
}
