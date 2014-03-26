import java.awt.Color;

public class Spieler {
	
	Color farbe;
	String name;
	int punkte;
	
	public Spieler(String pName, Color pFarbe) {
		farbe = pFarbe;
		name = pName;
		punkte = 0;
		
	}
	
	public Spieler(String pName){
		name = pName;
		punkte = 0;
		//TODO zufällige farbe
		
	} 

	public Color getFarbe() {
		return farbe;
	}

	public String getName() {
		return name;
	}

	public int getPunkte() {
		return punkte;
	}
}
