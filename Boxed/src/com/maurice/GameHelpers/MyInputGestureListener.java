package com.maurice.GameHelpers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maurice.GameObjects.Pin;
import com.maurice.GameWorld.GameWorld;

public class MyInputGestureListener implements GestureListener  {
	GameWorld world;
	private int pinRadius;
	private boolean isMoving=false;
	private Pin selectedPin=null;
	private int touchMargin=10;
	private int tileWidth;
	private int startRow;
	private int startColumn;
	private int endRow;
	private int endColumn;
	private float touchX;
	private float touchY;
    public MyInputGestureListener(GameWorld world ) {
    	this.world=world;
    	tileWidth=world.getTileWidth();
    	//this.pinRadius=world.getPinRadius();
    }
    
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		System.out.println("Swiped=="+velocityX);
		return false;
	}
	
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		startRow=(int) y/tileWidth;
		startColumn=(int) x/tileWidth;
		endRow=startRow;
		endColumn=startColumn;
		touchX=x;
		touchY=y;
		System.out.println("TouchStartPosiiton=="+touchX+"="+touchY);
		System.out.println("Start=="+startRow+"="+startColumn);
		world.highlight(startRow, startColumn);
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		world.unHighlightAll();
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}


	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		touchX+=deltaX;
		touchY+=deltaY;
		System.out.println("TouchPosiiton=="+touchX+"="+touchY);
		endColumn=(int) (touchX/tileWidth);
		endRow=(int) (touchY/tileWidth);
		System.out.println("end=="+endRow+"="+endColumn);
		world.unHighlightAll();
		world.highlightRect(startRow, startColumn, endRow, endColumn);
		/*ArrayList pins = world.getPins();
		if(selectedPin==null){			
			for (int i = 0; i < pins.size(); i++) {
				Pin c = (Pin) pins.get(i);
				if(((x<c.getPosition().x+pinRadius)&(x>c.getPosition().x-pinRadius))){
					if(((y<c.getPosition().y+pinRadius)&(y>c.getPosition().y-pinRadius))){
						selectedPin=c;
						break;
					}
				}
			}
		}*/
		//isMoving=true;
		/*if(selectedPin!=null){
			System.out.println("pin moved...!");
			System.out.println("PinPosiitonafter=="+selectedPin.getPosition().x+"="+selectedPin.getPosition().y);
			selectedPin.move(deltaX,deltaY);
			System.out.println("PinPosiitonafter=="+selectedPin.getPosition().x+"="+selectedPin.getPosition().y);
			System.out.println("Dragged=="+deltaX+"="+deltaY);
		}*/
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		System.out.println("PanStopped...!");
		world.testRect(startRow, startColumn, endRow, endColumn);
		world.unHighlightAll();
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

}
