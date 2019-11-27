package com.stg.bcp.GameObject.object;

import com.stg.bcp.GameObject.GameObject;;

public abstract class Bullet extends GameObject{
	
	protected boolean exist;
	
	public Bullet(float x, float y) {
		super(x, y);
		exist = true;
	}
	
	public boolean getExist() {
		return exist;
	}
}