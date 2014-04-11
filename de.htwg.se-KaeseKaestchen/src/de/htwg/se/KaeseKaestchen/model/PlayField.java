package de.htwg.se.KaeseKaestchen.model;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;

public class PlayField {
	
	KaeseKaestchenControl theControl;
	Square[][] theSquares;
	
	
	public PlayField(KaeseKaestchenControl pTheControl, int sizeX, int sizeY) {
		theControl = pTheControl;
		theSquares = new Square[sizeX][sizeY];
		createNewField(sizeX, sizeY);
	}


	private void createNewField(int sizeX, int sizeY) {
		for(int x=0; x<sizeX; x++){
			for(int y=0; y<sizeY; y++){
				Line[] lines = new Line[4];
				// handle top line
				if(y == 0){
					lines[0] = null;
				}else{
					lines[0] = theSquares[x][y-1].getLines()[2];
				}
				//handle right line
				if(x == sizeX-1){
					lines[1] = null;
				}else{
					lines[1] = new Line();
				}
				//handle bottom line
				if(y == sizeY-1){
					lines[2] = null;
				}else{
					lines[2] = new Line();
				}
				//handle left line
				if(x == 0){
					lines[3] = null;
				}else {
					lines[3] = theSquares[x-1][y].getLines()[1];
				}
				theSquares[x][y] = new Square(lines);
			}
		}
		
	}
	
	public boolean setLineFromToPointWithPlayer(Point start, Point end, Player owner){
		//TODO check if valid line vector
		//TODO implement method!
		return false;
	}
	
	public Square[][] getTheSquares(){
		return this.theSquares;
	}

}
