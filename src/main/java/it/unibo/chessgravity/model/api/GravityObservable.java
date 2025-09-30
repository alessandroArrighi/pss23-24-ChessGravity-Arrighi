package it.unibo.chessgravity.model.api;

import java.util.Collection;
import java.util.List;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Observable interface that represents the subject being observed
 * by a {@link GravityObserver}
 */
public interface GravityObservable {
    void subscribe(GravityObserver observer);

    void unsubsribe(GravityObserver observer);

    void subscribeAll(Collection<GravityObserver> observer);

    void unsubsribeAll();

    /**
     * Method that sends a notification (gravity) to the only observer with 
     * the same 'x' axis and a greater 'y' axis. This is used to send a notification 
     * to all the pieces that are above the moved piece.
     * 
     * @param pos The position of the moved piece.
     * @return A list of {@link GravityObserver}. This list is an ordered collection 
     * of the observers that have been notified (gravity).
     */
    List<GravityObserver> notifyObservers(SquarePosition pos);

    List<GravityObserver> notifyAllObservers();
}