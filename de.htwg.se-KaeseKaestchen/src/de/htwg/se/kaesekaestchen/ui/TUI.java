package de.htwg.se.kaesekaestchen.ui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI extends UI {
	Scanner in = new Scanner(System.in);
	Color[] colors= {Color.black, Color.blue, Color.green, Color.magenta, Color.orange, Color.red, Color.yellow};
	int sizeX = 0;
	int sizeY = 0;
	
	public TUI(KaeseKaestchenControl pTheControl){
		super(pTheControl);
	}

	@Override
	protected void refreshUI() {
	System.out.println(theControl.getPlayFieldString());
	}

	@Override
	public void showWelcomeMessage() {

		try {
			//TODO collect new game data
			printStringln("Welcome to KaeseKaestchen!\n(c) Matthias Weis & Joey Rieg\nHTWG Konstanz SS 2014\n\n");
			printString("Enter number of Players (max. " + colors.length + " Players):\n");
			
			int numberOfPlayers = in.nextInt();
			String playerNames[] = new String[numberOfPlayers];
			
			
			for(int i = 0; i < numberOfPlayers; i++){
				printString("Name of Player" + (i+1) + "\n");
				playerNames[i] = in.next();
			}
			
			
			printStringln("\nEnter size of playfield:");
			printString("x: ");
			sizeX = in.nextInt();
			printString("Y: ");
			sizeY = in.nextInt();
			if(sizeX <= 2 || sizeY <= 2){
				// throw Exception
			}
			
			
			printStringln("Playfield size is x: " + sizeX + "\t" + 
							  				"y: " + sizeY + "\n");
			printStringln("Let's play!");
			
			
			
			theControl.startNewGame(playerNames, colors, sizeX+1, sizeY+1);
			
			//refreshUI();
			// UPDATE UI --> only Playfield with Players and Points
			//System.out.println(controller.getPlayField());
			
			for(int i = 0; i < playerNames.length; i++) {
				//Where to get points of players???
				printString(playerNames[i] + ": x Points\t");
				if(i == 3) {
					printStringln("");
				}
			}
				
			
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				printStringln("Please type a number!");
				
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
	
	private void printStringln(String s) {
		System.out.println(s);
	}
	
	private void printString(String s) {
		System.out.print(s);
	}
	
	public void outPrint(){
		showWelcomeMessage();
	}

	

}
