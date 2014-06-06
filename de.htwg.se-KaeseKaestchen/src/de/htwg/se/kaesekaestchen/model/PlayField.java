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


	private void createNewField(int columnsX, int rowsY) {
		//TODO minimum size: 2x2
		for(int column=0; column<columnsX; column++){
			for(int row=0; row<rowsY; row++){
				Line[] lines = new Line[4];
				// handle top line
				if(row == 0){
					lines[0] = null;
				}else{
					lines[0] = theSquares[column][row-1].getLines()[Square.BOTTOMLINEINDEX];
				}
				//handle right line
				if(column == columnsX-1){
					lines[1] = null;
				}else{
					lines[1] = new Line(new Point(column+1,row), new Point(column+1, row+1));
				}
				//handle bottom line
				if(row == rowsY-1){
					lines[2] = null;
				}else{
					lines[2] = new Line(new Point(column, row+1), new Point(column+1, row+1));
				}
				//handle left line
				if(column == 0){
					lines[3] = null;
				}else {
					lines[3] = theSquares[column-1][row].getLines()[Square.RIGHTLINEINDEX];
				}
				theSquares[column][row] = new Square(lines);
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
	
	@Override
	public String toString() {
		int fieldSize = 2;
		Character erg[][] = new Character[fieldSize*theSquares.length+theSquares.length+1][fieldSize*theSquares[0].length+theSquares.length+1];
		for(int x = 0; x<erg.length; x++){
			for(int y=0; y<erg[x].length; y++){
				erg[x][y] = ' ';
			}
		}
		erg[0][0] = '+';
		for(int column=0; column<theSquares.length; column++){
			for(int row=0; row<theSquares[column].length; row++){
				erg[(column+1)*fieldSize+column+1][(row+1)*fieldSize+row+1] = '+';
				erg[(column+1)*fieldSize+column+1][row*fieldSize+row] = '+';
				erg[column*fieldSize+column][(row+1)*fieldSize+row+1] = '+';
				
				Line theLine = theSquares[column][row].getLines()[2];
				if(theLine == null || !theLine.isOwnerNotSet()){
					for(int i = 0; i<fieldSize; i++){
						erg[column*fieldSize+i+1+column][(row*fieldSize)+fieldSize+1+row] = '|';
					}
				}
				
				theLine = theSquares[column][row].getLines()[1];
				if(theLine == null || !theLine.isOwnerNotSet()){
					for(int i=0; i<fieldSize; i++){
							erg[column*fieldSize+fieldSize+1+column][(row*fieldSize+i+1)+row]= '-';
					}
				}
				
				if(column==0){
					for(int i=0; i<fieldSize; i++){
						erg[column*fieldSize+column][(row*fieldSize+i+1)+row]= '-';
					}
				}
				
				if(row==0){
					for(int i=0; i<fieldSize; i++){
						erg[column*fieldSize+i+1+column][(row*fieldSize)+row] = '|';
					}
				}
				
			}
		}
		String resultString = "";
		for(int x=0; x<erg.length; x++){
			for(int y=0; y<erg.length; y++){
				resultString+=erg[x][y];
			}
			resultString+="\n";
		}
		return resultString;
	}

}
