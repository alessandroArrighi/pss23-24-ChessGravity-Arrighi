package it.unibo.chessgravity.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.unibo.chessgravity.model.api.GravityObservable;
import it.unibo.chessgravity.model.api.GravityObserver;
import it.unibo.chessgravity.model.api.square.SquarePosition;

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
    public void subscribe(final GravityObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubsribe(final GravityObserver observer) {
        final int i = observers.indexOf(observer);

        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void subscribeAll(final Collection<GravityObserver> observer) {
        observers.addAll(observer);
    }

    @Override
    public void unsubsribeAll() {
        observers.removeAll(observers);
    }

    @Override
    public List<GravityObserver> notifyObservers(final SquarePosition pos) {
        final int posX = pos.getPosX();
        final int posY = pos.getPosY();
        final List<GravityObserver> res;

        res = observers.parallelStream()
        .filter(x -> x.getPos().getPosX() == posX)
        .filter(x -> x.getPos().getPosY() > posY)
        .sorted((a, b) -> {
            return Integer.compare(
                a.getPos().getPosY(),
                b.getPos().getPosY()
            );
        })
        .toList();
        
        res.forEach(x -> x.gravity());

        return res;
    }
}
