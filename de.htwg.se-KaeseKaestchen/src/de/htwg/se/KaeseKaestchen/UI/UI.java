package de.htwg.se.KaeseKaestchen.UI;

import de.htwg.se.KaeseKaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.KaeseKaestchen.event.Event;
import de.htwg.se.KaeseKaestchen.event.MessageUIEvent;
import de.htwg.se.KaeseKaestchen.event.UpdateUIEvent;
import de.htwg.se.KaeseKaestchen.event.WarningUIEvent;
import de.htwg.se.KaeseKaestchen.event.WelcomeUIEvent;
import de.htwg.se.KaeseKaestchen.util.IObserver;

public abstract class UI implements IObserver{
	
	KaeseKaestchenControl theControl;
	
	
	public	UI(KaeseKaestchenControl pTheControl){	
		pTheControl.addObserver(this);
		theControl = pTheControl;
	}
		
	abstract protected void refreshUI();
	abstract protected void showWelcomeMessage();
	abstract protected void showMessage();
	abstract protected void showWarning();
	
	@Override
	public void update(Event whatHappend) {
		// TODO Auto-generated method stub
		if(whatHappend.getClass().equals(UpdateUIEvent.class)){
			refreshUI();
		}else if(whatHappend.getClass().equals(WelcomeUIEvent.class)){
			showWelcomeMessage();
		}else if(whatHappend.getClass().equals(MessageUIEvent.class)){
			showMessage();
		}else if(whatHappend.getClass().equals(WarningUIEvent.class)){
			showWarning();
		}else{
			System.out.println("Event not Supported: "+whatHappend.getClass().toString());
		}
	}
	


}
