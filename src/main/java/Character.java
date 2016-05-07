package main.java;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character {
	
	private MainApplet parent;
	public float x, y;
	private String name;
	private String color;
	private ArrayList<Character> targets;
	private HashMap values;

	public Character(MainApplet parent, String name, float x, float y, String color){

		targets = new ArrayList<Character>();
		values = new HashMap();
		this.parent = parent;
		this.name = name;
		this.x = x;
		this.y = y;
		this.color = color;
		
	}
	
	public String getName(){
		return this.name;
	}

	public void display(){

	}
	
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
	
}
