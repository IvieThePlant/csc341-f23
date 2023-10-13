/**
ADT List maintaining a List of Students. Order of the elements is preserved with respect to where they were added to the List.
 */
public class StudentList {

  /** Reference to first element of the list. */
  private Node head = null;

  /** Reference to last element of the list. */
  private Node tail = null;
  
  /** Number of elements in the list. */
  private int count = 0;


  /** Default constructor */
  public StudentList() {

  }

  // ____________________ HELPERS

  /** Reports status of List. */
  public boolean isEmpty() {
    return true;
  }
  
  public boolean isValid() {
  	return false;
  }

  @Override
  public String toString() {
  	// TODO: complete this code
    return null;
  }

  // ____________________ FIND

  /** Determine location of specified student (0-based indexing).
  * @param student searching for in List.
  * @return return location (0-based), or -1 if not in list
  */
  public int find(Student student) {
    return -1;
  }

  /** Retrieve student at specified index, without removing it.
  @param index Location within the list (0-based indexing)
  @return if index valid, return element at that position, else null
  */
  public Student get(int index) {
    return null;
  }

  // ____________________ ADD

  /** Add specified item to the end of the List.
  * @param student added to the List.
  */
  public void add(Student student) {

  }

  /** Add specified student to the List at specified location (if index valid)
  @param index Location within the List (0-based indexing)
  @param student to be added to the List
  @return true if item added, else false.
  */
  public boolean add(Student student, int index) {

    return false;
  }


  // ____________________ REMOVE

  /** Remove specified item if in the List
  * @param item Removed from the List (if in the List)
  * @return if item removed, return true, else false
  */
  public boolean remove(Student item) {
    return false;
  }

  /** Remove item at specified index (if index valid)
  @param index Location with List (0-based indexing)
  @return if index valid, return element at that index.
  */
  public Student remove(int index) {
    return null;
  }


  // ____________________ CONVERT

  /** Place List items into a new array.
  * @return array of List items of the same length as elements in the array
  */
  public Student[] toArray() {
    return new Student[0];
  }

  // ____________________ NODE class _______________________
  // _______________________________________________________

  /** Node for a singly linked list */
  private class Node {
    // Hold a List item
    Student student;
    // Reference to the next element in the list.
    Node next;

    // Only constructor for a new Node
    Node(Student s) {
      student = s;
    }
  }
}
