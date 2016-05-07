package main.java;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/
public class Network {
	
	private PApplet parent;
	private int radius=200;
	private int x,y;

	public Network(PApplet parent){

		this.parent = parent;
		x=600;
		y=335;
	}

	public void display(){
		parent.fill(255);
		parent.stroke(125);
		parent.strokeWeight(4);
		parent.ellipse(x, y, radius*2, radius*2);
	}
		
	public int getRadius(){
		return this.radius;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
}
