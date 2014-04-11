package de.htwg.se.KaeseKaestchen.model;

public class Point {
	
	private int valX;
	private int valY;
	
	public Point(int pX, int pY){
		valX = pX;
		valY = pY;
	}

	public int getValX() {
		return valX;
	}

	public void setValX(int valX) {
		this.valX = valX;
	}

	public int getValY() {
		return valY;
	}

	public void setValY(int valY) {
		this.valY = valY;
	}

}
