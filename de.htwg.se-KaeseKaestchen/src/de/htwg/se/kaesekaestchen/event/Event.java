package de.htwg.se.kaesekaestchen.event;

public abstract class Event {
	

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass());
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
