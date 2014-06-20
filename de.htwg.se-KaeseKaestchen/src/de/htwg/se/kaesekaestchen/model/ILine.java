package de.htwg.se.kaesekaestchen.model;

public interface ILine {

	abstract boolean isOwnerNotSet();

	abstract boolean setOwner(IPlayer newOwner);

	abstract IPlayer getOwner();

	abstract double getLength();

}