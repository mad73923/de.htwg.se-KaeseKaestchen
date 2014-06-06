package de.htwg.se.kaesekaestchen.ui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;

import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TUI extends UI {
	private Scanner in = new Scanner(System.in);
	private Color[] colors= {Color.black, Color.blue, Color.green, Color.magenta, Color.orange, Color.red, Color.yellow};
	private int sizeX = 0;
	private int sizeY = 0;
	
	public TUI(KaeseKaestchenControl pTheControl){
		super(pTheControl);
	}

	@Override
	protected void refreshUI() {
		printStringln(theControl.getPlayFieldString());
		
	}

	@Override
	public void showWelcomeMessage() {
		try {
			printStringln("Welcome to KaeseKaestchen!\n(c) Matthias Weis & Joey Rieg\nHTWG Konstanz SS 2014\n\n");
			
			getNumberOfPlayersAndNames();

		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				printStringln("Please type a number!");
				
			}
			
		}

	}
	
	protected void getNumberOfPlayersAndNames() {
	    printString("Enter number of Players (max. " + colors.length + " Players):\n");
        
        int numberOfPlayers = in.nextInt();
        String playerNames[] = new String[numberOfPlayers];
        
        
        for(int i = 0; i < numberOfPlayers; i++){
            printString("Name of Player" + (i+1) + "\n");
            playerNames[i] = in.next();
        }
        
        getPlayfieldDataAndStartGame(playerNames);
	    
	}
	
	protected void getPlayfieldDataAndStartGame(String[] playerNames) {
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
        theControl.getStatusMessage();
        nextMove(playerNames);
	    
	}
	
	protected void nextMove(String[] playerNames) {
        for(int i = 0; i < playerNames.length; i++) {
			//Where to get points of players???
			int[] points = theControl.getPlayerPoints();
			printString(playerNames[i] + ":\t" + points[i] + " Points\t\t");
			if((i % 2) == 0) {
				printStringln("");
			}
		
	
    	}
        
        int [] coordinates = new int[4];
        printStringln("\nPlease give 2 Coordinates for your line (startx starty endx endy)");
        
        for ( int i = 0; i < coordinates.length; i++) {
            int j = in.nextInt();
            coordinates[i] = j;
        }
        printStringln(coordinates[0] + " " + coordinates[1] + " " + coordinates[2] + " " + coordinates[3]);
        
        theControl.newMove(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
	    
	}

	@Override
	protected void showMessage() {
		printStringln(theControl.getStatusMessage());	
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
