package it.unibs.fp.tamaGolem;

/**Represents the class for Stone*/
public class Stone {
	Elements stoneType;
	
	/**Constructor*/
	public Stone(Elements stoneType) {
		super();
		this.stoneType = stoneType;
	}

	/**Gets Type of Stone*/
	public Elements getStoneType() {
		return stoneType;
	}

	/**Sets Type of Stone*/
	public void setStoneType(Elements stoneType) {
		this.stoneType = stoneType;
	}
	
}
