package it.unibo.chessgravity.model.api;

import java.util.Collection;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Observable interface that represents the subject being observed
 * by a GravityObserver
 */
public interface GravityObservable {
    void subscribe(GravityObserver observer);

    void unsubsribe(GravityObserver observer);

    void subscribeAll(Collection<GravityObserver> observer);

    void unsubsribeAll();

    void notifyObservers(SquarePosition pos);
}