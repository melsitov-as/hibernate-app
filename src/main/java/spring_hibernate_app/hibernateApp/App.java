package spring_hibernate_app.hibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_hibernate_app.hibernateApp.model.Item;
import spring_hibernate_app.hibernateApp.model.Passport;
import spring_hibernate_app.hibernateApp.model.Person;

// здесь будем работать с нашими связанными сущностями
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
        		.addAnnotatedClass(Item.class).addAnnotatedClass(Passport.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
       try {
    	   session.beginTransaction();
    	  
    	   
//    	   Person person = new Person("Test person - passport", 50);
//    	   Passport passport = new Passport(12345);
//    	   
//    	   person.setPassport(passport);
//    	   session.save(person);
//    	   
    	   // найдем человека и прочитаем из него пасспорт
//    	   Person person = session.get(Person.class, 9);
//    	   System.out.println(person.getPassport().getPassportNumber());
 
    	   // Прочитаем пасспорт из таблицы и получим из него человека
    	   
//    	   Passport passport = session.get(Passport.class, 9);
//    	   System.out.println(passport.getPerson().getName());
    	  
    	   
    	   // Изменим номер паспорта у какого-то человека
//    	   Person person = session.get(Person.class, 9);
//    	   person.getPassport().setPassportNumber(54321);
//    	   System.out.println(person.getPassport().getPassportNumber());
    	   
    	   
    	   // Удалим человека и каскадом будет удаляться его пасспорт
    	   Person person = session.get(Person.class, 9);
    	   session.remove(person);
    	   session.getTransaction().commit();
    	   
    	   
    	   
    	   
    	   
       } finally {
    	   sessionFactory.close();
       }
    }
}
