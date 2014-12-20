package com.maurice.GameObjects;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Tile {
	private Vector2 position;
	private int type;
	private boolean isOriginal=false;
	private boolean isSelected=false;
	
	public Tile(int x, int y, Boolean original, int type) {//x and y are [row,column] and also send if it is one of original tiles
		position = new Vector2(x, y);
		
		this.setType(type);
		this.isOriginal=original;
		//System.out.println("Tile created at="+x+"="+y);
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
		//position.x+=deltaX;
		//position.y+=deltaY;
	}
	public boolean isOriginal() {
		return isOriginal;
	}
	public void setOriginal(boolean isOriginal) {
		this.isOriginal = isOriginal;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}


}
