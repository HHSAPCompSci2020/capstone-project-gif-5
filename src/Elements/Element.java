package Elements;

import java.util.ArrayList;

import Enemies.Enemy;
import Player.MovingImage;
import gbitton299.shapes.Circle;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Element extends MovingImage{
	
	private int speed;
	protected double direction; // in radians
	private Shape s; //for testing intersections
	
	//what does "frames" do?
	public Element(PImage img, int x, int y, int w, int h, int frames, int speed, double direction, String name) {
		super(img, x, y, w, h, frames, name);
		s = new Circle(); // s is a new shape
		this.speed = speed;
		this.direction = direction;
	}
	
	public void interactWithEnemies(ArrayList<Enemy> e) {
		for(int i = 0; i < e.size(); i ++) {
			if(this.intersectsEnemy(e.get(i))) {
				//enemy loses health
				dissipate();
			}
		}
	}

	/**
	 * returns whether any of the four corners of the enemy are inside the element
	 * 
	 * */
	public boolean intersectsEnemy(Enemy e) {
		// if s intersects any of the enemies, the enemies will lose health
		// if this is true, the element will dissipate and be set to null;
		
		//if any of the four coordinates of the square around an enemy
		//is inside the element, then return true
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
	
	public boolean isPointInside(int x, int y) {
		// 
		if(this.x + width >= x && this.x <= x) {
			if(this.y + height >= y && this.y <= y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean intersectsWalls(Dungeon d) { //parameters? you need the dungeon so you know where the walls are
		
	}
	
	// when the element hits a wall or enemy, it dissipates.
	// however, based on the placement of the enemies around the element,
	// elements dissipate in different ways. 
	public abstract void dissipate(); 
	
	public void draw(PApplet g) {	
		super.draw(g);
		
	}
	
	public void move() {
		// changes the x and y coordinates of the element,
		// moves in the direction of the private angle variable
	
		//if at a wall, then stop moving and dissipate
		//if not at wall, then keep moving
		
		
		
		if(intersectsWalls()) {
			dissipate();
		}
		else {
			x += speed * Math.cos(direction);
			y -= speed * Math.sin(direction);
		}
	}
	
	public double getX() {
		return x;
	}
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