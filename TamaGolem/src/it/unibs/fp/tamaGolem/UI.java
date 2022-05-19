package it.unibs.fp.tamaGolem;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;


import java.util.Scanner;

/**Represents the class to manage the Game*/
public class UI {
	
	private static final String CHAR_SPACE_MATRIX = "%-15s| ";
	private static final String YES = "si";
	private static final String NO = "no";
	private static final String MSG_ERROR = "Errore, riscrivere correttamente la scelta";
	
	public static ArrayList<Stone> setupBag = new ArrayList<Stone>();
	
	public static ArrayList<Stone> setupBagPlayer1 = new ArrayList<Stone>();
	public static ArrayList<Stone> setupBagPlayer2 = new ArrayList<Stone>();


	public static Glyph glyph;



	/**Runs the Program*/
	public static void runProgram(){
		/**
		 * TreeMap for a ordinated list of elements with a key for the value. The value
		 * is necessary for the glyph
		 */
		//setupBag.clear();
		checkBagSize();
		checkElementsSize();
		glyph = new Glyph(Setup.addElements(), Setup.adjacencyMatrixGenerator());
		// get key and value from a TreeMap
		// TEST print elements map
		for (Map.Entry<Elements, Integer> entry : glyph.getElements().entrySet()) {
			/*System.out.println(entry.getKey() + " -> " + entry.getValue());*/
			setupBag.add(new Stone(entry.getKey()));
		}
		
		
		Player.bagPlayer1.clear();
		Player.first = true;
		Player.turn = 1;
		Setup.fillBagFirst(Player.bagPlayer1);
		
		Player.bagPlayer2.clear();
		Player.second = true;
		//System.out.println("second: "+Player.second);
		Setup.fillBagFirst(Player.bagPlayer2);
		
		Match game = new Match();
		game.match();
		
		balance();
	}

	/**Prints the matrix with match's balance*/
	private static void balance() {
		System.out.println("#######################EQUILIBRIO#################");
		System.out.printf(CHAR_SPACE_MATRIX,"");	
		for (Map.Entry<Elements, Integer> entry : glyph.getElements().entrySet()) {
			System.out.printf(CHAR_SPACE_MATRIX, entry.getKey());
		}
		System.out.print("\n");
		int e=0, k =0;		
		for (Map.Entry<Elements, Integer> entry : glyph.getElements().entrySet()) {
				System.out.printf(CHAR_SPACE_MATRIX, entry.getKey());
				for (int j = 0; j < Setup.N; j++) {
					System.out.printf(CHAR_SPACE_MATRIX, glyph.getIteration()[k][j]);
				}
				System.out.print("\n");
				k++;			
		}
		k=0;
		System.out.println("##################################################");
	}
	
	/**Cleans the bag*/
	private static void checkBagSize() {
		if(!setupBag.isEmpty()) {
			setupBag.removeAll(setupBag);
			/*int size = setupBag.size();
			for (int i = 0; i < size; i++) {
				setupBag.remove(0);
			}*/
		}
	}
	
	/**Cleans the elements map in the glyph*/
	private static void checkElementsSize() {
		if(glyph != null) {
			glyph = null;
		}
	}
	
	/**Starts a new match without having to reset the execution of the program*/
	public static boolean continueGame() {
		int correct;
		Scanner scanner = new Scanner(System.in);

		try {
			do {
				System.out.print("Vuoi fare una nuova partita? (si o no): ");
				String choice = scanner.nextLine();
				//String choice = scanner.next();

				correct = 0;
				if(choice.equalsIgnoreCase(YES)) {
					//Player.first = true;
					//Player.second = true;
					//Player.turn = 1;
					//Setup.fillBagFirst(Player.bagPlayer1);
					return true;
				}else if(choice.equalsIgnoreCase(NO)){
					//Setup.fillBagFirst(Player.bagPlayer2);
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
