package org.obliquid.springdi.cache;

/**
 * A toy cache interface.
 * 
 * @author stivlo
 *
 */
public interface ICache {
        
        Object get(String key); 
        
        void set(String key, Object value);

}
