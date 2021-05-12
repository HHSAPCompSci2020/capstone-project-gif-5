package Enemies;
import processing.core.PApplet;
import Player.*;

/**
 * A class representing the Goblin enemy type
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Goblin extends Enemy{

	/**
	 * Basic information of a normal Goblin
	 */
    public Goblin(int x, int y, int w, int h, int frames, String name) {
        super(x, y, w, h, frames, name);
		diameter = 40;
		health = 25;
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
        if (intersects(p)) {
            p.setHealth(-10);
        }
    }


    
}

