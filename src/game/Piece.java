package game;

import java.util.ArrayList;


public abstract class Piece {
	private byte x;
	private byte y;
	private char type;
	
	public Piece(byte ex, byte why) {
		x = ex;
		y = why;
	}
	
	public byte getX() {
		return x;
	}
	
	public byte getY() {
		return y;
	}
	
	public char getType() {
		return type;
	}
	
	public void setX(byte ex) {
		x = ex;
	}
	
	public void setY(byte why) {
		y = why;
	}
	
	public void setType(char t) {
		type = t;
	}
	
	
	public abstract void movePiece()
	
}
