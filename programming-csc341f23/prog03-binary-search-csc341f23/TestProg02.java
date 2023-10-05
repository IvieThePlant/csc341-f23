//import java.lang.reflect.*;
//import java.util.Scanner;
//import java.io.*;

public class TestProg02 extends Assert {

	static Student s0 = new Student("s00");
	static Student s1 = new Student("s01");
	static Student s2 = new Student("s02");
	static Student s3 = new Student("s03");
	static Student s4 = new Student("s04");
	
	public static void assertEquals(Student expect, Student result, String msg) {
		boolean match = true;
		// First test for nulls to avoid Exceptions
		if ((null==expect) && (null!=result)) {
			match = false;
		} else if ((null==expect) && (null==result)) {
			match = true;
		} else {
			match = (expect.equals(result));
		}
		if (!match) {
			System.out.println(msg+".\n   Expect "+expect+".\n   Result "+result);
		}}

	public static void main(String[] args) {

		// Initial add() and get() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), get() needs to be correct to confirm student was added.
		* To test get(), add() needs to be correct to confirm location of student.
		*/

		System.out.println("\n\nSanity check test of add, count, get.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		StudentList students = new StudentList(5);
		students.add(s1);
		assertEquals(1,students.count(),"First Add (count)");
		assertEquals(s1,students.get(0),"First Add (s1)");
		System.out.println("\nSanity Check complete!");
		/* Once the above are confirmed to be working, the rest of the testing can proceed.
		*/

		
		try {
			testConstructorGetters();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructor!!\n\n");
		}
		
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}

		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
		try {
			testReplace();
		} catch(Exception e) {
			System.out.println("\n\nREPLACE THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		
	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing StudentList constructor ...");

		StudentList students;

		// Test default constructor and getters
		students = new StudentList();
		assertEquals(100, students.capacity(), "StudentList() capacity");
		assertEquals(0, students.count(), "StudentList() count");
		assertEquals(true, students.isEmpty(), "StudentList() empty");

		// Test constructor with size parameter
		students = new StudentList(5);
		assertEquals(0, students.count(), "StudentList(5) count");
		assertEquals(5, students.capacity(), "StudentList(5) capacity");
		assertEquals(true, students.isEmpty(), "StudentList(5) isEmpty");

		// Test count getter (tested at 0 above)
		students.add(s1);
		assertEquals(1,students.count(),"count()");
		students.add(s2);
		assertEquals(2,students.count(),"count()");

		// Test empty and null.
		students = new StudentList(3);
		assertEquals(false, students.isFull(), "test full when empty");
		assertEquals(true, students.isEmpty(), "test empty when empty");

		students.add(s1);
		assertEquals(false, students.isFull(), "test full - 1 of 3");
		assertEquals(false, students.isEmpty(), "test empty - 1 of 3");

		students.add(s1);
		students.add(s1);
		assertEquals(true, students.isFull(), "test full - 3 of 3");
		assertEquals(false, students.isEmpty(), "test empty - 3 of 3");

		// test count getter when full
		assertEquals(3,students.count(),"count()");

	} // end testConstructorGetters

	/* __________________________________________________________________ */
	public static void testSearches() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing StudentList search methods ...");

		StudentList students;

		Student s = new Student("userx");

		students = new StudentList(5);
		students.add(s0);
		students.add(s1);
		students.add(s2);

		System.out.println("------------testing get()");
		assertEquals(s0,students.get(0),"get at index 0");
		assertEquals(s1,students.get(1),"get at index 1");
		assertEquals(s2,students.get(2),"get at index 2");
		assertEquals(null,students.get(3), "get invalid >count");
		assertEquals(null,students.get(5), "get invalid >count");
		assertEquals(null,students.get(-1), "get invalid -1");

		System.out.println("------------Testing find(uname)");
		assertEquals(0, students.find("s00"), "locate first");
		assertEquals(1, students.find("s01"), "locate middle");
		assertEquals(2, students.find("s02"), "locate last");
		assertEquals(-1, students.find("s"), "locate but not in StudentList");
		
		System.out.println("------------Testing find(Student)");
		assertEquals(0, students.find(s0), "locate first");
		assertEquals(1, students.find(s1), "locate middle");
		assertEquals(2, students.find(s2), "locate last");
		assertEquals(-1, students.find(s4), "locate but not in StudentList");

	} // end testSearches

	/* __________________________________________________________________ */
	public static void testAdds() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing StudentList add methods ...");

		StudentList students;

		System.out.println("--------------add(Student)");
		students = new StudentList(3);

		// 0 of 3 added
		assertEquals(0,students.count(),"pre-add (count)");
		// adding 1 of 3
		students.add(s0);
		assertEquals(1,students.count(),"add first (count)");
		assertEquals(s0,students.get(0),"add first (value)");
		// adding 2 of 3
		students.add(s1);
		assertEquals(2,students.count(),"add 2nd (count)");
		assertEquals(s1,students.get(1),"add 2nd (value)");
		// adding 3 of 3
		students.add(s2);
		assertEquals(3,students.count(),"add to capacity (count)");
		assertEquals(s2,students.get(2),"add to capacity (value)");
		// attempt add 4 of 3
		students.add(s3);
		assertEquals(3,students.count(),"add attempt over capacity (count)");
		assertEquals(s2,students.get(2),"add attempt over capacity (value)");


		System.out.println("--------------add(student,index)");
		students = new StudentList(6);

		// attempt to add at 0 in empty array. it should fail to add.
		students.add(s1,0);
		assertEquals(0,students.count(),"attempt add to empty - invalid index (count)");

		// add 2 of 6
		students.add(s0);	// s0 should now be in list
		students.add(s1,1);	// again failing to add
		assertEquals(1,students.count(),"attempt add at 1 (count)");
		assertEquals(s0,students.get(0),"attempt add at 1 (value)");
		assertEquals(null,students.get(1),"attempt add at 1 (2nd null song)");
				
		students.add(s1,0); // order should be s1, s0
		assertEquals(2,students.count(),"add at 0 (count)");
		assertEquals(s1,students.get(0),"add at 0 (value)");
		assertEquals(s0,students.get(1),"add at 0 (2nd song)");

		// test invalid indices
		students.add(s4,-1);
		assertEquals(2,students.count(),"add at -1 (count)");
		students.add(s4,5);
		assertEquals(2,students.count(),"add beyond last (count)");
		
		System.out.println("--------------addAll()");
		students = new StudentList(8);

		Student[] toAdd = {s0,s1,s2};
		int total;

		total = students.addAll(toAdd);
		assertEquals(3,students.count(),"addAll to empty");
		assertEquals(3,total,"addAll added to empty");

		total = students.addAll(toAdd);
		assertEquals(6,students.count(),"addAll 3 to 3");
		assertEquals(3,total,"addAll added 3 of 3");

		// cannot add them all
		total = students.addAll(toAdd);
		assertEquals(8,students.count(),"addAll 3 to 6");
		assertEquals(2,total,"addAll added 2 of 3");

		// cannot add any
		total = students.addAll(toAdd);
		assertEquals(8,students.count(),"addAll 3 to 8");
		assertEquals(0,total,"addAll added 0 of 3");

	}
	
	/* __________________________________________________________________ */
	public static void testRemoves() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing StudentList remove methods ...");

		// This assumes add, length is working.

		StudentList students;

		System.out.println("--------------remove(index)");
		students = new StudentList(6);
		students.add(s0);
		students.add(s1);
		students.add(s2);
		students.add(s3);

		Student removed;

		// attempt remove invalid
		removed = students.remove(4);
		assertEquals(4,students.count(),"remove invalid (length)");
		assertEquals(null,removed,"remove invalid (value)");

		// attempt remove invalid (-1)
		removed = students.remove(-1);
		assertEquals(4,students.count(),"remove [-1] (length)");
		assertEquals(null,removed,"remove [-1] (value)");		

		// remove middle (s1) == {s0,s2,s3}
		removed = students.remove(1);
		assertEquals(3,students.count(),"remove middle (length)");
		assertEquals(s1,removed,"remove middle (value)");
		
		// remove last (s3) == {f0,f2}
		removed = students.remove(2);
		assertEquals(2,students.count(),"remove last (length)");
		assertEquals(s3,removed,"remove last (value)");

		// remove first (s0) == {s2}
		removed = students.remove(0);
		assertEquals(1,students.count(),"remove first (length)");
		assertEquals(s0,removed,"remove first (value)");

		// remove only (s2)
		removed = students.remove(0);
		assertEquals(0,students.count(),"remove only (length)");
		assertEquals(s2,removed,"remove only (value)");
	


		System.out.println("--------------remove(Student)");
		students = new StudentList(6);
		students.add(s0);
		students.add(s1);
		students.add(s2);
		students.add(s3);

		Boolean isRemoved;

		// attempt remove not in list
		isRemoved = students.remove(s4);
		assertEquals(4,students.count(),"remove not in (length)");
		assertEquals(false,isRemoved,"remove not in (return)");		

		// remove middle (s1) == {s0,s2,s3}
		isRemoved = students.remove(s1);
		assertEquals(3,students.count(),"remove middle student (length)");
		assertEquals(true,isRemoved,"remove middle student (value)");
		
		// remove last (s3) == {s0,s2}
		isRemoved = students.remove(s3);
		assertEquals(2,students.count(),"remove last student (length)");
		assertEquals(true,isRemoved,"remove last student (value)");

		// remove first (s0) == {s2}
		isRemoved = students.remove(s0);
		assertEquals(1,students.count(),"remove first student (length)");
		assertEquals(true,isRemoved,"remove first student (value)");

		// remove only (s2)
		isRemoved = students.remove(s2);
		assertEquals(0,students.count(),"remove only student (length)");
		assertEquals(true,isRemoved,"remove only student (value)");

		System.out.println("--------------clearAll()");
		students = new StudentList(6);
		students.add(s0);
		students.add(s1);
		students.add(s2);
		students.add(s3);	
		
		students.clearAll();
		assertEquals(0,students.count(),"remove all (length)");
		
		students.clearAll();
		assertEquals(0,students.count(),"remove all empty (length)");


	}

	/* __________________________________________________________________ */
	public static void testConvert() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing StudentList convert methods ...");

		StudentList students;
		Student[] array;

		System.out.println("--------------Testing toArray()");
		students = new StudentList(4);
		if (null!=students.toArray()) {
			System.out.println(
			"ERROR: toArray empty StudentList. Expect null. Results not null.");
		}

		students.add(s0);
		array = students.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 1 element. Returns null.");
		} else {
			assertEquals(1,array.length,"toArray 1 element (count)");
			assertEquals(array[0], s0, "toArray 1 element (value)");
		}

		students.add(s1);
		array = students.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 2 elements. Returns null.");
		} else {
			assertEquals(2,array.length,"toArray 2 elements (count)");
			assertEquals(array[0], s0, "toArray 2 elements (student 0)");
			assertEquals(array[1], s1, "toArray 2 elements (student 1)");
		}
		
		System.out.println("--------------Testing toArray(array)");
		students = new StudentList(6);
		Student[] toFill = new Student[4];
		int added;
		
		// List empty. nothing in toArray
		added = students.toArray(toFill);
		assertEquals(0,added,"fill with empty list");

		students.add(s0);
		students.add(s1);
		students.add(s2);

		added = students.toArray(toFill);
		assertEquals(3,added,"fill with 3");

		students.add(s0);

		added = students.toArray(toFill);
		assertEquals(4,added,"fill with 4 to cap");
		assertEquals(s0,toFill[0],"filled f0 at 0");

		students.add(s1);
		
		added = students.toArray(toFill);
		assertEquals(0,added,"fill array too small");

		System.out.println("--------------Testing sublist()");
		students = new StudentList(5);
		Student[] result;

		students.add(s0);
		students.add(s1);
		students.add(s2);
		students.add(s3);

		result = students.sublist(0,3);
		assertEquals(4,result.length,"copy all 4 (length)");
		assertEquals(s0,result[0],"copy all 4 (value)");

		result = students.sublist(0,0);
		assertEquals(1,result.length,"copy first (length)");
		assertEquals(s0,result[0],"copy first (value)");

		result = students.sublist(3,3);
		assertEquals(1,result.length,"copy last (length)");
		assertEquals(s3,result[0],"copy last (value)");

		result = students.sublist(1,2);
		assertEquals(2,result.length,"copy middle (length)");
		assertEquals(s1,result[0],"copy middle (value)");
		
		result = students.sublist(1,5);
		if (result != null) {
			System.out.println("Expected null. Actual "+result+" (invalid index)");
		}

	} // end testConvert
	
	/* __________________________________________________________________ */
	public static void testReplace() {
		System.out.println("\n\n_________________________________________");
	
		// TODO: Write 4 tests
		//- Student s1 is in the list - somewhere in the middle.
		//- Student s1 is in the list - at the first element.
		//- Student s1 is in the list - the last element.
		//- Student s1 is NOT in the list.
		System.out.println("------------Testing replace(Student, Student)");
		
		StudentList students = new StudentList(5);
		students.add(s0);
		students.add(s1);
		students.add(s2);
		students.add(s3);

		assertEquals(true, students.replace(s1, s4), "replace middle");
		assertEquals(true, students.replace(s0, s1), "replace first");
		assertEquals(true, students.replace(s3, s0), "replace end");
		assertEquals(false, students.replace(s3, s1), "replace NOT in list");


		
	} // end testReplace
} // end class Main