package com.stg.bcp.stageScript;

import java.awt.Color;
import java.awt.Graphics;
import com.stg.bcp.GameObject.Cursor;

public class GameOver extends StageScript{
	
	private Cursor cursor;
	
	public GameOver(Cursor cursor) {
		super(null, null, null);
		this.cursor = cursor;
	}
	
	public Cursor getCursor() {
		return cursor;
	}

	@Override
	public void tick() {
		cursor.tick();
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 768, 576);
		g.setColor(Color.WHITE);
		g.drawString("Retry", 384, 372);
		g.drawString("Quit", 384, 412);
		cursor.render(g);
	}
}
