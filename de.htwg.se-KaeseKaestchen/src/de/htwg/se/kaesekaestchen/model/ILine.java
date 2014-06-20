package de.htwg.se.kaesekaestchen.model;

public interface ILine {

	public abstract boolean isOwnerNotSet();

	public abstract boolean setOwner(IPlayer newOwner);

	public abstract IPlayer getOwner();

	public abstract double getLength();

}