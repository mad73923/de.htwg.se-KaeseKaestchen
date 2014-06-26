package de.htwg.se.kaesekaestchen.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.event.MessageUIEvent;
import de.htwg.se.kaesekaestchen.event.UpdateUIEvent;
import de.htwg.se.kaesekaestchen.event.WarningUIEvent;
import de.htwg.se.kaesekaestchen.event.WelcomeUIEvent;

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
			if(whatHappend.getClass().equals(UpdateUIEvent.class)){
				observer.refreshUI();
			}else if(whatHappend.getClass().equals(WelcomeUIEvent.class)){
				observer.showWelcomeMessage();
			}else if(whatHappend.getClass().equals(MessageUIEvent.class)){
				observer.showMessage();
			}else if(whatHappend.getClass().equals(WarningUIEvent.class)){
				observer.showWarning();
			}else{
				System.out.println("Event not Supported: "+whatHappend.getClass().toString());
			}
		}
	}

}
