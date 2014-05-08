package de.htwg.se.kaesekaestchen.util;

import de.htwg.se.kaesekaestchen.event.Event;

public interface IObserver {
	
	public void update(Event somethingHappend);

}
