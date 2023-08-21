package spring_hibernate_app.hibernateApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Item")
public class Item {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "item_name")
	private String item_name;
	
	// Связь один ко многим в дочернем классе
	// создадим поле типа Person
	// у нашего товара есть владелец
	
	@ManyToOne
	@JoinColumn(name="person_id", referencedColumnName="id")
	Person owner;

	public Item() {
	}

	public Item(String item_name, Person owner) {
		this.item_name = item_name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", item_name=" + item_name + "]";
	}
	
	
	
}
