package it.unibs.fp.tamaGolem;

import it.unibs.fp.mylib.*;
import java.util.*;

public class Player {
	
	ArrayList<Golem> golems= new ArrayList<Golem>();
	ArrayList<Stone> bag = new ArrayList<Stone>();
	int golemNumber;
	
	public void removeGolem() {
		golems.remove(0);
	}
	
	
	//attribuisce tre pietre scelte dal giocatore al primo golem disponibile
	public void setGolemStone() {
		System.out.println("seleziona " +golems.get(0).getStoneNumber()+ " pietre da far magiare al golem"+golems.get(0).getStoneNumber());
		
		for(int i = 0; i < golems.get(0).getStoneNumber();i++) {
			System.out.println("Il Tuo zaino: ");
			
			//stampare lo zaino
			
			golems.get(0).stones.add(bag.get(InputDati.leggiIntero("Selezionare la pietra da assegnare al golem:", 0, golems.get(0).getStoneNumber())));
		}
	}
	
	
	public ArrayList<Golem> getGolems() {
		return golems;
	}
	public void setGolems(ArrayList<Golem> golems) {
		this.golems = golems;
	}
	public ArrayList<Stone> getBag() {
		return bag;
	}
	public void setBag(ArrayList<Stone> bag) {
		this.bag = bag;
	}
	public int getGolemNumber() {
		return golemNumber;
	}
	public void setGolemNumber(int golemNumber) {
		this.golemNumber = golemNumber;
	}
	
	
	

	
	

}
