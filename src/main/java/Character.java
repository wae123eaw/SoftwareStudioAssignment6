package main.java;

import java.util.ArrayList;
<<<<<<< HEAD

import de.looksgood.ani.Ani;
=======
import java.util.HashMap;

>>>>>>> 3b0a95df2d6222bee7b0d5b9efc6802d2e38f4ca
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
	public float x, y;
	private String name;
	private String color;
	private ArrayList<Character> targets;
	private HashMap values;

<<<<<<< HEAD
	public Character(MainApplet parent, String name, int value, String color){
=======
	public Character(MainApplet parent, String name, float x, float y, String color){
>>>>>>> 3b0a95df2d6222bee7b0d5b9efc6802d2e38f4ca

		targets = new ArrayList<Character>();
		values = new HashMap();
		this.parent = parent;
		this.name = name;
<<<<<<< HEAD
		this.value = value;
		this.color = color;
		aniSetup();
	
	}
=======
		this.x = x;
		this.y = y;
		this.color = color;
>>>>>>> 3b0a95df2d6222bee7b0d5b9efc6802d2e38f4ca
		
	public void aniSetup(){
		Ani.init(parent);
		ani = new Ani(this,(float) 0.3,"radius",15,Ani.LINEAR);
		ani.setCallback("onStart:start");
		ani.setCallback("onEnd:end");		
	}
	
<<<<<<< HEAD
=======
	public String getName(){
		return this.name;
	}

>>>>>>> 3b0a95df2d6222bee7b0d5b9efc6802d2e38f4ca
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
	
<<<<<<< HEAD
	public void setY(int y){
		this.y = y;
	}
	
	
=======
	public ArrayList<Character> getTargets(){
		return this.targets;
	}
	
	public HashMap getValues(){
		return this.values;
	}
	
	
	public void addTarget(Character target, int value) {
		this.targets.add(target);
		this.values.put(target, value);
	}
>>>>>>> 3b0a95df2d6222bee7b0d5b9efc6802d2e38f4ca
	
}
