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

public class RestartScreen implements Screen {
	 

    MyBoxedGame game; // Note it's "GyroGame" not "Game"
    private SpriteBatch batch;
    private BitmapFont font;
    float screenWidth;
    float screenHeight;
    int yourScore=0;
    int highScore=2000;
    
    public String PREF_DATA="user";
    Preferences prefs;
    //String highScoreline;
    //private int score=0;//useful for final display of score only
    // constructor to keep a reference to the main Game class
     public RestartScreen(MyBoxedGame myBoxedGame){
            this.game = myBoxedGame;
            yourScore=game.getYourScore();
            System.out.println("text");
            screenWidth = Gdx.graphics.getWidth();
     		screenHeight = Gdx.graphics.getHeight();
     		batch = new SpriteBatch();  //text display
            font = new BitmapFont(Gdx.files.internal("data/devgothic.fnt"));
            font.setColor(Color.WHITE);
            font.setScale((float) 1);
            
            Preferences prefs = Gdx.app.getPreferences(PREF_DATA);
            //prefs.putInteger( "high1", 1000 );
            //prefs.flush();
            highScore=prefs.getInteger("high1");
            if(highScore==0){
                prefs.putInteger( "high1", 1000 );//useful to create default highscore aftre fresh installation
                prefs.flush();
            }
   
     }
     
     @Override
     public void render(float delta) {
             // update and draw stuff
    	 //score=game.gameScreen.getScore();
    	 //yourScore="YOURSCORE = "+score;
    	 //if(gigh)
    	 //highScoreline="HIGHSCORE = "+highScore;
    	 //yourScore=game.getYourScore();
          if (Gdx.input.justTouched()) // use your own criterion here
              {
        	  	//game.gameScreen.setScore(0);
        	  	//game.setLevel(game.getLevel()+1);
        	  	//game.nextLevel();
        	  	game.setNewGameScreen();
        	  	//game.setScreen(new GameScreen(game));
        	  	System.out.println("just touched....!");
              }
          Color bgcolor=colorFromHex(0x3366FF);
          Gdx.gl.glClearColor(bgcolor.r, bgcolor.g, bgcolor.b, 1);
          Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
          //add score
          batch.begin();
          font.setScale((float) 3);
          font.draw(batch, "BOXED", 10, screenHeight-20);
          font.setScale((float) 1);
          font.draw(batch, "CONGOS YOU R A STUDD "+game.getLevel(), 10, screenHeight/2+80);//text display
          font.draw(batch, "YOUR TIME = "+timeString(yourScore)+"secs", 10, screenHeight/2);//text display
          font.draw(batch, "BEST TIME = "+timeString(highScore)+"secs", 10, screenHeight/2-40);
          font.draw(batch, "TAP SCREEN TO START NEW PUZZLE", 10, screenHeight/4);//text display
          font.draw(batch, "DESIGNED BY : MAURICE", 10, (screenHeight/4)-40);//text display
          batch.end();
     }
     public void setScore(int score){
    	 this.yourScore=score;
     }
     public void checkHighScore(){
    	 if(highScore>yourScore){
         	highScore=yourScore;
         	prefs = Gdx.app.getPreferences(PREF_DATA);
         	prefs.putInteger( "high1", yourScore );
         	prefs.flush();
         }
     }
     private String timeString(int time){
    	String temp="";
 		int temp2=0;
 		//temp2=(int)time/3600;
 		//temp+=((temp2<10)?"0":"")+temp2+":";//hours
 		temp2=(int)time/60;
 		temp+=((temp2<10)?"0":"")+temp2+":";//minutes
 		temp2=(int)time%60;
 		temp+=((temp2<10)?"0":"")+temp2;//seconds
 		//temp2=(int)(time*100)%60;
 		//temp+=((temp2<10)?"0":"")+temp2;//milliseconds
 		return temp;
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