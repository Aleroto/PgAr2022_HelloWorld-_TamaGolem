package it.unibs.fp.tamaGolem;

public class Match {
	Player player1 = new Player();
	Player player2 = new Player();

	public void match() {
		int indexStonePlayer1 = 0;
		int indexStonePlayer2 = 0;
		setGolemStoneMenu();
		do {
			if (!player1.golem.checkLifePoint() && player1.golemsNumbers > 0) {
				System.out.println("Player 1 deve evocare un nuovo golem:");
				player1.resetGolem();
				controlSameGolemStone(player1);
				indexStonePlayer1 = 0;
			} else if (!player2.golem.checkLifePoint() && player2.golemsNumbers > 0) {
				System.out.println("Player 2 deve evocare un nuovo golem:");
				player2.resetGolem();
				controlSameGolemStone(player2);
				indexStonePlayer2 = 0;
			} else {
				System.out.println("PARTITA TERMINATA");
			}
			printDeck();
			indexStonePlayer1 = fight(indexStonePlayer1,indexStonePlayer2); 
			indexStonePlayer2 = indexStonePlayer1;
		} while (checkWinner());
	}

	//gestione battaglia tra due golem
	public int fight(int indexStonePlayer1,int indexStonePlayer2) {
		System.out.println("################INIZIO BATTAGLIA######################");
		do {
			if(indexStonePlayer1 >= Setup.P) {
				indexStonePlayer1 = 0;
			}
			if(indexStonePlayer2 >= Setup.P) {
				indexStonePlayer2 = 0;
			}
			int attachValue = Setup.getIteration(player1.golem.stones.get(indexStonePlayer1).getStoneType(),player2.golem.stones.get(indexStonePlayer2).getStoneType(), UI.glyph);
			switch (powerComparison(indexStonePlayer1,indexStonePlayer2)) {
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

			indexStonePlayer1++;
			indexStonePlayer2++;
		} while (player1.golem.checkLifePoint() && player2.golem.checkLifePoint());
		if(player1.golem.checkLifePoint()) {
			return indexStonePlayer1;
		}else {
			return indexStonePlayer2;
		}
		
	}
	
	//confronta le potnze degli elementi coinvolti in battaglia
	public int powerComparison(int indexStonePlayer1,int indexStonePlayer2) {
		int value = Setup.getIteration(player1.golem.stones.get(indexStonePlayer1).getStoneType(),
				player2.golem.stones.get(indexStonePlayer2).getStoneType(), UI.glyph);
		if (value == 0) {
			return 0;
		} else if (value < 0) {
			return 1;
		} else {
			return 2;
		}
	}

	// controlla se un giocatore ha finito i golem
	private boolean checkWinner() {
		System.out.println("golem: " + player1.golemsNumbers + " - " + player2.golemsNumbers);
		if (player1.golemsNumbers == 0 || player2.golemsNumbers == 0) {
			if (player1.golemsNumbers == 0) {
				System.out.println("IL VINCITORE E' IL GIOCATORE 2");
			} else {
				System.out.println("IL VINCITORE E' IL GIOCATORE 1");
			}
			return false;
		} else {
			return true;
		}
	}

	//stampa pietre possedute dai golem
	private void printDeck() {
		System.out.println("Pietre ingerite dai golem:");
		for (int j = 0; j < 4; j++) {
			System.out.println("\tG1\t" + player1.golem.stones.get(j).getStoneType() + "\t|G2\t"
					+ player2.golem.stones.get(j).getStoneType());
		}
		System.out.println("-----------------------------------------------------");
	}

	//interfaccia per gestione assegnazione iniziale pietre golem
	private void setGolemStoneMenu() {
		do {
			System.out.println("Assegnamento pietre:");
			System.out.println("PLAYER 1:");
			player1.setGolemStone();
			System.out.println("PLAYER 2:");
			player2.setGolemStone();
		} while (player1.golem.stones.equals(player2.golem.stones));
	}
	
	//controllo pietre uguali tra golem appena mandati in combattimento
	private void controlSameGolemStone(Player player) {
		if(player1.golem.stones.equals(player2.golem.stones)) {
			player.setGolemStone();
		}
	}

}
