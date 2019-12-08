package com.stg.bcp.stageScript;

import java.awt.Color;
import java.awt.Graphics;

public class GameOver extends StageScript{

	public GameOver() {
		super(null, null, null);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 768, 512);
	}
}
