package it.unibo.chessgravity.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.unibo.chessgravity.model.api.GravityObservable;
import it.unibo.chessgravity.model.api.GravityObserver;

/**
 * GravityObserver implementation: this class follow the Observer pattern to handle
 * the gravity after a movement.
 */
public class GravityNotifier implements GravityObservable {

    private final List<GravityObserver> observers;

    public GravityNotifier() {
        observers = new ArrayList<>();
    }

    @Override
    public void subscribe(GravityObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubsribe(GravityObserver observer) {
        final int i = observers.indexOf(observer);

        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void subscribeAll(Collection<GravityObserver> observer) {
        observers.addAll(observer);
    }

    @Override
    public void unsubsribeAll() {
        observers.removeAll(observers);
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
    }
}
