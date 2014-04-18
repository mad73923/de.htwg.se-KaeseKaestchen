package de.htwg.se.KaeseKaestchen.tests;

import static org.junit.Assert.*;

import java.awt.Color;


import org.junit.Before;
import org.junit.Test;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.KaeseKaestchen.model.Line;
import de.htwg.se.KaeseKaestchen.model.PlayField;
import de.htwg.se.KaeseKaestchen.model.Player;
import de.htwg.se.KaeseKaestchen.model.Point;

public class PlayFieldTest {
    
    PlayField thePlayField;
    
    private static int SIZEX;
    private static int SIZEY;

    @Before
    public void SetUp() throws Exception {
    	SIZEX = 5;
    	SIZEY = 5;
        thePlayField = new PlayField(SIZEX, SIZEY);
    }
    
    @Test
    public void testCreateNewField(){
    	Line[] theLines;
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
    	assertFalse(thePlayField.setLineFromToPointWithPlayer(new Point(-1, 0), new Point(0, 0), new Player("Tester", Color.black)));
    	//swap start end end point
    	assertTrue(thePlayField.setLineFromToPointWithPlayer(new Point(2, 1), new Point(1, 1), new Player("Tester", Color.black)));
    	assertTrue(thePlayField.setLineFromToPointWithPlayer(new Point(1, 2), new Point(1, 1), new Player("Tester", Color.black)));
    	//correct line
    	assertTrue(thePlayField.setLineFromToPointWithPlayer(new Point(1,4), new Point(2,4), new Player("Tester", Color.black)));
    	//line already set
    	assertFalse(thePlayField.setLineFromToPointWithPlayer(new Point(1,4), new Point(2,4), new Player("Tester", Color.black)));
    }

}
