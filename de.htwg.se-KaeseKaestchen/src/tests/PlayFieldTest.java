package tests;

import static org.junit.Assert.*;
import model.PlayField;

import org.junit.Before;
import org.junit.Test;

import controller.KaeseKaestchenControl;

public class PlayFieldTest {
    
    PlayField thePlayField;
    KaeseKaestchenControl theControl;

    @Before
    public void SetUp() throws Exception {
        thePlayField = new PlayField(theControl, 5, 5);
    }

}
