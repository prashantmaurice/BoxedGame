package com.maurice.GameObjects;

import com.badlogic.gdx.graphics.Color;

public class ConnectLine{
	public int a;
	public int b;
	public Color color;
	public ConnectLine(int a, int b){
		this.a=a;
		this.b=b;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
