package de.htwg.se.kaesekaestchen.model;


public class Square implements ISquare {
	
	private IPlayer owner;
	private ILine[] theLines;
	
	public Square(ILine[] linesAtTopRightBottomLeft) {
		//TODO abfangen wenn linesAtTopRightBottomLeft.length != 4!!
		theLines = new ILine[linesAtTopRightBottomLeft.length];
		System.arraycopy(linesAtTopRightBottomLeft, 0, theLines, 0, linesAtTopRightBottomLeft.length);
		
		owner = null;
		
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ISquare#allLinesHaveOwners()
	 */
	@Override
	public boolean allLinesHaveOwners(){
		for(int i =0; i<theLines.length; i++) {
			if(theLines[i]!=null && theLines[i].getOwner() == null) {
				return false;
			}
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ISquare#setOwner(de.htwg.se.kaesekaestchen.model.IPlayer)
	 */
	@Override
	public boolean setOwner(IPlayer newOwner){
		if(owner == null){
			owner = newOwner;
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ISquare#getOwner()
	 */
	@Override
	public IPlayer getOwner(){
		return owner;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.model.ISquare#getLines()
	 */
	@Override
	public ILine[] getLines(){
		return theLines;
	}

}
