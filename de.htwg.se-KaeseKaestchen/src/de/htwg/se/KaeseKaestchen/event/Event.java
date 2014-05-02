package de.htwg.se.KaeseKaestchen.event;

public abstract class Event {
	

	@Override
	public boolean equals(Object obj) {
		return this.getClass().equals(obj.getClass());
	}

}
