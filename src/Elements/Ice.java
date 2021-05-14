package Elements;

import java.util.ArrayList;
import java.util.*;

import Enemies.Enemy;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.Timer;
public class Ice extends Element {
	
//private static PImage iceImg;
//	private int speed;
//	private double direction; // in radians
//	private Shape s; //for testing intersections

	protected int speed = 10;
	//what does "frames" do?
	
	
	
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
	
	public void strikeEnemy(double direction, Enemy e) {
		
		e.setFrozen(true);
		e.loseHealth(10);
	
		

	}
	
	
	
	
	
	
}
