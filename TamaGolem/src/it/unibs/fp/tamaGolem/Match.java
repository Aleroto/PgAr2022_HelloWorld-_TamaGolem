package it.unibs.fp.tamaGolem;

public class Match {
	Player player1 = new Player();
	Player player2 = new Player();
	
	Glyph glyph = Setup.glyph();
	
	
	public void match() {
		player1.setGolemStone();
		player2.setGolemStone();
		do {
			fight();
			if(!player1.golem.checkLifePoint()) {
				player1.golem.setLifepoint(Setup.V);
				player1.setGolemStone();
				player1.lostGolem();
			}else {
				player2.golem.setLifepoint(Setup.V);
				player2.setGolemStone();
				player2.lostGolem();
			}			
		}while(checkWinner());
	}
	
	
	private void fight() {
		int i = 0;
		do {
			switch(powerComparison(i)) {
				case 0:
					System.out.println("Le potenze degli attacchi sono equivalenti");
					break;
				case 1:
					
					player1.golem.lifePoint -= Math.abs(Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph));
					break;
				case 2:
					player2.golem.lifePoint -= Math.abs(Setup.getIteration(player1.golem.stones.get(i).getStoneType(), player2.golem.stones.get(i).getStoneType(), glyph));					
					break;
			}
			i++;
			if(i == new Setup().P) { //TODO sostituire Setup.P con il numero massimo di pietre per golem
				i = 0;
			}
		}while(player1.golem.checkLifePoint() && player2.golem.checkLifePoint());
			
	}
	
	private int powerComparison(int i) {
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
