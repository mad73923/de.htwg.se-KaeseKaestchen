package de.htwg.se.kaesekaestchen.controller;

import java.awt.Color;

import org.junit.*;

import de.htwg.se.kaesekaestchen.event.OKEvent;
import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;

public class KaeseKaestchenStateNoValidInputTest {
	
	KaeseKaestchenStateNoValidInput object;
	
	
	@Before
	public void setup() throws Exception {
		KaeseKaestchenControl control = new KaeseKaestchenControl();
		control.startNewGame(new String[] {"Peter", "Paul"}, new Color[] {Color.black,  Color.blue}, 5,5);
		object = new KaeseKaestchenStateNoValidInput(control);
	}
	
	@Test
	public void testNextState(){
		object.nextState(new OKEvent());
	}

}
