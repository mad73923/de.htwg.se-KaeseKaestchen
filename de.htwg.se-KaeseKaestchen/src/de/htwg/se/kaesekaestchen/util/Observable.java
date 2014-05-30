package de.htwg.se.kaesekaestchen.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import de.htwg.se.kaesekaestchen.event.Event;

public class Observable {
	
	protected List<IObserver> subscribers = new ArrayList<IObserver>(2);

	public void addObserver(IObserver s) {
		subscribers.add(s);
	}

	public void removeObserver(IObserver s) {
		subscribers.remove(s);
	}

	public void removeAllObservers() {
		subscribers.clear();
	}

	public void notifyObservers(Event whatHappend) {
		for ( Iterator<IObserver> iter = subscribers.iterator(); iter.hasNext();) {
			IObserver observer = iter.next();
			observer.update(whatHappend);
		}
	}

}
