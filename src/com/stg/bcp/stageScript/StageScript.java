package com.stg.bcp.stageScript;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

import com.stg.bcp.GameObject.GameObject;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.GameObject.object.Player;

public abstract class StageScript {
	
	protected List<Object> objects;
	
	public StageScript(List<Object> objects) {
		this.objects = objects;
	}
	
	public void checkCollision(Object collision) {
		Rectangle r1 = collision.getBounds();
		
		for(Object object: objects) {
			Rectangle r2 = object.getBounds();
			
			if(r1.intersects(r2)) {
				collision.damageHealth(1);
				object.damageHealth(1);
			}
		}
	}
	
	public abstract void tick(); 
	
	public void render(Graphics g) {
		for(Object object: objects) {
			object.render(g);
		}
	}
}
