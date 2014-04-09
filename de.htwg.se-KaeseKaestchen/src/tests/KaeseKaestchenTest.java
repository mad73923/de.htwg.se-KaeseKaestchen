package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.KaeseKaestchenControl;

public class KaeseKaestchenTest {
    
    KaeseKaestchenControl theCheese;

    @Before
    public void setUp() throws Exception {
        theCheese =  new KaeseKaestchenControl();
    }

}
