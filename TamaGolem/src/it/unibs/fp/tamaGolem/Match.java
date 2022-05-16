package it.unibs.fp.tamaGolem;

public class Match {
	Player player1 = new Player();
	Player player2 = new Player();
	
	boolean winner;
	
	public void match() {
		System.out.println("Player 1:");
		player1.setGolemStone();
		System.out.println("Player 2:");
		player2.setGolemStone();
		do {
			System.out.println("################INIZIO BATTAGLIA######################");
			fight();
			winner = checkWinner();
			if(!player1.golem.checkLifePoint() && !winner) {
				System.out.println("Player 1 deve evocare un nuovo golem:");
				player1.resetGolem();
			}else if(!player2.golem.checkLifePoint() && !winner){
				System.out.println("Player 2 deve evocare un nuovo golem:");
				player2.resetGolem();
			}			
		}while(winner);
	}
	
	
	public void fight() {
		int i = 0;
		do {
			int attachValue =  Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(),UI.glyph);
			switch(powerComparison(i)) {
				case 0:
					System.out.println("Le potenze degli attacchi sono equivalenti");
					break;
				case 1:
					System.out.println("Il golem del player 1 prende " + attachValue + " danni");
					player1.golem.lifePoint -= Math.abs(attachValue);
					break;
				case 2:
					System.out.println("Il golem del player 2 prende " + attachValue + " danni");
					player2.golem.lifePoint -= Math.abs(attachValue);					
					break;
			}
			i++;
			if(i == Setup.P) { 
				i = 0;
			}
		}while(player1.golem.checkLifePoint() && player2.golem.checkLifePoint());
			
	}
	
	public int powerComparison(int i) {
		//System.out.println("Controllo iterazione"+Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), UI.glyph));
		
		for(int j = 0; j< 4;j++) {
			System.out.println("\tP1\t"+player1.golem.stones.get(j).getStoneType()+"|\tP2\t"+player2.golem.stones.get(j).getStoneType());
		}
		
		
		int value = Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), UI.glyph);
		System.out.println("VALUE = "+value);
		if(value == 0) {
			return 0;
		}else if(value < 0){
			return 1;
		}else {
			return 2;
		}
	}
	
	//controlla se un giocatore ha finito i golem
	private boolean checkWinner() {
		if(player1.golemsNumbers == 0 || player2.golemsNumbers
				== 0) {
			if(player1.golemsNumbers == 0) {
				System.out.println("IL VINCITORE E' IL GIOCATORE 2");
			}else {
				System.out.println("IL VINCITORE E' IL GIOCATORE 1");

			}
			return false;
		}else {
			return true;
		}
	}
	
}
