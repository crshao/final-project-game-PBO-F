package com.stg.bcp.states;

import java.awt.*;
import java.util.ArrayList;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.Cursor_GameOver;
import com.stg.bcp.GameObject.Cursor_MainMenu;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.gfx.Assets;
import com.stg.bcp.stageScript.GameOver;
import com.stg.bcp.stageScript.MainMenu;
import com.stg.bcp.stageScript.Stage1;
import com.stg.bcp.stageScript.StageScript;

public class GameState extends State {
	private Player player;
	private StageScript stageScript;
	private int counter, timer;
	private boolean buttonPressed;
	
	public GameState(Game game) {
		super(game);
		buttonPressed = false;
		startMainMenu();
	}
	
	private void startMainMenu() {
		stageScript = new MainMenu(new Cursor_MainMenu(game, 340, 310, Assets.player));
	}
	
	private void startStage1() {
		player = new Player(game, 256, 512, 32, 32, Assets.player);
		stageScript = new Stage1(new ArrayList<>(), new ArrayList<>(), player);
		counter = 0;
		timer = 100;
		((Stage1) stageScript).getStatusScreen().setTimer(timer);
	}
	
	private void updateMainMenu() {
		if(((MainMenu)stageScript).getCursor().getTag() == "Play")
			startStage1();
		else if(((MainMenu)stageScript).getCursor().getTag() == "Quit")
			System.exit(0);
	}
	
	private void updateStage1() {
		if(player.getHealth() == 0 || timer == 0)
			stageScript = new GameOver(new Cursor_GameOver(game, 345, 320, Assets.player), stageScript.getPlayer().getScore());
	}
	
	private void updateGameOver() {
		if(((GameOver)stageScript).getCursor().getTag() == "Retry")
			startStage1();
		else if(((GameOver)stageScript).getCursor().getTag() == "Main Menu")
			startMainMenu();
		else if(((GameOver)stageScript).getCursor().getTag() == "Quit")
			System.exit(0);
	}
	
	private void secondPassed() {
		counter = 0;
		timer--;
		((Stage1) stageScript).getStatusScreen().setTimer(timer);
	}
	
	@Override
	public void tick() {
		stageScript.tick();
		
		
		if(stageScript instanceof MainMenu) {
			if(game.getKeyManager().enter && !buttonPressed) {
				updateMainMenu();
				buttonPressed = true;
			}
			if(!game.getKeyManager().enter)
				buttonPressed = false;
		}
		if(stageScript instanceof Stage1) {
			counter++;
			if(counter == 60)
				secondPassed();
			updateStage1();
		}
		if(stageScript instanceof GameOver) {
			if(game.getKeyManager().enter) {
				updateGameOver();
				buttonPressed = true;
			}
			if(!game.getKeyManager().enter)
				buttonPressed = false;
		}
	}

	@Override
	public void render(Graphics g) {
		stageScript.render(g);
	}
	
}
