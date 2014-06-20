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
			theControl.setStatusMessage("\n" + theControl.getCurrentPlayerName()+", it's your turn.");
			theControl.notifyObservers(new UpdateUIEvent());
			theControl.notifyObservers(new MessageUIEvent());                                              
		}
	}

	@Override
	public void nextState(Event whatHappend) {
		// TODO Auto-generated method stub

	}

}
