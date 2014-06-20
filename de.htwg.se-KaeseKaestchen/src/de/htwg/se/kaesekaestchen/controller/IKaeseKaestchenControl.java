package de.htwg.se.kaesekaestchen.controller;

import java.awt.Color;

import de.htwg.se.kaesekaestchen.model.IPlayField;
import de.htwg.se.kaesekaestchen.model.IPlayer;

public interface IKaeseKaestchenControl {

	 abstract void startNewGame(String[] playerNames,
	Color[] playerColors, int sizeX, int sizeY);

	 abstract void newMove(int startX, int startY, int endX, int endY);

	 abstract boolean checkPlayfieldForCompleteSquares();

	 abstract void pickNextPlayerAsCurrentPlayer();

	 abstract String getCurrentPlayerName();

	 abstract void setCurrentState(KaeseKaestchenState theState);

	 abstract void setStatusMessage(String theMessage);

	 abstract void setWarningMessage(String theMessage);

	 abstract String getWarningMessage();

	 abstract String getStatusMessage();

	 abstract IPlayField getPlayField();

	 abstract IPlayer getCurrentPlayer();

}