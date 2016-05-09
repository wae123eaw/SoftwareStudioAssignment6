package main.java;

import java.util.ArrayList;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/
public class Network {
	//用來存在網路中的角色
	private ArrayList<Character>characters;
	private MainApplet parent;

	//網路的半徑
	private int radius=200;
	//圓的中心座標
	private float x,y;

	public Network(MainApplet parent){

		this.parent = parent;
		x=600;
		y=335;
		
		characters = new ArrayList<Character>();
	}

	public void display(){
		
		//算出滑鼠游標與圓的距離
		float distance = PApplet.dist(x,y,parent.mouseX,parent.mouseY);
		
		//畫出圓。根據情況設定顏色。
		if(parent.hasObject() && distance < radius){
			parent.strokeWeight(8);			
		}
		else{		
			parent.strokeWeight(4);		
		}
		parent.stroke(173,217,231);
		parent.fill(255);
		
		parent.ellipse(x, y, radius*2, radius*2);	
			
	}
	
	//重新排列網路中角色的位置
	private void reArrange(){
		int i=0;
		for(Character c: characters){
			System.out.println(characters.size());
			//根據在網路中角色的數量來決定座標。
			c.setX((float) (x + radius * Math.cos(Math.toRadians(360f/characters.size()*i))));
			c.setY((float) (y + radius * Math.sin(Math.toRadians(360f/characters.size()*i))));
			i++;
		}
	}
	//取得半徑方法
	public int getRadius(){
		return this.radius;
	}
	//取得X座標方法
	public float getX(){
		return this.x;
	}
	//取得Y座標方法
	public float getY(){
		return this.y;
	}
	//加入角色方法，呼叫後加入該角色到網路中，並且呼叫reArrange方法
	public void add(Character c){
		if(!characters.contains(c)){
			characters.add(c);			
		}		
		reArrange();
	}
	//移除角色方法。呼叫後移除該角色並重新排列
	public void remove(Character c){
		if(characters.contains(c)){
		characters.remove(c);
		}
		reArrange();		
	}
	//移除所有角色方法。呼叫設定角色inNetwork屬性為false，並且呼叫在網路中角色個別的fly方法。之後清除arrayList
	public void removeAll(){
		for(Character c : characters){
			c.setInNetwork(false);
			c.fly();		
		}
		characters.clear();		
	}
	
	public ArrayList<Character> getNetworkCh(){
		return characters;
	}
}
