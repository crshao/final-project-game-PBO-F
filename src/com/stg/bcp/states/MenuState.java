package com.stg.bcp.states;

import java.awt.Color;
import java.awt.Graphics;
import com.stg.bcp.Game;
import com.stg.bcp.states.State;

public class MenuState extends State {
	
	public MenuState(Game game) {
		super(game);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
	}

}
