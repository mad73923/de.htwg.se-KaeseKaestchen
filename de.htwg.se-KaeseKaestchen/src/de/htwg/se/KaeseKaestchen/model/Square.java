package de.htwg.se.KaeseKaestchen.model;


public class Square {
	
	Player owner;
	Line[] theLines;
	
	public Square(Line[] linesAtTopRightBottomLeft) {
		//TODO abfangen wenn linesAtTopRightBottomLeft.length != 4!!
		theLines = new Line[linesAtTopRightBottomLeft.length];
		for(int i=0; i<linesAtTopRightBottomLeft.length; i++){
			theLines[i]= linesAtTopRightBottomLeft[i];
		}
		
		owner = null;
		
	}
	
	public boolean allLinesHaveOwners(){
		for(int i =0; i<theLines.length; i++){
			if(theLines[i]!=null){
				if(theLines[i].getOwner() == null)
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
