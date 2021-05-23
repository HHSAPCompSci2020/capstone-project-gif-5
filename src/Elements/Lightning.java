package Elements;

import Enemies.Enemy;
import processing.core.PApplet;

import java.util.ArrayList;

import Enemies.Enemy;

public class Lightning extends Element{

	int hitCount = 0;
	
	public Lightning(int x, int y, int w, int h, int speed, double direction, String name, int frames) {
		super(x, y, w, h, speed, direction, name, frames);
		// TODO Auto-generated constructor stub
	}

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
	public void strikeEnemy(double direction, Enemy e, ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub
		e.loseHealth(1);
		
//		ArrayList<Enemy> enemiesCopy = new ArrayList<Enemy>(enemies.size());
//		for(int a = 0; a < enemies.size(); a ++) {
//			enemiesCopy.add(enemies.get(a));
//		}
//		
//		Enemy e1 = closestEnemy(enemiesCopy);
//		//move towards e1
//		
//		e1.loseHealth(10);
//	
//		
		
//		double angle = Math.atan((e1.y - y) / (e1.x - x));
//		
//		moveByAmount(10 * speed * Math.cos(angle), 10 * speed * Math.sin(angle));
////		System.out.println(10 * speed * Math.cos(angle));
//		
//		System.out.println(Math.toDegrees(angle));
//		
//		if(this.intersectsEnemy(e1)) {
////			System.out.println("DSAFASDFASD");
//			e1.loseHealth(5);
//		}
//		else {}
//		
//		enemiesCopy.remove(closestEnemyIndexInArray(enemiesCopy));
//		Enemy e2 = closestEnemy(enemiesCopy);
		// travel towards e1
		
			//
		
		}
	
	
	
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
