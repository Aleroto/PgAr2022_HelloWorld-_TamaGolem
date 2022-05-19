package it.unibs.fp.tamaGolem;

import java.util.*;

/**Represents the class to set the starting conditions*/
public class Setup {
	/**Total elements */
	public final static Integer N = 6;
	public final static Integer V = 10;
	private final static Integer V_ = -V;
	
	public  static Integer P = (int) (Math.ceil((N+1.0)/3.0)+1.0);			//4 per N=6
	public  static Integer G = (int) (Math.ceil((N-1.0)*(N-2.0)/(2.0*P)));	//3 per N=6
	public  static Integer S = (int) (Math.ceil((2.0*G*P)/N)*N);			//24 per N=6
		
	public static Map<String, Integer> bag = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

	
	//region Method for manage the random generation of element's match	
	/**Generates a map of N random elements from the "type" array_ */
	public static EnumMap<Elements, Integer> addElements(/*EnumMap<Elements, Integer> elements*/) {
		EnumMap<Elements, Integer> elements = new EnumMap<Elements, Integer>(Elements.class);
		int typeSize = 18; // number of elements in the enum
		ArrayList<Integer> randomNumber = new ArrayList<Integer>();
		randomNumber = setRandomInt(0, typeSize - 1);
		
		
		for (int i = 0; i < N; i++) {
			switch (randomNumber.get(i)) {
			case 0: {
				elements.put(Elements.Coleottero, i);
				break;
			}
			case 1: {
				elements.put(Elements.Buio, i);
				break;
			}
			case 2: {
				elements.put(Elements.Drago, i);
				break;
			}
			case 3: {
				elements.put(Elements.Elettro, i);
				break;
			}
			case 4: {
				elements.put(Elements.Folletto, i);
				break;
			}
			case 5: {
				elements.put(Elements.Lotta, i);
				break;
			}
			case 6: {
				elements.put(Elements.Fuoco, i);
				break;
			}
			case 7: {
				elements.put(Elements.Volante, i);
				break;
			}
			case 8: {
				elements.put(Elements.Spettro, i);
				break;
			}
			case 9: {
				elements.put(Elements.Erba, i);
				break;
			}
			case 10: {
				elements.put(Elements.Terra, i);
				break;
			}
			case 11: {
				elements.put(Elements.Ghiaccio, i);
				break;
			}
			case 12: {
				elements.put(Elements.Normale, i);
				break;
			}
			case 13: {
				elements.put(Elements.Veleno, i);
				break;
			}
			case 14: {
				elements.put(Elements.Psico, i);
				break;
			}
			case 15: {
				elements.put(Elements.Roccia, i);
				break;
			}
			case 16: {
				elements.put(Elements.Acciaio, i);
				break;
			}
			case 17: {
				elements.put(Elements.Acqua, i);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + randomNumber.get(i));
			}
		}

		return elements;
	}
	
	/**Generates a set of random number all different */
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


	/**Manages the random iteration of element's match*/
	public static int[][] adjacencyMatrixGenerator() {
		int[][] array_ = new int[N][N];
		int maxPos = V;
		int minNeg = V_;
		for (int i = 0; i < N; i++) {
			// array_[i] = generateRow(array_[i], i);
			maxPos = V;
			minNeg = -V;
			if (i == (N - 1)) {
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

	/**Generates a single row of a matrix[][] */
	private static int[] generateRow(int[] array_, int i) {
		int maxPos = V;
		final int minNeg = -V;
		for (int j = 0; j < N; j++) {
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
	
	/**Checks the sum of the single row*/
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
	
	/**Gets the value from two type, rappresents the iteration between the glyph's nodes*/ 
	public static int getIteration(Elements elementOne, Elements elementTwo, Glyph glyph) {		
		int indexOne = glyph.getElements().get(elementOne);
		int indexTwo = glyph.getElements().get(elementTwo);
		return glyph.getIteration()[indexOne][indexTwo];
	}
	
	/**Generates Glyph*/
	public static Glyph glyph() {
		return new Glyph(Setup.addElements(), Setup.adjacencyMatrixGenerator());
	}
		
	
	/**Fills the bag for a player*/
	public static void fillBagFirst(Map<String, Integer> bagPlayer) {			
		for(int i = 0; i < UI.setupBag.size(); i++) {
			bagPlayer.put(UI.setupBag.get(i).stoneType.toString(),P);
		}
	}
	

	

}
