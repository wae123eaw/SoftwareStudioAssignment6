package main.java;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PApplet;
import de.looksgood.ani.Ani;

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
	private ArrayList<Character> targets;
	private HashMap values;

	public Character(MainApplet parent, String name, int x, int y, String color){

		targets = new ArrayList<Character>();
		values = new HashMap();
		this.parent = parent;
		this.name = name;
		this.x = x;
		this.y = y;
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
		//填入顏色
		//int hi = PApplet.unhex(PApplet.hex(color.to));
		parent.fill(255);
		//畫出角色圓球
		parent.stroke(0);
		parent.ellipse(x, y, radius*2, radius*2);
		
		distance = PApplet.dist(parent.mouseX, parent.mouseY, x, y);
		//distance = Math.sqrt(Math.pow((parent.mouseX-x), 2) + Math.pow((parent.mouseY-y), 2));
		//判斷游標是否在圓球內
		if(distance<radius){
			//若鼠標在圓球內且鼠標上沒有物件，設定為有物件，並指定物件為此圓球。
			if(!parent.hasObject()){
				parent.setHasObject(true);
				parent.setObjectOnMouse(this);
			}
			//判斷是否為指定的圓球，若相同則進行圓球設定的動畫。
			if(parent.getObjectOnMouse().equals(this)){
				ani.start();
				//角色名字
				parent.fill(255,128,192);
				parent.stroke(255,128,192);
				parent.rect(parent.mouseX,parent.mouseY-15 ,30 + 8*name.length(),30,7);
				parent.fill(255);
				parent.text(name, parent.mouseX+15, parent.mouseY+5);
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
