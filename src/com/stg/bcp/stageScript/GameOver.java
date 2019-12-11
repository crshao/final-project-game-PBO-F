package com.stg.bcp.stageScript;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import com.stg.bcp.GameObject.Cursor;

public class GameOver extends StageScript{
	
	private Cursor cursor;
	private int score;
	
	
	public GameOver(Cursor cursor, int score) {
		super(null, null, null);
		this.cursor = cursor;
		this.score = score;
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
		Font font = new Font("arial", Font.BOLD,30);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 768, 576);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 295, 240);
		
		Font font2 = new Font("arial", Font.BOLD,20);
		g.setFont(font2);
		g.drawString("Score : " + score, 310, 290);
		
		Font font3 = new Font("arial", Font.BOLD,15);
		g.setFont(font3);
		g.drawString("Retry", 384, 332);
		g.drawString("Main Menu", 384, 372);
		g.drawString("Quit", 384, 412);
		cursor.render(g);
	}
}
