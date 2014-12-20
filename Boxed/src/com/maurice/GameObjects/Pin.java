package com.maurice.GameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Pin {
	private Vector2 position;
	//private int radius=30;
	private boolean isHighlight=false;
	
	public Pin(float x, float y) {
		position = new Vector2(x, y);
		System.out.println("pin created at="+x+"="+y);
	}
	public void update(){
	}
	public Vector2 getPosition(){
		return position;
	}
	public void setPosition(int x, int y){
		position.x=x;
		position.y=y;
	}
//	public int getRadius(){
//		return radius;
//	}
	public void move(float deltaX, float deltaY) {
		position.x+=deltaX;
		position.y+=deltaY;
	}
	public boolean isHighlight() {
		return isHighlight;
	}
	public void setHighlight(boolean isHighlight) {
		this.isHighlight = isHighlight;
	}

}
