package de.htwg.se.KaeseKaestchen.model;

public class Line {
	
	Player theOwner;
	
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
