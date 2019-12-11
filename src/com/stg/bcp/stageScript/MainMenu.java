package com.stg.bcp.stageScript;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.stg.bcp.GameObject.Cursor;
import com.stg.bcp.background.StaticBackground;
import com.stg.bcp.gfx.Assets;

public class MainMenu extends StageScript{
	
	StaticBackground a = new StaticBackground(100,200,Assets.mainmenu);
	private Cursor cursor;
	
	public MainMenu(Cursor cursor) {
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
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Shooting Game", 200,100);
		
		Font font2= new Font("arial",Font.BOLD,30);
		g.setFont(font2);
		g.drawString("Play", 384, 372);
		g.drawString("Quit", 384, 412);
		cursor.render(g);
	}
}

