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
	
	/**
	 * Basic information of a normal Goblin
	 */
    public Goblin(int x, int y, int w, int h, int frames, String name) {
        super(x, y, w, h, frames, name);
		diameter = 40;
		health = 25;
		canAttack = true;
		counter = 0;
	}
    
    public void draw(PApplet surface, Player p) {
    	
    	super.draw(surface, p);
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

