package de.htwg.se.kaesekaestchen.model;

import static org.junit.Assert.*;

import java.awt.Color;





import org.junit.Before;
import org.junit.Test;

import de.htwg.se.kaesekaestchen.event.LineAlreadySetEvent;
import de.htwg.se.kaesekaestchen.event.NotValidLineAllegationEvent;
import de.htwg.se.kaesekaestchen.event.OKEvent;
import de.htwg.se.kaesekaestchen.model.PlayField;
import de.htwg.se.kaesekaestchen.model.Player;
import de.htwg.se.kaesekaestchen.model.Point;

public class PlayFieldTest {
    
    IPlayField thePlayField;
    
    private static int SIZEX = 5;
    private static int SIZEY = 5;

    @Before
    public void SetUp() throws Exception {
        thePlayField = new PlayField(SIZEX, SIZEY);
    }
    
    @Test
    public void testCreateNewField(){
    	ILine[] theLines;
    	for(int x = 0; x<SIZEX; x++){
    		for(int y = 0; y<SIZEY; y++){
    			theLines = thePlayField.getTheSquares()[x][y].getLines();
    			//test top line
    			if(y == 0){
    				assertNull(theLines[0]);
    			}else{
    				assertSame(thePlayField.getTheSquares()[x][y-1].getLines()[2], theLines[0]);
    			}
    			//test right line
    			if(x == SIZEX-1){
    				assertNull(theLines[1]);
    			}else{
    				assertSame(thePlayField.getTheSquares()[x+1][y].getLines()[3], theLines[1]);
    			}
    			//test bottom line
    			if(y == SIZEY-1){
    				assertNull(theLines[2]);
    			}else{
    				assertSame(thePlayField.getTheSquares()[x][y+1].getLines()[0], theLines[2]);
    			}
    			//test left line
    			if(x == 0){
    				assertNull(theLines[3]);
    			}else{
    				assertSame(thePlayField.getTheSquares()[x-1][y].getLines()[1], theLines[3]);
    			}
    		}
    	}
    }
    
    @Test
    public void testIsValidLineAllegation(){
    	//same points
    	assertFalse(thePlayField.isValidLineAllegation(new Point(3,3), new Point(3,3)));
    	//negative coordinates
    	assertFalse(thePlayField.isValidLineAllegation(new Point(-1,0), new Point(0,-10)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(0,0), new Point(0,-10)));
    	//lines longer than 1
    	assertFalse(thePlayField.isValidLineAllegation(new Point(3,5), new Point(5, 5)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(1,1), new Point(1, 3)));
    	//diagonal lines
    	assertFalse(thePlayField.isValidLineAllegation(new Point(5, 5), new Point(6, 6)));
    	//lines longer than playfield
    	assertFalse(thePlayField.isValidLineAllegation(new Point(5, 5), new Point(5, 6)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(5, 5), new Point(6, 5)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(5, 6), new Point(5, 5)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(6, 5), new Point(5, 5)));
    	//line on playfield border
    	assertFalse(thePlayField.isValidLineAllegation(new Point(0, 1), new Point(0, 2)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(1, 0), new Point(2, 0)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(5, 5), new Point(5, 4)));
    	assertFalse(thePlayField.isValidLineAllegation(new Point(5, 5), new Point(4, 5)));
    	//correct line
    	assertTrue(thePlayField.isValidLineAllegation(new Point(3, 3), new Point(3, 4)));
    }
    
    @Test
    public void testSetLineFromToPointWithPlayer(){
    	//invalid Points
    	assertEquals(new NotValidLineAllegationEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(-1, 0), new Point(0, 0), new Player("Tester", Color.black)));
    	//swap start end end point
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(2, 1), new Point(1, 1), new Player("Tester", Color.black)));
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(1, 2), new Point(1, 1), new Player("Tester", Color.black)));
    	//correct line
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(1,4), new Point(2,4), new Player("Tester", Color.black)));
    	//line already set
    	assertEquals(new LineAlreadySetEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(1,4), new Point(2,4), new Player("Tester", Color.black)));
    }
    
    @Test
    public void testAreThereEmptyLines(){
    	assertTrue(thePlayField.areThereEmptyLines());
    	thePlayField = new PlayField(2, 2);
    	IPlayer peter = new Player("Tester", Color.black);
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(1, 0), new Point(1, 1), peter));
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(0, 1), new Point(1, 1), peter));
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(1, 2), new Point(1, 1), peter));
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(2, 1), new Point(1, 1), peter));
    	assertFalse(thePlayField.areThereEmptyLines());
    	
    }
    
    @Test
    public void testCheckForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(){
    	IPlayer peter = new Player("Tester", Color.black);
    	assertSame(0, peter.getPoints());
    	assertFalse(thePlayField.checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(peter));
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(1, 0), new Point(1, 1), peter));
    	assertEquals(new OKEvent(), thePlayField.setLineFromToPointWithPlayer(new Point(0, 1), new Point(1, 1), peter));
    	assertTrue(thePlayField.checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(peter));
    	assertSame(peter, thePlayField.getTheSquares()[0][0].getOwner());
    	assertSame(1, peter.getPoints());
    }
    
    @Test
    public void testToString(){
    	System.out.print(thePlayField.toString());
    }

}
