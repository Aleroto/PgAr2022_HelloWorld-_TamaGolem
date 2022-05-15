package it.unibs.fp.tamaGolem;

public class Match {
	Player player1 = new Player();
	Player player2 = new Player();
	
	Glyph glyph = Setup.glyph();
	boolean winner;
	
	public void match() {
		System.out.println("Player 1:");
		player1.setGolemStone();
		System.out.println("Player 2:");
		player2.setGolemStone();
		do {
			fight();
			winner = checkWinner();
			if(!player1.golem.checkLifePoint() && winner) {
				System.out.println("Player 1 deve evocare un nuovo golem:");
				player1.resetGolem();
			}else if(!player2.golem.checkLifePoint() && winner){
				System.out.println("Player 2 deve evocare un nuovo golem:");
				player2.resetGolem();
			}			
		}while(winner);
	}
	
	
	public void fight() {
		int i = 0;
		do {
			switch(powerComparison(i)) {
				case 0:
					System.out.println("Le potenze degli attacchi sono equivalenti");
					break;
				case 1:
					System.out.println("OK");
					player1.golem.lifePoint -= Math.abs(Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph));
					break;
				case 2:
					System.out.println("OK");
					player2.golem.lifePoint -= Math.abs(Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph));					
					break;
			}
			i++;
			if(i == new Setup().P) { 
				i = 0;
			}
		}while(player1.golem.checkLifePoint() && player2.golem.checkLifePoint());
			
	}
	
	public int powerComparison(int i) {
		System.out.println("OK");
		System.out.println("Controllo iterazione"+Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph));
		int value = Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph);
		if(value == 0) {
			return 0;
		}else if(Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph) > 0){
			return 1;
		}else {
			return 2;
		}
	}
	
	//controlla se un giocatore ha finito i golem
	private boolean checkWinner() {
		if(player1.golemNumber == 0 || player2.golemNumber == 0) {
			if(player1.golemNumber == 0) {
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
