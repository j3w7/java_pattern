package pattern.lazy.fields;

import dummies.MyField;

/**
 * Implementation of a double check idiom.
 * 
 * Prevents multiple initializations
 */
public class DoubleCheckIdiom1 {

    private volatile MyField lazyField;

    public MyField getMyField() {
        if (lazyField == null) {
            synchronized (this) {
                if (lazyField == null) {
                    lazyField = new MyField();
                }
            }
        }
        return lazyField;
    }

}