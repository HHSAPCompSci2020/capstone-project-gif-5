package Testers;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;



/**
 * This class reads the dungeon and easily makes levels
 * @author ido Tal
 * @version 5/6/20
 *
 */


public abstract class Dungeon {

	/** Add a field to represent the grid. This time, make it a 2D array of characters. **/
	protected char[][] grid;
	
	
	
	/**
	 * Construct an empty 2D array with some default dimensions.
	 */
	public Dungeon() {
		grid = new char[10][10];
		
	}
	
	
	/**
	 * Construct an empty 2D array with dimensions width and height, then fill it with data from the file filename.
	 * 
	 * @param width The width of the grid.
	 * @param height The height of the grid.
	 * @param filename The text file to read from.
	 */
	public Dungeon(int width, int height, String filename) {
		grid = new char[height][width];
		this.readData(filename, grid);
	}
	
	
	/**
	 * 
	 * Code a toString() method that nicely prints the grid to the commandline.
	 * 
	 */
	public String toString() {
		String output = "";
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length;j++) {
                output += grid[i][j];
            }
            output += "\n";
        }
        return output;
	}
	
	
	/**
	 * (Graphical UI)
	 * Draws the grid on a PApplet.
	 * The specific way the grid is depicted is up to the coder.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.noFill();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				float rectWidth = width / grid[0].length;
				float rectHeight = height / grid.length;
				float rectX = x + j * rectWidth;
				float rectY = y + i * rectHeight;
				
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
        
	}
	
	
	/**
	 * (Graphical UI)
	 * Determines which element of the grid matches with a particular pixel coordinate.
	 * This supports interaction with the grid using mouse clicks in the window.
	 * 
	 * @param p A Point object containing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the grid, or null if the pixel coordinate
	 * falls completely outside of the grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		
		double x2 = (p.getX()-x)/height*20;
		double y2 = (p.getY()-y)/width*20;
		
		
			
		
		Point g = new Point((int)y2,(int)x2);
		
		if(g.getY()>19 || g.getX()>19 || g.getY()<0 || g.getX()<0) {
			return null;
		}
		
		
		return g;
	}
	

	/**
	 * This reads the file and updates the array
	 * @param filename the name of the file being read
	 * @param gameData the data of whats there 
	 */
	public void readData (String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);
					
					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (count < gameData.length && i < gameData[count].length)
								gameData[count][i] = line.charAt(i);

						count++;
					}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
}
