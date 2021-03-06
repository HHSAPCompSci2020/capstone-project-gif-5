package Testers;

import javax.swing.*;

import Elements.*;
import Elements.Ice;
import Elements.Lightning;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;

import java.awt.event.KeyEvent;
import java.lang.*;
import java.util.ArrayList;

import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;






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
	private PImage giantImg;
	private PImage lgiantImg;
	private PImage witchImg;
	private PImage lwitchImg;
	private PImage iceImg, lightningImg,fireImg;
	private int gcounter;
	private int counter;
	private int ecounter = 0;
	private boolean startCount = false;
	private int repeat;
	private boolean facingLeft;
	private boolean shooting = false;
	private double x;
	private ArrayList<Integer> keys;
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
	private PImage lightningp; 
	private PImage magicp; 
	private PImage earthp; 
	private PImage icep; 
	private PImage firep;
	private PImage magicImg;
	private PImage potion; 
	private PImage ladder; 
	private PImage lW; 
	private int element = 1;
	private int level = 1;
	private int maxLevel = 15;
	private PImage midWall; 
	private int exitX = 0;
	private int exitY = 0;
	private int elementx  = 0;
	private int potionx=-100;
	private int potiony=-100;
	private boolean potionDrank = false;
	private boolean gameOver = false;
	private boolean victory = false;
	
	/**
	 * constructs the player and some monsters
	 */
	public DrawingSurface() {
	

		master = new Player( 10,  10,  64,  64,   "WIZARD",6);
		

		Dungeon = new DungeonMaker("room"+level);
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
		 icep = loadImage("icep.png");
		 firep = loadImage("firep.png");
		 earthp = loadImage("earthp.png");
		 magicp = loadImage("magicp.png");
		 lightningp = loadImage("lightningp.png");
		 midWall = loadImage("tiles/tile002.png");
		 ladder = loadImage("tiles/tile039.png");
		lW = loadImage("LWIZARD1.png");
		potion = loadImage("tiles/tile089.png");
		
		lwitchImg = loadImage("lwitch.png");
		dungeonSetUp();
		long start = System.currentTimeMillis();
		imageMode(CENTER);

		photo = loadImage("WIZARD"+""+".png");
		master.setImage(photo);
		photo = loadImage("LWIZARD"+""+".png");
		master.setImage2(photo);
		keys = new ArrayList<Integer>();
		
		iceImg = loadImage("icicle8.png");
		magicImg = loadImage("magic.png");
		fireImg = loadImage("fireball.png");
		lightningImg = loadImage("lightning.png");
		
		
		wand = loadImage("wand.png");
		
		wand.resize(32,32);
	}
	
	/**
	 * draws the enemies and other things on the dungeon
	 */
	public void draw() {
		

		
		if(!gameOver && !victory) {
			if(enemies.isEmpty() && master.getX() < exitX+64 && master.getX() > exitX && master.getY() < exitY+64 && master.getY() > exitY) {
				level++;
				if(level <= maxLevel) {
				
					Dungeon = new DungeonMaker("room"+level);
					walls = new ArrayList<wall>();
					elements = new ArrayList<Element>();
					dungeonSetUp();
				}
			}
			
			if(master.getHealth() <= 0)
				gameOver = true;
			
			if(level > maxLevel)
				victory = true;
				
			
			if(master.getX() < potionx+64 && master.getX() > potionx && master.getY() < potiony+64 && master.getY() > potiony) {
				if(!potionDrank) {
					potionDrank = true;
					potionx=-100;
					potiony=-100;
					
					master.setHealth(50); 
				}
			
			}
				
				
		
			
			
			
			background(37,19,26);
			if(element==1) {
				image(icep,900,50,64,64);
			}else if(element==2) {
				image(lightningp,900,50,64,64);
			}else if(element==3) {
				image(firep,900,50,64,64);
			}else if(element==4) {
				image(magicp,900,50,64,64);
			}

			dungeonDraw();

			
			for(int i = 0; i < enemies.size(); i++) {
				
				if(enemies.get(i) instanceof Witch) {
					Witch w = (Witch) enemies.get(i);
					for(int j = 0; j < w.getEnemies().size(); j++) {
						enemies.add(w.getEnemies().get(j));
						w.getEnemies().remove(j);
						j--;
					}
				}
				
				if(enemies.get(i).dead == true) {
					enemies.set(i,null);
					enemies.remove(i);
					
				}else {
					if(enemies.get(i).getFired()) {
						tint(240, 175, 0);
					}
					if(enemies.get(i).getFrozen()) {
						tint(0, 175, 240);
					}
					
					
					enemies.get(i).draw(this,master);
					
					noTint();
				}
				
				
			}
			
			if(ecounter<60)
				ecounter++;
			
			
			
			if(shooting) {
					if(ecounter-5 > 0) {
						ecounter-=5;
						double dir =  Math.atan2((mouseY-master.getY()),(mouseX-master.getX()));
						
						Lightning i = new Lightning((int)master.getX(), (int)master.getY(), 64, 64, 10, dir, "lightning", 1);
						i.setImage(lightningImg);
						

						
						i.direction = dir;
						i.w = walls;
						elements.add(i);
					}
					

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
			

			pushMatrix();
			
			
			
			master.draw(this);
		

		
			
		
			setUpWand();
			
			
			popMatrix();


		
			fill(255,255,255);
			rect(30, 30, 100, 10);
			fill(255, 0, 0);
			rect(30, 30, (float)(master.getHealth()* 0.01 * 100), 10);
			text("Health: " + master.getHealth(), 30, 30);

		
			fill(255);
			rect(30, 60, 100, 10);
			fill(0, 0, 255);
			
			rect(30, 60, (int)((10.0/6.0)*ecounter), 10);
			
			
			if (isPressed(KeyEvent.VK_A)) {
				facingLeft = true;
				master.moveLeft();
				master.runTrue();
				master.changeState(4);
			}
			if (isPressed(KeyEvent.VK_D))
			{
				facingLeft = false;
				master.moveRight();
				master.runTrue();
				master.changeState(3);
			}
			if (isPressed(KeyEvent.VK_W)) {
				master.moveUp();
				master.runTrue();
				master.changeState(1);
			}
			if(isPressed(KeyEvent.VK_S)) {
				master.moveDown();
				master.runTrue();
				master.changeState(2);
			}
			elementx++;
			if(isPressed(KeyEvent.VK_SPACE)) {
				if(elementx>10) {
					elementx = 0;
					if(element < 4) {
						element++;
						return;
					}
					if(element == 4) {
						element = 1;
					}
				}
				
			}
		}
		else if(gameOver) {
			background(0);
			textSize(128);
			fill(255, 0, 0);
			text("GAME OVER", 130 , 300);
			textSize(32);
			text("Room Number: " + level, 350 , 400);
		}
		else if(victory) {
			background(0);
			textSize(128);
			fill(0, 255, 0);
			text("VICTORY", 200 , 300);
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
 					if(Dungeon.grid[i][j]=='G') {
 						Giant giant = new Giant((int)rectX,(int)rectY, 128, 100, 6, "giant");
 						giantImg = loadImage("lgiantboy.png");
 						giant.setImage(giantImg);
 						lgiantImg = loadImage("giantboy.png");
 						giant.setImage2(lgiantImg);
 						
 						giant.w = walls;
 						enemies.add(giant);
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
 					if(Dungeon.grid[i][j]=='w') {
 						Witch witch = new Witch((int)rectX,(int)rectY, 64, 64, 6, "witch");
 						witchImg = loadImage("witch.png");
 						witch.setImage(lwitchImg);
 						witch.setImage2(witchImg);
 						witch.w = walls;
 						enemies.add(witch);
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
 						}else {
 							image(midWall,rectX,rectY,64,64);
 						}
 						
 						
 						
 						
 						imageMode(CENTER);
 					}
 					
 				
 					
 				if(Dungeon.grid[i][j]=='.'||Dungeon.grid[i][j]=='*'||Dungeon.grid[i][j]=='g'||Dungeon.grid[i][j]=='s'||Dungeon.grid[i][j]=='G'||Dungeon.grid[i][j]=='w') {
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
 				
 				if(Dungeon.grid[i][j]=='*') {
 						exitX = (int)rectX;
 						exitY = (int)rectY;
						imageMode(CORNER);
						image(ladder,rectX,rectY,64,64);
						imageMode(CENTER);
				}
 				
 				if(Dungeon.grid[i][j]=='h') {
 					imageMode(CORNER);
 					image(blankFloor,rectX,rectY,64,64);
 					imageMode(CENTER);
 					if(!potionDrank) {
 						potionx = (int)rectX;
 						potiony = (int)rectY;
 						imageMode(CORNER);
 						image(potion,rectX,rectY,64,64);
 						imageMode(CENTER);
 					}
					
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
		keys.add(keyCode);
	}

	public void keyReleased() {
		master.keyReleased();
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

	/**
	 * checks if the mouse is pressed
	 */
	public void mousePressed() {
			
			if(element == 1) {
				if(ecounter >32) {
				ecounter-=32;
				startCount = true;
				pushMatrix();
				
				double dir =  Math.atan2((mouseY-master.getY()),(mouseX-master.getX()));


				translate(3000,30);
				
				Ice i = new Ice((int)master.getX(), (int)master.getY(), 64, 64, 10, dir, "ice", 1);
				i.setImage(iceImg);
				
				popMatrix();
				
				i.direction = dir;
				i.w = walls;
				elements.add(i);
				}
			}
			else if(element == 2) {
				if(!shooting)
					shooting = true;
			
			}else if(element == 3) {
				if(ecounter >32) {
					ecounter-=32;
					startCount = true;
					pushMatrix();
					
					double dir =  Math.atan2((mouseY-master.getY()),(mouseX-master.getX()));


					translate(3000,30);
					
					Fire i = new Fire((int)master.getX(), (int)master.getY(), 64, 64, 10, dir, "fire", 1);
					i.setImage(fireImg);
					
					popMatrix();
					
					i.direction = dir;
					i.w = walls;
					elements.add(i);
			}}
			else if(element==4) {
				if(ecounter >16) {
					ecounter-=16;
					startCount = true;
					pushMatrix();
					
					double dir =  Math.atan2((mouseY-master.getY()),(mouseX-master.getX()));


					translate(3000,30);
					
					Magic i = new Magic((int)master.getX(), (int)master.getY(), 32, 32, 10, dir, "magic", 1);
					i.setImage(magicImg);
					
					popMatrix();
					
					i.direction = dir;
					i.w = walls;
					elements.add(i);
			}
			}
		
			
			
		
	}
	
	public void mouseReleased() {
		shooting = false;
	}
	
	/**
	 * checks if a key is realeased
	 */


	
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



