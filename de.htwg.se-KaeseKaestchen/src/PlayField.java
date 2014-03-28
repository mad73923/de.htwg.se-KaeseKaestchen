
public class PlayField {
	
	KaeseKaestchen theControl;
	Square matrix[][];
	
	public PlayField(KaeseKaestchen pTheControl, int sizeX, int sizeY) {
		theControl = pTheControl;
		matrix = new Square[sizeX][sizeY];
	}

}
