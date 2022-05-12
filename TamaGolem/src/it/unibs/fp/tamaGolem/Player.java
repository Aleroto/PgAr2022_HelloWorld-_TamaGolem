package it.unibs.fp.tamaGolem;

import it.unibs.fp.mylib.*;
import java.util.*;

public class Player {
	
	ArrayList<Stone> bag = new ArrayList<Stone>();
	public Golem golem = new Golem(new ArrayList<Stone>(),new Setup().P,Setup.V);
	public Integer golemsNumbers;
	public Integer golemNumber;
	
	public void lostGolem() {
		golemsNumbers--;
	}
	
	//attribuisce tre pietre scelte dal giocatore al primo golem disponibile
	public void setGolemStone() {
		
		golem.stones.clear();
		System.out.println("OK");
		System.out.println("seleziona " +golem.getStoneNumber() + " pietre da far magiare al golem"+golem.getStoneNumber());
		
		for(int i = 0; i < golem.getStoneNumber();i++) {
			System.out.println("Il Tuo zaino: ");
			
			//stampare lo zaino
			
			golem.stones.add(bag.get(InputDati.leggiIntero("Selezionare la pietra da assegnare al golem:", 0, golem.getStoneNumber())));
		}
	}
	
	
	public int getgolemsNumbers() {
		return golemsNumbers;
	}
	public void setgolemsNumbers(int golemsNumbers) {
		this.golemsNumbers = golemsNumbers;
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
