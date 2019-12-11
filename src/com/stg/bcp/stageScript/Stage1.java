package com.stg.bcp.stageScript;

import java.awt.Graphics;
import java.util.List;
import java.util.Random;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Enemy;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.background.Background;
import com.stg.bcp.background.MovingBackground;
import com.stg.bcp.background.StaticBackground;
import com.stg.bcp.background.StatusScreen;
import com.stg.bcp.gfx.Assets;

public class Stage1 extends StageScript{
	
	private Background mainBackground, sideBackground;
	private StatusScreen status;
	private Random rand = new Random();
	private int delay, counter;
	
	public Stage1(List<Enemy> enemies, List<Bullet> bullets, Player player) {
		super(enemies, bullets, player);
		
		initStage();
	}
	
	public void initStage() {
		mainBackground = new MovingBackground(-256, -864, 4, Assets.level);
		sideBackground = new StaticBackground(512, 0, Assets.background);
		status = new StatusScreen(player);
		delay = 300;
		counter = 0;
		spawnEnemy1(enemies, 4);
	}
	
	private void spawnEnemy() {
		delay--;
		if(delay == 0) {
			delay = rand.nextInt(120) + 300;
			counter++;
			if(counter == 4) {
				spawnEnemy1(enemies, counter);
				spawnEnemy2(enemies, counter);
				counter = 0;
			}
			spawnEnemy1(enemies, rand.nextInt(5) + 1);
			spawnEnemy2(enemies, rand.nextInt(2) + 1);
		}
	}
	
	public StatusScreen getStatusScreen() {
		return status;
	}
	
	@Override
	public void tick() {
		mainBackground.tick();
		updatePlayer();
		updateEnemy(enemies);
		updateBullet(bullets);
		status.tick();
		spawnEnemy();
	}

	@Override
	public void render(Graphics g) {
		mainBackground.render(g);
		player.render(g);
		for(Enemy enemy: enemies)
			enemy.render(g);
		
		for(Bullet bullet: bullets)
			bullet.render(g);
		sideBackground.render(g);
		status.render(g);
	}
}
