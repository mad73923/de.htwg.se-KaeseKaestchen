import java.awt.Color;

public class Player {
	
	Color playerColor;
	String name;
	int points;
	
	public Player(String pName, Color pFarbe) {
		playerColor = pFarbe;
		name = pName;
		points = 0;
		
	}
	
	public Player(String pName){
		name = pName;
		points = 0;
		//TODO zufaellige farbe
		
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
