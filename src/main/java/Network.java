package main.java;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/
public class Network {
	
<<<<<<< HEAD
	private MainApplet parent;
=======
	private PApplet parent;
>>>>>>> 72493895dc77129feb2598fd4ec68f127009fa16
	private int radius=200;
	private int x,y;

	public Network(MainApplet parent){

		this.parent = parent;
		x=600;
		y=335;
	}

	public void display(){
<<<<<<< HEAD
		float distance = PApplet.dist(x,y,parent.mouseX,parent.mouseY);
		
		if(parent.hasObject() && distance < radius){
			parent.strokeWeight(6);			
		}
		else{		
			parent.strokeWeight(4);		
		}
		parent.stroke(173,217,231);
		parent.fill(255);
		
		parent.ellipse(x, y, radius*2, radius*2);
				
=======
		parent.fill(255);
		parent.stroke(125);
		parent.strokeWeight(4);
		parent.ellipse(x, y, radius*2, radius*2);
>>>>>>> 72493895dc77129feb2598fd4ec68f127009fa16
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
