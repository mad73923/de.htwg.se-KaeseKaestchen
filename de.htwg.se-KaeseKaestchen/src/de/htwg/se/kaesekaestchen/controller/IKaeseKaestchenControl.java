package de.htwg.se.kaesekaestchen.controller;

import java.awt.Color;

import de.htwg.se.kaesekaestchen.model.IPlayField;
import de.htwg.se.kaesekaestchen.model.IPlayer;

public interface IKaeseKaestchenControl {

	public abstract void startNewGame(String[] playerNames,
			Color[] playerColors, int sizeX, int sizeY);

	public abstract void newMove(int startX, int startY, int endX, int endY);

	public abstract boolean checkPlayfieldForCompleteSquares();

	public abstract void pickNextPlayerAsCurrentPlayer();

	public abstract String getCurrentPlayerName();

	public abstract void setCurrentState(KaeseKaestchenState theState);

	public abstract void setStatusMessage(String theMessage);

	public abstract void setWarningMessage(String theMessage);

	public abstract String getWarningMessage();

	public abstract String getStatusMessage();

	public abstract IPlayField getPlayField();

	public abstract IPlayer getCurrentPlayer();
	
	public abstract String getPlayFieldString();
	
	public abstract int[] getPlayerPoints();

}