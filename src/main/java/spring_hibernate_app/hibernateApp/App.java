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
    	  
//    	   // получим товары человека с id = 3
//    	   // сначала получим самого человека
//    	   // получаем товары для человека
//    	   Person person = session.get(Person.class, 3);
//    	   System.out.println(person);
//    	   
//    	   List<Item> items = person.getItems();
//    	   
//    	   System.out.println(items);
//    	   
//    	   // получить товар и получить человека, владеющего этим товаром
//    	   Item item = session.get(Item.class, 5);
//    	   System.out.println(item);
//    	   
//    	   Person owner = item.getOwner();
//    	   System.out.println(owner);
//    	   
//    	   // добавлять товары и людей
//    	   // хорошей практикой считается задавать отношения с двух сторон
//    	   Person person2 = session.get(Person.class, 2);
//    	   Item newItem = new Item("Item from Hibernate", person2);
//    	   session.save(newItem);
//    	   person2.getItems().add(newItem);
//    	   
//    	   // создадим одного человека с одним товаров
//    	   Person person3 = new Person("Test person", 30);
//    	   Item newItem2 = new Item("Item form Hibernate 2", person3);
//    	   person3.setItems(new ArrayList<>(Collections.singletonList(newItem2)));
//    	   session.save(person3);
//    	   session.save(newItem2);
//    	   
//    	   // тут не настроено каскадирование, поэтому сохранение каждой сущности надо настравивать отдельно
//    	   
//    	   // удалим товар у какого-либо человека
//    	   
//    	   Person person4 = session.get(Person.class, 3);
//    	   List<Item> items2 = person4.getItems();
//    	   
//    	   // порождает SQl
//    	   for (Item item2 : items2) {
//    		  session.remove(item2); 
//    	   }
//    	   
//    	   // не порождает SQL, но необходимо для того, чтобы в кэше все было верно
//    	   person4.getItems().clear(); 
    	   
//    	   Person person5 = session.get(Person.class, 2);
//    	   
//    	   // SQL
//    	   session.remove(person5);
//    	   
//    	   // чтобы было правильное состояние кэша
//    	   person5.getItems().forEach(i -> i.setOwner(null));
    	   
    	   // поменять владельца у товара
    	   Person person = session.get(Person.class, 4);
    	   Item item = session.get(Item.class, 1);
    	   
    	   item.getOwner().getItems().remove(item);
    	   item.setOwner(person);
    	   person.getItems().add(item);
    	   session.getTransaction().commit();
    	   
    	   
    	   
    	   
    	   
       } finally {
    	   sessionFactory.close();
       }
    }
}
