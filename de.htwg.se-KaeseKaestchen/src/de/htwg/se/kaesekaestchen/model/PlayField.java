package de.htwg.se.kaesekaestchen.model;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.LineAlreadySetEvent;
import de.htwg.se.kaesekaestchen.event.NotValidLineAllegationEvent;
import de.htwg.se.kaesekaestchen.event.OKEvent;

public class PlayField implements IPlayField {
	
	private ISquare[][] theSquares;
	
	
	public PlayField(int sizeX, int sizeY) {
		theSquares = new ISquare[sizeX][sizeY];
		createNewField(sizeX, sizeY);
	}


	private void createNewField(int sizeX, int sizeY) {
		//TODO minimum size: 2x2
		for(int x=0; x<sizeX; x++){
			for(int y=0; y<sizeY; y++){
				ILine[] lines = new ILine[ISquare.NUMBEROFLINES];
				// handle top line
				if(y == 0){
					lines[ISquare.TOPLINEINDEX] = null;
				}else{
					lines[ISquare.TOPLINEINDEX] = theSquares[x][y-1].getLines()[ISquare.BOTTOMLINEINDEX];
				}
				//handle right line
				if(x == sizeX-1){
					lines[ISquare.RIGHTLINEINDEX] = null;
				}else{
					lines[ISquare.RIGHTLINEINDEX] = new Line(new Point(x+1,y), new Point(x+1, y+1));
				}
				//handle bottom line
				if(y == sizeY-1){
					lines[ISquare.BOTTOMLINEINDEX] = null;
				}else{
					lines[ISquare.BOTTOMLINEINDEX] = new Line(new Point(x, y+1), new Point(x+1, y+1));
				}
				//handle left line
				if(x == 0){
					lines[ISquare.LEFTLINEINDEX] = null;
				}else {
					lines[ISquare.LEFTLINEINDEX] = theSquares[x-1][y].getLines()[ISquare.RIGHTLINEINDEX];
				}
				theSquares[x][y] = new Square(lines);
			}
		}
		
	}
	
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayField#setLineFromToPointWithPlayer(de.htwg.se.kaesekaestchen.model.Point, de.htwg.se.kaesekaestchen.model.Point, de.htwg.se.kaesekaestchen.model.IPlayer)
	 */
	@Override
	public Event setLineFromToPointWithPlayer(IPoint start, Point end, IPlayer owner){
		if(!this.isValidLineAllegation(start, end)) {
			return new NotValidLineAllegationEvent();
		}
		IPoint pStart = start;
		IPoint pEnd = end;
		if(start.getValX()>end.getValX() || start.getValY()>end.getValY()){
			IPoint temp = pStart;
			pStart = pEnd;
			pEnd = temp;
		}
		boolean lineIshorizontal = false;
		if(pStart.getValY() == pEnd.getValY()) {
			lineIshorizontal = true;
		}
		return this.setLineInSquares(lineIshorizontal, theSquares[pStart.getValX()][pStart.getValY()], owner);
	}
	
	private Event setLineInSquares(boolean lineHorizontal, ISquare theSquare, IPlayer owner){
		int lineIndex = ISquare.TOPLINEINDEX;
		if(!lineHorizontal){
			lineIndex = ISquare.LEFTLINEINDEX;
		}
		if(theSquare.getLines()[lineIndex].setOwner(owner)){
			return new OKEvent();
		}
		return new LineAlreadySetEvent();
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayField#checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(de.htwg.se.kaesekaestchen.model.IPlayer)
	 */
	@Override
	public boolean checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(IPlayer currentPlayer){
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
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayField#areThereEmptyLines()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayField#isValidLineAllegation(de.htwg.se.kaesekaestchen.model.Point, de.htwg.se.kaesekaestchen.model.Point)
	 */
	@Override
	public boolean isValidLineAllegation(IPoint from, Point to){
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
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayField#getTheSquares()
	 */
	@Override
	public ISquare[][] getTheSquares(){
		return this.theSquares;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.IPlayField#toString()
	 */
	@Override
	public String toString() {
		int fieldSize = 2;
		String erg[][] = new String[fieldSize*theSquares.length+theSquares.length+1][fieldSize*theSquares[0].length+theSquares.length+1];
		for(int x = 0; x<erg.length; x++){
			for(int y=0; y<erg[x].length; y++){
				erg[x][y] = " ";
			}
		}
		erg[0][0] = "+";
		for(int x=0; x<theSquares.length; x++){
			for(int y=0; y<theSquares[x].length; y++){
				erg[(x+1)*fieldSize+x+1][(y+1)*fieldSize+y+1] = "+";
				erg[(x+1)*fieldSize+x+1][y*fieldSize+y] = "+";
				erg[x*fieldSize+x][(y+1)*fieldSize+y+1] = "+";
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
