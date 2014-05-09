package de.htwg.se.kaesekaestchen.model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.kaesekaestchen.model.Line;
import de.htwg.se.kaesekaestchen.model.Player;
import de.htwg.se.kaesekaestchen.model.Point;

public class LineTest {
	
	Line theLine;

	@Before
	public void setUp() throws Exception {
		theLine = new Line(new Point(1,1), new Point(2,2));
	}

	@Test
	public void testIsOwnerNotSet() {
		assertEquals(true, theLine.isOwnerNotSet());
		theLine.setOwner(new Player("Peter", Color.black));
		assertEquals(false, theLine.isOwnerNotSet());
	}

	@Test
	public void testSetOwner() {
		assertEquals(true, theLine.setOwner(new Player("Peter", Color.black)));
		assertEquals(false, theLine.setOwner(new Player("Peter", Color.black)));
	}

	@Test
	public void testGetOwner() {
		theLine.setOwner(new Player("Peter", Color.black));
		assertNotNull(theLine.getOwner());
	}
	
	@Test
	public void testGetLength(){
		assertTrue(Math.sqrt(2)==new Line(new Point(0, 0), new Point(1, 1)).getLength());
	}

}
