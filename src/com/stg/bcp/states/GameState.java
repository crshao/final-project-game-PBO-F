package com.stg.bcp.states;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import com.stg.bcp.Game;
import com.stg.bcp.GameObject.object.Bullet;
import com.stg.bcp.GameObject.object.Player;
import com.stg.bcp.gfx.Assets;
import org.w3c.dom.*;

public class GameState extends State {
	private Player player;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game, 256, 512);
	}
	
	@Override
	public void tick() {
		player.tick();
		
		List<Bullet> bullets = new ArrayList<>();
		bullets.addAll(player.getBullets());
		for(Bullet bullet: bullets) {
			bullet.tick();
		}
		
		// Update Bullet
		for(int i=0; i<bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if(!bullet.getExist()) {
				bullets.remove(i);
			}
				
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, game.getWidth()/2, game.getHeight());
		g.drawImage(Assets.background, 512, 0, null);

		g.setFont(new Font("Consolas", Font.PLAIN, 50));
		g.drawString("Hello PBO", 512, 150);


		player.render(g);
		
		List<Bullet> bullets = new ArrayList<>();
		bullets.addAll(player.getBullets());
		for(Bullet bullet: bullets) {
				bullet.render(g);
		}
	}
	
}
