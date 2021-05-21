
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
    boolean fired = false;
    private int counter = 0;
    private int fcounter = 0;
	/**
	 * 
	 * @param x the x variable
	 * @param y the y variable 
	 * @param w the width of the enemy
	 * @param h the height of the enemy
	 * @param frames frames in a goblin
	 * @param name name of the png file
	 */
    public Enemy(int x, int y, int w, int h, int frames, String name) {
		super(x, y, w, h, frames, name);
		// TODO Auto-generated constructor stub
	}

	
    /**
     * Draws the enemy
     * @param surface PApplet object 
     * @param p the player
     */
    public void draw(PApplet surface, Player p) {
    	if(!dead) {
    		super.draw(surface);
    		act(p);
    	}
    	if(frozen) {
    		counter++;
    		if(counter>100) {
    			setFrozen(false);
    		}
    		
    	}
    	if(fired) {
    		
    		if(fcounter%10==0) {
    			loseHealth(1);
    		}
    		frozen = false;
    		fcounter++;
    		if(fcounter>100) {
    			setFired(false);
    		}
    		
    	}
    }
    /**
     * gets the enemy freeze state
     * @return freeze state
     */
    public boolean getFrozen() {
    	return frozen;
    }
    /**
     * freezes or un freezes enemy
     * @param b what to change the freeze state to
     */
    public void setFrozen(boolean b) {
    	frozen = b;
    	counter = 0;
    	
    	
    }
    
    public boolean getFired() {
    	return fired;
    }
    
    public void setFired(boolean b) {
    	fired = b;
    	fcounter = 0;
    	
    	
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
