package it.unibs.fp.tamaGolem;

import it.unibs.fp.mylib.*;
import java.util.*;
import java.util.Scanner;

public class Player {

	public Golem golem = new Golem(new ArrayList<Stone>(), Setup.P, Setup.V);

	public int golemsNumbers;

	private static final String SEPARATORE = "---------------------------------------------------------------------";
	private static final String MSG_ERROR_STONE = "Pietra non presente nella lista";

	public void lostGolem() {
		golemsNumbers--;
	}

	// attribuisce tre pietre scelte dal giocatore al primo golem disponibile
	public void setGolemStone() {

		Setup.fillBag(); // riempimento zaino

		golem.stones.clear();
		System.out.println("seleziona " + golem.getStoneNumber() + " pietre da far magiare al golem:");

		printBag();

		for (int i = 0; i < golem.getStoneNumber(); i++) {
			manageStone();
			printBag();
		}
	}

	// crea un nuovo golem dopo che ne muore uno e abbassa il numero di golem
	// disponibili
	public void resetGolem() {
		golem.setLifepoint(Setup.V);
		lostGolem();
		setGolemStone();
	}

	private void printBag() {
		if (Setup.bag.isEmpty()) {
			System.out.println("Zaino vuoto");
		}
		System.out.println(SEPARATORE + "\nIl Tuo zaino: ");
		// stampa hasMap con nomi e quantita pietre
		Setup.bag.entrySet().forEach(System.out::println);
		System.out.println(SEPARATORE);
	}

	// fase di acquisizione e gestione pietre con treeMap
	public void manageStone() {
		int correct;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.print("Selezionare la pietra da assegnare al golem: ");
				String text = scanner.next();
				//String text = InputDati.leggiStringaNonVuota("Selezionare la pietra da assegnare al golem: ");
				correct = 0;
				if (Setup.bag.containsKey(text)) {
					// ricerca indice della stone e eliminazione ad arraylist di pietre scelte golem
					for (int i = 0; i < UI.setupBag.size(); i++) {
						if (UI.setupBag.get(i).getStoneType().toString().equalsIgnoreCase(text)) {
							// aggiungo nell'array di stones quelle inserite dall'utente
							golem.stones.add(UI.setupBag.get(i));
						}
					}
					// scala di un valore ad una certa key il valore di pietre
					Integer num = Setup.bag.get(text);
					Setup.bag.put(text, num - 1);
				} else {
					System.out.println(MSG_ERROR_STONE);
					correct = 1;
				}

			} while (correct == 1);

		} catch(Exception e) {
			System.out.println("Ricontrolla il valore inserito");
			}
	}

	public int getgolemsNumbers() {
		return golemsNumbers;
	}

	public void setgolemsNumbers(int golemsNumbers) {
		this.golemsNumbers = golemsNumbers;
	}

}
