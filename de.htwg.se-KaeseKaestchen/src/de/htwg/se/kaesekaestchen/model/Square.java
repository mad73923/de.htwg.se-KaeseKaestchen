package de.htwg.se.kaesekaestchen.model;


public class Square {
	
	private Player owner;
	private Line[] theLines;
	
	public static final int TOPLINEINDEX = 0;
	public static final int RIGHTLINEINDEX = 1;
	public static final int BOTTOMLINEINDEX = 2;
	public static final int LEFTLINEINDEX = 3;
	
	public Square(Line[] linesAtTopRightBottomLeft) {
		//TODO abfangen wenn linesAtTopRightBottomLeft.length != 4!!
		theLines = new Line[linesAtTopRightBottomLeft.length];
		System.arraycopy(linesAtTopRightBottomLeft, 0, theLines, 0, linesAtTopRightBottomLeft.length);
		
		owner = null;
		
	}
	
	public boolean allLinesHaveOwners(){
		for(int i =0; i<theLines.length; i++) {
			if(theLines[i]!=null && theLines[i].getOwner() == null) {
				return false;
			}
		}
		return true;
	}
	
	public boolean setOwner(Player newOwner){
		if(owner == null){
			owner = newOwner;
			return true;
		}
		return false;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public Line[] getLines(){
		return theLines;
	}

}
