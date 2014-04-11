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
    	theControl.startNewGame(new String[] {"Peter", "Paul"}, new Color[] {Color.black,  Color.blue}, 5,5);
    	assertNotNull(theControl.getPlayField());
    }

}
