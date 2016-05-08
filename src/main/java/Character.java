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

	private float x,y;
	private float tmpX,tmpY;
	private int radius=20;
	private String name;
	private int value;
	private String color;
	private boolean inNetwork;
	private int maxValue;

	private Ani ani;
	private MainApplet parent;
	private HashMap<Character,Integer> targets;

	public Character(MainApplet parent, String name, float x, float y, int value, String color){

		targets = new HashMap<Character, Integer>();		
		
		this.parent = parent;
		this.name = name;
		this.x = x;
		this.y = y;
		this.tmpX = x;
		this.tmpY = y;
		this.value = value;		
		this.maxValue = 0;
		this.color = "FF" + color.substring(1);
		this.inNetwork = false;
					
		aniSetup();
		
		for(int tmp: targets.values().toArray(new Integer[targets.size()])){
			maxValue = tmp > maxValue? tmp : maxValue;
		}
		
		}
	//Ani的初始化
	public void aniSetup(){
		Ani.init(parent);
		ani = new Ani(this,(float) 0.3,"radius",15,Ani.LINEAR);
		ani.setCallback("onStart:start");
		ani.setCallback("onEnd:end");		
	}
	
	public void display(){
		double distance=0;
				
		//填入顏色				
		int hi = PApplet.unhex(color);		
		parent.fill(hi);
		//畫出角色圓球
		parent.stroke(hi);
		parent.strokeWeight(4);
		parent.ellipse(tmpX, tmpY, radius*2, radius*2);
		
		distance = PApplet.dist(parent.mouseX, parent.mouseY, tmpX, tmpY);
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
				parent.textSize(14);
				parent.text(name, parent.mouseX+15, parent.mouseY+5);
			}
		}
							
	}
	//network display function
	public void ntDisplay(){		
		if(inNetwork){
			Network ntTmp = parent.getNetwork();			
			
			for(int i=0;i< ntTmp.getNetworkCh().size();i++){
				Character c = ntTmp.getNetworkCh().get(i);
				if(targets.containsKey(c)){					
					parent.stroke(128,21,21);
					parent.strokeWeight(4 + 2*(int)(Math.log(targets.get(c))));
					parent.noFill();
					parent.curve((2f* (this.tmpX -ntTmp.getX()) + this.tmpX), (2f * (this.tmpY - ntTmp.getY()) + this.tmpY)
							,this.tmpX, this.tmpY
							,c.tmpX, c.tmpY
							,(2f*(c.tmpX - ntTmp.getX()) + c.tmpX), (2f*(c.tmpY - ntTmp.getY()) + c.tmpY)
							);
					/*
					 * To see the bend point 
					 * parent.strokeWeight(2);
					 * parent.ellipse((2* (this.tmpX -ntTmp.getX()) + this.tmpX), (2f * (this.tmpY - ntTmp.getY()) + this.tmpY), 20, 20);
					 * parent.ellipse((2*(c.tmpX - ntTmp.getX()) + c.tmpX), (2f*(c.tmpY - ntTmp.getY()) + c.tmpY), 20, 20);
					*/
					}					
			}
		}
	}
	
	
	//Ani start control
	public void start(){
		System.out.println("in");		
			}
	//Ani end control
	public void end(){
		parent.setHasObject(false);
		parent.setObjectOnMouse(null);
		
		Ani.to(this,(float)0.2,"radius",15, Ani.LINEAR);		

		}
	//讓圓球飛回原始位置
	public void fly(){		
		parent.setHasObject(false);
		parent.setObjectOnMouse(null);
		
		Ani.to(this,(float)0.2,"tmpX",x, Ani.LINEAR);
		Ani.to(this, (float)0.2, "tmpY", y,Ani.LINEAR);
	}
	
	
	public void setX(float x){
		this.tmpX = x;
	}	
		
	public void setY(float y){
		this.tmpY = y;
	}
	
	public HashMap<Character, Integer> getTargets(){
		return this.targets;
	}
	
	public void addTarget(Character target, int value) {
		this.targets.put(target, value);
		}
	
	public void setInNetwork(boolean b){
		this.inNetwork = b;
	}
}
