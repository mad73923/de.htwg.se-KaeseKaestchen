package de.htwg.se.KaeseKaestchen.model;
import java.awt.Color;

public class Player {
	
	private Color playerColor;
	private String name;
	private int points;
	
	public Player(String pName, Color pFarbe) {
		playerColor = pFarbe;
		name = pName;
		points = 0;
		
	}
	
	public void incrementPoints(){
		points++;
	}

	public Color getColor() {
		return playerColor;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
}
