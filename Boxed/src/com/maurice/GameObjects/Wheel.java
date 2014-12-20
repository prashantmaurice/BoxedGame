package com.maurice.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Wheel {
	private Vector2 position;
	private float direction=0;
	private int velocity=0;
	int radius=100;
	private int centerCircle=50;
	private int fullHealth=50;
	private int health1=50;
	private int health2=50;
	private int health3=50;
	private int[] health=new int[]{health1,health2,health3};
	
	private Circle boundingCircle;
	public Wheel(int x,int y){

        position = new Vector2(x, y);
        boundingCircle = new Circle(x,y,radius);
	}
	public void update(float delta) {
		float temp=getDirection() - (velocity*delta);
		if(temp<0) temp=(temp+720)%360;
		if(temp>=360) temp=(temp-360)%360;
		setDirection(temp);
	}
	public float getDirection() {
		return direction;
	}
	public void setDirection(float direction) {
		this.direction = direction;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public int[] getHealth() {
		return health;
	}
	public int getRadius() {
		return radius;
	}
	public int getCenterRadius() {
		return centerCircle;
	}
	public int getFullHealth() {
		return fullHealth;
	}

}
