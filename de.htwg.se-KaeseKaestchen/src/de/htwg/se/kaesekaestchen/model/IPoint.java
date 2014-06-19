package de.htwg.se.kaesekaestchen.model;

public interface IPoint {

	public abstract int getValX();

	public abstract void setValX(int valX);

	public abstract int getValY();

	public abstract void setValY(int valY);

	public abstract boolean hasNegativeCoordinates();

	public abstract double getDistanceToPoint(Point p);

	public abstract boolean isUnderPoint(Point reference);

	public abstract boolean isOverPoint(Point reference);

	public abstract boolean isLeftOfPoint(Point reference);

	public abstract boolean isRightOfPoint(Point reference);

	public abstract boolean hasSameXValueAs(Point reference);

	public abstract boolean hasSameYValueAs(Point reference);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

}