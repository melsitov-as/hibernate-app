package spring_hibernate_app.hibernateApp.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
// тут название таблицы
@Table(name = "Person")
public class Person {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@SuppressWarnings("deprecation")
	@OneToOne(mappedBy = "person")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Passport passport;
	
	// указываем название того поля, в котором уже есть информация о нашей связи между сущностями
	// у OneToMany есть аргумент cascade и в этом аргументе мы указываем те операции,
	// которые будут каскадироваться 
	@SuppressWarnings("deprecation")
	@OneToMany(mappedBy="owner")
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private List<Item> items;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
		passport.setPerson(this);
	}

	public void addItem(Item item) {
		if (this.items == null) {
			this.items = new ArrayList<>();
		}
		
		this.items.add(item);
		item.setOwner(this);
	}

	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	

}

