package org.obliquid.springdi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The main class creates the application context and starts the application.
 * 
 * @author stivlo
 * 
 */
public class Main {
        
        private static Logger log = Logger.getLogger(Main.class);

        /**
         * Application entry point
         * 
         * @param args
         */
        public static void main(String[] args) {
                String config = "META-INF/spring/applicationContext.xml";
                BeanFactory appContext = new ClassPathXmlApplicationContext(config);
                PersonDao dao = appContext.getBean(PersonDao.class);
                Person aPerson = dao.loadById(1);
                log.info(aPerson.toString());
                aPerson = dao.loadById(1067);
                log.info(aPerson.toString());
        }

}
