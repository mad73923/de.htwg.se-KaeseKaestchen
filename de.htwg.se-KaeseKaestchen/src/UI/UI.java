package UI;

import kaeseKaestchen.KaeseKaestchen;
import util.IObserver;

public abstract class UI implements IObserver{
	
	KaeseKaestchen theControl;
	
	public	UI(KaeseKaestchen pTheControl){
		theControl = pTheControl;
		
		//this.addUIToControlObservable();
		//TODO observer problem
		
	}
	
	//abstract protected void addUIToControlObservable();
	//theControl.addObserver(this);
	
	abstract public void paintPlayingField();
	abstract public void showWelcomeScreen();

}
