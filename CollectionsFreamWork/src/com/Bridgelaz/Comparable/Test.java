package com.Bridgelaz.Comparable;

import java.util.*;

public class Test {
	
	public static void main(String[] args) {
		
		ArrayList<Student> ar = new ArrayList<Student>();

		ar.add(new Student(1,"vishal","vishal@gmail.com",9823729409l));
		ar.add(new Student(10,"vishal","vishal@gmail.com",9823729409l));
		ar.add(new Student(100,"vishal","vishal@gmail.com",9823729409l));

		Collections.sort(ar);

		for (Student str : ar) {
			System.out.println(str.getRollno() + " " + str.getName()+" "+str.getMobileNo());

		}
	}

}
