/** A collection of Student objects listed in no particular order. */
public class StudentList {

	// Add this member variable at the top of the file
	/** Comparator for ordering array. Uses compareTo of Student by default */
	private Comparator<Student> orderBy = new Comparator<Student>() {
    	@Override
    	public int compare(Student s1, Student s2) {
        	return s1.compareTo(s2);
    	}
	};
	
	// ____________________________________________________
    //                 CONSTRUCTORS
    // ____________________________________________________

	// REDO your constructors so that you have these 4 implemented
	// Do not forget to add Javadocs comments
	
    public StudentList() {
        this(DEFAULT_CAPACITY);
        // orderBy is initialized above
    }
    
    public StudentList(int capacity) {
        students = new Student[capacity];
    	// orderBy is initialized above
    }

    public StudentList(Comparator<Student> order) {
    	this(order, DEFAULT_CAPACITY);
    }
    
 	public StudentList(Comparator<Student> order, int capacity) {
 		this(capacity);
        orderBy = order;
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

	// MODIFY add(Student) to maintain order.
	// Order is based on the compare method of the Comparator.
	
	// REMEMBER TO Comment Out add(Student,int)
	

	// ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

	public int findBS(Student student) {
		// Use an iterative Binary Search to find the student.
		// Ordering is based on the Comparator.
		return -1;
	}
	
	
	// ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________


	public Student[] sublist(String start, String end) {
		// Create an array of students (in order)
		// that fall between start and end EXCLUSIVE of these.
		// Use the Comparator to establish inclusion within the range.
		// return null if no values are in between
		return null;
	}
}
	
