package de.htwg.se.kaesekaestchen.model;

import java.awt.Color;

public interface IPlayer {

	abstract void incrementPoints();

	abstract Color getColor();

	abstract String getName();

	abstract int getPoints();

}