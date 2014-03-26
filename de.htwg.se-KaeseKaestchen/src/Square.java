
public class Square {
	
	Player owner;
	Square[] neighbors;
	
	public Square(Square neighborTop, Square neighborBottom, Square neighborLeft, Square neighborRight) {
		neighbors = new Square[4];
		neighbors[0] = neighborTop;
		neighbors[1] = neighborBottom;
		neighbors[2] = neighborLeft;
		neighbors[3] = neighborRight;
		
	}

}
