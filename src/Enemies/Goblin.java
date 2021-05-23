package Enemies;
import processing.core.PApplet;
import Player.*;

/**
 * A class representing the Goblin enemy type
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Goblin extends Enemy{

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
    public Goblin(int x, int y, int w, int h, int frames, String name) {
        super(x, y, w, h, frames, name);
		diameter = 40;
		health = 25;
		ogH = 25;
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
    		surface.rect((float)x-23, (float)y-40, 50, 5);
    		surface.fill(255, 0, 0);
    		surface.rect((float)x-23, (float)y-40, (float)(health*0.01*200), 5);
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
        	super.act(p);
        if (intersects(p) && canAttack) {
            p.setHealth(-10);
            canAttack = false;
        }
        if(!canAttack) {
        	counter++;
        }
    }


    
}

