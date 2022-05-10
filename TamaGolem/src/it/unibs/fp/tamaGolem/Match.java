package it.unibs.fp.tamaGolem;

public class Match {
	Player player1;
	Player player2;
	Player[] players = new Player[2];
	
	
	public void match() {
		do {
			for(int i = 0;i<2;i++) {
				players[i].setGolemStone();
			}
			//battaglia
			
			
		}while(checkWinner());
	}
	
	
	private void fight() {
		
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
