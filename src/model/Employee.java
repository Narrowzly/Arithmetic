package model;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	public Employee(int id, String name) {
		this.setId(id);
		this.name = name;
	}
	
	public int compareTo(Employee e) {
		return this.getId() - e.getId();
	}
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
