package de.htwg.se.kaesekaestchen.starter;
import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.ui.TUI;
import de.htwg.se.kaesekaestchen.ui.UI;


public class KaeseKaestchenStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KaeseKaestchenControl control = new KaeseKaestchenControl();
		new TUI(control);
	}

}
