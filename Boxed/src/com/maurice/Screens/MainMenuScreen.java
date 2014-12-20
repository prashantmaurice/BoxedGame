package com.maurice.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;
import com.maurice.GameWorld.GameRenderer;
import com.maurice.GameWorld.GameWorld;
import com.maurice.GameHelpers.MyInputGestureListener;
import com.maurice.boxed.MyBoxedGame;

public class MainMenuScreen implements Screen {
	 

    MyBoxedGame game; // Note it's "GyroGame" not "Game"
    private SpriteBatch batch;
    private BitmapFont font;
    float screenWidth;
    float screenHeight;
    // constructor to keep a reference to the main Game class
     public MainMenuScreen(MyBoxedGame myBoxedGame){
            this.game = myBoxedGame;
            System.out.println("text");
            screenWidth = Gdx.graphics.getWidth();
     		screenHeight = Gdx.graphics.getHeight();
     		batch = new SpriteBatch();  //text display
            font = new BitmapFont(Gdx.files.internal("data/devgothic.fnt"));
            font.setColor(Color.WHITE);
     }
     
     @Override
     public void render(float delta) {
             // update and draw stuff
          if (Gdx.input.justTouched()) // use your own criterion here
              {
        	  	game.setGameScreen();
        	  	System.out.println("just touched....!");
              }
          Color bgcolor=colorFromHex(0x3366FF);
          Gdx.gl.glClearColor(bgcolor.r, bgcolor.g, bgcolor.b, 1);
          Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
          //add score
          batch.begin();
          font.setScale((float) 3);
          font.draw(batch, "BOXED", 10, screenHeight-60);
          font.setScale((float) 1);
          font.draw(batch, "TAP SCREEN TO START GAME", 10, screenHeight/4);//text display
          font.draw(batch, "DESIGNED BY : MAURICE", 10, (screenHeight/4)-40);//text display
          batch.end();
     }


    @Override
     public void resize(int width, int height) {
     }
    


    @Override
     public void show() {
          // called when this screen is set as the screen with game.setScreen();
    	System.out.println("mainmenu screen set");
     }


    @Override
     public void hide() {
          // called when current screen changes from this to a different screen
     }


    @Override
     public void pause() {
     }


    @Override
     public void resume() {
     }


    @Override
     public void dispose() {
             // never called automatically
     }
	private Color colorFromHex(long hex){
        //float a = (hex & 0xFF000000L) >> 24;
        float r = (hex & 0xFF0000L) >> 16;
        float g = (hex & 0xFF00L) >> 8;
        float b = (hex & 0xFFL);
                        
        return new Color(r/255f, g/255f, b/255f, 255f/255f);
	}
}