package com.stg.bcp.gfx;

import java.awt.image.BufferedImage;
import com.stg.bcp.gfx.ImageLoader;
import com.stg.bcp.gfx.SpriteSheet;

public class Assets {

	private static final int width = 16, height = 16;
	
	public static BufferedImage
		background, level,
		bullet_01,
		fireball,
		player,
		enemy1;
	
	public static void init() {
		background = ImageLoader.loadImage("/textures/background.png");
		level = ImageLoader.loadImage("/textures/level.png");
		bullet_01 = ImageLoader.loadImage("/textures/bullet_01.png");
		enemy1 = ImageLoader.loadImage("/textures/enemy1.png");
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		player = sheet.crop(0, 0, width, height);
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/fireball.png"));
		fireball = sheet.crop(0, 0, width, height);
	}
	
}
