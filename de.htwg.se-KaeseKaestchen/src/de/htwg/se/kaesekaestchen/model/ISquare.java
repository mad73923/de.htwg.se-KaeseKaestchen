package de.htwg.se.kaesekaestchen.model;

public interface ISquare {

	static final int TOPLINEINDEX = 0;
	static final int RIGHTLINEINDEX = 1;
	static final int BOTTOMLINEINDEX = 2;
	static final int LEFTLINEINDEX = 3;
	static final int NUMBEROFLINES = 4;

	abstract boolean allLinesHaveOwners();

	abstract boolean setOwner(IPlayer newOwner);

	abstract IPlayer getOwner();

	abstract ILine[] getLines();

}