package com.stg.bcp.background;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.stg.bcp.GameObject.object.Player;

public class StatusScreen {
	
	private int health, score;
	private Player player;
	
	public StatusScreen(Player player) {
		this.player = player;
	}
	
	public void tick() {
		health = player.getHealth();
		score = player.getScore();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Consolas", Font.PLAIN, 32));
		
		//Draw String
		g.drawString("Health", 520, 128);
		g.drawString("Score: " + score, 520, 32);
		
		//Draw Health
		g.drawRect(520, 132, 102, 28);
		g.setColor(Color.GREEN);
		g.fillRect(521, 133, health * 10, 26);
	}
	
}
