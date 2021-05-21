package Elements;

import java.util.ArrayList;

import Enemies.Enemy;

/**
 * 
 * @author Franklin Wang
 *Fire elemenet
 */
public class Fire extends Element {
protected int speed = 10;
	
	
	
	/**instantiates an ice element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the ice image
	 * @param h the height of the ice image
	 * @param frames The number of frames the animation has
	 * @param name name of the file path
	 * */
	public Fire(int x,int y,int w,int h, int speed, double direction, String name, int frames) {
		
		super(x, y, w, h, speed, direction, name, frames);
		
	}
	
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		
		e.setFired(true);
		e.loseHealth(2);
	
		

	}
	
}
