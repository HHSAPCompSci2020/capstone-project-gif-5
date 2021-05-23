package Testers;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import processing.core.PApplet;
import processing.core.PImage;

import processing.core.*;
import java.lang.*;

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

	Represents a 2D maze.

	Coded by: Ido Tal
	Modified on: Ido Tal

*/

public class DungeonMaker extends Dungeon {
	
	/**
	 * constructs an empty grid
	 */

	public DungeonMaker() {
		super();
	}
	/**
	 * he grid defined in the file specified
	 * @param filename The name of the file
	 */
	// Constructs the grid defined in the file specified
	public DungeonMaker(String filename) {
		super(12,10,filename);
		
		 
	}
	/**
	 * draws the grid
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.background(37,19,26);
		marker.noFill();
	
		
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				float rectWidth = 64;
				float rectHeight = 64;
				float rectX = x + j * rectWidth+100;
				float rectY = y + i * rectHeight+50;
			
				if(grid[i][j] == '*') {
					marker.fill(255,0,0);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
					
				
				}
				else if(grid[i][j] == '!') {
					marker.fill(0,255,0);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
					
				}else if(grid[i][j] == '.') {
					marker.fill(0,0,255);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
					
				}else if(grid[i][j] == '#') {
					marker.fill(0,0,200);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
					
				}else if(grid[i][j] == 'X') {
					marker.fill(130,128,30);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
					
				}
				else if(grid[i][j] == 'A') {
					marker.fill(245, 132, 66);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
				
				}
				else if(grid[i][j] == '@') {
					marker.fill(120, 219, 255);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
			
				}else if(grid[i][j] == 0) {
					marker.fill(128,128,128);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
					
				}else {
					marker.fill(255,255,255);
					marker.rect(rectX,rectY,rectWidth,rectHeight);
				}
		
				
				
				
				
				
			}
			
		}
	
}}