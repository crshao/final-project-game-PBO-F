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
import com.stg.bcp.stageScript.GameOver;
import com.stg.bcp.stageScript.Stage1;
import com.stg.bcp.stageScript.StageScript;

public class GameState extends State {
	private Player player;
	private StageScript stageScript;
	
	public GameState(Game game) {
		super(game);
		initState();
	}
	
	private void initState() {
		player = new Player(game, 256, 512, 32, 32, Assets.player);
		stageScript = new Stage1(new ArrayList<>(), new ArrayList<>(), player);
	}
	
	private void updateScreen() {
		if(player.getHealth() == 0)
			stageScript = new GameOver();
	}
	
	@Override
	public void tick() {
		stageScript.tick();
		updateScreen();
	}

	@Override
	public void render(Graphics g) {
		stageScript.render(g);
	}
	
}
