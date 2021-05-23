package Enemies;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import Elements.Element;
import Player.*;

/**
 * A class representing the Goblin enemy type
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Witch extends Enemy{

	private boolean canAttack;
	private int counter;
	protected int ogH;
	private ArrayList<Skeleton> enemies;
	private PImage skellyImage;
	private PImage skellyImage2;
	
	/**
	 * Basic information of a normal Goblin
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param w width of image
	 * @param h height of image
	 * @param frames number of frames in an animation
	 * @param name the name of the image file
	 */
    public Witch(int x, int y, int w, int h, int frames, String name) {
        super(x, y, w, h, frames, name);
		diameter = 40;
		health = 50;
		ogH = 50;
		canAttack = true;
		counter = 0;
		enemies = new ArrayList<Skeleton>();
		
	}
    /**
     * draws the goblin
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
    	for(Skeleton u : enemies) {
			u.act(surface, p);
			if(u.dead == true) {
				u = null;
				enemies.remove(u);
				
			}else {
				u.draw(surface);
			}
			
			
		}
    }

    /**
     * What a Goblin does when they act
     * @param p The player you act with and check if you intersect with
     */
    public void act(PApplet surface, Player p) {
    	if(counter >= 180) {
    		canAttack = true;
    		counter = 0;
    	}
    	//System.out.print("bruh");
    	if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))>400) {
    		stop = false;
    		super.act(p);
    	}else {
    		stop = true;
    	}
        if (intersects(p) && canAttack) {
            p.setHealth(-10);
            canAttack = false;
        }
        else if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<=400 && canAttack) {
			Skeleton skelly = new Skeleton((int)x,(int)y, 64, 64, 6, "skeleton");
			PImage skellyImg = surface.loadImage("skeleton.png");
			skelly.setImage(skellyImg);
			skellyImg.resize(100, 100);
			skellyImg = surface.loadImage("lskeleton.png");
				
			skelly.setImage2(skellyImg);
			skelly.w = this.w;
			enemies.add(skelly);
			canAttack = false;
        }
        else if(!canAttack) {
        	counter++;
        }
    }
    
    public void attack() {
    	
    }

    public ArrayList<Skeleton> getEnemies() {
    	return enemies;
    }
    
}

