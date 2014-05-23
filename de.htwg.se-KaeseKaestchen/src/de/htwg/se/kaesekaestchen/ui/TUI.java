package de.htwg.se.kaesekaestchen.ui;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import java.util.Scanner;

public class TUI extends UI {
	private KaeseKaestchenControl controller;
	Scanner in = new Scanner(System.in);
	
	public TUI(KaeseKaestchenControl pTheControl){
		super(pTheControl);
	}

	@Override
	protected void refreshUI() {
		// TODO Auto-generated method stub
	}

	@Override
	public void showWelcomeMessage() {
		//TODO collect new game data
		System.out.println("Welcome to KaeseKaestchen!\n(c) Matthias Weis & Joey Rieg\nHTWG Konstanz SS 2014\n\n");
		System.out.println("Enter number of Players:\n");
		int numberOfPlayers = in.nextInt();
		String playerNames[] = new String[numberOfPlayers];
		for(int i = 0; i < numberOfPlayers; i++){
			playerNames[i] = in.next();
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
		System.out.println("Test");
	}

	

}
