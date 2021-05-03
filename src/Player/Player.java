package Player;
import gbitton299.shapes.*;
import processing.core.PApplet;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Player{
	
	private int x,y, diameter;
	private int ax,ay;
	private double health;
	private double secondX,secondY;
	private boolean run = true;
	private boolean keyReleased;
	private int state = 0;
	
	public Player() {
	
		x = 100;
		y = 100;
		diameter = 40;
		health = 100;
		
	}
	
	


	public void draw(PApplet surface) {
		secondX = surface.mouseX;
		secondY = surface.mouseY;
		accelerate();
		
		//surface.circle((float)x, (float)y, (float)(Math.abs(diameter)));
		//surface.line(x, y, secondX, secondY);
		
	}

	public void keyReleased(){
		keyReleased = true;
	}
	

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

	
	public void moveUp(){
		if(isPointInside(x,diameter + 10)) {
			return;
		}
		ay = -10;
	}

	public void moveDown(){
		if(isPointInside(x, 800 + diameter * 2)) {
			return;
		}
		ay = 10;
	}

	public void moveRight(){
		if(isPointInside(1000 + diameter * 2, y)) {
			return;
		}
		ax = 10;
	}

	public void moveLeft() {
		if(isPointInside(diameter / 2, y)) {
			return;
		}
		ax = -10;
	}



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


	public void changeState(int changer){
		state = changer;
	}

	//Hit Box Methods:

	public boolean isPointInside(double x1, double y1) {
		boolean isPointInside = false;
		double d = Math.sqrt((x1 - x) * 2 + (y1 - y) * 2);
		if (d <= diameter / 2) {
			isPointInside = true;
		}
		return isPointInside;
	}

	public void setHealth(double change) {
		health += change;
		if(health <= 0) {
			System.exit(1);
		}
	}


	public int getX(){
		return x;
	}

	public int getY() {
		return y;
	}

	public double getX2() {
		return secondX;
	}

	public double getY2() {
		return secondY;
	}

	public int getDiameter() {
		return diameter;
	}
	public void runTrue(){
		run = true;
	}

	public double getHealth() {
		return health;
	}
	
}
