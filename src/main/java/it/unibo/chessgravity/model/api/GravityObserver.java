package it.unibo.chessgravity.model.api;

import it.unibo.chessgravity.model.api.square.SquarePosition;

/**
 * Observer interface for those entities that has to be notifyed when
 * there's gravity call to be done
 */
public interface GravityObserver {
    /**
     * Method used to send the notification (gravity call).
     */
    void gravity();

    SquarePosition getPos();
}
