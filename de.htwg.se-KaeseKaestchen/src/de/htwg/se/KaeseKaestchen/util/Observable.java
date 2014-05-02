package de.htwg.se.KaeseKaestchen.util;

import java.util.Iterator;
import java.util.Vector;

import de.htwg.se.KaeseKaestchen.event.Event;

public class Observable {
	
	protected Vector<IObserver> subscribers = new Vector<IObserver>(2);

	public void addObserver(IObserver s) {
		subscribers.addElement(s);
	}

	public void removeObserver(IObserver s) {
		subscribers.removeElement(s);
	}

	public void removeAllObservers() {
		subscribers.removeAllElements();
	}

	public void notifyObservers(Event whatHappend) {
		for ( Iterator<IObserver> iter = subscribers.iterator(); iter.hasNext();) {
			IObserver observer = iter.next();
			observer.update(whatHappend);
		}
	}

}
