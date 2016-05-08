package main.java;

import java.awt.event.KeyEvent;

import java.util.ArrayList;

import controlP5.ControlP5;
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
	private ArrayList<ArrayList<Character>> episode = new ArrayList<ArrayList<Character>>();	
	private int theChosenOne;
	private Network nt;
	private String series = "Star Wars 1";
	
	private ControlP5 cp5;
	
	private final static int width = 1200, height = 650;
	
	public void setup() {
			
		size(width, height);
		smooth();		
		initButton();
		theChosenOne = 0;
		nt = new Network(this);		
		loadData();	
		
	}

	public void draw() {
		background(255);		
		//顯示第N部曲
		fill(0);
		textSize(30);
		text(series,525,80);
		//顯示button
		
		//畫出中間網路部分。
		nt.display();
		

		for(Character c: episode.get(theChosenOne)){
			c.ntDisplay();
		}

		
		//畫出網路圖		
		//畫出左邊圓點
		//當滑鼠上有物件時，則選取的圓圈最後display
		if(hasObject()){
			for(Character c : episode.get(theChosenOne)){
				if(!c.equals(this.objectOnMouse)){					
					c.display();
				}
				}
			this.objectOnMouse.display();
			}
		else{
			for(Character c : episode.get(theChosenOne)){				
				c.display();
			}
		}
		
		}
	
	public void initButton(){
		cp5 = new ControlP5(this);
		cp5.addButton("addButton")
		.setLabel("Add All")
		.setPosition(900,150)
		.setSize(100,30);
		
		cp5.addButton("clearButton")
		.setLabel("clear All")
		.setPosition(900,200)
		.setSize(100,30);
		
		
	}
	
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch(keyCode) {
	    	case 97:	
	        case 49:	        	
	        	series = "Star Wars 1";	        	
	        	theChosenOne = 0;
	            break;
	        case 98:
	        case 50:	        	
	        	series = "Star Wars 2";	        	
	        	theChosenOne = 1;
	            break;
	        case 99:
	        case 51:	        	
	        	series = "Star Wars 3";	        	
	        	theChosenOne = 2;
	            break;
	        case 100:
	        case 52 :	        	
	        	series = "Star Wars 4";	        	
	        	theChosenOne = 3;
	        	break;
	        case 101:
	        case 53 :	        	
	        	series = "Star Wars 5";	        	
	        	theChosenOne = 4;
	        	break;
	        case 102:
	        case 54 :	        	
	        	series = "Star Wars 6";
	        	theChosenOne = 5;
	            break;
	        case 103:
	        case 55 :	        	
	        	series = "Star Wars 7";	        	
	        	theChosenOne = 6;
	            break;
	        default :
	        	break;
	     }
	    nt.removeAll();
   	} 
	
	private void loadData(){	
		
		for(int j=0;j<7;j++){
			file = ("main/resources/starwars-episode-" + (j+1) + "-interactions.json");
			
			data = loadJSONObject(file);
			nodes = data.getJSONArray("nodes");
			episode.add(new ArrayList<Character>());
			for(int i = 0; i < nodes.size(); i++){				
				JSONObject job = nodes.getJSONObject(i);
				String name = job.getString("name");
				int value = job.getInt("value");
				String color = job.getString("colour");				
				episode.get(j).add(new Character(this, name, 50 + (i/10) * (height/11), 50 + (i%10) * (height/11),value, color));
				}		
			links = data.getJSONArray("links");
			for(int i = 0; i < links.size(); i++){
				JSONObject job = links.getJSONObject(i);
				int s = job.getInt("source");
				int t = job.getInt("target");
				int v = job.getInt("value");
				episode.get(j).get(s).addTarget(episode.get(j).get(t), v);
				}		
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
				getObjectOnMouse().setInNetwork(false);
				getObjectOnMouse().fly();
			}
			else{				
				nt.add(getObjectOnMouse());
				getObjectOnMouse().setInNetwork(true);
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
	
	public void addButton(){
		for(Character c: episode.get(theChosenOne)){
			nt.add(c);
			c.setInNetwork(true);
		}
	}
	public void clearButton(){
		System.out.println("clear");
		/*for(Character c: episode.get(theChosenOne)){
			c.setInNetwork(false);
		}
		*/
		nt.removeAll();
	}
	}