package main.java;

import java.util.ArrayList;

import de.looksgood.ani.Ani;
import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {

	private int x,y;
	private int radius=20;
	private String name;
	private int value;
	private String color;

	private Ani ani;
	private MainApplet parent;

	public Character(MainApplet parent, String name, int value, String color){

		this.parent = parent;
		this.name = name;
		this.value = value;
		this.color = color;
		aniSetup();
	
	}
		
	public void aniSetup(){
		Ani.init(parent);
		ani = new Ani(this,(float) 0.3,"radius",15,Ani.LINEAR);
		ani.setCallback("onStart:start");
		ani.setCallback("onEnd:end");		
	}
	
	public void display(){
		double distance=0;
		//int hi = parent.unhex(color);
		//fill(hi);
		//stroke(hi);
		parent.fill(255);
		parent.stroke(0);
		parent.ellipse(x, y, radius*2, radius*2);	
		distance = PApplet.dist(parent.mouseX, parent.mouseY, x, y);
		//distance = Math.sqrt(Math.pow((parent.mouseX-x), 2) + Math.pow((parent.mouseY-y), 2));
		
		if(distance<radius){
			if(!parent.hasObject()){
				parent.setHasObject(true);
				parent.setObjectOnMouse(this);
			}
			if(parent.getObjectOnMouse().equals(this)){
				ani.start();
				parent.smooth();
				parent.fill(255,128,192);
				parent.stroke(255,128,192);
				parent.rect(parent.mouseX,parent.mouseY-15 , 60,30,7);
			}
		}				
		
	}
	
	public void start(){
		System.out.println("in");
			}
	public void end(){
		System.out.println("out");
		parent.setHasObject(false);
		parent.setObjectOnMouse(null);
		}
	
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	
	
}
