package it.unibo.chessgravity.model.api;

/**
 * Observer interface for those entities that has to be notifyed when
 * there's gravity call to be done
 */
public interface GravityObserver {
    void gravity();
}
