package com.maurice.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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

public class FinishedScreen implements Screen {
	 

    MyBoxedGame game; // Note it's "GyroGame" not "Game"
    private SpriteBatch batch;
    private BitmapFont font;
    float screenWidth;
    float screenHeight;
    int yourScore;
    int highScore;
    private int score=0;//useful for final display of score only
    
    private static final String PREFS_NAME = "user";
    
    
    // constructor to keep a reference to the main Game class
     public FinishedScreen(MyBoxedGame myBoxedGame){
            this.game = myBoxedGame;
            //yourScore=game.gameScreen.getScore();
            yourScore=10;
            System.out.println("text");
            screenWidth = Gdx.graphics.getWidth();
     		screenHeight = Gdx.graphics.getHeight();
     		batch = new SpriteBatch();  //text display
            font = new BitmapFont(Gdx.files.internal("data/devgothic.fnt"));
            font.setColor(Color.GRAY);
            font.setScale((float) 1);
            //Preferences prefs = Gdx.app.getPreferences( "user" );
            //prefs.putInteger( "Hisg", 1000 );
            //highscore=prefs.getInteger("high1");
     }
     public void updateScores(){
    	 Preferences prefs = Gdx.app.getPreferences( PREFS_NAME );
    	 prefs.putInteger( "high1", 1000 );
    	 getPrefs().flush();
    	 highScore=prefs.getInteger("high1");
    	 System.out.println("high1="+highScore);
    	 getPrefs().putInteger( "high2", 23 );
         getPrefs().flush();
    	 System.out.println("high2="+getPrefs().getInteger( "high2", 0 ));
    	 if(highScore>yourScore){
    		 highScore=yourScore;
    		 prefs.putInteger( "high1", yourScore );
    	 }
     }
     protected Preferences getPrefs(){
         return Gdx.app.getPreferences( PREFS_NAME );
     }
     
     @Override
     public void render(float delta) {
             // update and draw stuff
    	 //score=game.gameScreen.getScore();
    	 //yourScore="YOURSCORE = "+score;
    	 //highScoreline="HIGHSCORE = "+highScore;
    	 
          if (Gdx.input.justTouched()) // use your own criterion here
              {
        	  	//game.quitGame();
        	  	//game.setScreen(new GameScreen(game));
        	  	//System.out.println("quitGame");
              }
          Gdx.gl.glClearColor(220, 220, 220, 1);
          Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
          //add score
          batch.begin();
          font.draw(batch, "PLANARITY", 10, screenHeight-20);
          font.draw(batch, "CONGOS YOU FINISHED ALL LEVEL "+game.getLevel(), 10, screenHeight-80);//text display
          //font.draw(batch, "YOUR SCORE="+yourScore, 10, screenHeight-120);//text display
          //font.draw(batch, "HIGHSCORE="+highScore, 10, screenHeight-160);
          //font.draw(batch, "TAP SCREEN TO QUIT GAME", 10, screenHeight/2);//text display
          font.draw(batch, "DESIGNED BY : MAURICE", 10, (screenHeight/2)-40);//text display
          batch.end();
     }
     public void setScore(int score){
    	 this.score=score;
     }

    @Override
     public void resize(int width, int height) {
     }


    @Override
     public void show() {
    	updateScores();
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
}