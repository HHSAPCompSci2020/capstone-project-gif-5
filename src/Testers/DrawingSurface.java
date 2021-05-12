package Testers;

import javax.swing.*;

import Elements.Element;
import Elements.Ice;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;
import java.lang.*;
import java.util.ArrayList;
/*
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
*/





/**
 * 
 * @author ido Tal
 * @version
 * This class connects everything together and draws it
 */


public class DrawingSurface extends PApplet {
	

	

	Player master;
	Goblin goblin;
	ArrayList<Enemy> enemies = new ArrayList<Enemy> ();
	Element ice;
	public DungeonMaker Dungeon;
	private PImage photo;
	private PImage wand;

	private PImage goblinImg;
	private PImage iceImg;
	private int gcounter;
	private int counter;
	private int repeat;
	private boolean facingLeft;
	private double x;
	private ArrayList<wall> walls = new ArrayList<wall>();
	
	
	
	
	
	private PImage topLeft ;
	private PImage topRight ;
	private PImage bottomLeft;
	private PImage bottomRight; 
	private PImage upWall ;
	private PImage downWall;
	private PImage leftWall ;
	private PImage rightWall ;
	
	/**
	 * constructs the player and some monsters
	 */
	public DrawingSurface() {
	
//		Ice icee = new Ice(dungeon1, counter, counter, counter, counter, counter, counter, x);
		//sice = new Ice( 100, 100, 100, 100, 1, 1, "ICE");
		master = new Player( 10,  10,  64,  64,   "WIZARD",6);
		goblin = new Goblin(700, 700, 64, 64, 6, "goblin");
//		enemies.add(new Goblin());
//		ice = new Ice();
		Dungeon = new DungeonMaker("room1");
		counter = 1;
		gcounter = 1;
		repeat = 0;
	}
		
	/**
	 * initializes the images
	 */
	public void setup() {
		
	
		 topLeft = loadImage("tiles/tile000.png");
		 topRight  = loadImage("tiles/tile005.png");;
		 bottomLeft= loadImage("tiles/tile040.png");;
		 bottomRight = loadImage("tiles/tile045.png");;
		 upWall = loadImage("tiles/tile001.png");
		 downWall = loadImage("tiles/tile051.png");
		 leftWall = loadImage("tiles/tile030.png");
		 rightWall = loadImage("tiles/tile035.png");
		
		
		
		
		dungeonSetUp();
		long start = System.currentTimeMillis();
		imageMode(CENTER);
		//size(100,100);
		photo = loadImage("WIZARD"+1+".png");
		master.setImage(photo);
		
		goblinImg = loadImage("goblin.png");
		goblin.setImage(goblinImg);
		wand = loadImage("wand.png");
		
		//photo.resize(128,128);
	}
	
	/**
	 * draws the enemiesand other things on the dungeon
	 */
	public void draw() {
		
		background(37,19,26);
		//Dungeon.draw(this, 0, 0, 12, 10);
		dungeonDraw();
		//creating goblins
//		goblin.act(master);
		
//		for(Enemy e : enemies) {
//			if(e.getHealth() <= 0) {
//				enemies.remove(e);
//			}
//		}
		
		//everything in this Matrix is pushed
		pushMatrix();
		
		//draw ze stuff
		
		master.draw(this);
		goblin.draw(this, master);

		//animate le object
		
		
		
		//the wand action
		setUpWand();
		
		//pop le matrix
		popMatrix();


		//display text
		fill(255,255,255);
		rect(30, 30, 100, 10);
		fill(255, 0, 0);
		rect(30, 30, (float)(master.getHealth()* 0.01 * 100), 10);
		text("Health: " + master.getHealth(), 30, 30);
		
		
		
	}



	
     public void dungeonSetUp() {
    	 imageMode(CENTER);
    	 if (Dungeon != null) {
 			
 			for(int i = 0; i < Dungeon.grid.length;i++) {
 				for(int j = 0; j < Dungeon.grid[0].length;j++) {
 					float rectWidth = 64;
 					float rectHeight = 64;
 					float rectX =  j * rectWidth+100;
 					float rectY =  i * rectHeight+50;
 					if(Dungeon.grid[i][j]=='*') {
 						master.moveToLocation(rectX+40, rectY+40);
 					}
 					if(Dungeon.grid[i][j]=='#') {
 						wall w = new wall((int)rectX,(int)rectY,64,64);
 						walls.add(w);
 						
 						imageMode(CORNER);
 						if(i==0 && j==0) {
 						
 							image(topLeft,rectX,rectY,64,64);
 							
 						}else if(i==0 && j==Dungeon.grid[0].length-1) {
 							image(topRight,rectX,rectY,64,64);
 						}else if(i==Dungeon.grid.length-1 && j==0) {
 							image(bottomLeft,rectX,rectY,64,64);
 						}
 						else if(i==Dungeon.grid.length-1 && j==Dungeon.grid[0].length-1) {
 							image(bottomRight,rectX,rectY,64,64);
 						}
 						else if(j==0) {
 							image(leftWall,rectX,rectY,64,64);
 						}
 						else if(j==Dungeon.grid[0].length-1) {
 							image(rightWall,rectX,rectY,64,64);
 						}
 						else if(i==0) {
 							image(upWall,rectX,rectY,64,64);
 						}
 						else if(i==Dungeon.grid.length-1) {
 							image(downWall,rectX,rectY,64,64);
 						}
 						
 						
 				    	 imageMode(CENTER);
 					}
 				}
 			}
 		}
    	 
    	 master.w = walls;
    	 
     }
     
     

     public void dungeonDraw() {
    	 imageMode(CENTER);
    	 if (Dungeon != null) {
 			
 			for(int i = 0; i < Dungeon.grid.length;i++) {
 				for(int j = 0; j < Dungeon.grid[0].length;j++) {
 					float rectWidth = 64;
 					float rectHeight = 64;
 					float rectX =  j * rectWidth+100;
 					float rectY =  i * rectHeight+50;
 					
 					if(Dungeon.grid[i][j]=='#') {
 						wall w = new wall((int)rectX,(int)rectY,64,64);
 						walls.add(w);
 						
 						imageMode(CORNER);
 						if(i==0 && j==0) {
 						
 							image(topLeft,rectX,rectY,64,64);
 							
 						}else if(i==0 && j==Dungeon.grid[0].length-1) {
 							image(topRight,rectX,rectY,64,64);
 						}else if(i==Dungeon.grid.length-1 && j==0) {
 							image(bottomLeft,rectX,rectY,64,64);
 						}
 						else if(i==Dungeon.grid.length-1 && j==Dungeon.grid[0].length-1) {
 							image(bottomRight,rectX,rectY,64,64);
 						}
 						else if(j==0) {
 							image(leftWall,rectX,rectY,64,64);
 						}
 						else if(j==Dungeon.grid[0].length-1) {
 							image(rightWall,rectX,rectY,64,64);
 						}
 						else if(i==0) {
 							image(upWall,rectX,rectY,64,64);
 						}
 						else if(i==Dungeon.grid.length-1) {
 							image(downWall,rectX,rectY,64,64);
 						}
 						imageMode(CENTER);
 					}}
 			}
 		}
    	 
    	 master.w = walls;
    	 
     }
     
     
	 /**
	  * checks key pressed and then makes the wizard move
	  */
	public void keyPressed() {
		
		if (key == 'w') {
			
			master.moveUp();
			master.runTrue();
			master.changeState(1);
		}
		
		if (key == 'a') {
			facingLeft = true;
			master.moveLeft();
			master.runTrue();
			master.changeState(4);
		}
		if (key == 'd') {
			facingLeft = false;
			master.moveRight();
			master.runTrue();
			master.changeState(3);
		}
		
		if (key == 's') {
			
			master.moveDown();
			master.runTrue();
			master.changeState(2);
		}
	}
	/**
	 * checks if the mouse is pressed
	 */
	public void mousePressed() {
		
		
		
		
	}
	/**
	 * checks if a key is realeased
	 */

	public void keyReleased(){
		master.keyReleased();
	}

	
	/**
	 * setsUp the wand to make it rotates in the correct angle and face the mouse at all times
	 */

	public void setUpWand(){
		 translate((float) master.getX(), (float) master.getY());
		 x = Math.atan2(master.getY2() - master.getY(), master.getX2() - master.getX());
		 rotate((float) (x+0.349));
		 image(wand, 0,0);
	}
	
	
}



