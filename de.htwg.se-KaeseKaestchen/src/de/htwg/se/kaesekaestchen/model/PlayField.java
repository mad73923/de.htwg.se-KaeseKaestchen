package de.htwg.se.kaesekaestchen.model;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.LineAlreadySetEvent;
import de.htwg.se.kaesekaestchen.event.NotValidLineAllegationEvent;
import de.htwg.se.kaesekaestchen.event.OKEvent;

public class PlayField {
	
	private Square[][] theSquares;
	
	
	public PlayField(int sizeX, int sizeY) {
		theSquares = new Square[sizeX][sizeY];
		createNewField(sizeX, sizeY);
	}


	private void createNewField(int sizeX, int sizeY) {
		//TODO minimum size: 2x2
		for(int x=0; x<sizeX; x++){
			for(int y=0; y<sizeY; y++){
				Line[] lines = new Line[4];
				// handle top line
				if(y == 0){
					lines[0] = null;
				}else{
					lines[0] = theSquares[x][y-1].getLines()[Square.BOTTOMLINEINDEX];
				}
				//handle right line
				if(x == sizeX-1){
					lines[1] = null;
				}else{
					lines[1] = new Line(new Point(x+1,y), new Point(x+1, y+1));
				}
				//handle bottom line
				if(y == sizeY-1){
					lines[2] = null;
				}else{
					lines[2] = new Line(new Point(x, y+1), new Point(x+1, y+1));
				}
				//handle left line
				if(x == 0){
					lines[3] = null;
				}else {
					lines[3] = theSquares[x-1][y].getLines()[Square.RIGHTLINEINDEX];
				}
				theSquares[x][y] = new Square(lines);
			}
		}
		
	}
	
	
	public Event setLineFromToPointWithPlayer(Point start, Point end, Player owner){
		if(!this.isValidLineAllegation(start, end)) {
			return new NotValidLineAllegationEvent();
		}
		if(start.getValX()>end.getValX() || start.getValY()>end.getValY()){
			Point temp = start;
			start = end;
			end = temp;
		}
		boolean lineIshorizontal = false;
		if(start.getValY() == end.getValY()) {
			lineIshorizontal = true;
		}
		return this.setLineInSquares(lineIshorizontal, theSquares[start.getValX()][start.getValY()], owner);
	}
	
	private Event setLineInSquares(boolean lineHorizontal, Square theSquare, Player owner){
		int lineIndex = Square.TOPLINEINDEX;
		if(!lineHorizontal){
			lineIndex = Square.LEFTLINEINDEX;
		}
		if(theSquare.getLines()[lineIndex].setOwner(owner)){
			return new OKEvent();
		}
		return new LineAlreadySetEvent();
	}
	
	public boolean checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(Player currentPlayer){
		boolean newSquareMarked = false;
		for(int x =0; x<theSquares.length; x++){
			for(int y = 0; y<theSquares[x].length; y++){
				if(theSquares[x][y].getOwner() == null && theSquares[x][y].allLinesHaveOwners()){
					theSquares[x][y].setOwner(currentPlayer);
					currentPlayer.incrementPoints();
					newSquareMarked = true;
				}
			}
		}
		return newSquareMarked;
	}
	
	public boolean areThereEmptyLines(){
		for(int x=0; x<theSquares.length; x++){
			for(int y=0; y<theSquares[x].length; y++){
				if(!theSquares[x][y].allLinesHaveOwners()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isValidLineAllegation(Point from, Point to){
		//avoid same points
		if(from.equals(to)){
			return false;
		}
		//avoid negative coodinates
		if(from.hasNegativeCoordinates() || to.hasNegativeCoordinates()){
			return false;
		}
		//avoid lines longer than 1
		//avoid diagonal lines
		if(from.getDistanceToPoint(to)>1){
			return false;
		}
		int sizeX = theSquares.length;
		int sizeY = theSquares[0].length;
		//avoid lines over playfield border
		if(from.getValX()>sizeX || from.getValY()>sizeY) {
			return false;
		}
		if(to.getValX()>sizeX || to.getValY()>sizeY) {
			return false;
		}
		//avoid lines on playfield border
		if(from.getValX()==0 && to.getValX()==0) {
			return false;
		}
		if(from.getValY()==0 && to.getValY()==0) {
			return false;
		}
		if(from.getValX()==sizeX && to.getValX()==sizeX) {
			return false;
		}
		if(from.getValY()==sizeY && to.getValY()==sizeY) {
			return false;
		}
		return true;
	}
	
	public Square[][] getTheSquares(){
		return this.theSquares;
	}

}
