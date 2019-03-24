package org.learn.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {

	static {

	}

	public static void main(String[] args) {
		// TODO: create a list of students (may be five items)

		Address am1 = new Address(1, "street1", "Thane", "Maharashtra", 400602);
		Address ap1 = new Address(101, "Per_Street1", " ", "Maharashtra", "Thane", 1001);
		Student s1 = new Student("Prashant", "Kundeshwar", am1, ap1);

		Address am2 = new Address(2, "street2", "Navi Mumbai", "Gujrat", 400601);
		Address ap2 = new Address(202, "Per_Street2", " ", "Gujrat", "Navi Mumbai", 1002);
		Student s2 = new Student("Parth", "Patel", am2, ap2);

		Address am3 = new Address(3, "street3", "South Mumbai", "Punjab", 400619);
		Address ap3 = new Address(303, "Per_Street3", " ", "Punjab", "South Mumbai", 1003);
		Student s3 = new Student("John", "Doe", am3, ap3);

		Address am4 = new Address(4, "street4", "North Mumbai", "Kashmir", 400949);
		Address ap4 = new Address(404, "Per_Street4", " ", "Kashmir", "North Mumbai", 1004);
		Student s4 = new Student("Joe", "Smith", am4, ap4);

		Address am5 = new Address(5, "street5", "Mumbai", "Maharashtra", 400582);
		Address ap5 = new Address(505, "Per_Street5", " ", "Maharashtra", "Mumbai", 1005);
		Student s5 = new Student("David", "Beckham", am5, ap5);

		ArrayList<Student> lstud = new ArrayList<Student>();
		lstud.add(s1);
		lstud.add(s2);
		lstud.add(s3);
		lstud.add(s4);
		lstud.add(s5);

		System.out.println("Unsorted order");
		/*
		 * for (Student s : lstud) { System.out.println(s); System.out.println(); }
		 */

		// TODO: sort the list using last name of the student
		System.out.println("Sortted by last name");
		Collections.sort(lstud, new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				if (o1.getLastName().compareTo(o2.getLastName()) == 0) {
					return o1.getFirstName().compareTo(o2.getFirstName());
				} else
					return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		/*
		 * for (Student s : lstud) { System.out.println(s); System.out.println(); }
		 */

		// TODO: sort the list using the zip code of the mailing address
		System.out.println("Sorted by zipcode of mailing address");

		Collections.sort(lstud, new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				if (o1.getMailingAddress().getZipcode() - o2.getMailingAddress().getZipcode() == 0) {
					return o1.getLastName().compareTo(o2.getLastName());
				} // TODO Auto-generated method stub
				else {
					return o1.getMailingAddress().getZipcode() - o2.getMailingAddress().getZipcode();
				}

			}
		});
		/*
		 * for (Student s : lstud) { System.out.println(s); System.out.println(); }
		 */
		// TODO: find a student(s) by the last name which contain a given string

		/*
		 * String str = "Patel"; List<Student> list1 = lstud; lstud.contains(); for
		 * (Student s : list1) { System.out.println(s); }
		 */
		System.out.println("LastName String Search");
		String word = "Kundeshwar";
		List<Student> l1 = lstud;
		for (Student s : l1) {
			if (s.getLastName().contains(word)) {
				// System.out.println(s);
			}

		}

		// TODO: create a set of students (may be five items) where unique student
		// should be defined by their
		// 1)last name, 2)first name and 3)permanent address

		System.out.println("Set that returns unique by lastname, firstname,permenant address");
		Set<Student> sSet = new HashSet<Student>();

		Map<String, Student> mStud = new HashMap<String, Student>();
		for (Student s : lstud) {
			String setUnique = s.getFirstName() + s.getLastName() + s.getPermanentAddress();
			if (!mStud.containsKey(setUnique)) {
				mStud.put(setUnique, s);
			}
		}

		Iterator mStudIterator = mStud.entrySet().iterator();
		while (mStudIterator.hasNext()) {
			Map.Entry pair = (Map.Entry) mStudIterator.next();
			sSet.add((Student) pair.getValue());
			//System.out.println(pair.getValue());

		}
		/*
		 * System.out.println(); for (Student s : sSet) { System.out.println(s); }
		 */

		// TODO: remove all of the addresses (may be set it to null) of all students and
		// return them in a list

		System.out.println("All address are null or deleted");
		List<Student> noAddress = new ArrayList<Student>();
		for (Student s : lstud) {
			Address a = new Address(0, null, null, null, 0);
			Student nos = new Student(s.getFirstName(), s.getLastName(), a, a);
			noAddress.add(nos);
		}

		System.out.println("Deleted Address");
		for (Student s : noAddress) {
			// System.out.println(s);
		}

		/*
		 * Iterator<Student> iSet = sSet.iterator(); while(iSet.hasNext()) { Student
		 * stud = iSet.next(); sSet.remove(stud);
		 * 
		 * }
		 */

	}

}
