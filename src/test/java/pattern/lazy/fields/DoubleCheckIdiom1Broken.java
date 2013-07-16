package pattern.lazy.fields;

import dummies.MyField;

/**
 * Broken implementation of a double check idiom.
 * 
 * Prevents multiple initializations
 */
public class DoubleCheckIdiom1Broken {

    // broken: should be volatile 
    private MyField lazyField;

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