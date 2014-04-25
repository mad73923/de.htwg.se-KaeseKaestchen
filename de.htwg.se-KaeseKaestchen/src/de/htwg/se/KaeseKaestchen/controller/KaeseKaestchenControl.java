package de.htwg.se.KaeseKaestchen.controller;

import java.awt.Color;

import de.htwg.se.KaeseKaestchen.UI.TUI;
import de.htwg.se.KaeseKaestchen.UI.UI;
import de.htwg.se.KaeseKaestchen.event.Event;
import de.htwg.se.KaeseKaestchen.event.MessageUIEvent;
import de.htwg.se.KaeseKaestchen.event.OKEvent;
import de.htwg.se.KaeseKaestchen.event.UpdateUIEvent;
import de.htwg.se.KaeseKaestchen.event.WelcomeUIEvent;
import de.htwg.se.KaeseKaestchen.model.PlayField;
import de.htwg.se.KaeseKaestchen.model.Player;
import de.htwg.se.KaeseKaestchen.model.Point;
import de.htwg.se.KaeseKaestchen.util.Observable;

public class KaeseKaestchenControl extends Observable{

	/**
	 * @param args
	 */
	
	Player[] thePlayer;
	Player currentPlayer;
	
	PlayField thePlayField;
	UI theUI;
	
	String warningMessage;
	String statusMessage;

	public KaeseKaestchenControl(){
		theUI = new TUI(this);
		notifyObservers(new WelcomeUIEvent());
	}
	
	public void startNewGame(String[] playerNames, Color[] playerColors, int sizeX, int sizeY){
		//TODO fetch if playerNames.length != playerColors.length
		thePlayer = new Player[playerNames.length];
		for(int i=0; i<playerNames.length; i++){
			thePlayer[i] = new Player(playerNames[i], playerColors[i]);
		}
		this.pickRandomPlayerAsCurrentPlayer();
		thePlayField = new PlayField(sizeX, sizeY);
		notifyObservers(new UpdateUIEvent());
	}
	
	public void newMove(int startX, int startY, int endX, int endY){
		Point start = new Point(startX, startY);
		Point end = new Point(endX, endY);
		Event result = thePlayField.setLineFromToPointWithPlayer(start, end, currentPlayer);
		if(result.getClass().equals(OKEvent.class)){
			//linie gesetzt
			if(thePlayField.checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(currentPlayer)){
				//quadrat wurde geschlossen, kein spielerwechsel
			}else{
				pickNextPlayerAsCurrentPlayer();
				statusMessage = currentPlayer.getName()+" ist an der Reihe.";
				notifyObservers(new MessageUIEvent());
				notifyObservers(new UpdateUIEvent());
			}
		}
	}
	
	private void pickNextPlayerAsCurrentPlayer(){
		//TODO spielerwechsel
	}
	
	private void pickRandomPlayerAsCurrentPlayer(){
		currentPlayer = thePlayer[randomNumberInLowAndHigh(0, thePlayer.length-1)];
	}
	
	public static int randomNumberInLowAndHigh(int low, int high) {
		high++;
		return (int) (Math.random() * (high - low) + low);
	}
	
	public String getWarningMessage() {
		return warningMessage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public PlayField getPlayField(){
		return thePlayField;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}

}
