package Testers;


import java.awt.Dimension;
import Player.*;
import Enemies.*;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import javax.swing.*;
public class DungeonGame{
	
	
	
	
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
		
		
		
	}//bruh
	
	
	
	
	
	
	
	
}
