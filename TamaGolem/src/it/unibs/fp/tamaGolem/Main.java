package it.unibs.fp.tamaGolem;

/**Uses only for start the program in the user interface and for restart the game*/	
public class Main {	
	public static void main(String[] args) {
		do {
			UI.runProgram();
		}while(UI.continueGame());		
	}

	

}

