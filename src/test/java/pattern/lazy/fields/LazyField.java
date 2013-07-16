package pattern.lazy.fields;

import dummies.MyField;

/**
 * A simple implementation of lazy initialization of a field. 
 * 
 * Issues: erroneous multiple initializations are not prevented.
 */
public class LazyField {

    private MyField lazyField;

    public synchronized MyField getMyField() {
        if (lazyField == null)
            lazyField = new MyField();

        return lazyField;
    }

}
