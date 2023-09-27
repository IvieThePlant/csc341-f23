import java.util.*;

public class Comparing {

	public static void main(String[] args) {
	
	
		// Define a collection of courses
		Course mat202 = new Course("MAT",202,"Discrete");
		Course mat302 = new Course("MAT",302,"Discrete");
		Course mat165 = new Course("MAT",165,"Made it up");
		Course csc165 = new Course("CSC",165,"Python");
		Course csc170 = new Course("CSC",170,"Intro Java");
		Course csc341 = new Course("CSC",341,"Data Structures");

	
		// Compare these courses in various ways
		
		System.out.print("Both CSC165 -- Equal to each other?  ");
		System.out.println(csc165.equals(new Course("CSC",165,"Python too")));
		
		System.out.print("Both CSC165 one after the other?  ");
		System.out.println(csc165.compareTo(new Course("CSC",165,"Python too")));
		
		System.out.print("CSC165 before or after CSC170?  ");
		System.out.println(csc165.compareTo(csc170));
		
		System.out.print("CSC165 before or after MAT165?  ");
		System.out.println(csc165.compareTo(mat165));
		
		System.out.print("CSC341 before or after MAT165?  ");
		System.out.println(csc341.compareTo(mat165));
		
		System.out.print("CSC341 before or after MAT165?  ");
		System.out.println(byLevel.compare(csc341,mat165));
	}
	public static Course[] buildList(Course[] courses,Comparator<Course> orderBy) {

		// make a copy for the sorting process
		Course[] copy = new Course[courses.length];
		for (int i=0; i<courses.length; i++) {
			copy[i] = courses[i];
		}

		// create a new array to store the sorted list
		Course[] ordered = new Course[courses.length];

		// Move the contents of copy into ordered (in order according to orderBy)
		// Repeatedly find the minimum value and place in ordered.
		// Replace the element copied with null

		return ordered;
	}
}
