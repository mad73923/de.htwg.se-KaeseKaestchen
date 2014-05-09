package de.htwg.se.KaeseKaestchen.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.kaesekaestchen.model.Point;

public class PointTest {
	
	Point thePoint;

	@Before
	public void setUp() throws Exception {
		thePoint = new Point(100, 200);
	}

	@Test
	public void testGetValX() {
		assertEquals(100, thePoint.getValX());
	}

	@Test
	public void testSetValX() {
		assertEquals(100, thePoint.getValX());
		thePoint.setValX(55);
		assertEquals(55, thePoint.getValX());
	}

	@Test
	public void testGetValY() {
		assertEquals(200, thePoint.getValY());
	}

	@Test
	public void testSetValY() {
		assertEquals(200, thePoint.getValY());
		thePoint.setValY(255);
		assertEquals(255, thePoint.getValY());
	}

}
