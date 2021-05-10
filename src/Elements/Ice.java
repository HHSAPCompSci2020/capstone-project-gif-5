package Elements;

import gbitton299.shapes.Shape;
import processing.core.PImage;

public class Ice extends Element {
	
//	private int speed;
//	private double direction; // in radians
//	private Shape s; //for testing intersections

	
	//what does "frames" do?
	/**instantiates an ice element
	 * @param img the ice image
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * @param speed the speed of the ice element
	 * @param direction the direction that the ice element will move towards
	 * */
	public Ice(int x,int y,int w,int h,String name, int frames) {
//		super(img, speed, speed, speed, speed, speed, speed, direction, "icicle1.png");
		super( x,  y,  w,  h,  frames,  name);
	}
//		mario = new Mario(loadImage("mario.png"), DRAWING_WIDTH/2-Mario.MARIO_WIDTH/2,50);
	@Override
	public void dissipate() {
		// TODO Auto-generated method stub
		
	}
}
