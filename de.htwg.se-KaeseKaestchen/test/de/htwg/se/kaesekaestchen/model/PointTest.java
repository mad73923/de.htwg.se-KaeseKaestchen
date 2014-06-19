package de.htwg.se.kaesekaestchen.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.kaesekaestchen.model.Point;

public class PointTest {
	
	IPoint thePoint;

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
	
	@Test
	public void testIsUnderPoint(){
		assertTrue(thePoint.isUnderPoint(new Point(99,201)));
		assertFalse(thePoint.isUnderPoint(new Point(99,199)));
	}
	
	@Test
	public void testIsOverPoint(){
		assertFalse(thePoint.isOverPoint(new Point(99,201)));
		assertTrue(thePoint.isOverPoint(new Point(99,199)));
	}
	
	@Test
	public void testIsLeftOfPoint(){
		assertTrue(thePoint.isLeftOfPoint(new Point(101,201)));
		assertFalse(thePoint.isLeftOfPoint(new Point(99,199)));
	}
	
	@Test
	public void testIsRightOfPoint(){
		assertFalse(thePoint.isRightOfPoint(new Point(101,201)));
		assertTrue(thePoint.isRightOfPoint(new Point(99,199)));
	}
	
	@Test
	public void testHasSameXValueAs(){
		assertTrue(thePoint.hasSameXValueAs(new Point(100,201)));
		assertFalse(thePoint.hasSameXValueAs(new Point(101,201)));
	}
	
	@Test
	public void testHasSameYValueAs(){
		assertTrue(thePoint.hasSameYValueAs(new Point(100,200)));
		assertFalse(thePoint.hasSameYValueAs(new Point(101,201)));
	}
	
	@Test
	public void testEquals(){
		assertFalse(thePoint.equals(null));
	}
	
	@Test
	public void testHashCode(){
		assertEquals(300, thePoint.hashCode());
	}

}
