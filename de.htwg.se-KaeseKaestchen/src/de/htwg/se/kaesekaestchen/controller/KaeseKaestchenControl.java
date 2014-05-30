package de.htwg.se.kaesekaestchen.controller;

import java.awt.Color;

import de.htwg.se.kaesekaestchen.event.UpdateUIEvent;
import de.htwg.se.kaesekaestchen.event.WelcomeUIEvent;
import de.htwg.se.kaesekaestchen.model.PlayField;
import de.htwg.se.kaesekaestchen.model.Player;
import de.htwg.se.kaesekaestchen.model.Point;
import de.htwg.se.kaesekaestchen.util.Observable;

public class KaeseKaestchenControl extends Observable{

	/**
	 * @param args
	 */
	
	private Player[] thePlayer;
	private int currentPlayerIndex;
	
	private PlayField thePlayField;
	private KaeseKaestchenState currentState;
	private String warningMessage;
	private String statusMessage;

	public KaeseKaestchenControl(){
		//TODO UI zu diesem Zeitpunkt noch kein Observer
		notifyObservers(new WelcomeUIEvent());
		currentPlayerIndex = -1;
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
		currentState = new KaeseKaestchenStateMove(this);
		currentState.nextState(thePlayField.setLineFromToPointWithPlayer(start, end, thePlayer[currentPlayerIndex]));

	}
	
	public boolean checkPlayfieldForCompleteSquares(){
		return thePlayField.checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(thePlayer[currentPlayerIndex]);		
	}
	
	public void pickNextPlayerAsCurrentPlayer(){
		currentPlayerIndex = (currentPlayerIndex+1)%(thePlayer.length-1);
	}
	
	public String getCurrentPlayerName(){
		return this.thePlayer[currentPlayerIndex].getName();
	}
	
	public void setCurrentState(KaeseKaestchenState theState){
		currentState = theState;
	}
	
	public void setStatusMessage(String theMessage){
		statusMessage = theMessage;
	}
	
	public void setWarningMessage(String theMessage){
		warningMessage = theMessage;
	}
	
	private void pickRandomPlayerAsCurrentPlayer(){
		currentPlayerIndex = randomNumberInLowAndHigh(0, thePlayer.length-1);
	}
	
	public static int randomNumberInLowAndHigh(int low, int high) {
		return (int) (Math.random() * (high+1 - low) + low);
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
	
	public String getPlayFieldString(){
		return thePlayField.toString();
	}
	
	public Player getCurrentPlayer(){
		try {
			return thePlayer[currentPlayerIndex];
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

}
