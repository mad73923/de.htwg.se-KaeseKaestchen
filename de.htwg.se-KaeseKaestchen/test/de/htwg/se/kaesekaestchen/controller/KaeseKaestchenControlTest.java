package de.htwg.se.kaesekaestchen.controller;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.model.Player;
import de.htwg.se.kaesekaestchen.ui.TUI;

public class KaeseKaestchenControlTest {
    
    KaeseKaestchenControl theControl;

    @Before
    public void setUp() throws Exception {
        theControl =  new KaeseKaestchenControl();
        new TUI(theControl);
    }
    
    @Test
    public void testStartNewGame(){
    	assertNull(theControl.getPlayField());
    	assertNull(theControl.getCurrentPlayer());
    	theControl.startNewGame(new String[] {"Peter", "Paul"}, new Color[] {Color.black,  Color.blue}, 5,5);
    	assertNotNull(theControl.getPlayField());
    	assertNotNull(theControl.getCurrentPlayer());
    }
    
    @Test
    public void testRandomNumberInLowAndHigh(){
    	assertTrue(KaeseKaestchenControl.randomNumberInLowAndHigh(-100, 100)<101);
    	assertTrue(KaeseKaestchenControl.randomNumberInLowAndHigh(-100, 100)>-101);
    	int test = KaeseKaestchenControl.randomNumberInLowAndHigh(-1, 1);
    	assertTrue(test<2 && test>-2);
    	test = KaeseKaestchenControl.randomNumberInLowAndHigh(0, 0);
    	assertTrue(test == 0);
    }
    
    @Test
    public void testNewMove(){
    	theControl.startNewGame(new String[] {"Peter", "Paul"}, new Color[] {Color.black,  Color.blue}, 2,2);
    	theControl.getCurrentPlayer();
    	theControl.newMove(1, 0, 1, 1);
    	assertEquals("\n" + theControl.getCurrentPlayer().getName()+", it's your turn.", theControl.getStatusMessage());
    	theControl.newMove(0, 1, 1, 1);
    	theControl.newMove(0, 1, 1, 1);
    	assertEquals("This line is already set!", theControl.getWarningMessage());
    	theControl.newMove(0, 0, 1, 1);
    	assertEquals("No valid line given!", theControl.getWarningMessage());
    }
    
    @Test
    public void testGetPlayerpoints() {
    	theControl.startNewGame(new String[] {"Peter", "Paul"}, new Color[] {Color.black,  Color.blue}, 2,2);
    	int[] playerPointsTest = {0, 0};
    	assertArrayEquals(playerPointsTest, theControl.getPlayerPoints());
    }

}
