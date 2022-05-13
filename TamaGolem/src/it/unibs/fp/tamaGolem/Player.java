package it.unibs.fp.tamaGolem;

import it.unibs.fp.mylib.*;
import java.util.*;

public class Player {
	
	ArrayList<Stone> bag = new ArrayList<Stone>();
	public Golem golem = new Golem(new ArrayList<Stone>(),new Setup().P,Setup.V);
	public Integer golemsNumbers;
	public Integer golemNumber;
	
	private static final String SEPARATORE = "----------------------------------------";
	
	public void lostGolem() {
		golemsNumbers--;
	}
	
	//attribuisce tre pietre scelte dal giocatore al primo golem disponibile
	public void setGolemStone() {
		
		provaZaino();
		
		golem.stones.clear();
		System.out.println("OK");
		System.out.println("seleziona " +golem.getStoneNumber() + " pietre da far magiare al golem:");
		
		for(int i = 0; i < golem.getStoneNumber();i++) {
			if(printBag()) {
				int stoneIndex = InputDati.leggiIntero("Selezionare la pietra da assegnare al golem:", 0, bag.size()+1)-1;
				golem.stones.add(bag.get(stoneIndex));
				bag.remove(stoneIndex);
			}else {
				return;
			}
		}
	}
	
	//crea un nuovo golem dopo che ne è morto uno e abbassa il numero di golem disponibili
	public void resetGolem() {
		golem.setLifepoint(Setup.V);
		lostGolem();
		setGolemStone();		
	}
	
	private boolean printBag() {
		if(bag.size() <= 0) {
			System.out.println("Lo zaiono è vuoto");
			return false;
		}
		System.out.println(SEPARATORE+"\nIl Tuo zaino: ");
		for(int i = 0; i < bag.size();i++) {
			System.out.println("-" + (i+1) + "- " + bag.get(i).getStoneType() );
		}
		System.out.println(SEPARATORE);
		return true;
		
	}
	
	
	private void provaZaino() {
		bag.add(new Stone(Elements.Fighting));
		bag.add(new Stone(Elements.Flying));
		bag.add(new Stone(Elements.Ground));
		bag.add(new Stone(Elements.Ice));
		bag.add(new Stone(Elements.Fighting));
		bag.add(new Stone(Elements.Electric));
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
