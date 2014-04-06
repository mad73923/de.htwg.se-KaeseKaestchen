package tests;

import static org.junit.Assert.*;
import kaeseKaestchen.KaeseKaestchen;
import kaeseKaestchen.PlayField;

import org.junit.Before;
import org.junit.Test;

public class PlayFieldTest {
    
    PlayField thePlayField;
    KaeseKaestchen theControl;

    @Before
    public void SetUp() throws Exception {
        thePlayField = new PlayField(theControl, 5, 5);
    }

}
