package de.htwg.se.KaeseKaestchen.tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;

public class KaeseKaestchenControlTest {
    
    KaeseKaestchenControl theControl;

    @Before
    public void setUp() throws Exception {
        theControl =  new KaeseKaestchenControl();
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

}
