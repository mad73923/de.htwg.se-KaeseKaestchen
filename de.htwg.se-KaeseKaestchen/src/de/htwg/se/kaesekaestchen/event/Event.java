package de.htwg.se.kaesekaestchen.event;

public abstract class Event {
	

	@Override
	public boolean equals(Object obj) {
		if (obj == null){
			return false;
		}
		return this.getClass().equals(obj.getClass());
	}
	
	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

}
