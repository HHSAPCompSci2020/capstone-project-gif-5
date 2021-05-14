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
 * @version beta
 * This class connects everything together and draws it
 */


public class DrawingSurface extends PApplet {
	

	

	Player master;
	Goblin goblin;
	ArrayList<Enemy> enemies = new ArrayList<Enemy> ();
	ArrayList<Element> elements = new ArrayList<Element> ();
	Element ice;
	public DungeonMaker Dungeon;
	private PImage photo;
	private PImage wand;

	private PImage goblinImg;
	private PImage iceImg;
	private int gcounter;
	private int counter;
	private int ecounter = 0;
	private boolean startCount = false;
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
	private PImage topLeftFloor ;
	private PImage topRightFloor ;
	private PImage bottomLeftFloor;
	private PImage bottomRightFloor; 
	private PImage upFloor ;
	private PImage downFloor;
	private PImage leftFloor ;
	private PImage rightFloor ;
	private PImage blankFloor; 
	private PImage blankFloor2; 
	private PImage lW; 
	private int element = 1;
	/**
	 * constructs the player and some monsters
	 */
	public DrawingSurface() {
	
//		Ice icee = new Ice(dungeon1, counter, counter, counter, counter, counter, counter, x);
		//sice = new Ice( 100, 100, 100, 100, 1, 1, "ICE");
		master = new Player( 10,  10,  64,  64,   "WIZARD",6);
		
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
		 
		 topLeftFloor = loadImage("tiles/tile011.png");
		 topRightFloor  = loadImage("tiles/tile014.png");;
		 bottomLeftFloor= loadImage("tiles/tile031.png");;
		 bottomRightFloor = loadImage("tiles/tile034.png");;
		 upFloor = loadImage("tiles/tile012.png");
		 downFloor = loadImage("tiles/tile032.png");
		 leftFloor = loadImage("tiles/tile021.png");
		 rightFloor = loadImage("tiles/tile024.png");
		 blankFloor = loadImage("tiles/tile023.png");
		 blankFloor2 = loadImage("tiles/tile022.png");
		
		lW = loadImage("LWIZARD1.png");
		
		
		dungeonSetUp();
		long start = System.currentTimeMillis();
		imageMode(CENTER);
		//size(100,100);
		photo = loadImage("WIZARD"+""+".png");
		master.setImage(photo);
		photo = loadImage("LWIZARD"+""+".png");
		master.setImage2(photo);
		
		iceImg = loadImage("icicle8.png");
		
		
		wand = loadImage("wand.png");
		
		wand.resize(32,32);
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
		
		for(Enemy p : enemies) {
			if(p.dead == true) {
				p = null;
				enemies.remove(p);
			}else {
				p.draw(this,master);
			}
			
		}
		
		if(startCount)
		ecounter++;
		
		if(ecounter>=60) {
			ecounter = 0;
			startCount = false;
		}
		
		for(Element u : elements) {
			u.interactWithObjects(enemies);
			if(u.isDead == true) {
				u = null;
				elements.remove(u);
				
			}else {
				u.draw(this);
			}
			
			
		}
		
		//everything in this Matrix is pushed
		pushMatrix();
		
		//draw ze stuff
		
		master.draw(this);
	

		//animate le object
		
		//the wand action
		setUpWand();
		
		//pop le matrix
		popMatrix();


		//display health
		fill(255,255,255);
		rect(30, 30, 100, 10);
		fill(255, 0, 0);
		rect(30, 30, (float)(master.getHealth()* 0.01 * 100), 10);
		text("Health: " + master.getHealth(), 30, 30);

		//mana
		fill(255);
		rect(30, 60, 100, 10);
		fill(0, 0, 255);
		if(startCount)
		rect(30, 60, (int)((10.0/6.0)*ecounter), 10);
		else {
			rect(30, 60, 100, 10);
		}
		
		
	}


	
	/**
	 * setsup the dungeon, it reads from 2d array and creates the new dungeon
	 */
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
 						
 						
 					}
 					if(Dungeon.grid[i][j]=='g') {
 						Goblin goblin = new Goblin((int)rectX,(int)rectY, 64, 64, 6, "goblin");
 						goblinImg = loadImage("goblin.png");
 						goblin.setImage(goblinImg);
 						goblinImg = loadImage("Lgoblin6.png");
 						goblin.setImage2(goblinImg);
 						goblin.w = walls;
 						enemies.add(goblin);
 					}
 					if(Dungeon.grid[i][j]=='s') {
 						Skeleton skelly = new Skeleton((int)rectX,(int)rectY, 64, 64, 6, "skeleton");
 						PImage skellyImg = loadImage("skeleton.png");
 						skelly.setImage(skellyImg);
 						skellyImg.resize(100, 100);
 						skellyImg = loadImage("lskeleton.png");
 						
 						skelly.setImage2(skellyImg);
 						skelly.w = walls;
 						enemies.add(skelly);
 					}
 				}
 			}
 		}
    	 
    	 master.w = walls;
    	 
     }
     
     
     /**
      * method that draws the dungeon every draw method call
      */
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
 					}
 					
 				if(Dungeon.grid[i][j]=='.'||Dungeon.grid[i][j]=='*'||Dungeon.grid[i][j]=='g'||Dungeon.grid[i][j]=='s') {
 					imageMode(CORNER);
 					if(i==1 && j==1) {
	 						
							image(topLeftFloor,rectX,rectY,64,64);
							
						}else if(i==1 && j==Dungeon.grid[0].length-2) {
							image(topRightFloor,rectX,rectY,64,64);
						}else if(i==Dungeon.grid.length-2 && j==1) {
							image(bottomLeftFloor,rectX,rectY,64,64);
						}
						else if(i==Dungeon.grid.length-2 && j==Dungeon.grid[0].length-2) {
							image(bottomRightFloor,rectX,rectY,64,64);
						}
						else if(j==1) {
							image(leftFloor,rectX,rectY,64,64);
						}
						else if(j==Dungeon.grid[0].length-2) {
							image(rightFloor,rectX,rectY,64,64);
						}
						else if(i==1) {
							image(upFloor,rectX,rectY,64,64);
						}
						else if(i==Dungeon.grid.length-2) {
							image(downFloor,rectX,rectY,64,64);
						}else {
							
								image(blankFloor,rectX,rectY,64,64);
							
							
						}
 					
 					
 					
 					imageMode(CENTER);

 				}
 						
 				}
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
		if(ecounter == 0) {
			startCount = true;
			if(element == 1) {
			
//				pushMatrix();
				
				double dir =  Math.atan2((mouseY-master.getY()),(mouseX-master.getX()));

//				rotate((float)(dir));
//				translate(3000,30);
				
				Ice i = new Ice((int)master.getX(), (int)master.getY(), 64, 64, 10, dir, "ice", 1);
				i.setImage(iceImg);
				
//				popMatrix();
				
				i.direction = dir;
				i.w = walls;
				elements.add(i);
			}
			
		}
		
		
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
		 translate((float) (master.getX()-5), (float) master.getY()+15);
		 x = Math.atan2(master.getY2() - master.getY(), master.getX2() - master.getX());
		 rotate((float) (x+ 2 * 0.349));
		 image(wand, 0,0);
	}
}



