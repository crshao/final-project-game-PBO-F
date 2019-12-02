package com.stg.bcp.stageScript;

import java.util.List;
import java.util.Random;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Enemy1;
import com.stg.bcp.GameObject.object.Enemy2;
import com.stg.bcp.gfx.Assets;

public class Stage1 extends StageScript{
	
	private Random rand = new Random();
	private int delay, counter;
	
	public Stage1(List<Enemy> enemies, List<Bullet> bullets) {
		super(enemies, bullets);
		
		initStage();
	}
	
	public void initStage() {
		delay = 300;
		counter = 4;
		for(int i=0; i<counter; i++)
			enemies.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1));
	}
	
	private void tick1() {
		for(Enemy enemy: enemies) {
			enemy.tick();
			if(enemy.getFire())
				bullets.add(new Bullet(enemy.getX(), enemy.getY(), 0, -2, Assets.bullet_02));
			enemy.setFire(false);
		}
		for(int i=0; i<enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if(!enemy.getExist())
				enemies.remove(i);
		}
		
		for(Bullet bullet: bullets) {
			bullet.tick();
		}
		for(int i=0; i< bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if(!bullet.getExist())
				bullets.remove(i);
		}
		
		delay--;
		if(delay == 0) {
			delay = rand.nextInt(120) + 300;
			counter = rand.nextInt(4) + 1;
			for(int i=0; i<counter; i++)
				enemies.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1));
			for(int i=0; i<counter/2; i++)
				enemies.add(new Enemy2(rand.nextInt(256) + 128, -48, Assets.enemy2));
		}
	}
	
	@Override
	public void tick() {
		tick1();
	}
}
