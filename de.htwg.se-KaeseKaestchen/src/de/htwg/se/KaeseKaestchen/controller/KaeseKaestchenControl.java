package de.htwg.se.KaeseKaestchen.controller;

import java.awt.Color;

import de.htwg.se.KaeseKaestchen.UI.TUI;
import de.htwg.se.KaeseKaestchen.UI.UI;
import de.htwg.se.KaeseKaestchen.model.PlayField;
import de.htwg.se.KaeseKaestchen.model.Player;
import util.Observable;

public class KaeseKaestchenControl extends Observable{

	/**
	 * @param args
	 */
	
	Player[] thePlayer;
	Player recentPlayer;
	
	PlayField thePlayField;
	UI theUI;

	public KaeseKaestchenControl(){
		theUI = new TUI(this);
		notifyObservers();
	}
	
	public void startNewGame(String[] playerNames, Color[] playerColors, int sizeX, int sizeY){
		//TODO fetch if playerNames.length != playerColors.length
		thePlayer = new Player[playerNames.length];
		for(int i=0; i<playerNames.length; i++){
			thePlayer[i] = new Player(playerNames[i], playerColors[i]);
		}
		thePlayField = new PlayField(this, sizeX, sizeY);
		notifyObservers();
	}
	
	public PlayField getPlayField(){
		return thePlayField;
	}

}
