package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Board b;
	
	public Game() {
		b = new Board();
	}
	
	public boolean gameNotOver() {
		return !b.gameOver();
	}
	
	public boolean checkInput(String s) {
		Scanner ss = new Scanner(s);
		
		String piece = ss.next();
		String rowcolInit = ss.next();
		String rowcolFinal = ss.next();
		ss.close();
		
		//check to see if piece type is correct
		if(!(piece.contentEquals("pawn") || 
				piece.contentEquals("rook") || 
				piece.contentEquals("knight") || 
				piece.contentEquals("bishop") || 
				piece.contentEquals("queen") || 
				piece.contentEquals("king"))) {
			return false;
		}
		
		//make sure row/col is right size, within bounds of board
		if(rowcolInit.length() != 2 || rowcolFinal.length() != 2) {
			return false;
		}
		char initCol = rowcolInit.charAt(0);
		char initRow = rowcolInit.charAt(1);
		
		char finalCol = rowcolInit.charAt(0);
		char finalRow = rowcolInit.charAt(1);
		
		if(initCol < 97 || finalCol < 97 || initCol > 104 || finalCol > 104) {
			return false;
		}
		
		if(initRow < 49 || finalRow < 49 || initRow > 56 || finalRow > 56) {
			return false;
		}
		return true;
		
		/*
		 * 8
		 * 7
		 * 6
		 * 5
		 * 4
		 * 3
		 * 2
		 * 1
		     a  b  c  d  e  f  g  h
		*/
	}
	
	public boolean isValidMove(String s, boolean isWhite) {
		Scanner ss = new Scanner(s);
		
		//decipher next move and put it through the board;
		String pieceType = ss.next();
		String initColRow = ss.next();
		String finalColRow = ss.next();
		
		int px = (int)initColRow.charAt(0) - 96;
		int py = (int)initColRow.charAt(0) - 48;
		
		int x = (int)finalColRow.charAt(0) - 96;
		int y = (int)finalColRow.charAt(0) - 48;
		
		return b.isValidMove(pieceType, px, py, x, y, isWhite);
	}
	
	public void move(String s, boolean isWhite) {
		Scanner ss = new Scanner(s);
		
		//decipher next move and put it through the board;
		String pieceType = ss.next();
		String initColRow = ss.next();
		String finalColRow = ss.next();
		
		int px = (int)initColRow.charAt(0) - 96;
		int py = (int)initColRow.charAt(0) - 48;
		
		int x = (int)finalColRow.charAt(0) - 96;
		int y = (int)finalColRow.charAt(0) - 48;
		
		b.move(pieceType, px, py, x, y, isWhite);
	}
	
	/*
	 *  0x2654	9812	WHITE CHESS KING	
		0x2655	9813	WHITE CHESS QUEEN	
		0x2656	9814	WHITE CHESS ROOK	
		0x2657	9815	WHITE CHESS BISHOP	
		0x2658	9816	WHITE CHESS KNIGHT	
		0x2659	9817	WHITE CHESS PAWN	
		0x265A	9818	BLACK CHESS KING	
		0x265B	9819	BLACK CHESS QUEEN	
		0x265C	9820	BLACK CHESS ROOK	
		0x265D	9821	BLACK CHESS BISHOP	
		0x265E	9822	BLACK CHESS KNIGHT	
		0x265F	9823	BLACK CHESS PAWN	
	 */
	
	public void displayBoard() {
		ArrayList<Piece> whitePieces = b.getWhitePieces();
		ArrayList<Piece> blackPieces = b.getBlackPieces();
		
		char board[][] = new char[8][8];
		//place all of white's pieces in the board matrix
		for(int i = 0; i < whitePieces.size(); i++) {
			Piece curr = whitePieces.get(i);
			char currType = curr.getType();
			switch(currType) {
			case 'k':
				board[curr.getX()-1][curr.getY()-1] = '\u2654';
				break;
			case 'q':
				board[curr.getX()-1][curr.getY()-1] = '\u2655';
				break;
			case 'b':
				board[curr.getX()-1][curr.getY()-1] = '\u2657';
				break;
			case 'n':
				board[curr.getX()-1][curr.getY()-1] = '\u2658';
				break;
			case 'r':
				board[curr.getX()-1][curr.getY()-1] = '\u2656';
				break;
			case 'p':
				board[curr.getX()-1][curr.getY()-1] = '\u2659';
				break;
			}
			board[curr.getX()-1][curr.getY()-1] = '\u2654';
		}
		
		//place all of black's pieces in the matrix
		for(int i = 0; i < blackPieces.size(); i++) {
			Piece curr = blackPieces.get(i);
			char currType = curr.getType();
			switch(currType) {
			case 'k':
				board[curr.getX()-1][curr.getY()-1] = '\u265A';
				break;
			case 'q':
				board[curr.getX()-1][curr.getY()-1] = '\u265B';
				break;
			case 'b':
				board[curr.getX()-1][curr.getY()-1] = '\u265D';
				break;
			case 'n':
				board[curr.getX()-1][curr.getY()-1] = '\u265E';
				break;
			case 'r':
				board[curr.getX()-1][curr.getY()-1] = '\u265C';
				break;
			case 'p':
				board[curr.getX()-1][curr.getY()-1] = '\u265F';
				break;
			}
		}
		                        
//		|-------------------------------|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
//		| a | b | c | d | e | f | g | h |
//		|-- --- --- --- --- --- --- ----|
		
		//print out the board
		System.out.println("|-------------------------------|");
		for(int i = 7; i >= 0; i++) {
			System.out.print("| ");
			for(int j = 0; j < 8; j++) {
				System.out.println(board[j][i]);
				System.out.print(" | ");
			}
			System.out.println();
			System.out.println("|-------------------------------|");
		}
	}
	
	public void printGameResults() {
		//TODO: figure this out
	}
}
