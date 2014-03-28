
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
	
	public void startNewGame(String[] playerNames, int sizeX, int sizeY){
		//TODO test if game is already running
		//TODO set Player color
		thePlayer = new Player[playerNames.length];
		for(int i = 0; i<thePlayer.length; i++){
			thePlayer[i] = new Player(playerNames[i]);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new KaeseKaestchen(true);		

	}
	
	

}
