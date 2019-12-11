package com.stg.bcp.stageScript;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import com.stg.bcp.GameObject.Cursor;
import com.stg.bcp.background.Background;
import com.stg.bcp.background.StaticBackground;
import com.stg.bcp.gfx.Assets;

public class MainMenu extends StageScript{
	
	private Background background = new StaticBackground(0, 0, Assets.mainmenu);
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
		background.render(g);
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Shooting Game", 200,100);
		
		Font font2= new Font("arial",Font.BOLD,30);
		g.setFont(font2);
		g.drawString("Play", 360, 330);
		g.drawString("Quit", 360, 370);
		cursor.render(g);
	}
}


