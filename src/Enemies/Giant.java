package Enemies;
import processing.core.PApplet;
import Player.*;

/**
 * A class representing the Goblin enemy type
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Giant extends Enemy{

	private boolean canAttack;
	private int counter;
	protected int ogH;
	/**
	 * Basic information of a normal Goblin
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param w width of image
	 * @param h height of image
	 * @param frames number of frames in an animation
	 * @param name the name of the image file
	 */
    public Giant(int x, int y, int w, int h, int frames, String name) {
        super(x, y, w, h, frames, name);
		diameter = 80;
		health = 100;
		ogH = 100;
		canAttack = true;
		counter = 0;
	}
    /**
     * draws the goblin
     */
    public void draw(PApplet surface, Player p) {
    	
    	super.draw(surface, p);
    	if(!dead) {
    		surface.fill(255,255,255);
    		surface.rect((float)x-23, (float)y-80, 50, 5);
    		surface.fill(255, 0, 0);
    		surface.rect((float)x-23, (float)y-80, (float)(health*0.01*50), 5);
    	}
    	act(p);
    }

    /**
     * What a Goblin does when they act
     * @param p The player you act with and check if you intersect with
     */
    public void act(Player p) {
    	if(counter >= 180) {
    		canAttack = true;
    		counter = 0;
    	}
    	//System.out.print("bruh");
        if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<500) {
        	   
            sawPlayer = true;
        }
        
       
        
        
        if(sawPlayer) {
        	
        	if(frozen) {
            	if(x<p.getX()) {
            		moveByAmount(-0.3,0);
                }
                else if(x>p.getX()) {
                	moveByAmount(0.3,0);
                }
                if(y<p.getY()) {
                	moveByAmount(0,-0.3);
                }
                else if(y>p.getY()) {
                	moveByAmount(0,0.3);
                }
            }
        	
        	
            if(x<p.getX()) {
            	moveByAmount(1,0);
            }
            else if(x>p.getX()) {
            	moveByAmount(-1,0);
            }
            if(y<p.getY()) {
            	moveByAmount(0,1);
            }
            else if(y>p.getY()) {
            	moveByAmount(0,-1);
            }
            
            
            
        }
        if (intersects(p) && canAttack) {
            p.setHealth(-20);
            canAttack = false;
        }
        if(!canAttack) {
        	counter++;
        }
    }


    
}

