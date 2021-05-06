package Enemies;

import javax.swing.*;
import Enemies.*;
import processing.core.*;
import gbitton299.shapes.*;
import Player.*;
import java.lang.*;
import Player.*;
public class Enemy {

    protected int x, y, diameter, health;
    protected int ax, ay;
    boolean sawPlayer = false;

    public void act(Player p) {//double angle) {
        if((Math.sqrt(Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2)))<500) {
            sawPlayer = true;
        }
        if(sawPlayer) {
            if(x<p.getX()) {
                x+=2;
            }
            else if(x>p.getX()) {
                 x-=2;   
            }
            if(y<p.getY()) {
                y+=2;
            }
            else if(y>p.getY()) {
             y-=2;
            }
        }
    }

    

    public boolean isPointInside(double x1, double y1) {
        boolean isPointInside = false;
        double d = Math.sqrt((x1 - x) * 2 + (y1 - y) * 2);
        if (d <= diameter / 2) {
            isPointInside = true;
        }
        return isPointInside;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public boolean intersects(Player p) {
        float distanceX = (float)p.getX() - getX();
        float distanceY = (float)p.getY() - getY();
        float radiusSum = getDiameter() / 2 + p.getDiameter();
        return distanceX * distanceX + distanceY * distanceY <= radiusSum * radiusSum;
    }

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

    public double getAngle(Player p){
        return Math.atan2((double) p.getX() - getX(), (double) p.getY() - getY());
    }
    
    public void loseHealth(int x) {
    	health -= x;
    }

}
