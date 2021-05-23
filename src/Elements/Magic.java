package Elements;

import java.util.ArrayList;

import Enemies.Enemy;

/**
 * 
 * @author Franklin Wang
 *Magic elemenet
 */
public class Magic extends Element {
	/**instantiates an magic element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the magic image
	 * @param h the height of the magic image
	 * @param frames The number of frames the animation has
	 * @param name name of the file path
	 * @param direction direction of the element
	 * @param speed the speed of the object
	 * */
	public Magic(int x, int y, int w, int h, int speed, double direction, String name, int frames) {
		super(x, y, w, h, speed, direction, name, frames);
	
	}

	@Override
	/**
	 * Draws the element using PApplet
	 * @param This is a PApplet object
	 */
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		e.loseHealth(5);
		
	}
	
}
