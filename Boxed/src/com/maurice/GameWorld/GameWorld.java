package com.maurice.GameWorld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.maurice.GameObjects.Ball;
import com.maurice.GameObjects.Cluster;
import com.maurice.GameObjects.ConnectLine;
import com.maurice.GameObjects.Pin;
import com.maurice.GameObjects.Tile;
import com.maurice.GameObjects.Wheel;
import com.maurice.boxed.MyBoxedGame;


public class GameWorld{
	
	private int midPointX;
    private int midPointY;
    private int gameHeight;
    private int gameWidth;
    private int tilesHeight;
    private int tilesWidth;
    private int rows;
    private int columns;
    private int progress=0;
    
    private int tileWidth;
    
  
	MyBoxedGame game;
    private float runtime=0;
    
	Random rand = new Random();
	private int score=0;
	private Tile[][] board;
	public GameWorld(int midPointX,int midPointY, int gameHeight, int gameWidth, MyBoxedGame game, int level) {
		this.midPointX=midPointX;
		this.midPointY=midPointY;
		this.gameHeight=gameHeight;
		this.gameWidth=gameWidth;
		tilesWidth=gameWidth;
		tilesHeight=gameWidth;//to make it responsive with width
		tileWidth=tilesWidth/8;//8 in a row
		System.out.println("GameWidth="+gameWidth);
		System.out.println("GameHeight="+gameHeight);
		//this.tileWidth=gcd(gameHeight,gameWidth);
		System.out.println("TileWidth="+tileWidth);
		this.game=game;
		columns=gameWidth/tileWidth;
		rows=columns;
		board=new Tile[rows][columns];
		Random rand = new Random();
		for(int r=0;r<rows;r++)
			for(int c=0;c<columns;c++){
				board[r][c]=new Tile(r,c,true,rand.nextInt(2));
			}
		
	}
	public void update(float delta) {
		runtime+=delta;
	}
	public Tile[][] getBoard() {
		return board;
	}
	public void highlight(int r, int c){
		if((r<0)|(c<0)|(r>=rows)|(c>=columns)) return;
		board[r][c].setSelected(true);
	}
	public void highlightRect(int x1, int y1, int x2,int y2){
		int temp;
		if(x1>x2) {temp=x1; x1=x2; x2=temp;}
		if(y1>y2) {temp=y1; y1=y2; y2=temp;}
		for(int r=x1;r<x2+1;r++)
			for(int c=y1;c<y2+1;c++){
				if((r<0)|(c<0)|(r>=rows)|(c>=columns)) continue;
				board[r][c].setSelected(true);
			}
	}
	public void unHighlightAll(){
		for(int r=0;r<rows;r++)
			for(int c=0;c<columns;c++){
				board[r][c].setSelected(false);
			}
	}
	public void testRect(int x1, int y1, int x2,int y2){
		if(board[x1][y1].getType()!=board[x1][y2].getType()) return;
		if(board[x1][y2].getType()!=board[x2][y2].getType()) return;
		if(board[x2][y2].getType()!=board[x2][y1].getType()) return;
		if(board[x2][y1].getType()!=board[x1][y1].getType()) return;
		//all are same color
		//System.out.println("samecolor...!");
		createNew(x1, y1, x2,y2);
	}
	public void createNew(int x1, int y1, int x2,int y2){
		if(x1==x2) return;
		if(y1==y2) return;
		int temp;
		if(x1>x2) {temp=x1; x1=x2; x2=temp;}
		if(y1>y2) {temp=y1; y1=y2; y2=temp;}
		for(int r=x1;r<x2+1;r++)
			for(int c=y1;c<y2+1;c++){
				if((r<0)|(c<0)|(r>=rows)|(c>=columns)) continue;
				board[r][c]=new Tile(r,c,false,rand.nextInt(2));
			}
	}
	public int getRows(){
		return rows;
	}
	public int getColumns(){
		return columns;
	}
	public int getTileWidth() {
			return tileWidth;
	}
	public void setBoard(Tile[][] board) {
		this.board = board;
	}
	public void setLevel(int level) throws IOException{
	}
	public  MyBoxedGame getGame(){
		return this.game;
	}
	public void move(float pixel) {
	}
	public int getScore(){
		return score;
	}
	public void setScore(int score){
		this.score=score;;
	}
	public void addScore(int x){
		score+=x;
	}
	public float getRuntime() {
		return runtime;
	}
	public void setRuntime(float runtime) {
		this.runtime = runtime;
	}
	//boced methods-----------------
	public int gcd(int a, int b){
		if (b==0) return a;
		return gcd(b,a%b);
	}
	public int getProgress() {
		setProgress();
		if(progress>=100){
			game.restartScreen.setScore((int)(runtime*60));
			game.restartScreen.checkHighScore();
			game.setRestartScreen();
		}
		return progress;
	}
	public void setProgress() {
		int original=0;
		int total=0;
				
		for(int r=0;r<rows;r++)
			for(int c=0;c<columns;c++){
				if(board[r][c].isOriginal()) original++;
				total++;
			}
		this.progress = 100-((100*original)/total);
	}
	

}
