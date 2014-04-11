package de.htwg.se.KaeseKaestchen.UI;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.KaeseKaestchen.util.IObserver;

public abstract class UI implements IObserver{
	
	KaeseKaestchenControl theControl;
	
	public	UI(KaeseKaestchenControl pTheControl){
		theControl = pTheControl;		
		theControl.addObserver(this);
		
	}
		
	abstract protected void refreshUI();
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		refreshUI();
	}
	


}
