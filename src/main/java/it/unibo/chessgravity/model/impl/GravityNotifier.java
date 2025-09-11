package it.unibo.chessgravity.model.impl;

import java.util.Collection;

import it.unibo.chessgravity.model.api.GravityObservable;
import it.unibo.chessgravity.model.api.GravityObserver;

/**
 * GravityObserver implementation: this class follow the Observer pattern to handle
 * the gravity after a movement.
 */
public class GravityNotifier implements GravityObservable {

    @Override
    public void subscribe(GravityObserver observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscribe'");
    }

    @Override
    public void unsubsribe(GravityObserver observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unsubsribe'");
    }

    @Override
    public void subscribeAll(Collection<GravityObserver> observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscribeAll'");
    }

    @Override
    public void unsubsribeAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unsubsribeAll'");
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
    }
    
}
