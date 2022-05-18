package it.unibs.fp.tamaGolem;

import java.util.Map;
import java.util.*;

public class Match {
	Player player1 = new Player();
	Player player2 = new Player();

	/**Main method for manage the match*/
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

	/**manage the battle between two golem*/
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
			// Player.turn = 2;
			// Player.bagPlayer2.entrySet().forEach(System.out::println);
			return indexStonePlayer1;
		} else {
			System.out.println("IL GOLEM DEL GIOCATORE 1 E' STATO SCONFITTO");
			// Player.turn = 1;
			// Player.bagPlayer1.entrySet().forEach(System.out::println);

			return indexStonePlayer2;
		}

	}

	/**Analyse the iteration between the element for take the winner */
	public int powerComparison(int indexStonePlayer1, int indexStonePlayer2) {
		System.out.println("-Il golem 1 scaglia una pietra "
				+ player1.golem.stones.get(indexStonePlayer1).getStoneType() + " e il golem 2 scaglia una pietra "
				+ player2.golem.stones.get(indexStonePlayer2).getStoneType() + "-");
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

	/**Check if a player ended the golem*/
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

	/**print the stones of a player*/
	private void printDeck() {
		System.out.println("Pietre ingerite dai golem:");
		for (int j = 0; j < 4; j++) {
			System.out.println("\tG1\t" + player1.golem.stones.get(j).getStoneType() + "\t\t|G2\t"
					+ player2.golem.stones.get(j).getStoneType());
		}
		System.out.println("-----------------------------------------------------");
	}

	/** Interface for manage the first set of stones*/
	private void setGolemStoneMenu() {
		do {
			System.out.println("Assegnamento pietre:");
			System.out.println("PLAYER 1:");
			// Setup.fillBagFirst(Player.bagPlayer1);
			// Player.printBag(Player.bagPlayer1);
			player1.setGolemStone();

			System.out.println("PLAYER 2:");
			// Setup.fillBagFirst(Player.bagPlayer2);
			// Player.printBag(Player.bagPlayer2);
			// Player.turn = 2;
			player2.setGolemStone();

		} while (player1.golem.stones.equals(player2.golem.stones));
	}

	/**Check the golem with the same elements*/
	private void controlSameGolemStone(Player player) {
		if (player1.golem.stones.equals(player2.golem.stones)) {
			
			player.setGolemStone();
		}
	}

}
