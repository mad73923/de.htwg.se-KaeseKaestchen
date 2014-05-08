package de.htwg.se.kaesekaestchen.model;

public class Line {
	
	private Player theOwner;
	
	public Line(){
		
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

}
