package main.java;

import java.awt.event.KeyEvent;

import java.util.ArrayList;

import de.looksgood.ani.Ani;
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
	private Network nt;
	private String series = "Star Wars 1";;
	
	private final static int width = 1200, height = 650;
	
	public void setup() {

		size(width, height);
		smooth();		
		nt = new Network(this);
		characters = new ArrayList<Character>();		
		loadData();	
		
	}

	public void draw() {
		background(255);
		
		//顯示第N部曲
		fill(0);
		textSize(30);
		text(series,500,80);
		//畫出中間網路部分。
		nt.display();
		//畫出左邊圓點
		//當有滑鼠上有物件時，則選取的圓圈最後display
		if(hasObject()){
			for(Character c : characters){
				if(!c.equals(this.objectOnMouse)){
					c.display();
				}
				}
			this.objectOnMouse.display();
			}
		else{
			for(Character c : characters)
				c.display();
		}

		}
	
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch(keyCode) {
	    	case 97:	
	        case 49:
	        	file = "main/resources/starwars-episode-1-interactions.json";
	        	series = "Star Wars 1";
	        	setup();
	            break;
	        case 98:
	        case 50:
	        	file = "main/resources/starwars-episode-2-interactions.json";
	        	series = "Star Wars 2";
	        	setup();
	            break;
	        case 99:
	        case 51:
	        	file = "main/resources/starwars-episode-3-interactions.json";
	        	series = "Star Wars 3";
	        	setup();
	            break;
	        case 100:
	        case 52 :
	        	file = "main/resources/starwars-episode-4-interactions.json";
	        	series = "Star Wars 4";
	        	setup();
	        	break;
	        case 101:
	        case 53 :
	        	file = "main/resources/starwars-episode-5-interactions.json";
	        	series = "Star Wars 5";
	        	setup();
	        	break;
	        case 102:
	        case 54 :
	        	file = "main/resources/starwars-episode-6-interactions.json";
	        	series = "Star Wars 6";
	        	setup();
	            break;
	        case 103:
	        case 55 :
	        	file = "main/resources/starwars-episode-7-interactions.json";
	        	series = "Star Wars 7";
	        	setup();
	            break;
	        default :
	        	break;
	     }
	} 

	private synchronized void loadData(){

		data = loadJSONObject(file);
		nodes = data.getJSONArray("nodes");
		for(int i = 0; i < nodes.size(); i++){
			JSONObject job = nodes.getJSONObject(i);
			String name = job.getString("name");
			String color = job.getString("colour");
			this.characters.add(new Character(this, name, 50 + (i/10) * (height/11), 50 + (i%10) * (height/11), color));

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
	
	//當滑鼠拖曳時，判斷是否有物件。當有物件時，則設定該物件的X，Y座標。
	public void mouseDragged(){
		if(hasObject()){
			this.objectOnMouse.setX(mouseX);
			this.objectOnMouse.setY(mouseY);
		}
	}
	
	//當滑鼠鍵放開時，判斷是否有物件。當有物件時，判斷是否在network圓圈中。若不是在圓圈中，則使用Character中的fly()方法飛回原處。
	public void mouseReleased(){
		if(hasObject()){
			if(dist(mouseX,mouseY,nt.getX(),nt.getY()) > nt.getRadius()){
				System.out.print("true");
				nt.remove(getObjectOnMouse());
				getObjectOnMouse().fly();
			}
			else{
				nt.add(getObjectOnMouse());
			}
		}		
	}
	//hasObject getter
	public boolean hasObject(){
		return this.hasObject;
	}
	//hasObject setter
	public void setHasObject(boolean b){
		this.hasObject = b;
	}
	//objectOnMouse getter
	public Character getObjectOnMouse(){
		return this.objectOnMouse;
	}
	//objectOnMouse setter
	public void setObjectOnMouse(Character c){
		this.objectOnMouse = c;
		}
	//nt getter
	public Network getNetwork(){
		return this.nt;
	}
	}