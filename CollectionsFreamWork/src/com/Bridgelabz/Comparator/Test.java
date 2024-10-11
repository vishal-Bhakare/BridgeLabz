package com.Bridgelabz.Comparator;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Set<Student> set = null;

		System.out.println("1 : Rollno \n2 : Name sort ");

		int choice = sc.nextInt();

		if (choice == 1) {
			set = new TreeSet<Student>(new RollNoSort());
		} else if (choice == 2) {
			set = new TreeSet<Student>(new NameSort());
		}

		set.add(new Student(201, "AKSHAY", 26, 75485748));
		set.add(new Student(205, "PRAVIN", 25, 4215241));
		set.add(new Student(204, "VISHAL", 26, 421365241));
		set.add(new Student(203, "SAURABH", 45, 214259658));

		for (Student stu : set) {
			System.out.println(stu);
		}

	}

}