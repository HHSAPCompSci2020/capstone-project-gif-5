package Player;


import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.*;
import javax.swing.*;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;
import java.lang.*;
/*
 * Represents a moving image.
 *
 * by: Shelby
 * on: 5/3/13
 */
 
public class MovingImage extends Rectangle2D.Double {
	
	// FIELDS
	PApplet i;
	protected PImage image;
	private int counter;
	private int repeat;
	private int frames;
	private boolean facingLeft;
	protected String name;

	// CONSTRUCTORS
	/** creates a moving image with starting coordinates (x, y), width w, height h, with "frames" amount of animation switches,
	 * 
	 * 
	 * */
	public MovingImage(PImage img, int x, int y, int w, int h, int frames, String name) {
		super(x,y,w,h);
		image = img;
		counter = 1;
		this.frames = frames;
		repeat = 0;
		this.name = name;
	}
	
	
	// METHODS	
	/** moves the movingImage to location (x, y)
	 * @param x the x coordinate of the movingImage's new location
	 * @param y the y coordinate of the movingImage's new location
	 * */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/** moves the movingImage by x units horizontally, and y units vertically
	 * @param x the horizontal distance to move the movingImage
	 * @param y the vertical distance to move the movingImage
	 * */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	/**
	 * 
	 * */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-width);
		y = Math.min(y,windowHeight-height);
		x = Math.max(0,x);
		y = Math.max(0,y);
	}
	
	
	/** draws the movingImage
	 * @param g the PApplet used to draw the MovingImage
	 * */
	public void draw(PApplet g) {
		g.image(image,(int)x,(int)y,(int)width,(int)height);
	}
	

	/**
	 * animates the movingImage
	 * */
	public void animation(){
		
		repeat++;
		if (repeat % 10 == 0) {
			counter
			++;
			if (counter > frames) {
				counter = 1;
			}
		}

		
		
		if (!facingLeft) {
			image = i.loadImage(name + counter + ".png");
		} else {
			image = i.loadImage(name + counter + ".png");
		}

		

		
		i.image(image,(float)x,(float)y);

	}
	
	
}










