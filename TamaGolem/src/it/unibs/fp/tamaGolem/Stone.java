package it.unibs.fp.tamaGolem;

public class Stone {
	Elements stoneType;
	int value;
	
	

	public Stone(Elements stoneType, int value) {
		super();
		this.stoneType = stoneType;
		this.value = value;
	}

	public Elements getStoneType() {
		return stoneType;
	}

	public void setStoneType(Elements stoneType) {
		this.stoneType = stoneType;
	}
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
