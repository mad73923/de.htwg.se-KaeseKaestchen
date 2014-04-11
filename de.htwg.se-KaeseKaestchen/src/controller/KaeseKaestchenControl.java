package controller;

import java.awt.Color;

import util.Observable;
import model.PlayField;
import model.Player;
import UI.TUI;
import UI.UI;

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
		
	}
	
	public PlayField getPlayField(){
		return thePlayField;
	}

}
