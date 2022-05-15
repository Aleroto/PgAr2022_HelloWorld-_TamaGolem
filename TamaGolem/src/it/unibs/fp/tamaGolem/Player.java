package it.unibs.fp.tamaGolem;

import it.unibs.fp.mylib.*;
import java.util.*;
import java.util.Scanner;



public class Player {

	public Golem golem = new Golem(new ArrayList<Stone>(),Setup.P,Setup.V);
	
	public static Golem gole = new Golem(new ArrayList<Stone>(),Setup.P,Setup.V);

	public int golemsNumbers;
	public int golemNumber;
	
	private static final String SEPARATORE = "----------------------------------------";
	private static final String MSG_ERROR_STONE = "Pietra non presente nella lista";
	
	public void lostGolem() {
		golemsNumbers--;
	}
	
	//attribuisce tre pietre scelte dal giocatore al primo golem disponibile
	public void setGolemStone() {
		
		Setup.fillBag(); //riempimento zaino
		
		golem.stones.clear();
		System.out.println("seleziona " + golem.getStoneNumber() + " pietre da far magiare al golem:");

		printBag();

		for(int i = 0; i < golem.getStoneNumber();i++) {
		    manageStone();
			printBag();
		}
		
		//copia le stone dentro all'arraylist di stone
		for(int i = 0; i < golem.getStoneNumber();i++) {
		    //golem.stones.add(null);
		}
		

			/*
			if(printBag()) {
				//int stoneIndex = InputDati.leggiIntero("Selezionare la pietra da assegnare al golem:", 0, UI.setupBag.size()+1)-1;
				
		
				//controlla se pietra scelta è presente nello zaino
				if(Setup.bag.containsKey(UI.setupBag.get(stoneIndex).toString())){
					//scala di un valore ad una certa key il valore di pietre
					Integer num = Setup.bag.get(UI.setupBag.toString());				
					Setup.bag.put(UI.setupBag.toString(), num - 1);
					
					//golem.stones.add(UI.setupBag.get(stoneIndex));
				
				}else {
					System.out.println(MSG_ERROR_STONE);
					//correct = 1;
				}
				//UI.setupBag.remove(stoneIndex);
			*/
				

		
			
		}
	//}
		
	
	//crea un nuovo golem dopo che ne muore uno e abbassa il numero di golem disponibili
	public void resetGolem() {
		golem.setLifepoint(Setup.V);
		lostGolem();
		setGolemStone();		
	}
	
	private void printBag() {
		if(Setup.bag.isEmpty()) {
			System.out.println("Zaino vuoto");
			//return false;
		}
		System.out.println(SEPARATORE+"\nIl Tuo zaino: ");
	
		//stampa hasMap con nomi e quantita pietre
		Setup.bag.entrySet().forEach(System.out::println);
		
		
		for(int i = 0; i < Setup.bag.size();i++) {
			//System.out.println("-" + (i+1) + "- " + Setup.bag);
			
			//System.out.println("-" + (i+1) + "- " + Setup.bag);		
		}
		//System.out.println(UI.setupBag);
		
	

		System.out.println(SEPARATORE);
		//return true;
		
	}
	

	public int getgolemsNumbers() {
		return golemsNumbers;
	}
	public void setgolemsNumbers(int golemsNumbers) {
		this.golemsNumbers = golemsNumbers;
	}
	
	/*
	public ArrayList<Stone> getBag() {
		return bag;
	}
	
	public void setBag(ArrayList<Stone> bag) {
		this.bag = bag;
	}
	*/
	
	public int getGolemNumber() {
		return golemNumber;
	}
	public void setGolemNumber(int golemNumber) {
		this.golemNumber = golemNumber;
	}




	//fase di acquisizione e gestione pietre con treeMap
	public void manageStone() {
		int correct;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.print("Selezionare la pietra da assegnare al golem: ");
				//String text = scanner.nextLine();
				String text = scanner.next();
				correct = 0;
				if(Setup.bag.containsKey(text)){					
					//ricerca indice della stone e eliminazione ad arraylist di pietre scelte golem
					for(int i = 0; i < UI.setupBag.size(); i++) {
						if(UI.setupBag.get(i).getStoneType().toString().equalsIgnoreCase(text)) {
							//aggiungo nell'array di stones quelle inserite dall'utente
							golem.stones.add(UI.setupBag.get(i));						
						}

					}
				
					//scala di un valore ad una certa key il valore di pietre
					Integer num = Setup.bag.get(text);	
					Setup.bag.put(text, num - 1);
					
					
					//Integer num = Setup.bag.get(UI.setupBag.toString());				
					//Setup.bag.put(UI.setupBag.toString(), num - 1);
					
				}else {
					System.out.println(MSG_ERROR_STONE);
					correct = 1;
				}
				
			}while(correct == 1);
			
		}finally {
			//scanner.close();
		}	
	}

				
	
}
