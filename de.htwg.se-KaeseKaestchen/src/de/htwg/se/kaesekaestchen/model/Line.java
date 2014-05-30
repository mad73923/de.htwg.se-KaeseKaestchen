package de.htwg.se.kaesekaestchen.model;

public class Line {
	
	private Player theOwner;
	private Point startPoint;
	private Point endPoint;
	
	public Line(Point pStartPoint, Point pEndPoint){
		startPoint = pStartPoint;
		endPoint = pEndPoint;
		
	}
	
	public boolean isOwnerNotSet(){
		return theOwner == null;
	}
	
	public boolean setOwner(Player newOwner){
		if(isOwnerNotSet()){
			theOwner = newOwner;
			return true;
		}
		return false;
	}
	
	public Player getOwner(){
		return theOwner;
	}
	
	public double getLength(){
		return startPoint.getDistanceToPoint(endPoint);
	}

}
