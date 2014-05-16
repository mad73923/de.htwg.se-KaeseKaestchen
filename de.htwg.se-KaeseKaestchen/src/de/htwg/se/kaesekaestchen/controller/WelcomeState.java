package de.htwg.se.kaesekaestchen.controller;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.OKEvent;
import de.htwg.se.kaesekaestchen.event.WelcomeUIEvent;

public class WelcomeState extends KaeseKaestchenState {
	

	public WelcomeState(KaeseKaestchenControl pTheControl) {
		super(pTheControl);
		theControl.setStatusMessage("Welcome to KaeseKaestchen!\n(c) Matthias Weis & Joey Rieg\nHTWG Konstanz SS 2014");
		theControl.notifyObservers(new WelcomeUIEvent());
		this.nextState(theControl, new OKEvent());
	}

	@Override
	public void nextState(KaeseKaestchenControl theControl, Event whatHappend) {
		theControl.setCurrentState(new NewGameState(theControl));

	}

}
