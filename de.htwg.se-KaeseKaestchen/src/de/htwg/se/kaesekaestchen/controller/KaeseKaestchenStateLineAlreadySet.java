package de.htwg.se.kaesekaestchen.controller;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.WarningUIEvent;

public class KaeseKaestchenStateLineAlreadySet extends KaeseKaestchenState {

	public KaeseKaestchenStateLineAlreadySet(KaeseKaestchenControl pTheControl) {
		super(pTheControl);
		theControl.setWarningMessage("Diese Linie wurde bereits gezeichnet!");
		theControl.notifyObservers(new WarningUIEvent());
	}

	@Override
	public void nextState(Event whatHappend) {
		// TODO Auto-generated method stub

	}

}
