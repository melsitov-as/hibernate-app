package spring_hibernate_app.hibernateApp.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Passport")
public class Passport implements Serializable{

	// когда имеем в качестве первичного ключа что-то не числовое в классе-сущности мы дожны 
	// реализовывать Serializable
	@Id
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	@Column(name = "passport_number")
	private int passportNumber;

	public Passport() {
	}

	public Passport(int passportNumber) { 
		this.passportNumber = passportNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Override
	public String toString() {
		return "Passport [person=" + person + ", passportNumber=" + passportNumber + "]";
	}
	
	
	
	
	

}
