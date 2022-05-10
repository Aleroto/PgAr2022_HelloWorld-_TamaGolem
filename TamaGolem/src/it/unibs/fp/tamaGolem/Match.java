package it.unibs.fp.tamaGolem;

public class Match {
	Player player1;
	Player player2;
	
	
	public void match() {
		do {
			for(int i = 0;i<2;i++) {
				player1.setGolemStone();
				player2.setGolemStone();
			}
			//battaglia
	
			
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
					player1.golems.get(0).setLifepoint(player1.golems.get(0).getLifepoint()- player2.golems.get(0).getStones().get(i).getValue()); 
					System.out.println("Il golem del giocatore 1 ha subito "+player2.golems.get(0).getStones().get(i).getValue()+" di danno");
					break;
				case 2:
					player2.golems.get(0).setLifepoint(player2.golems.get(0).getLifepoint()- player1.golems.get(0).getStones().get(i).getValue()); 					
					break;
			}
			i++;
			if(i = Setup.P) { //TODO sostituire Setup.P con il numero massimo di pietre per golem
				i = 0;
			}
		}while(player1.golems.get(0).checkLifePoint() && player2.golems.get(0).checkLifePoint());
			
	}
	
	private int powerComparison(int i) {
		if(player1.golems.get(0).getStones().get(i).getValue() == player2.golems.get(0).getStones().get(i).getValue()) {
			return 0;
		}else if(player1.golems.get(0).getStones().get(i).getValue() < player2.golems.get(0).getStones().get(i).getValue()) {
			return 1;
		}else {
			return 2;
		}
	}
	
	//controlla numero di golem rimanenti
	private int checkGolemNumber(Player player) {
		return player.getGolems().size();
	}
	
	//controlla se un giocatore ha finito i golem
	private boolean checkWinner() {
		if(checkGolemNumber(player1) == 0 || checkGolemNumber(player2) == 0) {
			if(checkGolemNumber(player1) == 0) {
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
