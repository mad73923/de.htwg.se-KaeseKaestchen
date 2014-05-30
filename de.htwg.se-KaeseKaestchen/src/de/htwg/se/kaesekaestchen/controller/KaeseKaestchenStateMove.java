package de.htwg.se.kaesekaestchen.controller;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.LineAlreadySetEvent;
import de.htwg.se.kaesekaestchen.event.NotValidLineAllegationEvent;
import de.htwg.se.kaesekaestchen.event.OKEvent;

public class KaeseKaestchenStateMove extends KaeseKaestchenState {

	public KaeseKaestchenStateMove(KaeseKaestchenControl pTheControl) {
		super(pTheControl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void nextState(Event whatHappend) {
		if(whatHappend.getClass().equals(OKEvent.class)){
			theControl.setCurrentState(new KaeseKaestchenStateLegalMove(theControl));
		}else if(whatHappend.getClass().equals(LineAlreadySetEvent.class)){
			theControl.setCurrentState(new KaeseKaestchenStateLineAlreadySet(theControl));
		}else if(whatHappend.getClass().equals(NotValidLineAllegationEvent.class)){
			theControl.setCurrentState(new KaeseKaestchenStateNoValidInput(theControl));
		}

	}

}
