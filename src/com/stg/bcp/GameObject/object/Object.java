package com.stg.bcp.GameObject.object;

import com.stg.bcp.GameObject.GameObject;

public abstract class Object extends GameObject{
	
	protected int health;
	
	public Object(float x, float y) {
		super(x, y);
		health = 10;
	}
	
}
