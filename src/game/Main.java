package game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Game g = new Game();
		
		Scanner keyboard = new Scanner(System.in);
		
		while(g.gameNotOver()) {
			//whites turn
			boolean moveNotEntered = true;
			while(moveNotEntered) {
				System.out.println("P1 enter move");
				String s = keyboard.nextLine();
				if(g.checkInput(s) && g.isValidMove(s, true)) {
					g.move(s, true);
					moveNotEntered = false;
				}
				else {
					System.out.println("invalid move");
				}
			}			
			g.displayBoard();

			if(!g.gameNotOver()) {
				break;
			}
			
			//black's turn
			moveNotEntered = true;
			while(moveNotEntered) {
				System.out.println("P1 enter move");
				String s = keyboard.nextLine();
				if(g.checkInput(s) && g.isValidMove(s, false)) {
					g.move(s, false);
					moveNotEntered = false;
				}
				else {
					System.out.println("invalid move");
				}
			}
			g.displayBoard();
		}
		
		g.printGameResults();
		keyboard.close();
	}
}
