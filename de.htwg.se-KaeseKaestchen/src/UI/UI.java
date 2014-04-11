package UI;

import controller.KaeseKaestchenControl;
import util.IObserver;

public abstract class UI implements IObserver{
	
	KaeseKaestchenControl theControl;
	
	public	UI(KaeseKaestchenControl pTheControl){
		theControl = pTheControl;
		
		theControl.addObserver(this);
		//TODO observer problem
		
	}
	
	//abstract protected void addUIToControlObservable();
	
	
	abstract public void paintPlayingField();
	abstract public void showWelcomeScreen();

}
