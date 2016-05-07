package main.java;

import java.util.ArrayList;

import de.looksgood.ani.Ani;
import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	private Ani ani;
	private int x,y;
	private int radius=20;
	private String name;
	private int value;
	private String color;
	
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
		
	}

	public void display(){
		double distance=0;
		parent.ellipse(x, y, radius*2, radius*2);
		distance = Math.sqrt(Math.pow((parent.mouseX-x), 2) + Math.pow((parent.mouseY-y), 2));
		if(distance<=radius){
			ani.start();
			parent.setHasObject(true);
		}		
		
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	
	
}
