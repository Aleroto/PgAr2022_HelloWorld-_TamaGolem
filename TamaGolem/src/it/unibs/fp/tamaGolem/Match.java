package it.unibs.fp.tamaGolem;

public class Match {
	Player player1 = new Player();
	Player player2 = new Player();

	//programma principale per gestione dello guerra
	public void match() {
		int indexStonePlayer1 = 0;
		int indexStonePlayer2 = 0;
		setGolemStoneMenu();
		do {
			printDeck();
			indexStonePlayer1 = fight(indexStonePlayer1, indexStonePlayer2);
			indexStonePlayer2 = indexStonePlayer1;
			
			if (!player1.golem.checkLifePoint() && player1.golemsNumbers > 0) {
				player1.resetGolem(1);
				controlSameGolemStone(player1);
				indexStonePlayer1 = 0;
			} else if (!player2.golem.checkLifePoint() && player2.golemsNumbers > 0) {
				player2.resetGolem(2);
				controlSameGolemStone(player2);
				indexStonePlayer2 = 0;
			} else {
			}
		} while (checkWinner());
	}

	// gestione battaglia tra due golem
	public int fight(int indexStonePlayer1, int indexStonePlayer2) {
		System.out.println("################INIZIO BATTAGLIA######################");
		do {
			if (indexStonePlayer1 >= Setup.P) {
				indexStonePlayer1 = 0;
			}
			if (indexStonePlayer2 >= Setup.P) {
				indexStonePlayer2 = 0;
			}
			int attachValue = Setup.getIteration(player1.golem.stones.get(indexStonePlayer1).getStoneType(),
					player2.golem.stones.get(indexStonePlayer2).getStoneType(), UI.glyph);
			switch (powerComparison(indexStonePlayer1, indexStonePlayer2)) {
			case 0:
				System.out.println("Le potenze degli attacchi sono equivalenti");
				break;
			case 1:
				System.out.println("Il golem del player 1 prende " + Math.abs(attachValue) + " danni");
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
		System.out.println("################TERMINE BATTAGLIA#####################");
		if (player1.golem.checkLifePoint()) {
			System.out.println("IL GOLEM DEL GIOCATORE 2 E' STATO SCONFITTO");
			return indexStonePlayer1;
		} else {
			System.out.println("IL GOLEM DEL GIOCATORE 1 E' STATO SCONFITTO");
			return indexStonePlayer2;
		}

	}

	// confronta le potnze degli elementi coinvolti in battaglia
	public int powerComparison(int indexStonePlayer1, int indexStonePlayer2) {
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

	// stampa pietre possedute dai golem
	private void printDeck() {
		System.out.println("Pietre ingerite dai golem:");
		for (int j = 0; j < 4; j++) {
			System.out.println("\tG1\t" + player1.golem.stones.get(j).getStoneType() + "\t|G2\t"
					+ player2.golem.stones.get(j).getStoneType());
		}
		System.out.println("-----------------------------------------------------");
	}

	// interfaccia per gestione assegnazione iniziale pietre golem
	private void setGolemStoneMenu() {
		do {
			System.out.println("Assegnamento pietre:");
			System.out.println("PLAYER 1:");
			player1.setGolemStone();
			System.out.println("PLAYER 2:");
			player2.setGolemStone();
		} while (player1.golem.stones.equals(player2.golem.stones));
	}

	// controllo pietre uguali tra golem appena mandati in combattimento
	private void controlSameGolemStone(Player player) {
		if (player1.golem.stones.equals(player2.golem.stones)) {
			player.setGolemStone();
		}
	}

}
