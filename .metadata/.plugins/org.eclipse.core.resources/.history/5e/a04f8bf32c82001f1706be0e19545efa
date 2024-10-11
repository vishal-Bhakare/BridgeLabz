package com.Bridgelaz.Comparable;

public class Student implements Comparable<Student>{

	private Integer rollno;
	private String name;
	private String email;
	private Long mobileNo;

	public Student(Integer rollno, String name, String email, Long mobileNo) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public int compareTo(Student stu) {
		
		return -this.getRollno()-stu.getRollno();
	}

}
