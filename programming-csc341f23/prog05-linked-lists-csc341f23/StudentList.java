/**
 * ADT List maintaining a List of Students. Order of the elements is preserved
 * with respect to where they were added to the List.
 */
public class StudentList {

  /** Reference to first element of the list. */
  private Node head;

  /** Reference to last element of the list. */
  private Node tail;

  /** Number of elements in the list. */
  private int count;

  /** Default constructor */
  public StudentList() {
    head = null;
    tail = null;
    count = 0;
  } // end StudentList()

  // ____________________ HELPERS

  /**
   * Reports status of List
   * 
   * @return True if StudentList empty, else false
   */
  public boolean isEmpty() {
    return count == 0;
  } // end isEmpty()

  /**
   * Checks if given index is valid (within bounds of StudentList)
   * 
   * @param index Index to validate
   * @return True if valid, else false
   */
  public boolean isValid(int index) {
    return (index >= 0 && index < count);
  } // end isValid(index)

  @Override
  /**
   * Uses recursion to display all values of StudentList
   * 
   * Returns a String with one value per line
   */
  public String toString() {
    return toSting(head);
  } // end toString()

  /**
   * Overloaded recursive toString only called by toString()
   * 
   * @param n Node to append to sting, plus next
   * @return String with one value per line
   */
  private String toSting(Node n) {
    if (n == tail) {
      return n.toString();
    } else {
      return n.toString() + "\n" + toSting(n.next);
    }
  } // end toString(n)

  // ____________________ FIND

  /**
   * Determine location of specified student (0-based indexing).
   * 
   * @param student searching for in List.
   * @return return location (0-based), or -1 if not in list
   */
  public int find(Student student) {
    // Iterate through Nodes until student is found, or tail is reached
    int idx = 0;
    Node pointer = head;
    while (!pointer.student.equals(student) && pointer != tail) {
      idx++;
      pointer = pointer.next;
    }
    // Check tail
    if (tail.student.equals(student)) {
      return idx;
    } else {
      return -1;
    }
  }

  /**
   * Retrieve student at specified index, without removing it.
   * 
   * @param index Location within the list (0-based indexing)
   * @return if index valid, return element at that position, else null
   */
  public Student get(int index) {
    // Check validity
    if (!isValid(index)) {
      return null;
    }
    // Set pointer at head and move index number of times
    Node pointer = head;
    while (index > 0) {
      pointer = pointer.next;
      index--;
    }
    return pointer.student;
  } // end get(index)

  // ____________________ ADD

  /**
   * Add specified item to the end of the List.
   * 
   * @param student added to the List.
   */
  public void add(Student student) {
    Node n = new Node(student);
    tail.next = n;
    tail = n;
    count++;
  } // end add(student)

  /**
   * Add specified student to the List at specified location (if index valid)
   * 
   * @param index   Location within the List (0-based indexing)
   * @param student to be added to the List
   * @return true if item added, else false.
   */
  public boolean add(Student student, int index) {
    if (!isValid(index)) {
      return false;
    }

    Node newNode = new Node(student);

    // If empty, add value
    if (isEmpty()) {
      add(student);
      return true;
    }

    // Set pointer at head and move index number of times
    Node pointer = head;
    while (index > 0) {
      pointer = pointer.next;
      index--;
    }

    return false;
  }

  // ____________________ REMOVE

  /**
   * Remove specified item if in the List
   * 
   * @param item Removed from the List (if in the List)
   * @return if item removed, return true, else false
   */
  public boolean remove(Student item) {
    // TODO: Write remove(item)
    return false;
  }

  /**
   * Remove item at specified index (if index valid)
   * 
   * @param index Location with List (0-based indexing)
   * @return if index valid, return element at that index.
   */
  public Student remove(int index) {
    // TODO: Write remove(index)
    return null;
  }

  // ____________________ CONVERT

  /**
   * Place List items into a new array.
   * 
   * @return array of List items of the same length as elements in the array
   */
  public Student[] toArray() {
    // TODO: Write toArray()
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
