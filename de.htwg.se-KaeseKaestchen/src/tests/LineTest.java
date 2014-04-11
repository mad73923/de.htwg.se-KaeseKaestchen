package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Line;
import model.Player;

import org.junit.Before;
import org.junit.Test;

public class LineTest {
	
	Line theLine;

	@Before
	public void setUp() throws Exception {
		theLine = new Line();
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

}
