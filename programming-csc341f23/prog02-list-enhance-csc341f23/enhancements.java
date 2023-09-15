/** A collection of Student objects listed in no particular order. */
public class StudentList {

    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

	public int addAll(Student[] array) {
	
		// Add only as many will fit in the List.
		// Add everything to the end of the List.
		// Return how many were added to the List.
		return 0;
	} 
	
	// ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

	public int find(Student student) {
		// look for a match using equals
		// return the location of the student (if found), else return -1
		return -1;
	}
	
	// ____________________________________________________
    //                   REMOVE METHODS
    // ____________________________________________________

	public Student remove(int index) {
	
		// if the index is valid, remove the student and return it
		// if not valid, return null
		return null
	}
	
	public boolean remove(Student student) {
	
		// search for the student
		// if found, remove them and return true, else false
		// Use your find method and your other remove method!
		//    no need to write the same code twice!
		return false;
	}
	
	public void clearAll() {
	
		// "remove" all elements from the list
		// no need to iterate -- just change the count!!
		// if you are really worried about elements left in the array,
		// you can always declare a new array and start fresh.
	}
	
	
	// ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

	public int toArray(Student[] toFill) {
		// if all List elements fit in toFill, copy them into the array.
		// if they do not all fit, copy nothing.
		// return the number of elements copied into the toFill array.
		return 0;
	}
	
	public Student[] sublist(int start, int end) {
		// if the indices are invalid, return null
		// create a new Student array the size of the sublist.
		// Copy elements from index start to end (inclusive) into the array.
		return null;
	}
}
	
