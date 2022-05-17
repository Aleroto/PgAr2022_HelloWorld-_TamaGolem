package it.unibs.fp.tamaGolem;

import java.util.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Setup {

	
	/** total elements */
	public final static Integer N = 6;
	public final static Integer V = 10;
	private final static Integer V_ = -V;
	
	public  static Integer P = (int) (Math.ceil((N+1.0)/3.0)+1.0);			//4 per N=6
	public  static Integer G = (int) (Math.ceil((N-1.0)*(N-2.0)/(2.0*P)));	//3 per N=6
	public  static Integer S = (int) (Math.ceil((2.0*G*P)/N)*N);			//24 per N=6
	
	
	
	//public static ArrayList<Stone> setupBag = new ArrayList<Stone>();

	//public static HashMap<String,Integer> bag = new HashMap<>();
	
	public static Map<String, Integer> bag = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);


	
	
//region Method for manage the random generation of element's match	
	/** Generate a map of N random elements from the "type" array_ */
	public static EnumMap<Elements, Integer> addElements(/*EnumMap<Elements, Integer> elements*/) {
		EnumMap<Elements, Integer> elements = new EnumMap<Elements, Integer>(Elements.class);
		int typeSize = 18; // number of elements in the enum
		ArrayList<Integer> randomNumber = new ArrayList<Integer>();
		randomNumber = setRandomInt(0, typeSize - 1);
		
		
		for (int i = 0; i < N; i++) {
			switch (randomNumber.get(i)) {
			case 0: {
				elements.put(Elements.Bug, i);
				break;
			}
			case 1: {
				elements.put(Elements.Dark, i);
				break;
			}
			case 2: {
				elements.put(Elements.Dragon, i);
				break;
			}
			case 3: {
				elements.put(Elements.Electric, i);
				break;
			}
			case 4: {
				elements.put(Elements.Fairy, i);
				break;
			}
			case 5: {
				elements.put(Elements.Fighting, i);
				break;
			}
			case 6: {
				elements.put(Elements.Fire, i);
				break;
			}
			case 7: {
				elements.put(Elements.Flying, i);
				break;
			}
			case 8: {
				elements.put(Elements.Ghost, i);
				break;
			}
			case 9: {
				elements.put(Elements.Grass, i);
				break;
			}
			case 10: {
				elements.put(Elements.Ground, i);
				break;
			}
			case 11: {
				elements.put(Elements.Ice, i);
				break;
			}
			case 12: {
				elements.put(Elements.Normal, i);
				break;
			}
			case 13: {
				elements.put(Elements.Poison, i);
				break;
			}
			case 14: {
				elements.put(Elements.Psychic, i);
				break;
			}
			case 15: {
				elements.put(Elements.Rock, i);
				break;
			}
			case 16: {
				elements.put(Elements.Steel, i);
				break;
			}
			case 17: {
				elements.put(Elements.Water, i);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + randomNumber.get(i));
			}
		}

		return elements;
	}
	/** Generate a set of random number all different */
	
	
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


//region Method for manage the random iteration of element's match	
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

	/** Generate a single row of a matrix[][] */
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
	
	//TODO Ditemi se questi metodi per ottenere le iterazioni fra elementi le volete in una classe di supporto o altro...
	public static int getIteration(Elements elementOne, Elements elementTwo, Glyph glyph) {
		/*
		System.out.println("VERIFICA같같같같같같같같같같같같같같같같같");
		System.out.println("Mappa: " + glyph.getElements());
		System.out.println(elementOne);
		System.out.println(elementTwo);

		System.out.println(glyph.getElements().get(elementOne));
		System.out.println(glyph.getElements().get(elementTwo));
		*/
		
		int indexOne = glyph.getElements().get(elementOne);
		int indexTwo = glyph.getElements().get(elementTwo);
		return glyph.getIteration()[indexOne][indexTwo];
	}
//endregion	
	//generazione glifo
	public static Glyph glyph() {
		return new Glyph(Setup.addElements(), Setup.adjacencyMatrixGenerator());
	}
		
	
	/**fills the bag with the number of stones equal to S*/
	public static void fillBag() {			
		for(int i = 0; i < UI.setupBag.size(); i++) {
			bag.put(UI.setupBag.get(i).stoneType.toString(),P);
			
			bag.put(UI.setupBag.get(i).stoneType.toString(),4);
		}
	}
}
