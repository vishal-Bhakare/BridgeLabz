package com.Bridgelaz.ListOfList;

import java.util.*;

public class List_Of_List {

	public static void main(String[] args) {

		List<String> mh = new ArrayList<String>();
		
		mh.add("NAGPUR");
		mh.add("PUNE");
		mh.add("MUMBAI");

		List<String> mp = new ArrayList<String>();

		mp.add("JABALPUR");
		mp.add("RAIPUR");
		mp.add("CHINDWADA");

		List<List<String>> ind = new ArrayList<List<String>>();

		ind.add(mh);
		ind.add(mp);

		System.out.println("List of List Is : " + ind);

		Iterator<List<String>> itr = ind.iterator();
		while (itr.hasNext()) {
			List<String> state = itr.next();

			System.out.println("List Of State City :" + state);

			Iterator<String> itr1 = state.iterator();

			while (itr1.hasNext()) {
				String city = itr1.next();
				System.out.println("CITY : " + city);
			}
		}
	}

}
