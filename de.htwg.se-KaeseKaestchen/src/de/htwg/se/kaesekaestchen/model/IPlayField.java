package de.htwg.se.kaesekaestchen.model;

import de.htwg.se.kaesekaestchen.event.Event;

public interface IPlayField {

	abstract Event setLineFromToPointWithPlayer(IPoint start, Point end,
	IPlayer owner);

	abstract boolean checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(
	IPlayer currentPlayer);

	abstract boolean areThereEmptyLines();

	abstract boolean isValidLineAllegation(IPoint from, Point to);

	abstract ISquare[][] getTheSquares();

	abstract String toString();

}