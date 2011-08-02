package org.obliquid.springdi.cache;


 
/**
 * A null cache implementation that actually doesn't cache anything and always has cache miss:
 * this is the simplest possible implementation of ICache.
 * 
 * @author stivlo
 *
 */
public class NullCache implements ICache {

        @Override
        public Object get(String key) {
                return null;
        }

        @Override
        public void set(String key, Object value) {
                //don't do anything!
        }

}
