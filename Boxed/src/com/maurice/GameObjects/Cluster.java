package com.maurice.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Cluster {
	private Vector2 position;
	//private Vector2 velocity;
	private int type=1 ;
	//private float velocity1=10;
	private int radiusOut=10;
	private int radiusIn=10;
	private boolean isAlive=true;
	private int timeAlive=300;
	
	
	public Cluster(float x, float y,  int type) {
		position = new Vector2(x, y);
		setAlive(true);
		this.radiusOut=140;
		this.radiusOut=70;
		this.type=type;
	}
	public void update(){
		timeAlive--;
		radiusOut+=4;
		radiusIn+=8;
	}
	public boolean isAlive() {
		if(timeAlive<=0) isAlive=false;
		if(radiusOut<=radiusIn) isAlive=false;
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public Vector2 getPosition(){
		return position;
	}
	public int getOutRadius(){
		return radiusOut;
	}
	public int getInRadius(){
		return radiusIn;
	}
	public int getType(){
		return type;
	}

}
