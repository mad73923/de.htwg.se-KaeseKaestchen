package de.htwg.se.KaeseKaestchen.tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.KaeseKaestchen.model.Line;
import de.htwg.se.KaeseKaestchen.model.Player;
import de.htwg.se.KaeseKaestchen.model.Square;

public class SquareTest {
    
    Square theSquare;
    Line[] theLines;

    @Before
    public void SetUp() throws Exception {
    	theLines = new Line[] {new Line(), new Line(), new Line(), new Line()};
        theSquare = new Square(theLines);
    }
    
    @Test
    public void testAllLinesHaveOwners(){    	
    	assertEquals(false, theSquare.allLinesHaveOwners());
    	for(int i=0; i< theLines.length; i++){
    		assertEquals(false, theSquare.allLinesHaveOwners());
    		theSquare.getLines()[i].setOwner(new Player("Peter", Color.black));
    	}
    	assertEquals(true, theSquare.allLinesHaveOwners());
    }
    
    @Test
    public void testSetOwner(){
    	assertEquals(true, theSquare.setOwner(new Player("Peter", Color.black)));
    	assertEquals(false, theSquare.setOwner(new Player("Peter", Color.black)));
    }
    
    @Test
    public void testGetOwner(){
    	assertNull(theSquare.getOwner());
    	theSquare.setOwner(new Player("Peter", Color.black));
    	assertNotNull(theSquare.getOwner());
    }

}
