
public class KaeseKaestchen {

	/**
	 * @param args
	 */
	
	Player[] thePlayer;
	Player recentPlayer;
	
	PlayField thePlayField;
	UI theUI;
	
	public KaeseKaestchen(boolean tui) {
		if(tui){
			theUI = new TUI(this);
		}else{
			//TODO create GUI
		}
		theUI.showWelcomeScreen();
	}
	
	
	
	public static void main(String[] args) {
		new KaeseKaestchen(true);		

	}
	
	

}
