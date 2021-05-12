package Testers;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;




/*

	Represents a 2D maze.

	Coded by:
	Modified on:

*/

public class DungeonMaker extends Dungeon {

	// Constructs an empty grid
	public DungeonMaker() {
		super();
	}

	// Constructs the grid defined in the file specified
	public DungeonMaker(String filename) {
		super(20,20,filename);
	}

	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.background(0);
		marker.noFill();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				float rectWidth = 32;
				float rectHeight = 32;
				float rectX = x + j * rectWidth+20;
				float rectY = y + i * rectHeight+20;
				
				if(grid[i][j] == '*') {
					marker.fill(255,0,0);
				}
				else if(grid[i][j] == '!') {
					marker.fill(0,255,0);
					
				}else if(grid[i][j] == '.') {
					marker.fill(0,0,255);
					
				}else if(grid[i][j] == '#') {
					marker.fill(0,128,128);
					
				}else if(grid[i][j] == 'X') {
					marker.fill(130,128,30);
					
				}
				else if(grid[i][j] == 'A') {
				marker.fill(245, 132, 66);
				
				}
				else if(grid[i][j] == '@') {
					marker.fill(120, 219, 255);
			
				}else if(grid[i][j] == 0) {
					marker.fill(128,128,128);
					
				}else {
					marker.fill(255,255,255);
				}
			
				
				marker.rect(rectX,rectY,rectWidth,rectHeight);
				
				
				
			}
			
		}
	
}}