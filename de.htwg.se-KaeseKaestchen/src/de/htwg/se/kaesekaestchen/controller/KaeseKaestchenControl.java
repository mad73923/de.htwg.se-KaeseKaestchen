package de.htwg.se.kaesekaestchen.controller;

import java.awt.Color;

import de.htwg.se.kaesekaestchen.event.UpdateUIEvent;
import de.htwg.se.kaesekaestchen.event.WelcomeUIEvent;
import de.htwg.se.kaesekaestchen.model.IPlayField;
import de.htwg.se.kaesekaestchen.model.IPlayer;
import de.htwg.se.kaesekaestchen.model.IPoint;
import de.htwg.se.kaesekaestchen.model.PlayField;
import de.htwg.se.kaesekaestchen.model.Player;
import de.htwg.se.kaesekaestchen.model.Point;
import de.htwg.se.kaesekaestchen.util.Observable;

public class KaeseKaestchenControl extends Observable implements IKaeseKaestchenControl{

	/**
	 * @param args
	 */
	
	private IPlayer[] thePlayer;
	private int currentPlayerIndex;
	
	private IPlayField thePlayField;
	private KaeseKaestchenState currentState;
	private String warningMessage;
	private String statusMessage;

	public KaeseKaestchenControl(){
		//TODO UI zu diesem Zeitpunkt noch kein Observer
		notifyObservers(new WelcomeUIEvent());
		currentPlayerIndex = -1;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#startNewGame(java.lang.String[], java.awt.Color[], int, int)
	 */
	@Override
	public void startNewGame(String[] playerNames, Color[] playerColors, int sizeX, int sizeY){
		//TODO fetch if playerNames.length != playerColors.length
		thePlayer = new IPlayer[playerNames.length];
		for(int i=0; i<playerNames.length; i++){
			thePlayer[i] = new Player(playerNames[i], playerColors[i]);
		}
		this.pickRandomPlayerAsCurrentPlayer();
		thePlayField = new PlayField(sizeX, sizeY);
		notifyObservers(new UpdateUIEvent());
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#newMove(int, int, int, int)
	 */
	@Override
	public void newMove(int startX, int startY, int endX, int endY){
		IPoint start = new Point(startX, startY);
		Point end = new Point(endX, endY);
		currentState = new KaeseKaestchenStateMove(this);
		currentState.nextState(thePlayField.setLineFromToPointWithPlayer(start, end, thePlayer[currentPlayerIndex]));

	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#checkPlayfieldForCompleteSquares()
	 */
	@Override
	public boolean checkPlayfieldForCompleteSquares(){
		return thePlayField.checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(thePlayer[currentPlayerIndex]);		
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#pickNextPlayerAsCurrentPlayer()
	 */
	@Override
	public void pickNextPlayerAsCurrentPlayer(){
		currentPlayerIndex = (currentPlayerIndex+1)%(thePlayer.length-1);
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#getCurrentPlayerName()
	 */
	@Override
	public String getCurrentPlayerName(){
		return this.thePlayer[currentPlayerIndex].getName();
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#setCurrentState(de.htwg.se.kaesekaestchen.controller.KaeseKaestchenState)
	 */
	@Override
	public void setCurrentState(KaeseKaestchenState theState){
		currentState = theState;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#setStatusMessage(java.lang.String)
	 */
	@Override
	public void setStatusMessage(String theMessage){
		statusMessage = theMessage;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#setWarningMessage(java.lang.String)
	 */
	@Override
	public void setWarningMessage(String theMessage){
		warningMessage = theMessage;
	}
	
	private void pickRandomPlayerAsCurrentPlayer(){
		currentPlayerIndex = randomNumberInLowAndHigh(0, thePlayer.length-1);
	}
	
	public static int randomNumberInLowAndHigh(int low, int high) {
		return (int) (Math.random() * (high+1 - low) + low);
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#getWarningMessage()
	 */
	@Override
	public String getWarningMessage() {
		return warningMessage;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#getStatusMessage()
	 */
	@Override
	public String getStatusMessage() {
		return statusMessage;
	}

	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#getPlayField()
	 */
	@Override
	public IPlayField getPlayField(){
		return thePlayField;
	}
	
	/* (non-Javadoc)
	 * @see de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl#getCurrentPlayer()
	 */
	@Override
	public IPlayer getCurrentPlayer(){
		try {
			return thePlayer[currentPlayerIndex];
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	

}
