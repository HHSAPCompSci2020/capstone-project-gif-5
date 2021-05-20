package Elements;

import java.util.ArrayList;

import Enemies.Enemy;

/**
 * 
 * @author Franklin Wang
 *earth elemenet
 */
public class Earth extends Element{

	public Earth(int x, int y, int w, int h, int speed, double direction, String name, int frames) {
		super(x, y, w, h, speed, direction, name, frames);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub
		e.loseHealth(5);
		
	}
}
