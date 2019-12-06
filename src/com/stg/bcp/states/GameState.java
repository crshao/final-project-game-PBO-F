package com.stg.bcp.states;

import java.awt.*;
import java.util.ArrayList;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.background.Background;
import com.stg.bcp.background.MovingBackground;
import com.stg.bcp.background.StaticBackground;
import com.stg.bcp.background.StatusScreen;
import com.stg.bcp.gfx.Assets;
import com.stg.bcp.stageScript.Stage1;
import com.stg.bcp.stageScript.StageScript;

public class GameState extends State {
	private Player player;
	private Background mainBackground, sideBackground;
	private StageScript stageScript = new Stage1(new ArrayList<>(), new ArrayList<>());
	private StatusScreen status;
	public static Integer currentLevel, currentScore;
	
	public GameState(Game game) {
		super(game);
		initState();
		currentLevel = 1;
		currentScore = 0;
	}
	
	private void initState() {
		player = new Player(game, 256, 512);
		mainBackground = new MovingBackground(-256, -864, 4, Assets.level);
		sideBackground = new StaticBackground(512, 0, Assets.background);
		status = new StatusScreen(player);
	}
	
	@Override
	public void tick() {
		player.tick();
		mainBackground.tick();
		stageScript.tick();
		
		stageScript.checkCollision(player);
		
		//Update Player's Bullets
		for(Bullet bullet: player.getBullets()) {
			bullet.tick();
			stageScript.checkCollision(bullet);
		}
		for(int i=0; i<player.getBullets().size(); i++) {
			Bullet bullet = player.getBullets().get(i);
			if(!bullet.isExist()) {
				player.getBullets().remove(i);
			}
		}
		
		status.tick();
	}

	@Override
	public void render(Graphics g) {
		mainBackground.render(g);
		player.render(g);
		stageScript.render(g);

		//Render player's bullets
		for(Bullet bullet: player.getBullets())
			bullet.render(g);
		sideBackground.render(g);
		status.render(g);
		
//		g.fillRect(0, 0, game.getWidth()/2, game.getHeight());
//		g.drawImage(Assets.background, 512, 0, null);
//		g.setFont(new Font("Consolas", Font.PLAIN, 30));
//		g.setColor(Color.WHITE);
//		g.drawString("Level " + currentLevel.toString(), 520, 50);
//		g.drawString("HP:", 520, 100);
//		g.drawString("PowerUp:", 520, 180);
//		g.drawString("*simbol-simbol", 520, 210);
//		g.drawString("Score:\n" + currentScore.toString(), 520, 300);
//		healthBarPanel = new JPanel();
//		healthBarPanel.setBounds(100, 15, 200, 30);
//		healthBarPanel.setBackground(Color.GREEN);
	}
	
}
