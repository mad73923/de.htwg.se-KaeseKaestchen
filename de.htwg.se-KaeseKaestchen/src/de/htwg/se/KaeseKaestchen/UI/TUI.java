package de.htwg.se.KaeseKaestchen.UI;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;

public class TUI extends UI {
	
	public TUI(KaeseKaestchenControl pTheControl){
		super(pTheControl);
	}

	@Override
	protected void refreshUI() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void showWelcomeMessage() {
		//TODO collect new game data
		//System.out.println("Welcome to KaeseKaestchen!\n(c) Matthias Weis & Joey Rieg\nHTWG Konstanz SS 2014");
	}

	

}
