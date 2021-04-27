package org.rabbit.consumer.rabbitConsumer.model;

public class Employee {
	private String name;
	private String address;
	private String number;
	private long id;
	private String grade;

	public Employee(String name, String address, String number, long id, String grade) {
		this.name = name;
		this.address = address;
		this.number = number;
		this.id = id;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", number=" + number + ", id=" + id + ", grade="
				+ grade + "]";
	}

}
