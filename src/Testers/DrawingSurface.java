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
	
	/**
	 * constructs the player and some monsters
	 */
	public DrawingSurface() {
		
//		Ice icee = new Ice(dungeon1, counter, counter, counter, counter, counter, counter, x);
		//sice = new Ice( 100, 100, 100, 100, 1, 1, "ICE");
		master = new Player( 50,  50,  64,  64,   "WIZARD",6);
		goblin = new Goblin(500, 500, 64, 64, 6, "goblin");
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
		long start = System.currentTimeMillis();
		imageMode(CENTER);
		//size(100,100);
		photo = loadImage("WIZARD"+1+".png");
		master.setImage(photo);
		goblinImg = loadImage("goblin.png");
		goblin.setImage(goblinImg);
		wand = loadImage("wand.png");
		
		photo.resize(128,128);
	}
	
	/**
	 * draws the enemiesand other things on the dungeon
	 */
	public void draw() {
		
		if (Dungeon != null) {
			Dungeon.draw(this, 0, 0, 20, 10);
		}
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
		text("Health: " + master.getHealth(), 100, 100);
		
		
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



