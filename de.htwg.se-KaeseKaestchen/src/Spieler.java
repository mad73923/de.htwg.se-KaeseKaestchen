import java.awt.Color;

public class Spieler {
	
	Color farbe;
	String name;
	int punkte;
	
	public Spieler(String pName, Color pFarbe) {
		farbe = pFarbe;
		name = pName;
		
	}
	
	public Spieler(String pName){
		name = pName;
		//TODO zufällige farbe bla
		//another test
		
	}
}
