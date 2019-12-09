package com.stg.bcp.GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.stg.bcp.Game;

public class Cursor {
	
	private int x, y;
	private static final int
		upperLimitY = 360,
		lowerLimitY = 400;
	private BufferedImage image;
	private Game game;
	private String tag;
	
	public Cursor(Game game, int x, int y, BufferedImage image) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.image = image;
		tag = "Retry";
	}
	
	public String getTag() {
		return tag;
	}

	public void tick() {
		if((game.getKeyManager().up || game.getKeyManager().up2) &&
				y > upperLimitY) {
			y -= 40;
			tag = "Retry";
		}
			
		if((game.getKeyManager().down || game.getKeyManager().down2) &&
				y < lowerLimitY) {
			y += 40;
			tag = "Quit";
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	
}
