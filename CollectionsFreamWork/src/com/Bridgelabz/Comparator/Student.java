package com.Bridgelabz.Comparator;

public class Student {

	private int rollno;
	private String name;
	private int age;
	private int mblno;
	public Student(int rollno, String name, int age, int mblno) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.mblno = mblno;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
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
	public int getMblno() {
		return mblno;
	}
	public void setMblno(int mblno) {
		this.mblno = mblno;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", age=" + age + ", mblno=" + mblno + "]";
	}
	
	
	
	
	
	
	
	
}