package it.unibs.fp.tamaGolem;

import java.util.*;

public class Golem {
	ArrayList<Stone> stones = new ArrayList<Stone>();
	public int stoneNumber = new Setup().P;
	int lifePoint;
	
	
	//controlla se il golem ha ancora lifePoint
	public boolean checkLifePoint() {
		if(lifePoint <= 0) {
			return false;
		}
		return true;
	}
	
	
	public Golem(ArrayList<Stone> stones, int stoneNumber, int lifePoint) {
		super();
		this.stones = stones;
		this.stoneNumber = stoneNumber;
		this.lifePoint = lifePoint;
	}


	public ArrayList<Stone> getStones() {
		return stones;
	}
	public void setStones(ArrayList<Stone> stones) {
		this.stones = stones;
	}
	public int getStoneNumber() {
		return stoneNumber;
	}
	public void setStoneNumber(int stoneNumber) {
		this.stoneNumber = stoneNumber;
	}
	public int getLifepoint() {
		return lifePoint;
	}
	public void setLifepoint(int lifepoint) {
		this.lifePoint = lifepoint;
	}
	
	
	
}
