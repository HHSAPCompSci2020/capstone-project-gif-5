package Testers;


import java.awt.Dimension;

import Player.*;
import Enemies.*;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import javax.swing.*;
/**
 * The main class that runs everything
 * @author All of us
 * @version 5/6/2021
 */
public class DungeonGame{
	
	
	
	/**
	 * The main method
	 * @param args The arguments for the method 
	 */
	public static void main(String args[]) {
	
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		javax.swing.JFrame window = (JFrame)canvas.getFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		window.setTitle("DungeonGame");
	
		
		window.setSize(1000, 800);
		window.setMinimumSize(new Dimension(1000,800));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}
	
	
	
	
	
	
	
	
}
