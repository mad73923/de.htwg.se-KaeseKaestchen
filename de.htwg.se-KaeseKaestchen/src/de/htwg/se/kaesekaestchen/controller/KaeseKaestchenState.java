package de.htwg.se.kaesekaestchen.controller;

import de.htwg.se.kaesekaestchen.event.Event;

public abstract class KaeseKaestchenState {
	
	protected KaeseKaestchenControl theControl;
	
	public KaeseKaestchenState(KaeseKaestchenControl pTheControl) {
		theControl = pTheControl;
	}
	
	public abstract void nextState(KaeseKaestchenControl theControl, Event whatHappend);
}
