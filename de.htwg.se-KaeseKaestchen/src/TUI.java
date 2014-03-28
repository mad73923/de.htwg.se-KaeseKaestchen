import java.io.*;


public class TUI extends UI {

	public TUI(KaeseKaestchen pTheControl) {
		super(pTheControl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintPlayingField() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showWelcomeScreen() {
		System.out.println("Welcome to Käsekästchen!\nDeveloped by Joey Rieg & Matthias Weis\nHTWG Konstanz SS2014");
		System.out.print("Number of Players: ");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int numberOfPlayers = 0;
		try {
			//TODO avoid numberOfPlayers = 0 or >10
			numberOfPlayers = Integer.parseInt(buffer.readLine());
	      } catch (IOException ioe) {
	    	 //TODO handle Exception
	         System.out.println("IO error trying to read player number!");
	         System.exit(1);
	      }
		String[] playerNames = new String[numberOfPlayers];
		for(int i=1; i<=numberOfPlayers; i++){
			System.out.print("Name Player "+i+":");
			try {
				playerNames[i-1] = buffer.readLine();
		      } catch (IOException ioe) {
		    	 //TODO handle Exception
		         System.out.println("IO error trying to read player name!");
		         System.exit(1);
		      }
		}
		int fieldSize = 0;
		System.out.print("Size of field:");
		try {
			//TODO avoid fieldsize = 0 or >10!?
			fieldSize = Integer.parseInt(buffer.readLine());
	      } catch (IOException ioe) {
	    	 //TODO handle Exception
	         System.out.println("IO error trying to read field size!");
	         System.exit(1);
	      }
		theControl.startNewGame(playerNames, fieldSize, fieldSize);
		
	}

	@Override
	public void showMessage(String pMessage) {
		// TODO Auto-generated method stub
		
	}

}
