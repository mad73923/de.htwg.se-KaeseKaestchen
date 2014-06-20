package de.htwg.se.kaesekaestchen.ui.gui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.ui.UI;

public class GUI extends UI {

	public GUI(KaeseKaestchenControl pTheControl) {
		super(pTheControl);
		KaeseKaestchenFrame gui = new KaeseKaestchenFrame(theControl);
	}

	@Override
	protected void refreshUI() {
		
		
	}

	@Override
	protected void showWelcomeMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showWarning() {
		// TODO Auto-generated method stub
		
	}

}
