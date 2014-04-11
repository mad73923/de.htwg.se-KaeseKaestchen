package UI;

import controller.KaeseKaestchenControl;
import util.IObserver;

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
