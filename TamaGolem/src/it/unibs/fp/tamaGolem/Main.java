package it.unibs.fp.tamaGolem;

import java.util.*;

public class Main {
	private final static Integer N = 6;

	/** total elements */
	/** max health for a golem */

	public static void main(String[] args) {
		/**
		 * TreeMap for a ordinated list of elements with a key for the value. The value
		 * is necessary for the glyph
		 */
		Map<Integer, String> elements = new TreeMap<>();

		elements = Setup.addElements(elements);
		// get key and value from a TreeMap
		// TEST print elements map
		for (Map.Entry<Integer, String> entry : elements.entrySet()) {
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
		int[][] iteration = new int[N][N];
		iteration = Setup.adjacencyMatrixGenerator();
		// TEST print iteration
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(iteration[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
	}

}
