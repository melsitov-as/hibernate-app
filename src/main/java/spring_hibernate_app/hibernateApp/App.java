package spring_hibernate_app.hibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_hibernate_app.hibernateApp.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
       try {
    	   session.beginTransaction();
    	   
    	   Person person1 = new Person("Test1", 31);
    	   Person person2 = new Person("Test2", 40);
    	   Person person3 = new Person("Test3", 50);
    	   
    	   session.save(person1);
    	   session.save(person2);
    	   session.save(person3);
    	   
    	   session.getTransaction().commit();
       } finally {
    	   sessionFactory.close();
       }
    }
}
