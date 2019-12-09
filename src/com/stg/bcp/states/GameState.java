package com.stg.bcp.states;

import java.awt.*;
import java.util.ArrayList;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.Cursor;
import com.stg.bcp.GameObject.object.Player;
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
	
	private void updateStage1() {
		if(player.getHealth() == 0)
			stageScript = new GameOver(new Cursor(game, 360, 360, Assets.player));
	}
	
	private void updateGameOver() {
		if(((GameOver)stageScript).getCursor().getTag() == "Retry") {
			player = new Player(game, 256, 512, 32, 32, Assets.player);
			stageScript = new Stage1(new ArrayList<>(), new ArrayList<>(), player);
		}
		else if(((GameOver)stageScript).getCursor().getTag() == "Quit") {
			game.setRunning(false);
		}
	}
	
	@Override
	public void tick() {
		stageScript.tick();
		
		if(stageScript instanceof Stage1)
			updateStage1();
		if(stageScript instanceof GameOver) {
			if(game.getKeyManager().enter)
				updateGameOver();
		}
	}

	@Override
	public void render(Graphics g) {
		stageScript.render(g);
	}
	
}
