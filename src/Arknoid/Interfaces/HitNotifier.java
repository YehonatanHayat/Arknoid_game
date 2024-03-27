
// Yehonatan Hayat
// ID 318228046

package Arknoid.Interfaces;


/**
 * The interface Hit notifier.
 */
public interface HitNotifier {

    /**
     * Add hit listener.
     *
     * @param hl the listener
     */

    void addHitListener(HitListener hl);


    /**
     * Remove hit listener.
     *
     * @param hl the listener
     */
    void removeHitListener(HitListener hl);
}
