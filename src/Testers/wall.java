package Testers;

import java.awt.geom.Rectangle2D;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.*;
import javax.swing.*;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;
import java.lang.*;
/**
 * 
 * @author ido Tal
 *A wall object 
 */
public class wall extends Rectangle2D.Double{
	/**
	 *  Creates a wall
	 * @param x the x coord
	 * @param y the y coord
	 * @param w the width
	 * @param h the height
	 */
	public wall(int x, int y, int w, int h) {
		super(x,y,w,h);
	}
	
}
