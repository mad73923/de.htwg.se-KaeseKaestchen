package de.htwg.se.kaesekaestchen.ui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI extends UI {
	private KaeseKaestchenControl controller = new KaeseKaestchenControl();
	Scanner in = new Scanner(System.in);
	Color[] colors= {Color.black, Color.blue, Color.green, Color.magenta, Color.orange, Color.red, Color.yellow};
	int sizeX = 0;
	int sizeY = 0;
	
	public TUI(KaeseKaestchenControl pTheControl){
		super(pTheControl);
	}

	@Override
	protected void refreshUI() {
		
		
	}

	@Override
	public void showWelcomeMessage() {

		try {
			//TODO collect new game data
			System.out.println("Welcome to KaeseKaestchen!\n(c) Matthias Weis & Joey Rieg\nHTWG Konstanz SS 2014\n\n");
			System.out.printf("Enter number of Players (max. %d Players):\n", colors.length);
			
			int numberOfPlayers = in.nextInt();
			String playerNames[] = new String[numberOfPlayers];
			
			
			for(int i = 0; i < numberOfPlayers; i++){
				System.out.printf("Name of Player%d\n", i+1);
				playerNames[i] = in.next();
			}
			
			
			System.out.println("\nEnter size of playfield:");
			System.out.print("x: ");
			sizeX = in.nextInt();
			System.out.print("Y: ");
			sizeY = in.nextInt();
			if(sizeX <= 2 || sizeY <= 2){
				// throw Exception
			}
			
			
			System.out.printf("Playfield size is x: %d\ty: %d\n\n", sizeX, sizeY);
			System.out.println("Let's play!");
			
			
			
			controller.startNewGame(playerNames, colors, sizeX+1, sizeY+1);
			
			refreshUI();
			// UPDATE UI --> only Playfield with Players and Points
			System.out.println(controller.getPlayField());
			
			for(int i = 0; i < playerNames.length; i++) {
				//Where to get points of players???
				System.out.printf("%s: x Points\t", playerNames[i]);
				if(i == 3) {
					System.out.println();
				}
			}
				
			
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("Please type a number!");
				
			}
			
		}

	}

	@Override
	protected void showMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void showWarning() {
		// TODO Auto-generated method stub
		
	}
	
	public void outPrint(){
		showWelcomeMessage();
	}

	

}
