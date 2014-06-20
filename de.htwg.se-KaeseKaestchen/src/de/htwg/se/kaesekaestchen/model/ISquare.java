package de.htwg.se.kaesekaestchen.model;

public interface ISquare {

	public static final int TOPLINEINDEX = 0;
	public static final int RIGHTLINEINDEX = 1;
	public static final int BOTTOMLINEINDEX = 2;
	public static final int LEFTLINEINDEX = 3;

	public abstract boolean allLinesHaveOwners();

	public abstract boolean setOwner(IPlayer newOwner);

	public abstract IPlayer getOwner();

	public abstract ILine[] getLines();

}