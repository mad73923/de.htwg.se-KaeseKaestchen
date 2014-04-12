package de.htwg.se.KaeseKaestchen.tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.KaeseKaestchen.model.Line;
import de.htwg.se.KaeseKaestchen.model.PlayField;
import de.htwg.se.KaeseKaestchen.model.Point;

public class PlayFieldTest {
    
    PlayField thePlayField;
    KaeseKaestchenControl theControl;
    
    private static int SIZEX;
    private static int SIZEY;

    @Before
    public void SetUp() throws Exception {
    	SIZEX = 5;
    	SIZEY = 5;
    	theControl = new KaeseKaestchenControl();
        thePlayField = new PlayField(theControl, SIZEX, SIZEY);
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
    	//negative coordinates
    	assertFalse(PlayField.isValidLineAllegation(new Point(-1,0), new Point(0,-10)));
    	assertFalse(PlayField.isValidLineAllegation(new Point(0,0), new Point(0,-10)));
    	//lines longer than 1
    	assertFalse(PlayField.isValidLineAllegation(new Point(5,7), new Point(7, 7)));
    	assertFalse(PlayField.isValidLineAllegation(new Point(5,7), new Point(5, 10)));
    	//diagonal lines
    	assertFalse(PlayField.isValidLineAllegation(new Point(5, 5), new Point(6, 6)));
    	//correct line
    	assertTrue(PlayField.isValidLineAllegation(new Point(5, 5), new Point(4, 5)));
    }

}
