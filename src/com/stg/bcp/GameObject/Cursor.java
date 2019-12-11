package com.stg.bcp.GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.stg.bcp.Game;

public abstract class Cursor {
	
	protected int x, y, choice;
	protected BufferedImage image;
	protected Game game;
	protected String tag;
	
	public Cursor(Game game, int x, int y, BufferedImage image) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.image = image;
	}
	
	protected abstract void initCursor();
	
	public String getTag() {
		return tag;
	}

	public abstract void tick();
	
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	
}
