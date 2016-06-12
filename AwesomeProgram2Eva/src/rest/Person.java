package rest;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
	private int id;
	private String fname;
	
	public Person(){
		
	}
	
	public Person(String name){
		fname = name;
	}
	
	public Person(int id, String fname) {
		this.id = id;
		this.fname = fname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "fname")
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
