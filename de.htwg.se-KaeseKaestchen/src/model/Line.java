package model;

public class Line {
	
	Player theOwner;
	
	public Line(){
		
	}
	
	public boolean isNotSet(){
		return theOwner == null;
	}
	
	public boolean setOwner(Player newOwner){
		if(isNotSet()){
			theOwner = newOwner;
			return true;
		}
		return false;
	}
	
	public Player getOwner(){
		return theOwner;
	}

}
