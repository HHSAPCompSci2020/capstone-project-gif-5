package Elements;

import java.util.ArrayList;

import Enemies.Enemy;

/**
 * 
 * @author Franklin Wang
 *Magic elemenet
 */
public class Magic extends Element {

	public Magic(int x, int y, int w, int h, int speed, double direction, String name, int frames) {
		super(x, y, w, h, speed, direction, name, frames);
	
	}

	@Override
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		e.loseHealth(5);
		
	}
	
}
