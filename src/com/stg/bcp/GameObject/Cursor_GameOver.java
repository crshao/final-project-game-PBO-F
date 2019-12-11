package com.stg.bcp.GameObject;

import java.awt.image.BufferedImage;
import com.stg.bcp.Game;

public class Cursor_GameOver extends Cursor {

	private static final int
		upperLimitY = 320,
		lowerLimitY = 400;
	private boolean buttonPressed;
	
	public Cursor_GameOver(Game game, int x, int y, BufferedImage image) {
		super(game, x, y, image);
		initCursor();
	}
	
	@Override
	protected void initCursor() {
		choice = 1;
		tag = "Retry";
		buttonPressed = false;
	}
	
	@Override
	public void tick() {
		getInput();
		setTag();
	}
	
	private void getInput() {
		if((game.getKeyManager().up || game.getKeyManager().up2) &&
				y > upperLimitY && !buttonPressed) {
			y -= 40;
			choice--;
			buttonPressed = true;
		}
		else if((game.getKeyManager().down || game.getKeyManager().down2) &&
				y < lowerLimitY && !buttonPressed) {
			y += 40;
			choice++;
			buttonPressed = true;
		}
		else if(!(game.getKeyManager().down || game.getKeyManager().down2) &&
				!(game.getKeyManager().up || game.getKeyManager().up2))
			buttonPressed = false;
	}
	
	private void setTag() {
		if(choice == 1)
			tag = "Retry";
		if(choice == 2)
			tag = "Main Menu";
		if(choice == 3)
			tag = "Quit";
	}

}
