package de.htwg.se.kaesekaestchen.model;
import java.awt.Color;

public class Player implements IPlayer {
	
	private Color playerColor;
	private String name;
	private int points;
	
	public Player(String pName, Color pFarbe) {
		playerColor = pFarbe;
		name = pName;
		points = 0;
		
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayer#incrementPoints()
	 */
	@Override
	public void incrementPoints(){
		points++;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayer#getColor()
	 */
	@Override
	public Color getColor() {
		return playerColor;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayer#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayer#getPoints()
	 */
	@Override
	public int getPoints() {
		return points;
	}
}
