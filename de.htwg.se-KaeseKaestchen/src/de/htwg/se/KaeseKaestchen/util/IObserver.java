package de.htwg.se.KaeseKaestchen.util;

import de.htwg.se.KaeseKaestchen.event.Event;

public interface IObserver {
	
	public void update(Event somethingHappend);

}
