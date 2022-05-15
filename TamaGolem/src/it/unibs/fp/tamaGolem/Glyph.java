package it.unibs.fp.tamaGolem;

import java.util.EnumMap;

public class Glyph {
	private EnumMap<Elements, Integer> elements = new EnumMap<>(Elements.class);
	
	private int[][] iteration = new int[Setup.N][Setup.N];

	
	public Glyph(EnumMap<Elements, Integer> elements, int[][] iteration) {
		super();
		this.elements = elements;
		this.iteration = iteration;
	}
	public EnumMap<Elements, Integer> getElements() {
		return elements;
	}
	public void setElements(EnumMap<Elements, Integer> elements) {
		this.elements = elements;
	}
	public int[][] getIteration() {
		return iteration;
	}
	public void setIteration(int[][] iteration) {
		this.iteration = iteration;
	}

}
