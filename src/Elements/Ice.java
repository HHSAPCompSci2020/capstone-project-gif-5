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
	
	@Override

	public void dissipate(int x, int y, double direction, ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub
		// after ice hits first enemy, it freezes the first enemy and slows the three enemies behind it
		// 
		boolean b = false;
		
		
		if(/*if enemy exists at (x, y)*/) {
			
			// freeze enemy at (x, y)
			
			
			if(direction == 0) {
				// freeze enemies behind (x, y)
			}
			else if(direction == Math.PI / 2) {
				
			}		
			else if(direction == Math.PI) {
				
			}
			else if(direction == 3 * Math.PI / 2) {
				
			}	
		}
		else // if there is no enemy at (x, y)
		{
			//
		}
		
		// erase ice element
	}
	
	public void strikeEnemy() {
		
	}
	
	public void draw(PApplet surface) {
		iceImg = surface.loadImage(name);
		this.setImage(iceImg);
		super.draw(surface);
		
		
		
	}
}
