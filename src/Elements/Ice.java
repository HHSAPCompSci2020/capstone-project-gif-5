package Elements;

import java.util.ArrayList;

import Enemies.Enemy;
import gbitton299.shapes.Shape;
import processing.core.PApplet;
import processing.core.PImage;

public class Ice extends Element {
	
//private static PImage iceImg;
//	private int speed;
//	private double direction; // in radians
//	private Shape s; //for testing intersections

	
	//what does "frames" do?
	
	private PImage iceImg = new PImage();
	
	/**instantiates an ice element
	 * @param img the ice image
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * */
	public Ice(int x,int y,int w,int h,int frames,String name) {
		
		super(x,  y,  w,  h,  name,  frames);
		
	}
	
	public void strikeEnemy(double direction, Enemy e) {
		
		e.setFrozen(true);
		
		// code this later
		
//		if(direction == 0) {
//			// slow enemies behind (x, y)
//			
//			
//		}
//		else if(direction == Math.PI / 2) {
//			
//		}		
//		else if(direction == Math.PI) {
//			
//		}
//		else if(direction == 3 * Math.PI / 2) {
//			
//		}	
	}
	
	
	
//	public void draw(PApplet surface) {
//		iceImg = surface.loadImage(name);
//		this.setImage(iceImg);
//		super.draw(surface);
//	}
}
