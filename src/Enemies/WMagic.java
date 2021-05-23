
package Enemies;

import java.util.ArrayList;

import Enemies.Enemy;
import Player.MovingImage;
import Player.Player;
import gbitton299.shapes.Circle;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;
import java.lang.*;
import processing.core.*;
/**
 * 
 * @author Gilad Bitton
 *The Wmagic is the witches magic
 */
public class WMagic extends MovingImage{
	
	public boolean isDead = false;
	protected int speed = 15;
	public double direction;

	private Shape s; 
	
	
	
	/**instantiates an ice element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * @param name name of the file
	 * */
	public WMagic(int x,int y,int w,int h,String name, int frames) {
		
		super(x, y, w, h, frames, name);
		s = new Circle(); // s is a new shape
		this.speed = speed;
		this.direction = direction;
		
	}
	
	public void act() {
		
	}
	
	/** checks whether any enemies have touched the element. if there are any, then interact with them
	 * @param p The Player it's attacking
	 * @param surface the surface it's being drawn on 
	 * */
	public void interactWithObjects(Player p) {
		
		boolean hasIntersected = false;
		
			if(this.intersectsEnemy(p)) {
			
				strikeEnemy(direction, p);
				dissipate();
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
		if(isDead) {
			
		}
		else {		
//			
			move();
			
			g.pushMatrix();
			g.translate((float)(x+width/2),(float) (y+height/2));
			
			g.rotate((float)direction+(float)Math.PI/4);
			
			g.image(image,(int)0,(int)0,(int)width,(int)height);
			g.popMatrix();
			
			}
		

	}

	/**
	 * returns whether any of the four corners of the enemy are inside the element
	 * @param e the enemy that this element checks for intersection with
	 * @return whether this element has intersected this enemy or not
	 * */
	private boolean intersectsEnemy(Player p) {
		if(isPointInside(p.getX(), p.getY())) {
			return true;
		}
		if(isPointInside(p.getX() + p.getDiameter(), p.getY())) {
			return true;
		}
		if(isPointInside(p.getX() + p.getDiameter(), p.getY() + p.getDiameter())) {
			return true;
		}
		if(isPointInside(p.getX(), p.getY() + p.getDiameter())) {
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
	/**
	 * This strikes the enemy
	 * @param direction The direction it's going
	 * @param p The player it's striking
	 */
	public void strikeEnemy(double direction, Player p) {
		p.setHealth(-10);
	}
	
	/**moves the element
	 * */
	public void move() {

		
		
		
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

}