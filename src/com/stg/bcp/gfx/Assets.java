package com.stg.bcp.gfx;

import java.awt.image.BufferedImage;
import com.stg.bcp.gfx.ImageLoader;

public class Assets {
	
	public static BufferedImage
		background, level,
		bullet_01, bullet_02,bullet_03,
		player,
		enemy1, enemy2,enemy3,
		beam1,
		powerUp,mainmenu;
	
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
		player = ImageLoader.loadImage("/textures/player.png");
		powerUp = ImageLoader.loadImage("/textures/powerUp.png");
		mainmenu = ImageLoader.loadImage("/textures/space.png");
	}
	
}
