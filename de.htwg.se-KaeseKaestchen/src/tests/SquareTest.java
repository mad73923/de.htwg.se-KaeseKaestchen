package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Line;
import model.Player;
import model.Square;

import org.junit.Before;
import org.junit.Test;

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
