package main.java;

import java.awt.event.KeyEvent;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet{

	private boolean hasObject;
	private Character objectOnMouse;
	
	//private String path = "";
	private String file = "main/resources/starwars-episode-1-interactions.json";
	JSONObject data;
	JSONArray nodes, links;
	private ArrayList<Character> characters;
	

	private final static int width = 1200, height = 650;
	
	
	public void setup() {

		size(width, height);
		smooth();
		characters = new ArrayList<Character>();
		loadData();	
		
	}

	public void draw() {
		background(255);
		for(Character c : characters)
			c.display();
		}
	
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch(keyCode) { 
	        case 49:
	        	file = "main/resources/starwars-episode-1-interactions.json";
	        	setup();
	            break;
	        case 50:
	        	file = "main/resources/starwars-episode-2-interactions.json";
	        	setup();
	            break;
	        case 51:
	        	file = "main/resources/starwars-episode-3-interactions.json";
	        	setup();
	            break;
	        case 52 :
	        	file = "main/resources/starwars-episode-4-interactions.json";
	        	setup();
	        	break;
	        case 53 :
	        	file = "main/resources/starwars-episode-5-interactions.json";
	        	setup();
	        	break;
	        case 54 :
	        	file = "main/resources/starwars-episode-6-interactions.json";
	        	setup();
	            break;
	        case 55 :
	        	file = "main/resources/starwars-episode-7-interactions.json";
	        	setup();
	            break;
	        default :
	        	break;
	     }
	} 

	private void loadData(){

		data = loadJSONObject(file);
		nodes = data.getJSONArray("nodes");
		for(int i = 0; i < nodes.size(); i++){
			JSONObject job = nodes.getJSONObject(i);
			String name = job.getString("name");
			String color = job.getString("colour");
			this.characters.add(new Character(this, name, 20 + (i/10) * (height/11), 20 + (i%10) * (height/11), color));

		}
		
		data = loadJSONObject(file);
		links = data.getJSONArray("links");
		for(int i = 0; i < links.size(); i++){
			JSONObject job = links.getJSONObject(i);
			int s = job.getInt("source");
			int t = job.getInt("target");
			int v = job.getInt("value");
			this.characters.get(s).addTarget(this.characters.get(t), v);
			}
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