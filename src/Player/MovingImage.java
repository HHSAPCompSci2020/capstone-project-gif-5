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
import Testers.wall;
import java.util.ArrayList;
/*
 * Represents a moving image.
 *
 * by: Shelby
 * on: 5/3/13
 */


/**
 * This represents an image that can move
 *@author John Shelby
 *@version 5/6
 */
 
public class MovingImage extends Rectangle2D.Double {
	
	// FIELDS
	private String inWall = "none";
	public ArrayList<wall> w = new ArrayList<wall>();
	PApplet i;
	protected PImage image;
	protected PImage image2;
	private int counter;
	private int repeat;
	private int frames;
	public boolean facingLeft;
	protected String name;

	// CONSTRUCTORS
	/** creates a moving image with starting coordinates (x, y), width w, height h, with "frames" amount of animation switches,
	 * @param x  the x coordinate of the image
	 * @param y  the y coordinate of the image
	 * @param w the width of the image
	 * @param h  the height of the image
	 * @param frames the number of frames the animation has
	 * @param name the name of the image file
	 * 
	 * */
	public MovingImage( int x, int y, int w, int h, int frames, String name) {
		super(x,y,w,h);
		
		counter = 1;
		this.frames = frames;
		repeat = 0;
		this.name = name;
	}
	
	
	public void setImage(PImage imga) {
		image = imga;
	}
	public void setImage2(PImage imga) {
		image2 = imga;
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
		
		if(touchingWall(this.x,this.y)){
			
			
			
			return;
		}
		if(touchingWall(super.x + x,super.y + y)) {
			return;
		}
		if(x>0) {
			facingLeft = false;

		}
		if(x<0) {
			facingLeft = true;

		}
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Makes the limits for the moving image
	 * @param windowWidth is the width of the window
	 * @param windowHeight is the height of the window
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
		if(!facingLeft || image2==null) {
			g.image(image,(int)x,(int)y,(int)width,(int)height);
		}else {
			g.image(image2,(int)x,(int)y,(int)width,(int)height);
		}
		
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
	/**
	 * checks if the enemy is touching the wall
	 * @param x x coordinate of player
	 * @param y y coordinate of player
	 * @return returns if the player is in the wall
	 */
	public boolean touchingWall(double x, double y) {
		if(w==null) {
			return false;
		}
		Rectangle2D.Double q = new Rectangle2D.Double(x-32,y-32,width,height);
		for(wall r : w) {
			if(r.intersects(q)) {
				if(r.x>q.x) {
					inWall = "right";
				}
				if(r.x<q.x) {
					inWall = "left";
				}
				if(r.y>q.y) {
					inWall = "down";
				}
				if(r.y<q.y) {
					inWall = "up";
				}
				
				return true;
			}
		}
		return false;
	}
	
}










