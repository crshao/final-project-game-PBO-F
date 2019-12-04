package com.stg.bcp.states;

import java.awt.*;
import java.util.ArrayList;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.background.Background;
import com.stg.bcp.background.MovingBackground;
import com.stg.bcp.background.StaticBackground;
import com.stg.bcp.gfx.Assets;
import com.stg.bcp.stageScript.Stage1;
import com.stg.bcp.stageScript.StageScript;

import javax.swing.*;

public class GameState extends State {
	private Player player;
	private Background mainBackground, sideBackground;
	private StageScript stageScript = new Stage1(new ArrayList<>(), new ArrayList<>());

//	public JPanel healthBarPanel;
	
	public GameState(Game game) {
		super(game);
		initState();
	}
	
	private void initState() {
		player = new Player(game, 256, 512);
		mainBackground = new MovingBackground(-256, -864, 4, Assets.level);
		sideBackground = new StaticBackground(512, 0, Assets.background);
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
			if(!bullet.getExist()) {
				player.getBullets().remove(i);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		mainBackground.render(g);
		player.render(g);
		stageScript.render(g);

		//Render player's bullets
		for(Bullet bullet: player.getBullets())
		{
			bullet.render(g);
		}
		sideBackground.render(g);
//		g.fillRect(0, 0, game.getWidth()/2, game.getHeight());
//		g.drawImage(Assets.background, 512, 0, null);
		g.setFont(new Font("Consolas", Font.PLAIN, 30));
		g.setColor(Color.WHITE);
		g.drawString("HP:", 520, 25);

//		healthBarPanel = new JPanel();
//		healthBarPanel.setBounds(100, 15, 200, 30);
//		healthBarPanel.setBackground(Color.GREEN);
	}
	
}
