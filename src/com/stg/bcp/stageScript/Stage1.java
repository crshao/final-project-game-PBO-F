package com.stg.bcp.stageScript;

import java.util.List;
import java.util.Random;
import com.stg.bcp.GameObject.object.Object;
import com.stg.bcp.GameObject.object.Enemy1;
import com.stg.bcp.gfx.Assets;

public class Stage1 extends StageScript{
	
	private Random rand = new Random();
	private int delay, counter;
	
	public Stage1(List<Object> objects) {
		super(objects);
		initStage();
	}
	
	public void initStage() {
		delay = 300;
		counter = 4;
		for(int i=0; i<counter; i++)
			objects.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1, 100));
	}
	
	@Override
	public void tick() {
		for(Object object: objects) {
			object.tick();
		}
		for(int i=0; i<objects.size(); i++) {
			Object object = objects.get(i);
			if(!object.getExist())
				objects.remove(i);
		}
		
		delay--;
		if(delay == 0) {
			delay = rand.nextInt(600) + 300;
			counter = rand.nextInt(4) + 1;
			for(int i=0; i<counter; i++)
				objects.add(new Enemy1(rand.nextInt(256) + 128, -48, Assets.enemy1, 100));
		}
	}
}
