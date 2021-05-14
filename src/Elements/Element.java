package Elements;

import java.util.ArrayList;

import Enemies.Enemy;
import Player.MovingImage;
import gbitton299.shapes.Circle;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;
import java.lang.*;
import processing.core.*;

public abstract class Element extends MovingImage{
	
	public boolean isDead = false;
	protected int speed = 15;
	public double direction; // in radians
	public float width;
	public float height;
	private Shape s; //for testing intersections
	
	//what does "frames" do?
	
	/**instantiates an ice element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * @param name name of the file
	 * */
	public Element(int x,int y,int w,int h, int speed, double direction, String name, int frames) {
		
		super(x, y, w, h, frames, name);
		s = new Circle(); // s is a new shape
		this.speed = speed;
		this.direction = direction;
		width = w;
		height = h;
	}
	
	public void act() {
		
	}
	
	/** checks whether any enemies have touched the element. if there are any, then interact with them
	 * @param e an arraylist full of all the enemies
	 * */
	public void interactWithObjects(ArrayList<Enemy> e) {
		
		boolean hasIntersected = false;
		
		for(int i = 0; i < e.size(); i ++) {
			if(this.intersectsEnemy(e.get(i))) {
				//enemy loses health
				//dissipate();
				// how to get direction?
				strikeEnemy(direction, e.get(i));
				dissipate();
			}
			//intersects walls?
		}
		
		if(hasIntersected = false) {
			dissipate();
		}
	}
	
	/**This moves an element, its an override and it  moves stuff.
	 * @param x is the move amount to the x
	 * @param y is the move amount to the y
	 */
	public void moveByAmount(double x, double y) {
		
		if(touchingWall(this.x,this.y)){
			
			dissipate();
			isDead = true;
			return;
		}
		if(touchingWall(super.x + x,super.y + y)) {
			dissipate();
			isDead = true;
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
	 * draws the element if its not dead
	 */
	public void draw(PApplet g) {
		
//		
//		if(!facingLeft || image2==null) {
//			g.image(image,(int)x,(int)y,(int)width,(int)height);
//		}else {
//			g.image(image2,(int)x,(int)y,(int)width,(int)height);
//		}
		
		if(isDead) {}
		else {		
//			super.draw(g);
//			g.rotate((float)(direction + 0.5));
//			System.out.println("j");
//			rotate((float)(direction));
	
//			 translate((float) (master.getX()-5), (float) master.getY()+15);
//			 x = Math.atan2(master.getY2() - master.getY(), master.getX2() - master.getX());
//			 rotate((float) (x+ 2 * 0.349));
//			 image(wand, 0,0);
			
			g.pushMatrix();
			g.rotate((float)(direction));
			g.image(image, height, width, height, speed);
			move();
			super.draw(g);
			g.popMatrix(); 
			 
//			move();
//	
//			super.draw(g);
		
			
			}
		
//		p = g.loadImage(name);
//		g.draw(this);
	}
	
	public void rotate(PApplet g) {
		
	}

	/**
	 * returns whether any of the four corners of the enemy are inside the element
	 * @param e the enemy that this element checks for intersection with
	 * @return whether this element has intersected this enemy or not
	 * */
	private boolean intersectsEnemy(Enemy e) {
		if(isPointInside(e.getX(), e.getY())) {
			return true;
		}
		if(isPointInside(e.getX() + e.getDiameter(), e.getY())) {
			return true;
		}
		if(isPointInside(e.getX() + e.getDiameter(), e.getY() + e.getDiameter())) {
			return true;
		}
		if(isPointInside(e.getX(), e.getY() + e.getDiameter())) {
			return true;
		}
		return false;
	}
	
	/** returns whether the given point is inside the element or not
	 * @param d the x coordinate of the given point
	 * @param e the y coordinate of the given point
	 * @return whether the given point is inside the element
	 * */

	private boolean isPointInside(double x, double y) {
		// 
		if(this.x + width >= x && this.x <= x) {
			if(this.y + height >= y && this.y <= y) {
				return true;
			}
		}
		return false;
	}
	
	/** makes this element disappear from the board and affect any nearby enemies
	 * 
	 * */
	public void dissipate() {
		isDead = true;
		moveToLocation(-10,-10);
	}

	public abstract void strikeEnemy(double direction, Enemy e);
	
	/**moves the element
	 * */
	public void move() {
		// changes the x and y coordinates of the element,
		// moves in the direction of the private angle variable
	
		//if at a wall, then stop moving and dissipate
		//if not at wall, then keep moving
		
		
		
//		if(intersectsWalls()) {
//			dissipate();
//		}
//		else {
//			x += speed * Math.cos(direction);
//			y -= speed * Math.sin(direction);
//		}
		
		
		
		moveByAmount(speed * Math.cos(direction),speed * Math.sin(direction));
		
		
		
	}
	
	/** returns the starting x coordinate of the element
	 * @return the starting x coordinate of the element
	 * */
	public double getX() {
		return x;
	}
	
	/** returns the starting y coordinate of the element
	 * @return the starting y coordinate of the element
	 * */
	public double getY() {
		return y;
	}
	
	
	
	
	
	// other methods : 
	// intersects wall?
	// 

	// questions : 
	// how to make element disappear as it dissipates?
	// 
}