package com.stg.bcp.states;

import java.awt.Graphics;
import com.stg.bcp.Game;

public abstract class State {

	private static State currentState = null;
	private boolean toMenu, toLevel1, toGameOver;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
		
		initState();
	}
	
	private void initState() {
		toMenu = false;
		toLevel1 = false;
		toGameOver = false;
	}
	
	public boolean isToMenu() {
		return toMenu;
	}

	public void setToMenu(boolean toMenu) {
		this.toMenu = toMenu;
	}

	public boolean isToLevel1() {
		return toLevel1;
	}

	public void setToLevel1(boolean toLevel1) {
		this.toLevel1 = toLevel1;
	}

	public boolean isToGameOver() {
		return toGameOver;
	}

	public void setToGameOver(boolean toGameOver) {
		this.toGameOver = toGameOver;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
