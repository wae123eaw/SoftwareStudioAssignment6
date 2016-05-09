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
	//�ΨӦs�b������������
	private ArrayList<Character>characters;
	private MainApplet parent;

	//�������b�|
	private int radius=200;
	//�ꪺ���߮y��
	private float x,y;

	public Network(MainApplet parent){

		this.parent = parent;
		x=600;
		y=335;
		
		characters = new ArrayList<Character>();
	}

	public void display(){
		
		//��X�ƹ���лP�ꪺ�Z��
		float distance = PApplet.dist(x,y,parent.mouseX,parent.mouseY);
		
		//�e�X��C�ھڱ��p�]�w�C��C
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
	
	//���s�ƦC���������⪺��m
	private void reArrange(){
		int i=0;
		for(Character c: characters){
			System.out.println(characters.size());
			//�ھڦb���������⪺�ƶq�ӨM�w�y�СC
			c.setX((float) (x + radius * Math.cos(Math.toRadians(360f/characters.size()*i))));
			c.setY((float) (y + radius * Math.sin(Math.toRadians(360f/characters.size()*i))));
			i++;
		}
	}
	//���o�b�|��k
	public int getRadius(){
		return this.radius;
	}
	//���oX�y�Ф�k
	public float getX(){
		return this.x;
	}
	//���oY�y�Ф�k
	public float getY(){
		return this.y;
	}
	//�[�J�����k�A�I�s��[�J�Ө����������A�åB�I�sreArrange��k
	public void add(Character c){
		if(!characters.contains(c)){
			characters.add(c);			
		}		
		reArrange();
	}
	//���������k�C�I�s�Ჾ���Ө���í��s�ƦC
	public void remove(Character c){
		if(characters.contains(c)){
		characters.remove(c);
		}
		reArrange();		
	}
	//�����Ҧ������k�C�I�s�]�w����inNetwork�ݩʬ�false�A�åB�I�s�b����������ӧO��fly��k�C����M��arrayList
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
