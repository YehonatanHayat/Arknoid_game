
// Yehonatan Hayat
// ID 318228046

package Arknoid.GameSetup;


/**
 * The type Counter.
 */
public class Counter {
    private int value;


    /**
     * Instantiates a new Counter.
     *
     * @param value the value
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * Increase.
     *
     * @param number the number
     */
    public void increase(int number) {
        this.value += number;
    }


    /**
     * Decrease.
     *
     * @param number the number
     */
    public void decrease(int number) {
        this.value -= number;
    }


    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }
}
