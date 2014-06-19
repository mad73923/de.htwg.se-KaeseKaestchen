package de.htwg.se.kaesekaestchen.model;

import java.awt.Color;

public interface IPlayer {

	public abstract void incrementPoints();

	public abstract Color getColor();

	public abstract String getName();

	public abstract int getPoints();

}