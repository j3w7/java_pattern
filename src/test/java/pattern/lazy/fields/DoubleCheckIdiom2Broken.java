package pattern.lazy.fields;

import dummies.MyField;

/**
 * Implementation of a double check idiom.
 * 
 * Prevents multiple initializations
 */
public class DoubleCheckIdiom2Broken {

    // broken: should be volatile 
    private MyField lazyField;

        public MyField getMyField() {
            MyField tmp = lazyField;
            if (tmp == null) {
                synchronized (this) {
                    tmp = lazyField;
                    if (tmp == null) {
                        lazyField = tmp = new MyField(  );
                    }
                }
             }

            return tmp;
   
    } 
}