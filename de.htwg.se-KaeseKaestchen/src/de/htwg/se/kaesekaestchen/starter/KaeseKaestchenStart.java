package de.htwg.se.kaesekaestchen.starter;
import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.ui.TUI;


public class KaeseKaestchenStart {

	/**
	 * @param args
	 */
	public KaeseKaestchenStart() {
		
	}
	public static void main(String[] args) {
		KaeseKaestchenControl control = new KaeseKaestchenControl();
		TUI tui = new TUI(control);
		tui.outPrint();
		
	}

}
