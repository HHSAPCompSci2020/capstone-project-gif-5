
package Enemies;

import javax.swing.*;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;
import java.lang.*;
import Player.*;
/**
 * A class supposed to describe an enemy in the game, it also has everything any enemy can do or anything it has.
 * @author Gilad Bitton
 * @version 5/6/2021
 */
public class Enemy extends MovingImage{
	
	protected int diameter, health = 100;
	protected int ogH= 100;
    protected int ax, ay;
    boolean sawPlayer = false;
    public boolean dead = false;
    boolean frozen = false;
	
    public Enemy(int x, int y, int w, int h, int frames, String name) {
		super(x, y, w, h, frames, name);
		// TODO Auto-generated constructor stub
	}

	
    
    public void draw(PApplet surface, Player p) {
    	if(!dead) {
    		surface.fill(255,255,255);
    		surface.rect((float)x-23, (float)y-40, 50, 5);
    		surface.fill(255, 0, 0);
    		surface.rect((float)x-23, (float)y-40, (float)(health* 0.02 * ogH), 5);
    		super.draw(surface);
    		act(p);
    	}
    }
    
    public boolean getFrozen() {
    	return frozen;
    }
    
    public void setFrozen(boolean b) {
    	frozen = b;
    }

    /**
     * A method representing how each enemy will act, for example, all enemies will move towards the player.
     * @param p The Player the Enemy moves towards
     */
    public void act(Player p) {//double angle) {
    	
    	
    	
        if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<500) {
   
            sawPlayer = true;
        }
        
       
        
        
        if(sawPlayer) {
        	
        	if(frozen) {
            	if(x<p.getX()) {
            		moveByAmount(-0.5,0);
                }
                else if(x>p.getX()) {
                	moveByAmount(0.5,0);
                }
                if(y<p.getY()) {
                	moveByAmount(0,-0.5);
                }
                else if(y>p.getY()) {
                	moveByAmount(0,0.5);
                }
            }
        	
        	
            if(x<p.getX()) {
            	moveByAmount(1.5,0);
            }
            else if(x>p.getX()) {
            	moveByAmount(-1.5,0);
            }
            if(y<p.getY()) {
            	moveByAmount(0,1.5);
            }
            else if(y>p.getY()) {
            	moveByAmount(0,-1.5);
            }
            
            
            
        }
        
        
       
        
        
       
    }

    
    /**
     * A method to check if something is inside the enemy
     * @param x1 The x coordinate of the thing that you check
     * @param y1 The y coordinate of the thing that you check
     * @return returns whether or not those coordinates are within the enemy "circle".
     */
    public boolean isPointInside(double x1, double y1) {
        boolean isPointInside = false;
        double d = Math.sqrt((x1 - x) * 2 + (y1 - y) * 2);
        if (d <= diameter / 2) {
            isPointInside = true;
        }
        return isPointInside;
    }

    /**
     * 
     * @return X location of enemy
     */
    public double getX() {
        return x;
    }

    /**
     * 
     * @return Y location of enemy
     */
    public double getY() {
        return y;
    }

    
   /**
    * 
    * @return Diameter of enemy "Circle"
    */
    public int getDiameter() {
        return diameter;
    }

    /**
     * Checks if an enemy and a player are intersecting
     * @param p The player you check if you intersect with
     * @return whether or not the enemy intersected with the Player.
     */
    public boolean intersects(Player p) {
        float distanceX = (float)(p.getX() - getX());
        float distanceY = (float)(p.getY() - getY());
        float radiusSum = getDiameter() / 2 + p.getDiameter();
        return distanceX * distanceX + distanceY * distanceY <= radiusSum * radiusSum;
    }

    /** 
     * Controls how fast the enemy is going when they accelerate from 0 to their max speed.
     */
    public void accelerate() {
        double amount = 0.2;
        if (ax > 0) {
            ax -= amount;
        } else if (ax < 0) {
            ax += amount;
        }
        if (ay > 0) {
             ay -= amount;
        } else if (ay < 0) {
            ay += amount;
        }
        x += ax;
        y += ay;
    }

    /**
     * Gets the angle of the enemy relative to the player
     * @param p The Player you check how far you are away from
     * @return The angle from the enemy to the player
     */
    public double getAngle(Player p){
        return Math.atan2((double) p.getX() - getX(), (double) p.getY() - getY());
    }
    
    /**
     * Loses a specified amount of health
     * @param x Amount of health lost
     */
    public void loseHealth(int x) {
    	
    	health -= x;
    	if(health <= 0) {
    		x = -100;
    		y = - 100;
    		dead = true;
    	}
    }
    
    /**
     * 
     * @return Amount of health the enemy has
     */
    public int getHealth() {
    	return health;
    }

}
