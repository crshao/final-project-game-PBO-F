package com.stg.bcp.states;

import java.awt.Color;
import java.awt.Graphics;
import com.stg.bcp.Game;
import com.stg.bcp.states.State;

public class MenuState extends State {
	
	public MenuState(Game game) {
		super(game);
		
		initState();
	}
	
	private void initState() {
		
	}
	
	@Override
	public void tick() {
//		delay++;
//		if(delay == 120) {
//			delay = 0;
//			State.getState().setState(gameState);
//		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
	}

}
