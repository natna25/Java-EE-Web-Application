package model;

import org.hibernate.*;
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

    public UserHandler() {
    }
    //methods to add new users, check user credentials, delete user and update their account info

    /*
    creates a new user, send back a boolean if the user was created correctly or if a user with the same username already exists
     */
    public boolean createUser(User user){

        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Integer id = (Integer) session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  finds a user based on his username
     */
    public User getUser(String username){
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, username);
            transaction.commit();
            return user;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    /**
     * updates the current user, used for updating the dates that a user changes when he logs in and out
     * @param user
     * @return
     */
    public boolean updateUser(User user){
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


}
