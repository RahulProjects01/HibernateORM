package org.example;


import org.example.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {

        System.out.println("Classpath: " + System.getProperty("java.class.path"));

        System.out.println( "Hello World!" );

        User user = new User();
        user.setId(1);
        user.setName("Ram");
        user.setEmail("rahul@gmail.com");
        user.setPassword("1234");
        user.setGender("male");
        user.setCity("Jaipur");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");


        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(user); // provide the CURD operations
            transaction.commit(); // permanent save the data in database
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
