package UI;

import controller.KaeseKaestchenControl;

public class TUI extends UI {
	
	public TUI(KaeseKaestchenControl pTheControl){
		super(pTheControl);
	}

	@Override
	protected void refreshUI() {
		// TODO Auto-generated method stub
		if(theControl.getPlayField() == null){
			
		}
	}

	

}
