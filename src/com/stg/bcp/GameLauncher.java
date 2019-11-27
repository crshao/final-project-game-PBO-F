package com.stg.bcp;

import com.stg.bcp.Game;

public class GameLauncher {

	public static void main(String[] args) {
		Game game = new Game("Tile Game!", 768, 576);
		game.start();
	}

}
