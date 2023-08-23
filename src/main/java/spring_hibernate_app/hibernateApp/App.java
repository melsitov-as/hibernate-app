package spring_hibernate_app.hibernateApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring_hibernate_app.hibernateApp.model.Actor;
import spring_hibernate_app.hibernateApp.model.Item;
import spring_hibernate_app.hibernateApp.model.Movie;
import spring_hibernate_app.hibernateApp.model.Passport;
import spring_hibernate_app.hibernateApp.model.Person;

// здесь будем работать с нашими связанными сущностями
public class App 
{
    @SuppressWarnings("deprecation")
	public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
       
       
       // попробовать здесь try with resources (try с ресурсами)
       try(sessionFactory) {
    	   Session session = sessionFactory.getCurrentSession();
    	   session.beginTransaction();  
    	   
//    	   Movie movie = new Movie("Pulp fiction", 1994);
//    	   Actor actor1 = new Actor("Harvey Keitel", 81);
//    	   Actor actor2 = new Actor("Samuel L. Jackson", 72);
//    	   
//    	   // назначим связи с двух сторон
//    	   movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
//    	   actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//    	   actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//    	   
//    	   session.save(movie);
//    	   session.save(actor1);
//    	   session.save(actor2);
    	   
    	   // Получим список актеров для какого-либо фильма
//    	   Movie movie = session.get(Movie.class, 1);
//    	   System.out.println(movie.getActors());
//    	   
//    	   Movie movie2 = new Movie("Reservour Dogs", 1992);
//    	   Actor actor = session.get(Actor.class, 1);
//    	   movie2.setActors(new ArrayList<>(Collections.singletonList(actor)));
//    	   actor.getMovies().add(movie2);
//    	   session.save(movie2);
//    	  
    	   
    	   // Удалим фильма у какого-либо существующего актера
    	   Actor actor = session.get(Actor.class, 2);
    	   System.out.println(actor.getMovies());
    	   Movie movieToRemove = actor.getMovies().get(0);
    	   actor.getMovies().remove(0);
    	   
    	   // чтобы метод remove правильно работал нужно реализовать методы hashCode и equals у классов Actor и Movie
    	   movieToRemove.getActors().remove(actor);
    	   
    	   session.getTransaction().commit();   
       }
    }
}
