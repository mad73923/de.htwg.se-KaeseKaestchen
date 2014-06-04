package de.htwg.se.kaesekaestchen.ui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TUI extends UI {
	private Scanner in = new Scanner(System.in);
	private Color[] colors= {Color.black, Color.blue, Color.green, Color.magenta, Color.orange, Color.red, Color.yellow};
	private int sizeX = 0;
	private int sizeY = 0;
	private String[] args;
	
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

			nextMove(playerNames);
				
			
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				printStringln("Please type a number!");
				
			}
			
		}

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
        List l = new ArrayList();
        printStringln("Please give 2 Coordinates for your line (startx starty endx endy");
        List<Integer> list = new ArrayList<Integer>();
        Scanner sc = in.useDelimiter(" ");
        int [] coordinates = new int[4];
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            coordinates[i] = list.get(i);
        }
        for (int i = 0; i < coordinates.length; i++) {
            System.out.println(coordinates[i]);
        }
        //theControl.newMove(1, 2, 1, 1);
        //showMessage();
	    
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
