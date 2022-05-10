package it.unibs.fp.tamaGolem;

import java.util.*;

public class Main {
	private final static Integer N = 6;
	/** total elements */
	private final static Integer V = 10;
	private final static Integer V_ = -V;
	/** max health for a golem */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * TreeMap for a ordinated list of elements with a key for the value. The value
		 * is necessary for the glyph
		 */
		Map<Integer, String> elements = new TreeMap<>();

		elements = addElements(elements);
		// get key and value from a TreeMap
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
		iteration = adjacencyMatrixGenerator();
		int a = 0;
	}

	/**
	 * Generate a set of random number all different
	 * 
	 * @return
	 */
	// TODO da mettere nel setup
	private static ArrayList<Integer> setRandomInt(int min, int max) {
		Set<Integer> s = new HashSet<>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		while (s.size() != N) {
			int random = (int) (Math.random() * (max - min + 1) + min);
			s.add(random);
		}

		for (Integer n : s) {
			a.add(n);
		}
		return a;
	}

	/** Generate a map of N random elements from the "type" array_ */
	// TODO da mettere nel setup
	private static Map<Integer, String> addElements(Map<Integer, String> elements) {
		String[] type = { "Normal", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", "Steel", "Fire",
				"Water", "Grass", "Electric", "Psychic", "Ice", "Dragon", "Dark", "Fairy" };
		int typeSize = type.length;
		ArrayList<Integer> randomNumber = new ArrayList<Integer>();
		randomNumber = setRandomInt(0, typeSize - 1);

		for (int i = 0; i < N; i++) {
			elements.put(i, type[randomNumber.get(i)]);
		}
		return elements;
	}

	private static int[][] adjacencyMatrixGenerator() {
		int[][] array_ = new int[N][N];
		int maxPos = V;
		int minNeg = V_;
		for (int i = 0; i < N; i++) {
			// array_[i] = generateRow(array_[i], i);
			maxPos = V;
			minNeg = -V;
			if(i == (N - 1)) {
				continue;
			}
			for (int j = 0; j < N; j++) {
				// check if i'm in the last elements of the row, for efficiency i can found with
				// the value of the other
				if (j == (N - 1)) {
					int sum = 0;
					for (int t = 0; t < N - 1; t++) {
						sum += array_[i][t];
					}
					array_[i][j] = -(sum);
					array_[j][i] = sum;
				} else if (i == j) {
					array_[i][j] = 0;
				} else if (i < j) {
					int temp = 0;
					// random number from -V <= x <=1 & 1<= x <= V
					do {
						temp = (int) (Math.random() * (maxPos - minNeg + 1) + minNeg);
						int tempAbs = Math.abs(temp);
						maxPos -= tempAbs;
						if (maxPos < 1) {
							maxPos = 1;
						}
						minNeg += tempAbs;
						if (minNeg > -1) {
							minNeg = -1;
						}

					} while (temp == 0);
					array_[i][j] = temp;
					array_[j][i] = -temp;
				}
			}
			
			// check return true if sum is zero
			if (!checkRow(array_[i])) {
				i--;
				continue;
			}
		}

		return array_;
	}

	/** Generate a single row of a matrix[][] */
	private static int[] generateRow(int[] array_, int i) {
		int maxPos = V;
		final int minNeg = -V;
		for (int j = 0; j < N; j++) {
//			if (j == (N-1)) {
//				int sum = 0;
//				for(int t=0; t < N-1; t++) {
//					sum += array_[t];
//				}
//				array_[j] = -(sum);
			if (i < j) {
				int temp = 0;
				// random number from -V <= x <=1 & 1<= x <= V
				do {
					temp = (int) (Math.random() * (maxPos - minNeg + 1) + minNeg);
				} while (temp == 0);
				array_[j] = temp;
			} else if (i == j) {
				array_[j] = 0;
			}
		}
		return array_;
	}

	private static boolean checkRow(int[] array_) {
		int sum = 0;
		for (int i = 0; i < array_.length; i++) {
			sum += array_[i];
		}

		if (sum == 0) {
			int p = array_[array_.length - 1];
			if (array_[array_.length - 1] != 0 && (array_[array_.length - 1] <= V && array_[array_.length - 1] >= V_)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
}
