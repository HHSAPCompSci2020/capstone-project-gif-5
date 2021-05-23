package Elements;

import Enemies.Enemy;
import processing.core.PApplet;

import java.util.ArrayList;

import Enemies.Enemy;
/**
 * 
 * @author Franklin Wang
 * This is the lightning clasas and it makes a lightning
 *
 */
public class Lightning extends Element{

	int hitCount = 0;
	/**instantiates an ice element
	 * @param x the starting x coordinate
	 * @param y the starting y coordinate
	 * @param w the width of the lightning image
	 * @param h the height of the lightning image
	 * @param frames The number of frames the animation has
	 * @param name name of the file path
	 * */
	public Lightning(int x, int y, int w, int h, int speed, double direction, String name, int frames) {
		super(x, y, w, h, speed, direction, name, frames);
		
	}
	/**
	 * This finds the closest enemy
	 * @param enemies all the enemies on dungeon
	 * @return the closest enemy to the lightning
	 */
	private Enemy closestEnemy(ArrayList<Enemy> enemies) {
		double largestDist = Math.pow(Math.pow(enemies.get(0).x, 2) + Math.pow(enemies.get(0).y, 2), 0.5);
		int largestDistIndex = 0;
		
		for(int i = 0; i < enemies.size(); i ++) {
			if((Math.pow(Math.pow(enemies.get(i).x, 2) + 
					Math.pow(enemies.get(i).y, 2), 0.5))> largestDist)
			{
				largestDist = (Math.pow(Math.pow(enemies.get(i).x, 2) + 
						Math.pow(enemies.get(i).y, 2), 0.5));
				largestDistIndex = i;
			}
		}
		
		return enemies.get(largestDistIndex);
	}
	/**
	 * Finds closest enemy index
	 * @param enemies the enemy array
	 * @return the closest enemy index
	 */
	private int closestEnemyIndexInArray(ArrayList<Enemy> enemies) {
		double largestDist = Math.pow(Math.pow(enemies.get(0).x, 2) + Math.pow(enemies.get(0).y, 2), 0.5);
		int largestDistIndex = 0;
		
		for(int i = 0; i < enemies.size(); i ++) {
			if((Math.pow(Math.pow(enemies.get(i).x, 2) + 
					Math.pow(enemies.get(i).y, 2), 0.5))> largestDist)
			{
				largestDist = (Math.pow(Math.pow(enemies.get(i).x, 2) + 
						Math.pow(enemies.get(i).y, 2), 0.5));
				largestDistIndex = i;
			}
		}
		
		return largestDistIndex;
	}
	
	@Override
	/**
	 * @param The direction the element will go to
	 * @param	 the enemy its hitting
	 * @param all of the enemies that are in the array list
	 */
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		
		e.loseHealth(1);
		
		
		}
	
	
	/**
	 * Draws the element using PApplet
	 * @param g This is a PApplet object
	 */
	public void draw(PApplet g) {
		
		if(isDead) {}
		else {
			
		
			g.pushMatrix();
			g.translate((float)x+width/2,(float) y+height/2);
			
			g.rotate((float)direction+(float)0);
			
			g.image(image,(int)0,(int)0,(int)width,(int)height);
			g.popMatrix();
			
			
			move();
			}
		
	}
	
	
}
