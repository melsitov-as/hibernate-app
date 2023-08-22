package spring_hibernate_app.hibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_hibernate_app.hibernateApp.model.Item;
import spring_hibernate_app.hibernateApp.model.Person;

// здесь будем работать с нашими связанными сущностями
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
        		.addAnnotatedClass(Item.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
       try {
    	   session.beginTransaction();
    	  
    	   
    	   Person person = new Person("Test cascading", 30);
    	   Item item = new Item("Test cascading item", person);
    	   
    	   // настроим обратную связь
    	   person.setItems(new ArrayList<>(Collections.singletonList(item)));
    	   
    	   // методы save и persist похожи
    	   // методы persist чтобы каскадирование при сохранении работало 
    	   session.persist(person);
    	   
    	   session.getTransaction().commit();
    	   
    	   
    	   
    	   
    	   
       } finally {
    	   sessionFactory.close();
       }
    }
}
