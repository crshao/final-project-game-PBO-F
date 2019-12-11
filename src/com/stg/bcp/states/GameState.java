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
	private int counter, timer;
	
	public GameState(Game game) {
		super(game);
		initState();
	}
	
	private void initState() {
		player = new Player(game, 256, 512, 32, 32, Assets.player);
		stageScript = new Stage1(new ArrayList<>(), new ArrayList<>(), player);
		counter = 0;
		timer = 100;
		((Stage1) stageScript).getStatusScreen().setTimer(timer);
	}
	
	private void updateStage1() {
		if(player.getHealth() == 0 || timer == 0)
			stageScript = new GameOver(new Cursor(game, 360, 360, Assets.player));
	}
	
	private void updateGameOver() {
		if(((GameOver)stageScript).getCursor().getTag() == "Retry")
			initState();
		else if(((GameOver)stageScript).getCursor().getTag() == "Quit")
			game.setRunning(false);
	}
	
	private void secondPassed() {
		counter = 0;
		timer--;
		((Stage1) stageScript).getStatusScreen().setTimer(timer);
	}
	
	@Override
	public void tick() {
		stageScript.tick();
		
		if(stageScript instanceof Stage1) {
			counter++;
			if(counter == 60)
				secondPassed();
			updateStage1();
		}
			
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
