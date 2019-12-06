package com.stg.bcp.stageScript;

import java.util.List;
import java.util.Random;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Enemy1;
import com.stg.bcp.GameObject.object.Enemy2;
import com.stg.bcp.GameObject.object.Enemy3;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.display.Display;
import com.stg.bcp.gfx.Assets;

public class Stage1 extends StageScript{
	
	private Random rand = new Random();
	private int delay, counter;
	
	public Stage1(List<Enemy> enemies, List<Bullet> bullets, Player player) {
		super(enemies, bullets, player);
		
		initStage();
	}
	
	public void initStage() {
		delay = 300;
		counter = 4;
		for(int i=0; i<counter; i++)
			enemies.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1));
	}
	
	private void spawnEnemy() {
		delay--;
		if(delay == 0) {
			delay = rand.nextInt(120) + 300;
			counter = rand.nextInt(5) + 1;
			for(int i=0; i<counter; i++)
				enemies.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1));
			for(int i=0; i<counter/2; i++)
				enemies.add(new Enemy2(rand.nextInt(256) + 128, -48, Assets.enemy2));
			for(int i=0; i<counter/3; i++)
				enemies.add(new Enemy3(rand.nextInt(256) + 50, -48, Assets.enemy3));
		}
	}
	
	@Override
	public void tick() {
		for(Enemy enemy: enemies) {
			enemy.tick();
			if(enemy.isFire())
				enemyFire(enemy);
		}
		updateEnemy(enemies);
		
		for(Bullet bullet: bullets)
			bullet.tick();
		updateBullet(bullets);

		spawnEnemy();
	}
}
