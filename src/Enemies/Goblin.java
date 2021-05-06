package Enemies;
import processing.core.PApplet;
import Player.*;

public class Goblin extends Enemy{

    

    public Goblin() {
        super();
		x = 700;
		y = 700;
		diameter = 40;
		health = 25;
	}

    public void act(Player p) {
        super.act(p);
        if (intersects(p)) {
            p.setHealth(-10);
        }
    }


    
}

