package it.unibs.fp.tamaGolem;

import java.util.ArrayList;
import java.util.Map;


import java.util.Scanner;


public class UI {
	
	private static final String YES = "si";
	private static final String NO = "no";
	private static final String MSG_ERROR = "Errore, riscrivere correttamente la scelta";
	
	
	public static ArrayList<Stone> setupBag = new ArrayList<Stone>();
	public static Glyph glyph;




	public static void runProgram(){
		/**
		 * TreeMap for a ordinated list of elements with a key for the value. The value
		 * is necessary for the glyph
		 */
		
		glyph = new Glyph(Setup.addElements(), Setup.adjacencyMatrixGenerator());
		// get key and value from a TreeMap
		// TEST print elements map
		for (Map.Entry<Elements, Integer> entry : glyph.getElements().entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			setupBag.add(new Stone(entry.getKey()));
		}
		
		//stampa zaino con tutti gli elementi
		/*
	     for(int i = 0; i < setupBag.size(); i++) {
	            System.out.println(setupBag.get(i).stoneType);
	      }
	      */
		
		/**
		 * creating a glyph using an adjacency matrix like below for iteration between
		 * the elements
		 * 
		 * Rows for the attack golem and columns for defens golem, in the diagonal line
		 * there is 0 because same elements to 0 of damage
		 * 
		 * |0 X2 X3 Xn| |Y1 0 Y2 Yn| |Z1 Z2 0 Zn| |T1 T2 T3 0 |
		 */
		// TEST print iteration
		for (int i = 0; i < Setup.N; i++) {
			for (int j = 0; j < Setup.N; j++) {
				System.out.print(glyph.getIteration()[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		Match prova = new Match();
		prova.match();
	}
	
	/**starts a new match without having to reset the execution of the program*/
	public static boolean continueGame() {
		int correct;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.println("Vuoi fare una nuova partita? (si o no):");
				String choice = scanner.nextLine();
				correct = 0;
				if(choice.equalsIgnoreCase(YES)) {
					return true;
				}else if(choice.equalsIgnoreCase(NO)){
					return false;
				}else {
					System.out.println(MSG_ERROR);
					correct = 1;
				}
				
			}while(correct == 1);
			
			return false;

		}catch (Exception e) {
			System.out.println("Ricontrolla il valore inserito");
			return false;
		}	
	}
	
}
