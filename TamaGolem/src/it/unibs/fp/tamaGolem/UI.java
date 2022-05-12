package it.unibs.fp.tamaGolem;

import java.util.Map;

public class UI {
	
	
	
	public static void runProgram(){
		/**
		 * TreeMap for a ordinated list of elements with a key for the value. The value
		 * is necessary for the glyph
		 */
		
		Glyph glyph = new Glyph(Setup.addElements(), Setup.adjacencyMatrixGenerator());
		// get key and value from a TreeMap
		// TEST print elements map
		for (Map.Entry<Elements, Integer> entry : glyph.getElements().entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

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
}
