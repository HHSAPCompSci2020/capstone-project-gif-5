package Elements;

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
	public void dissipate() {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(PApplet surface) {
		iceImg = surface.loadImage(name);
		this.setImage(iceImg);
		super.draw(surface);
		
		
		
	}
}
