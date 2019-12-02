package com.stg.bcp.gfx;

import java.awt.image.BufferedImage;
import com.stg.bcp.gfx.ImageLoader;
import com.stg.bcp.gfx.SpriteSheet;

public class Assets {

	private static final int width = 16, height = 16;
	
	public static BufferedImage
		background, level,
		bullet_01, bullet_02,bullet_03,
		player,
		enemy1, enemy2,enemy3,
		beam1;
	
	public static void init() {
		background = ImageLoader.loadImage("/textures/background.png");
		level = ImageLoader.loadImage("/textures/level.png");
		bullet_01 = ImageLoader.loadImage("/textures/bullet01.png");
		bullet_02 = ImageLoader.loadImage("/textures/bullet02.png");
		bullet_03 = ImageLoader.loadImage("/textures/bullet03.png");
		enemy1 = ImageLoader.loadImage("/textures/enemy1.png");
		enemy2 = ImageLoader.loadImage("/textures/enemy2.png");
		enemy3 = ImageLoader.loadImage("/textures/enemy3.png");
		beam1 = ImageLoader.loadImage("/textures/beam1.png");
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		player = sheet.crop(0, 0, width, height);
	}
	
}
