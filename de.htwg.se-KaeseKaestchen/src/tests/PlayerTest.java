package tests;


import static org.junit.Assert.*;

import java.awt.Color;

import kaeseKaestchen.Player;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player thePlayer;

	@Before
	public void setUp() throws Exception {
		thePlayer = new Player("Dieter", Color.black);
		thePlayer.incrementPoints();
		thePlayer.incrementPoints();
	}

	@Test
	public void testGetColor() {
		assertSame(Color.black,thePlayer.getColor());
	}
	
	@Test
	public void testGetName(){
		assertSame("Dieter", thePlayer.getName());
	}
	
	@Test
	public void testGetPoints(){
		assertSame(2, thePlayer.getPoints());
	}
	
	@Test
	public void testIncrementPoints(){
		assertSame(2, thePlayer.getPoints());
		thePlayer.incrementPoints();
		thePlayer.incrementPoints();
		assertSame(4, thePlayer.getPoints());
	}

}
