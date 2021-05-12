package Testers;

import javax.swing.*;

import Elements.Element;
import Elements.Ice;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;
import java.lang.*;
import java.util.ArrayList;
/*
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
*/





/**
 * 
 * @author ido Tal
 * @version
 * This class connects everything together and draws it
 */


public class ElementTester extends PApplet {
	
	Element ice;
	Player master;
	
	private PImage iceImg = new PImage();
	private PImage photo;
	
	/**
	 * constructs the player and some monsters
	 */
	public ElementTester() {
		System.out.println("2");
		if(iceImg == null) {
			System.out.println("FAIL");
		}
		else System.out.println("SUCCESS");
		
		ice = new Ice(100, 100, 100, 100, 1, "icicle1.png");
//		master = new Player(photo,  10,  10,  32,  32,   "WIZARD",6);
	}
		
	/**
	 * initializes the images
	 */
	public void setup() {
		System.out.println("1");
		iceImg = loadImage("icicle" + 1 + ".png");
//		photo = loadImage("WIZARD"+1+".png");
	}
	
	/**
	 * draws the enemiesand other things on the dungeon
	 */
	public void draw() {
//		System.out.println("asdf");
		ice.draw(this);
//		master.draw(this);
	}	
}
