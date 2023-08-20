package spring_hibernate_app.hibernateApp;

import java.util.List;

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
    	   
    	   // получить список всех людей
    	   List<Person> people1 = session.createQuery("FROM Person").getResultList();
    	   List<Person> people2 = session.createQuery("FROM Person where age > 30").getResultList();
    	   List<Person> people3 = session.createQuery("FROM Person where name LIKE 'T%'").getResultList();
    	   
    	   for (Person person : people1) {
    		   System.out.println(person);
    	   }
    	   
    	   System.out.println("*************");
    	   
    	   for (Person person : people2) {
    		   System.out.println(person);
    	   }
    	   
    	   System.out.println("*************");
    	   
    	   for (Person person : people3) {
    		   System.out.println(person);
    	   }
    	   
    	   session.getTransaction().commit();
    	   
       } finally {
    	   sessionFactory.close();
       }
    }
}
