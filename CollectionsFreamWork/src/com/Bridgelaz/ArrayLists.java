package com.Bridgelaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayLists {
	public static void main(String[] args) {

		basicIteration();
		usingIteratorMethod();
		ArrayListDeclaration();
	}



	private static void ArrayListDeclaration() {
		/* Declaration of ArrayList */
		ArrayList<String> al = new ArrayList<String>();

		/* Elements added to the ArrayList */
		al.add("Apple");
		al.add("Pear");
		al.add("Banana");
		al.add("PineApple");
		al.add("Orange");

		/* Showing ArrayList elements */
		System.out.println("ArrayList contains: " + al);

		/* Add element at the given index */
		al.add(0, "Blackberry");
		al.add(1, "Kiwi");

		/* Remove elements from array list like this */
		al.remove("Pear");
		al.remove("Orange");

		System.out.println("Current ArrayList is: " + al);

		/* Remove element from the given index */
		al.remove(1);

		System.out.println("Updated ArrayList is:" + al);
	}

	

	private static void usingIteratorMethod() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		Iterator<Integer> itr = list.iterator();

		while (itr.hasNext()) {
			Integer next = itr.next();

			System.out.println(next);
		}
	}

	private static void basicIteration() {
		ArrayList<String> al = new ArrayList<String>(Arrays.asList("Boston", "Chicago", "Dallas"));
		System.out.println("Elements are: " + al);

		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(131);
		al2.add(71);
		al2.add(361);
		al2.add(891);
		al2.add(971);

		/* Advanced For Loop Example for iterating ArrayList */
		System.out.println("Using Advanced For Loop");

		for (Integer num : al2) {
			System.out.println(num);
		}
	}
}
