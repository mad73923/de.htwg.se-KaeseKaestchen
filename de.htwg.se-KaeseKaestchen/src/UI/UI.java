package UI;

import controller.KaeseKaestchenControl;
import util.IObserver;

public abstract class UI implements IObserver{
	
	KaeseKaestchenControl theControl;
	
	public	UI(KaeseKaestchenControl pTheControl){
		theControl = pTheControl;
		
		//this.addUIToControlObservable();
		//TODO observer problem
		
	}
	
	//abstract protected void addUIToControlObservable();
	//theControl.addObserver(this);
	
	abstract public void paintPlayingField();
	abstract public void showWelcomeScreen();

}
