package com.stg.bcp.stageScript;

import java.awt.Graphics;
import java.util.List;
import com.stg.bcp.GameObject.object.Object;

public abstract class StageScript {
	
	protected List<Object> objects;
	
	public StageScript(List<Object> objects) {
		this.objects = objects;
	}
	
	public abstract void tick(); 
	
	public void render(Graphics g) {
		for(Object object: objects) {
			object.render(g);
		}
	}
}
