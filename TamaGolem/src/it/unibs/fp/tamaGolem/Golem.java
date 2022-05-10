package it.unibs.fp.tamaGolem;

import java.util.*;

public class Golem {
	ArrayList<Stone> stones = new ArrayList<Stone>();
	int stoneNumber;
	int lifepoint;
	
	
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
		return lifepoint;
	}
	public void setLifepoint(int lifepoint) {
		this.lifepoint = lifepoint;
	}
	
	
	
}
