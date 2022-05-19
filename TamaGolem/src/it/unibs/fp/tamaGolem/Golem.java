package it.unibs.fp.tamaGolem;

import java.util.*;

/**Represents the class for golem */
public class Golem {
	ArrayList<Stone> stones = new ArrayList<Stone>();
	public int stoneNumber = Setup.P;
	int lifePoint;
	
	/**Constructor*/
	public Golem(ArrayList<Stone> stones, int stoneNumber, int lifePoint) {
		super();
		this.stones = stones;
		this.stoneNumber = stoneNumber;
		this.lifePoint = lifePoint;
	}
	
	/**Checks if the golem still has LifePoints*/
	public boolean checkLifePoint() {
		if(lifePoint <= 0) {
			return false;
		}
		return true;
	}
	
	/**Gets Stones*/
	public ArrayList<Stone> getStones() {
		return stones;
	}
	
	/**Sets Stone*/
	public void setStones(ArrayList<Stone> stones) {
		this.stones = stones;
	}
	
	/**Gets Stone Number */
	public int getStoneNumber() {
		return stoneNumber;
	}
	
	/**Sets Stone Number*/
	public void setStoneNumber(int stoneNumber) {
		this.stoneNumber = stoneNumber;
	}
	
	/**Gets LifePoint*/
	public int getLifepoint() {
		return lifePoint;
	}
	
	/**Sets LifePoint*/
	public void setLifepoint(int lifepoint) {
		this.lifePoint = lifepoint;
	}
	
	
	
}
