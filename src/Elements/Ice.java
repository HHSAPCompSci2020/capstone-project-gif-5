package Elements;

import java.util.ArrayList;


import java.util.*;

import Enemies.Enemy;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Timer;

/**
 * 
 * @author Franklin
 *This is the ice class
 */
public class Ice extends Element {
	


	protected int speed = 10;
	
	
	
	
	/**instantiates an ice element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * @param name name of the file path
	 * */
	public Ice(int x,int y,int w,int h, int speed, double direction, String name, int frames) {
		
		super(x, y, w, h, speed, direction, name, frames);
		
	}
	/**
	 * @param The direction the element will go to
	 * @param	 the enemy its hitting
	 * @param all of the enemies that are in the array list
	 */
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		
		e.setFrozen(true);
		e.loseHealth(10);
	
		

	}
	/**
	 * Draws the element using PApplet
	 * @param This is a PApplet object
	 */
	public void draw(PApplet g) {
		
		if(isDead) {}
		else {
			
		
			g.pushMatrix();
			g.translate((float)x+width/2,(float) y+height/2);

			g.rotate((float)direction+(float)Math.PI/2);
			
			g.image(image,(int)0,(int)0,(int)width,(int)height);
			g.popMatrix();
			
			
			move();
			}
		
	}
	
	
	
	
	
	
	
}
