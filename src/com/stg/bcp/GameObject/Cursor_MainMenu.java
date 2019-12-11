package com.stg.bcp.GameObject;

import java.awt.image.BufferedImage;
import com.stg.bcp.Game;

public class Cursor_MainMenu extends Cursor{
	
	//Atur Batas Atas dan Bawah
	private static final int
	upperLimitY = 0,
	lowerLimitY = 576;
	
	public Cursor_MainMenu(Game game, int x, int y, BufferedImage image) {
		super(game, x, y, image);
		initCursor();
	}

	@Override
	protected void initCursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
