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
	}

	@Test
	public void testGetColor() {
		Color.black.equals(thePlayer.getColor());
	}

}
