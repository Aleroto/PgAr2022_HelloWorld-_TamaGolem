package it.unibs.fp.tamaGolem;

import java.util.EnumMap;

/**Represents the class for Glyph*/
public class Glyph {
	private EnumMap<Elements, Integer> elements = new EnumMap<>(Elements.class);
	
	private int[][] iteration = new int[Setup.N][Setup.N];

	/**Constructor*/
	public Glyph(EnumMap<Elements, Integer> elements, int[][] iteration) {
		super();
		this.elements = elements;
		this.iteration = iteration;
	}
	
	/**Gets Elements*/
	public EnumMap<Elements, Integer> getElements() {
		return elements;
	}
	
	/**Sets Elements*/
	public void setElements(EnumMap<Elements, Integer> elements) {
		this.elements = elements;
	}
	
	/**Gets Iteration*/
	public int[][] getIteration() {
		return iteration;
	}
	
	/**Sets Iteration*/
	public void setIteration(int[][] iteration) {
		this.iteration = iteration;
	}

}
