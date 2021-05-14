package Testers;

import Elements.Ice;
import processing.core.PImage;

public class IceSurface extends DrawingSurface {
	
	private PImage iceImg;
	
	public IceSurface() {
		super();
	}
	
	public void setup() {
		iceImg = loadImage("icicle8.png");
	}
	
	public void draw() {
		 translate((float) (master.getX()-5), (float) master.getY()+15);
		 double x = Math.atan2(master.getY2() - master.getY(), master.getX2() - master.getX());
		 System.out.println("x : " + x);
		 rotate((float) (x));
		Ice i = new Ice((int)master.getX(), (int)master.getY(), 64, 64, 10, x, "ice", 1);
		i.setImage(iceImg);
		elements.add(i);
	}
}
