package de.htwg.se.kaesekaestchen.ui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.MessageUIEvent;
import de.htwg.se.kaesekaestchen.event.UpdateUIEvent;
import de.htwg.se.kaesekaestchen.event.WarningUIEvent;
import de.htwg.se.kaesekaestchen.event.WelcomeUIEvent;
import de.htwg.se.kaesekaestchen.util.IObserver;

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
