package tests;

import static org.junit.Assert.*;
import model.Square;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {
    
    Square theSquare;

    @Before
    public void SetUp() throws Exception {
        theSquare = new Square();
    }

}
