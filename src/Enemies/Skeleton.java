package Enemies;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import Elements.Element;
import Player.*;

/**
 * A class representing the Skeleton enemy type
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Skeleton extends Enemy{

	private boolean canAttack;
	private int counter;
	protected int ogH;
	private ArrayList<Arrow> arrows;
	private PImage arrowImage;
	
	/**
	 * Basic information of a normal Skeleton
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param w width of image
	 * @param h height of image
	 * @param frames number of frames in an animation
	 * @param name the name of the image file
	 */
    public Skeleton(int x, int y, int w, int h, int frames, String name) {
        super(x, y, w, h, frames, name);
		diameter = 40;
		health = 50;
		ogH = 50;
		canAttack = true;
		counter = 0;
		arrows = new ArrayList<Arrow>();
		
	}
    /**
     * draws the Skeleton
     */
    public void draw(PApplet surface, Player p) {
    	
    	super.draw(surface, p);
    	act(surface, p);
    	
    	if(!dead) {
    		surface.fill(255,255,255);
    		surface.rect((float)x-23, (float)y-40, 50, 5);
    		surface.fill(255, 0, 0);
    		surface.rect((float)x-23, (float)y-40, (float)(health*0.01*100), 5);
    	}
    	for(Arrow u : arrows) {
			u.interactWithObjects(p);
			if(u.isDead == true) {
				u = null;
				arrows.remove(u);
				
			}else {
				u.draw(surface);
			}
			
			
		}
    }

    /**
     * What a Skeleton does when they act
     * @param p The player you act with and check if you intersect with
     * @param surface The PApplet it's being drawn on
     */
    public void act(PApplet surface, Player p) {
    	if(counter >= 60) {
    		canAttack = true;
    		counter = 0;
    	}
    
    	if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))>300) {
    		stop = false;
    		super.act(p);
    	}else {
    		stop = true;
    	}
        if (intersects(p) && canAttack) {
            p.setHealth(-10);
            canAttack = false;
        }
        else if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<=300 && canAttack) {
        	Arrow a = new Arrow((int)x, (int)y, 64, 64, "arrow", 1);
        	arrowImage = surface.loadImage("ARROW.png");
        	a.setImage(arrowImage);
        	double dir =  Math.atan2((p.getY()-getY()),(p.getX()-getX()));
    		
			a.direction = dir;
			a.w = this.w;
			arrows.add(a);
			canAttack = false;
        }
        else if(!canAttack) {
        	counter++;
        }
    }
   

    
}

