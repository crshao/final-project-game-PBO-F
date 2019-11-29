package com.stg.bcp.states;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.background.Background;
import com.stg.bcp.background.MovingBackground;
import com.stg.bcp.background.StaticBackground;
import com.stg.bcp.gfx.Assets;
import org.w3c.dom.*;

public class GameState extends State {
	private Player player;
	private Background mainBackground, sideBackground;
	
	public GameState(Game game) {
		super(game);
		initState();
	}
	
	private void initState() {
		player = new Player(game, 256, 512);
		mainBackground = new MovingBackground(-256, 0, 1, Assets.level);
		sideBackground = new StaticBackground(512, 0, Assets.background);
	}
	
	@Override
	public void tick() {
		player.tick();
		mainBackground.tick();
		
		//Update Player Bullet
		for(Bullet bullet: player.getBullets()) {
			bullet.tick();
		}
		for(int i=0; i<player.getBullets().size(); i++) {
			Bullet bullet = player.getBullets().get(i);
			if(!bullet.getExist()) {
				System.out.println("Removed!"); //To be removed
				player.getBullets().remove(i);
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		mainBackground.render(g);
		player.render(g);
		
		for(Bullet bullet: player.getBullets()) {
			bullet.render(g);
		}
		
		sideBackground.render(g);
		g.setFont(new Font("Consolas", Font.PLAIN, 50));
		g.drawString("Hello PBO", 512, 150);
	}
	
}
