package model;


public class Square {
	
	Player owner;
	Square[] neighbors;
	Line[] theLines;
	
	public Square(boolean linesAtTopRightBottomLeft[]) {
		//TODO abfangen wenn linesAtTopRightBottomLeft.length > 4!!
		theLines = new Line[linesAtTopRightBottomLeft.length];
		for(int i=0; i<linesAtTopRightBottomLeft.length; i++){
			if(linesAtTopRightBottomLeft[i])
				theLines[i]= new Line();
		}
		
	}

}
