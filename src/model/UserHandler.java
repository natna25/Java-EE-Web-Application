package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserHandler {

    private static final SessionFactory factory;

    /**
     * static method that is executed once at the begining of the JVM, this is used to
     * make the necessary calls on hibernate in order to set up our database
     */
    static {
        try {
            // creates a Hibernate configuration object and initializes it based on the hibernate.cfg.xml configuration file
            Configuration configuration = new Configuration();
            configuration.configure();
            // instructs Hibernate to manage the Product entity class through annotations rather than XML files
            configuration.addAnnotatedClass(User.class);
            // creates the session factory
            factory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    //methods to add new users, check user credentials, delete user and update their account info



}
