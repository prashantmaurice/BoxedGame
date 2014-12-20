package com.maurice.Screens;


import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.maurice.GameWorld.GameRenderer;
import com.maurice.GameWorld.GameWorld;
import com.maurice.GameHelpers.MyInputGestureListener;
import com.maurice.boxed.MyBoxedGame;
import com.badlogic.gdx.graphics.Pixmap;

public class TransitionScreen implements Screen {
	 

	public final static float screenWidth = Gdx.graphics.getWidth();
    public final static float screenHeight = Gdx.graphics.getHeight();
 
    private Game game;
    private Screen current;
    private Screen next;
 
    private FrameBuffer currentBuffer;
    private FrameBuffer nextBuffer;
 
    private SpriteBatch spriteBatch;
    private TweenManager manager;
    private TweenCallback backgroundAnimationTweenComplete;
 
    private Sprite currentScreenSprite;
    private Sprite nextScreenSprite;
 
    public TransitionScreen(Screen current, Screen next, Game game)
    {
        this.current = current;
        this.next = next;
        this.game = game;
    }
 
    @Override
    public void render(float delta)
    {
        manager.update(Gdx.graphics.getDeltaTime());
 
        spriteBatch.begin();
        currentScreenSprite.draw(spriteBatch);
        nextScreenSprite.draw(spriteBatch);
        spriteBatch.end();
 
    }
 
    @Override
    public void show()
    {
        spriteBatch = new SpriteBatch();
 
        manager = new TweenManager();
        //Tween.registerAccessor(Sprite.class, new SpriteTween());
 
        backgroundAnimationTweenComplete = new TweenCallback()
        {
            @Override
            public void onEvent(int type, BaseTween<?> source)
            {
                game.setScreen(next);
            };

		};
        
    	
 
        nextBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, (int)screenWidth, (int)screenHeight, false);
 
        nextBuffer .begin();
        next.render(Gdx.graphics.getDeltaTime());
        nextBuffer .end();
 
        nextScreenSprite = new Sprite(nextBuffer .getColorBufferTexture());
        nextScreenSprite.setPosition(screenWidth, 0);
        nextScreenSprite.flip(false, true);
 
        currentBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, (int)screenWidth, (int)screenHeight, false);
        currentBuffer .begin();
        current.render(Gdx.graphics.getDeltaTime());
        currentBuffer .end();
 
        currentScreenSprite = new Sprite(currentBuffer.getColorBufferTexture());
        currentScreenSprite.setPosition(0, 0);
        currentScreenSprite.flip(false, true);
    }
 
    @Override
    public void resume()
    {
        //Tween.to(nextScreenSprite, SpriteTween.POS_XY, 1.0f)
          //      .target(0, 0)
          //      .setCallback(backgroundAnimationTweenComplete)
          //      .setCallbackTriggers(TweenCallback.COMPLETE)
          //      .start(manager);
    }

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}