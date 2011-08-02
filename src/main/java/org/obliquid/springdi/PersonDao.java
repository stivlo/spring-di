package org.obliquid.springdi;

import java.util.HashMap;
import java.util.Map;

import org.obliquid.springdi.cache.ICache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDao {

        @Autowired
        private ICache cache;

        @SuppressWarnings("serial")
        private Map<Integer, String> persons = new HashMap<Integer, String>()
        { {
                 put(1, "Benjamin Kirk");
                 put(1067, "Eloise Berry");
        } };

        public Person loadById(int id) {
                String memCacheKey = "Person-" + id;
                Person aPerson = (Person) cache.get(memCacheKey);
                if (aPerson != null) {
                        return aPerson;
                }
                aPerson = loadByIdFromSdb(id);
                cache.set(memCacheKey, aPerson);
                return aPerson;
        }

        /**
         * This method should load the Entity from Amazon SimpleDB, but for demo-purposes, I just set the
         * id and the name with a random string.
         * 
         * @param id
         *                person's id
         * @return a newly created Person object
         */
        private Person loadByIdFromSdb(int id) {
                Person person = new Person();
                person.setId(id);
                person.setName(persons.get(id));
                return person;
        }

}
