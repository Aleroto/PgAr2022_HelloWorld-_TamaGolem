package it.unibs.fp.tamaGolem;

import java.util.*;

/**Represents the class for player */
public class Player {

	public Golem golem = new Golem(new ArrayList<Stone>(), Setup.P, Setup.V);
	public int golemsNumbers = Setup.G;

	public static boolean first = true;
	public static boolean second = true;

	public static int turn = 1; // fase d'inzio

	public static Map<String, Integer> bagPlayer1 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	public static Map<String, Integer> bagPlayer2 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	private static final String SEPARATORE = "---------------------------------------------------------------------";
	private static final String MSG_ERROR_STONE = "Pietra non disponibile";

	public void lostGolem() {
		golemsNumbers--;
	}

	/**Sets the stone at the golem player*/
	public void setGolemStone() {
		int cnt1 = 0;
		int cnt2 = 0;

		// riempio due zaini con pietre
		if (first == true || second == true) {
			if (first) {
				first = false;
			} else {
				turn = 2;
				second = false;
			}
		}
				
		golem.stones.clear();
		System.out.println("seleziona " + golem.getStoneNumber() + " pietre da far mangiare al golem:");
				
		printBag(turn);
		for (int i = 0; i < golem.getStoneNumber(); i++) {
			manageStone(getBagPlayer(turn));
		}
		printBag(turn);		
				
		//gestione caso in cui fanno un pareggio
		for(Map.Entry<String,Integer> entry : Player.getBagPlayer(1).entrySet()) {
			  Integer value = entry.getValue();
			  if(value == 0)
				 cnt1++;
			}
			
		//gestione caso in cui fanno un pareggio
		for(Map.Entry<String,Integer> entry : Player.getBagPlayer(2).entrySet()) {
			  Integer value = entry.getValue();
			  if(value == 0)
				  cnt2++;
		}	
			
		if(cnt1 == Setup.N && cnt2 == Setup.N) {
			System.out.println("################LA PARTITA E' FINITA IN PARITA'################");
			cnt1 = 0;
			cnt2 = 0;
			Player.bagPlayer1.clear();
			Player.bagPlayer2.clear();
			Setup.fillBagFirst(Player.bagPlayer1);
			Setup.fillBagFirst(Player.bagPlayer2);
		}
			
		if(turn == 1)
			turn = 2;
		else
			turn = 1;
	}


	/**Creates a new golem after one dies and lower the number of golems available*/
	public void resetGolem(int player) {
		golem.setLifepoint(Setup.V);
		lostGolem();
		if (golemsNumbers > 0) {
			System.out.println("Player " + player + " deve evocare un nuovo golem:");
			if (player == 1) {
				turn = 1;
			} else {
				turn = 2;
			}
			setGolemStone();
		}

	}
	
	/**Prints the bag*/
	public static void printBag(int turn) {
		System.out.println(SEPARATORE + "\nIl Tuo zaino: ");

		if (turn == 1) {
			// stampa treeMap con nomi e quantita pietre
			bagPlayer1.entrySet().forEach(System.out::println);
		} else if (turn == 2) {
			bagPlayer2.entrySet().forEach(System.out::println);
		} else {
			Setup.bag.isEmpty();
			System.out.println("Zaino vuoto");
		}

		System.out.println(SEPARATORE);
	}

	
	/**Manages stones of player*/
	public void manageStone(Map<String, Integer> bag) {
		int correct;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.print("Selezionare la pietra da assegnare al golem: ");
				String text = scanner.next();
				// String text = InputDati.leggiStringaNonVuota("Selezionare la pietra da
				// assegnare al golem: ");
				correct = 0;
				if (bag.containsKey(text) && bag.get(text) > 0) {
					// ricerca indice della stone e eliminazione ad arraylist di pietre scelte golem
					for (int i = 0; i < UI.setupBag.size(); i++) {
						if (UI.setupBag.get(i).getStoneType().toString().equalsIgnoreCase(text)) {
							// aggiungo nell'array di stones quelle inserite dall'utente
							golem.stones.add(UI.setupBag.get(i));
						}
					}
					// scala di un valore ad una certa key il valore di pietre
					Integer num = bag.get(text);
					bag.put(text, num - 1);

				} else {
					System.out.println(MSG_ERROR_STONE);
					correct = 1;
				}

			} while (correct == 1);

		} catch (Exception e) {
			System.out.println("Ricontrolla il valore inserito");
		}
	}

	/**Gets Bag of the Player*/
	public static Map<String, Integer> getBagPlayer(int turn) {
		if (turn == 1)
			return bagPlayer1;
		else if (turn == 2)
			return bagPlayer2;
		else
			return Setup.bag;
	}

	/**Gets Golems Numbers*/
	public int getgolemsNumbers() {
		return golemsNumbers;
	}

	/**Sets Golems Numbers*/
	public void setgolemsNumbers(int golemsNumbers) {
		this.golemsNumbers = golemsNumbers;
	}

}
