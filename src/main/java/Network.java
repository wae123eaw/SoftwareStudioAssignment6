package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/
public class Network {
	
	private ArrayList<Character>characters;
	private MainApplet parent;

	private int radius=200;
	private int x,y;

	public Network(MainApplet parent){

		this.parent = parent;
		x=600;
		y=335;
		
		characters = new ArrayList<Character>();
	}

	public void display(){

		float distance = PApplet.dist(x,y,parent.mouseX,parent.mouseY);
		
		if(parent.hasObject() && distance < radius){
			parent.strokeWeight(8);			
		}
		else{		
			parent.strokeWeight(4);		
		}
		parent.stroke(173,217,231);
		parent.fill(255);
		
		parent.ellipse(x, y, radius*2, radius*2);	
			
	}
	
	private void reArrange(){
		int i=0;
		for(Character c: characters){
			System.out.println(characters.size());
			c.setX((int) (x + radius * Math.cos(Math.toRadians(360/characters.size()*i))));
			c.setY((int) (y + radius * Math.sin(Math.toRadians(360/characters.size()*i))));
			i++;
		}
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
	
	public void add(Character c){
		if(!characters.contains(c)){
			characters.add(c);			
		}
		reArrange();
	}
	
	public void remove(Character c){
		if(characters.contains(c)){
		characters.remove(c);
		}
		reArrange();		
	}
	
	public void removeAll(){
		for(Character c : characters)
			c.fly();
		characters.clear();
		
	}
	
	public ArrayList<Character> getNetworkCh(){
		return characters;
	}
}
