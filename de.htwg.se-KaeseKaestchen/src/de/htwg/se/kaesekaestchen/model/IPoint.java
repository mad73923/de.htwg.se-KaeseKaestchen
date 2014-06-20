package de.htwg.se.kaesekaestchen.model;

public interface IPoint {

	abstract int getValX();

	abstract void setValX(int valX);

	abstract int getValY();

	abstract void setValY(int valY);

	abstract boolean hasNegativeCoordinates();

	abstract double getDistanceToPoint(Point p);

	abstract boolean isUnderPoint(Point reference);

	abstract boolean isOverPoint(Point reference);

	abstract boolean isLeftOfPoint(Point reference);

	abstract boolean isRightOfPoint(Point reference);

	abstract boolean hasSameXValueAs(Point reference);

	abstract boolean hasSameYValueAs(Point reference);

	abstract boolean equals(Object obj);

	abstract int hashCode();

}