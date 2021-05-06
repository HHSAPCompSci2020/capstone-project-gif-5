package Testers;

import javax.swing.*;

import Elements.Element;
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
	ArrayList<Enemy> enemies = new ArrayList<Enemy> ();
	Element ice;
	private PImage photo;
	private PImage wand;
	private PImage dungeon1;
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
		master = new Player(photo,  10,  10,  32,  32,   "WIZARD",6);
		enemies.add(new Goblin());
//		ice = new Ice();
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
		goblinImg = loadImage("goblin.png");
		wand = loadImage("wand.png");
		dungeon1 = loadImage("dungeon1.png");
		photo.resize(128,128);
	}
	
	/**
	 * draws the enemiesand other things on the dungeon
	 */
	public void draw() {
		

		//creating goblins
		enemies.get(0).act(master);
		
		for(Enemy e : enemies) {
			if(e.getHealth() <= 0) {
				enemies.remove(e);
			}
		}
		
		//everything in this Matrix is pushed
		pushMatrix();
		
		//draw ze stuff
		image(dungeon1,500,400);
		master.draw(this);
//		goblin.draw(this);

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



