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
    	   
    	    // получить человека из бд с id=2
//    	   Person person = session.get(Person.class, 2);
//    	   Person person2 = session.get(Person.class, 3);
//    	   person.setName("New name");
//    	   session.delete(person2);
    	   
    	   // получить id при сохранении и например куда-то в другое место его отправить или сохранить
    	   Person person3 = new Person("Some name", 60);
    	   session.save(person3);
    
    	   
    	   session.getTransaction().commit();
    	   
    	   System.out.println(person3.getId());
       } finally {
    	   sessionFactory.close();
       }
    }
}
