package de.htwg.se.kaesekaestchen.controller;

import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.MessageUIEvent;
import de.htwg.se.kaesekaestchen.event.UpdateUIEvent;

public class KaeseKaestchenStateLegalMove extends KaeseKaestchenState {

	public KaeseKaestchenStateLegalMove(KaeseKaestchenControl pTheControl) {
		super(pTheControl);
		if(theControl.checkPlayfieldForCompleteSquares()){
			theControl.notifyObservers(new UpdateUIEvent());
		}else{
			theControl.pickNextPlayerAsCurrentPlayer();
			theControl.setStatusMessage(theControl.getCurrentPlayerName()+" ist an der Reihe.");
			theControl.notifyObservers(new MessageUIEvent());
			theControl.notifyObservers(new UpdateUIEvent());
		}
	}

	@Override
	public void nextState(Event whatHappend) {
		// TODO Auto-generated method stub

	}

}
