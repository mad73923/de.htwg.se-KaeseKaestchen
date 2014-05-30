package de.htwg.se.kaesekaestchen.controller;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.WarningUIEvent;

public class KaeseKaestchenStateNoValidInput extends KaeseKaestchenState {

	public KaeseKaestchenStateNoValidInput(KaeseKaestchenControl pTheControl) {
		super(pTheControl);
		theControl.setWarningMessage("Keine gueltige Linie eingegeben.");
		theControl.notifyObservers(new WarningUIEvent());
	}

	@Override
	public void nextState(Event whatHappend) {
		// TODO Auto-generated method stub

	}

}
