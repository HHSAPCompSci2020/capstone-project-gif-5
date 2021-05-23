package Enemies;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import Elements.Element;
import Player.*;

/**
 * A class representing the Witch enemy type
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Witch extends Enemy{

	private boolean canAttack;
	private boolean canSpawn;
	private int counter;
	private int counter2;
	protected int ogH;
	private ArrayList<Skeleton> enemies;
	private ArrayList<WMagic> magic;
	private PImage skellyImage;
	private PImage skellyImage2;
	private PImage magicImg;
	private boolean beg = true;
	
	/**
	 * Basic information of a normal Witch
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
		canSpawn = true;
		counter = 0;
		enemies = new ArrayList<Skeleton>();
		magic = new ArrayList<WMagic>();
	}
    /**
     * draws the Witch
     */
    public void draw(PApplet surface, Player p) {
    	
    	
    	if(beg) {
    		beg = false;
    		magicImg = surface.loadImage("wmagic.png");
    	}
    	
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
    	for(WMagic u : magic) {
			u.interactWithObjects(p);
			if(u.isDead == true) {
				u = null;
				magic.remove(u);
				
			}else {
				u.draw(surface);
			}
			
			
		}
    }

    /**
     * What a Witch does when they act
     * @param p The player you act with and check if you intersect with
     * @param surface the surface it's being drawn on 
     */
    public void act(PApplet surface, Player p) {
    	if(counter >= 300) {
    		canSpawn = true;
    		counter = 0;
    	}
    	if(counter2 >= 60) {
    		canAttack = true;
    		counter2 = 0;
    	}
 
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
        if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<=400 && canSpawn) {
			Skeleton skelly = new Skeleton((int)x,(int)y, 64, 64, 6, "skeleton");
			PImage skellyImg = surface.loadImage("skeleton.png");
			skelly.setImage(skellyImg);
			skellyImg.resize(100, 100);
			skellyImg = surface.loadImage("lskeleton.png");
				
			skelly.setImage2(skellyImg);
			skelly.w = this.w;
			enemies.add(skelly);
			canSpawn = false;
        }
        if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<=400 && canAttack) {
        	WMagic m = new WMagic((int)x, (int)y, 32, 32, "magic", 1);
        	
        	m.setImage(magicImg);
        	double dir =  Math.atan2((p.getY()-getY()),(p.getX()-getX()));
    		
			m.direction = dir;
			m.w = this.w;
			magic.add(m);
			canAttack = false;
        }
        if(!canAttack) {
        	counter2++;
        }
        if(!canSpawn) {
        	counter++;
        }
    }
    
    public void attack() {
    	
    }

    public ArrayList<Skeleton> getEnemies() {
    	return enemies;
    }
    
}

