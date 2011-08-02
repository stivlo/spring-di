package org.obliquid.springdi;

import org.obliquid.springdi.cache.ICache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;

//Eclipse (Indigo = 3.7) for some reason can't suggest the import for Autowired, in case it happens
//just copy the autowired import and remove the final 'd'.
@RooJavaBean
@Configurable(autowire=Autowire.BY_TYPE)
public class Person {

        private int id;

        private String name;

        @Autowired
        private transient ICache cache;

        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Id: ").append(getId()).append(", ");
                sb.append("Name: '").append(getName()).append("', ");;
                sb.append("Cache: ").append(getCache());
                return sb.toString();
        }

        private Object getCache() {
                return cache;
        }

}
