package Elements;

import java.util.ArrayList;

import Enemies.Enemy;
import Player.MovingImage;
import gbitton299.shapes.Circle;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Element extends MovingImage{
	
	private boolean isDead = false;
	private int speed;
	protected double direction; // in radians
	private PImage p;
	private Shape s; //for testing intersections
	
	//what does "frames" do?
	
	/**instantiates an ice element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * */
	public Element(int x,int y,int w,int h,String name, int frames) {
		
		super(x, y, w, h, frames, name);
		s = new Circle(); // s is a new shape
		this.speed = speed;
		this.direction = direction;
		
	}
	
	/** checks whether any enemies have touched the element. if there are any, then interact with them
	 * @param e an arraylist full of all the enemies
	 * */
	public void interactWithEnemies(ArrayList<Enemy> e) {
		
		boolean hasIntersected = false;
		
		for(int i = 0; i < e.size(); i ++) {
			if(this.intersectsEnemy(e.get(i))) {
				//enemy loses health
				//dissipate();
				strikeEnemy(e.get(i));
				hasIntersected = true;
				break;
			}
		}
		
		if(hasIntersected = false) {
			dissipate();
		}
	}
	
	public void draw(PApplet g) {
		if(isDead) {}
		else {		
			super.draw(g);
			}
		
//		p = g.loadImage(name);
//		g.draw(this);
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
<<<<<<< Updated upstream
	public boolean isPointInside(double d, double e) {
=======
	private boolean isPointInside(double x, double y) {
>>>>>>> Stashed changes
		// 
		if(this.x + width >= d && this.x <= d) {
			if(this.y + height >= e && this.y <= e) {
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
	}

	public abstract void strikeEnemy(Enemy e);
	
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
		
		x += speed * Math.cos(direction);
		y -= speed * Math.sin(direction);
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