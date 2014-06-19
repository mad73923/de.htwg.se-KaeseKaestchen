package de.htwg.se.kaesekaestchen.model;

import de.htwg.se.kaesekaestchen.event.Event;

public interface IPlayField {

	public abstract Event setLineFromToPointWithPlayer(IPoint start, Point end,
			IPlayer owner);

	public abstract boolean checkForCompleteSquaresWithoutOwnerAndSetCurrentPlayer(
			IPlayer currentPlayer);

	public abstract boolean areThereEmptyLines();

	public abstract boolean isValidLineAllegation(IPoint from, Point to);

	public abstract ISquare[][] getTheSquares();

	public abstract String toString();

}