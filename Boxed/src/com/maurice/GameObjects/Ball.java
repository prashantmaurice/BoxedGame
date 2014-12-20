package com.maurice.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
	private Vector2 position;
	private Vector2 velocity;
	private int type=1 ;
	private float velocity1=10;
	private int radius=10;
	private boolean isAlive=true;
	
	
	public Ball(float x, float y, int velX, int velY, int type, int radius) {
		position = new Vector2(x, y);
		velocity = new Vector2(velX, velY);
		setAlive(true);
		this.radius=radius;
		this.type=type;
	}
	public void update(){
		position.x+=velocity.x/15;
		position.y+=velocity.y/15;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public Vector2 getPosition(){
		return position;
	}
	public int getRadius(){
		return radius;
	}
	public int getType(){
		return type;
	}

}
