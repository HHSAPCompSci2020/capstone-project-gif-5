package Player;
import gbitton299.shapes.*;
import processing.core.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * 
 * @author Ido
 * @version 5/6
 * 
 */

public class Player extends MovingImage{
	
	private int x,y, diameter;
	private int ax,ay;
	private double health;
	private double secondX,secondY;
	private boolean run = true;
	private boolean keyReleased;
	private int state = 0;
	/**
	 * 
	 * @param i the image
	 * @param x the x variable which it will start in
	 * @param y the y variable it starts in
	 * @param w the width of the image
	 * @param h the height of the image
	 * @param name the name of the image file
	 * @param frames the number of frames of the player
	 */
	public Player(PImage i,int x,int y,int w,int h,String name, int frames) {
		
		super( i,  x,  y,  w,  h,  frames,  name);
		
	}
	
	
	

	/**
	 * draws the wizard
	 */
	public void draw(PApplet surface) {
		secondX = surface.mouseX;
		secondY = surface.mouseY;
		accelerate();
		act();
		
		
		
	}
	/**
	 * checks when a key is released
	 */
	public void keyReleased(){
		keyReleased = true;
	}
	
	/**
	 * a method that acts everytime drawn
	 */
	public void act() {
		if (run) {
			accelerate();
			if (keyReleased) {
				run = false;
				keyReleased = false;
			}
		}
	}

	


	//MOVE METHODS

	/**
	 * checks if it can move up
	 */
	public void moveUp(){
		if(isPointInside(x,diameter + 10)) {
			return;
		}
		ay = -10;
	}
	/**
	 * checks if it can move down
	 */
	public void moveDown(){
		if(isPointInside(x, 800 + diameter * 2)) {
			return;
		}
		ay = 10;
	}
	/**
	 * checks if it can move right
	 */
	public void moveRight(){
		if(isPointInside(1000 + diameter * 2, y)) {
			return;
		}
		ax = 10;
	}
	/**
	 * checks if it can move left
	 */
	public void moveLeft() {
		if(isPointInside(diameter / 2, y)) {
			return;
		}
		ax = -10;
	}

	
	/**
	 * accelerates the object
	 */
	public void accelerate(){
		double amount = 0.2;
		if(ax>0){
			ax -= amount;
		}
		else if (ax<0){
			ax += amount;
		}
		if(ay>0){
			ay -= amount;
		}
		else if(ay<0){
			ay += amount;
		}
		x += ax;
		y += ay;


		if (run) {
			if (state == 1) {
				moveUp();
			}
			if (state == 2) {
				moveDown();
			}
			if (state == 3) {
				moveRight();
			}
			if (state == 4) {
				moveLeft();
			}
			if (keyReleased) {
				run = false;
				keyReleased = false;
			}
		}
	}

	/**
	 * makes it so you move smoothly in correct direction
	 * @param changer the way you move
	 */
	public void changeState(int changer){
		state = changer;
	}

	//Hit Box Methods:
	/**
	 * checks if point is inside the hitbox
	 * @param x1 x pos
	 * @param y1 y pos
	 * @return if the point is  inside
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
	 * adds an amount to the health
	 * @param change new value to set health to
	 */
	public void setHealth(double change) {
		health += change;
		if(health <= 0) {
			System.exit(1);
		}
	}

	/**
	 * @return the x value
	 */
	public double getX(){
		return x;
	}
	/**
	 * @return the y value
	 */
	public double getY() {
		return y;
	}
	/**
	 * @return the x2 value
	 */
	public double getX2() {
		return secondX;
	}
	/**
	 * @return the y2 value
	 */
	public double getY2() {
		return secondY;
	}
	/**
	 * @return the diameter of the hitbox
	 */
	public int getDiameter() {
		return diameter;
	}
	/**
	 *  makes run to true
	 */
	public void runTrue(){
		run = true;
	}
	/**
	 * @return the value of the health
	 */
	public double getHealth() {
		return health;
	}
	
}
