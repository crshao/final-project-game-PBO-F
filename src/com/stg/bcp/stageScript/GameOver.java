package com.stg.bcp.stageScript;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import com.stg.bcp.GameObject.Cursor;
import com.stg.bcp.Score.Score;
import com.stg.bcp.Score.ScoreComparator;

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
		g.drawString("Leaderboard:", 295, 50);


		
		Font font2 = new Font("arial", Font.BOLD,20);
		g.setFont(font2);
		g.drawString("Score : " + score, 340, 290);
		
		Font font3 = new Font("arial", Font.BOLD,15);
		g.setFont(font3);
		g.drawString("Retry", 365, 332);
		g.drawString("Main Menu", 365, 372);
		g.drawString("Quit", 365, 412);
		cursor.render(g);
	}
}
