package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{
	private boolean hasObject;
	private Character objectOnMouse;
	private String path = "main/resources/";
	private String file = "starwars-episode-1-interactions.json";
	//private ArrayList<Character>characters = new ArrayList();
	private Character c;
	private Character b;
	private final static int width = 1200, height = 650;
	
	public void setup() {

		size(width, height);
		smooth();
		loadData();
		
	}

	public void draw() {
		background(255);
		c.display();
		b.display();
	}

	private void loadData(){
		c = new Character(this,"test",10,"test");
		c.setX(30);
		c.setY(30);
		b = new Character(this,"test1",10,"test1");
		b.setX(30);
		b.setY(60);
	}
	
	public void mouseDragged(){
		this.objectOnMouse.setX(mouseX);
		this.objectOnMouse.setY(mouseY);
	}
	
	public boolean hasObject(){
		return this.hasObject;
	}
	
	public void setHasObject(boolean b){
		this.hasObject = b;
	}
	
	public Character getObjectOnMouse(){
		return this.objectOnMouse;
	}
	
	public void setObjectOnMouse(Character c){
		this.objectOnMouse = c;
	}
}
