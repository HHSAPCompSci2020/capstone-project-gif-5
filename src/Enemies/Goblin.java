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
    public Goblin() {
        super();
		x = 700;
		y = 700;
		diameter = 40;
		health = 25;
	}

    /**
     * What a Goblin does when they act
     * @param p The player you act with and check if you intersect with
     */
    public void act(Player p) {
        super.act(p);
        if (intersects(p)) {
            p.setHealth(-10);
        }
    }


    
}

