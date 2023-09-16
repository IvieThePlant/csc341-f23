/** A collection of Student objects listed in no particular order. */
public class StudentList {

    /** Primary structure for storing the collection of Students */
    protected Student[] students;

    /** Default for maximum number of students that can be stored */
    protected static final int DEFAULT_CAPACITY = 100;

    /** The number of students stored in the array. */
    private int count = 0;

    // ____________________________________________________
    //              CONSTRUCTORS
    // ____________________________________________________

    /** Constructor creates List with user-specified capacity, or DEFAULT_CAPACITY if 0 or negative
     * @param size The capacity of the list (i.e. max number of elements)
     */
    public StudentList(int capacity) {
    	// TODO: create primary data structure for holding students
        if (capacity > 0) {
            this.students = new Student[capacity];
        } else {
            this.students = new Student[DEFAULT_CAPACITY];
        }
    }

    /** Default Constructor */
    public StudentList() {
        this(DEFAULT_CAPACITY);
    }

    // ____________________________________________________

    @Override
    public String toString() {
        // Create numbered list of students in the collection
        String printedList = "";
        for (int i = 0; i < count; i++) {
            printedList += (i + 1) + ". " + students[i].toString() + "\n";
        }
        return printedList;
    } // end toString()


    // ____________________________________________________
    //              LIST STATUS METHODS
    // ____________________________________________________

    /**
     *
     */
    public boolean isFull() {
        /** TODO: fix this (can be 1 line of code) */
        return (count == students.length);
    }

    /**
     *
     */
    public boolean isEmpty() {
        /** TODO: fix this (can be 1 line of code) */
        return (count == 0);
    }

    /**
     *
     */
    private Boolean isValid(int index) {
        /** TODO: fix this */
        return (index >= 0 && index < students.length && students[index] != null);
    }


    // ____________________________________________________
    //                   ADD METHODS
    // ____________________________________________________

    /**
    */
    public boolean add(Student student) {
    	/** TODO: write this */
        // Default location for adding a student is at the end of the array
        // Add only if it is not full. Return true/false for added/not added.
        if (! isFull()) {
            if (students[count] != null) {
                System.out.println("Student was at added position. Not good dudes. Not good. :(");
            }
            students[count] = student;
            count ++;
            return true;
        }
        return false;
    } // end add(Student)

    /**
    */
    public boolean add(Student student, int index) {
        /** TODO: write this */
        // Add at index only if it is a valid index AND the array isn't full.
        // All elements must be shifted to make room for the new item.
        // HINT: start shifting at the end until you get to where you want to add
        // return true/false for added/not added.
        if (! isFull() && isValid(index)){
            Integer i = students.length - 1;
            while (i > index) {
                students[i] = students[i-1];
                i --;
            }
            count ++;
            students[index] = student;
            return true;
        }
        return false;

    } // end add(index,student)

    // ____________________________________________________
    //                   SEARCH METHODS
    // ____________________________________________________

    /**
    */
    public int find(String uname) {
        /** TODO: write this */
        // Determine the location of the specified student (its index)
        // Use the equals to match students.
        // Return -1 if it is not in the List
        int i = 0;
        while (i < students.length) {
            if (students[i] != null) {
                if (uname.equals(students[i].username())) {
                    return i;
                }
            }
            i ++;
        }
        return -1;
    } // end locate()

    /**
    */
    public Student get(int index) {
        /** TODO: write this */
        // Return the student at the given index, if index is valid
        // Return null if index invalid
        // Do not remove the Student, just return it
        if (isValid(index)){
            return students[index];
        }
        return null;

    } // end get()

    // ____________________________________________________
    //                   CONVERT METHODS
    // ____________________________________________________

    /**
    */
    public Student[] toArray() {
        // TODO: write this
        // create a new array and copy the contents of the list into the array
        // if the list is empty, return null;
        // else return an array of the exact length as the List
        if (! isEmpty()) {
            Student[] newArray = new Student[count];
            
            int numCopied = 0;
            int i = 0;
            while(numCopied < count) {
                newArray[numCopied] = students[i];
                numCopied ++;
                i ++;
            }
            return newArray;
        }
        return null;
    } // end toArray()

    // ____________________________________________________
    //                   SETTERS AND GETTERS
    // ____________________________________________________

        public int count() {
            return count;
        }

        public int capacity() {
            return students.length;
        }

} // end class List
