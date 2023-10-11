import java.util.Comparator;

/** A collection of Student objects listed in no particular order. */
public class StudentList {

    /** Comparator for ordering array. Uses compareTo of Student by default */
    private Comparator<Student> orderBy = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.compareTo(s2);
        }
    };

    /** Primary structure for storing the collection of Students */
    protected Student[] students;

    /** Default for maximum number of students that can be stored */
    protected static final int DEFAULT_CAPACITY = 100;

    /** The number of students stored in the array. */
    private int count = 0;

    // ____________________________________________________
    // CONSTRUCTORS
    // ____________________________________________________

    /**
     * Default Constructor, creates Student array of capacity 100
     * Uses default Comparator
     */
    public StudentList() {
        this(DEFAULT_CAPACITY);
        // orderBy is initialized above
    }

    /**
     * Creates Student array of given capacity
     * Uses default Comparator
     * 
     * @param capacity for Student array
     */
    public StudentList(int capacity) {
        students = new Student[capacity];
        // orderBy is initialized above
    }

    /**
     * Creates Student array of default capacity (100)
     * Uses given Comparator to order
     * 
     * @param order Comparator to sort Student array by
     */
    public StudentList(Comparator<Student> order) {
        this(order, DEFAULT_CAPACITY);
    }

    /**
     * Creates Student array of given capacity
     * Uses given Comparator to order
     * 
     * @param order    Comparator to sort Student array by
     * @param capacity for Sudent array
     */
    public StudentList(Comparator<Student> order, int capacity) {
        this(capacity);
        orderBy = order;
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
    // LIST STATUS METHODS
    // ____________________________________________________

    /**
     * Checks if StudentList is full
     * 
     * @return True if StudentList is full, else false
     */
    public boolean isFull() {
        return (count == students.length);
    }

    /**
     * Checks if StudentList is empty
     * 
     * @return True if there is 0 items in the list, else false
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Checks if given index is valid, meaning it is within range and has a student
     * at index
     * 
     * @param index The index to be checked in StudentList
     * @return True if in range and has student at index, else false
     */
    private Boolean isValid(int index) {
        return (index >= 0 && index < students.length && students[index] != null);
    }

    // ____________________________________________________
    // ADD METHODS
    // ____________________________________________________

    /**
     * Adds a student to the end of the list
     * 
     * @param student Student to be added to StudentList
     * @return True if added, else false
     */
    public boolean add(Student student) {
        // Add to Student array, maintaining list order using orderBy
        // Add only if it is not full. Return true/false for added/not added.
        if (isFull()) {
            return false;
        }
        // If array is empty, add at first index
        if (count == 0) {
            students[0] = student;
        } else {
            // Find first index with greater student, or count if no greater student found
            int idx = 0;
            while (orderBy.compare(students[idx], student) <= 0 && idx < count) {
                idx++;
            }

            // Insert student at idx, moving rest of objects to the right
            Student save1 = student;
            Student save2 = null;
            for (; idx < count; idx++) {
                save2 = students[idx];
                students[idx] = save1;
                save1 = save2;
            }
        }
        // Update count and return sucsess
        count++;
        return true;
    } // end add(Student)

    /**
     * COMMENTED OUT
     * Adds student at given index if valid. Previous student, as well as all
     * folowing students, get shifted over one
     * 
     * @param student Student to be added to StudentList
     * @param index   Index of desired location of student
     * @return True if added, else false
     * 
     *         public boolean add(Student student, int index) {
     *         // Add at index only if it is a valid index AND the array isn't full.
     *         // All elements must be shifted to make room for the new item.
     *         // HINT: start shifting at the end until you get to where you want to
     *         add
     *         // return true/false for added/not added.
     *         if (! isFull() && isValid(index)){
     *         Integer i = students.length - 1;
     *         while (i > index) {
     *         students[i] = students[i-1];
     *         i --;
     *         }
     *         count ++;
     *         students[index] = student;
     *         return true;
     *         }
     *         return false;
     * 
     *         } // end add(index,student)
     */

    /**
     * Takes given students and adds them as long StudentList has room
     * 
     * @param array Array of students to be added
     * @return Count of students from array added
     */
    public int addAll(Student[] array) {
        // Add only as many will fit in the List.
        // Add everything to the end of the List.
        // Return how many were added to the List.
        int added = 0;
        for (Student objStudent : array) {
            if (!isFull()) {
                add(objStudent);
                added++;
            }
        }
        return added;
    } // end addAll(array)

    // ____________________________________________________
    // SEARCH METHODS
    // ____________________________________________________

    /**
     * Attempts to find index of student with given username
     * 
     * @param uname Username of desired student
     * @return Index of fitst student with matching username, else -1 if not found
     */
    public int find(String uname) {
        // Determine the location of the specified student (its index)
        // Use the equals to match students.
        // Return -1 if it is not in the List
        for (int i = 0; i < count; i++) {
            if (isValid(i)) {
                if (uname.equals(students[i].username())) {
                    return i;
                }
            }
        }
        return -1;
    } // end find(uname)

    /**
     * Attempts to return student at given index
     * 
     * @param index Index of desired student
     * @return Desired student, else null if invalid index
     */
    public Student get(int index) {
        // Return the student at the given index, if index is valid
        // Return null if index invalid
        // Do not remove the Student, just return it
        if (isValid(index)) {
            return students[index];
        }
        return null;

    } // end get(index)

    /**
     * Attempts to find index of matching student
     * 
     * @param student Student being searched for
     * @return Index of student if found, else -1
     */
    public int find(Student student) {
        // look for a match using equals
        // return the location of the student (if found), else return -1
        for (int i = 0; i < count; i++) {
            if (student.equals(get(i))) {
                return i;
            }
        }
        return -1;
    } // end find(student)

    /**
     * Attempts to replace first student with second student
     * 
     * @param s1 Student to be replaced
     * @param s2 Student to replace with
     * @return True if replaced. False if s1 not found
     */
    boolean replace(Student s1, Student s2) {
        // find s1 in the List and replace with s2
        // Use your find method!
        int i = find(s1);
        if (i != -1) {
            students[i] = s2;
            return true;
        }
        return false;
    } // end replace(s1,s2)

    public int findBS(Student student) {
        // TODO
        // Use an iterative Binary Search to find the student.
        // Ordering is based on the Comparator.

        // Number of iterations = celing of x, where 2^x = count
        int iterations = (int) Math.ceil(Math.log(count));

        // Start with comparing whole list
        int start = 0;
        int end = count - 1;
        int mid;

        // Find the middle of our list. Compare student to value at middle
        // If value is larger
        while (iterations > 0) {
            mid = (start + end) / 2;
            if (orderBy.compare(student, students[mid]) == 0) {
                return mid;
            }
            if (orderBy.compare(student, students[mid]) < 0) {
                end = mid;
            }
            if (orderBy.compare(student, students[mid]) > 0) {
                start = mid + 1;
            }
            if (start > end) {
                return -1;
            }
        }
        return -1;
    }

    // ____________________________________________________
    // REMOVE METHODS
    // ____________________________________________________

    /**
     * Removes student at valid index, shifting all other students over to fill gap
     * 
     * @param index Index of student to be removes
     * @return Removed student. Null if index is not valid
     */
    public Student remove(int index) {
        // if the index is valid, remove the student and return it
        if (isValid(index)) {
            Student removeStudent = students[index];
            for (int i = index; i < count - 1; i++) {
                students[i] = students[i + 1];
            }
            students[count - 1] = null;
            count--;
            return removeStudent;
        }
        // if not valid, return null
        return null;
    } // end remove(index)

    /**
     * Removes given student
     * 
     * @param student Student to be removed
     * @return True if found. False if not found
     */
    public boolean remove(Student student) {
        // search for the student
        // if found, remove them and return true, else false
        // Use your find method and your other remove method!
        // no need to write the same code twice!
        int i = find(student);
        if (i != -1) {
            remove(i);
            return true;
        }
        return false;
    } // end remove(student)

    /**
     * Removes all students from array
     */
    public void clearAll() {
        // "remove" all elements from the list
        // no need to iterate -- just change the count!!
        // if you are really worried about elements left in the array,
        // you can always declare a new array and start fresh.
        count = 0;
        students = new Student[capacity()];
    } // end clearAll()

    // ____________________________________________________
    // CONVERT METHODS
    // ____________________________________________________

    /**
     * Creates a new array and copy the contents of the list into the array
     * 
     * @return New array, else null if
     */
    public Student[] toArray() {
        // create a new array and copy the contents of the list into the array
        // if the list is empty, return null;
        // else return an array of the exact length as the List
        if (!isEmpty()) {
            Student[] newArray = new Student[count];

            int numCopied = 0;
            int i = 0;
            while (numCopied < count) {
                newArray[numCopied] = students[i];
                numCopied++;
                i++;
            }
            return newArray;
        }
        return null;
    } // end toArray()

    /**
     * Attempts to put all List elements into array, but only if all will fit
     * 
     * @param toFill Array to fill with students
     * @return Number of students added to toFill
     */
    public int toArray(Student[] toFill) {
        // if all List elements fit in toFill, copy them into the array.
        // if they do not all fit, copy nothing.
        // return the number of elements copied into the toFill array.
        if (count <= toFill.length) {
            for (int i = 0; i < count; i++) {
                toFill[i] = students[i];
            }
            return count;
        }
        return 0;
    } // end toArray(toFill)

    /**
     * Creates a new sublist of StudentList
     * 
     * @param start starting index of sublist
     * @param end   ending index of sublist(inclusive)
     * @return New sublist as array. Null if start or end not valid
     */
    public Student[] sublist(int start, int end) {
        // if the indices are invalid, return null
        // create a new Student array the size of the sublist.
        // Copy elements from index start to end (inclusive) into the array.
        if (isValid(start) && isValid(end)) {
            Student[] newStudentArray = new Student[end - start + 1];
            for (int i = 0; i + start <= end; i++) {
                newStudentArray[i] = students[i + start];
            }
            return newStudentArray;
        }
        return null;
    } // end sublist(start,end)

    public Student[] sublist(String start, String end) {
        // TODO
        // Create an array of students (in order)
        // that fall between start and end EXCLUSIVE of these.
        // Use the Comparator to establish inclusion within the range.
        // return null if no values are in between
        Student s1 = new Student(start);
        Student s2 = new Student(end);
        sublist(s1, s2);
        return null;
    }

    public Student[] sublist(Student start, Student end) {
        // Create a new array to hold all the elements between start and end. 
        // You will have to search the list to determine the start and end index. 
        // The order is based on the Comparator. The students do not need to exist in the list! 
        // Importantly, you have to determine the size of the array, 
        // then iterate over the sublist elements again to put them into the new array 
        // (or better yet, use the other sublist method!). 
        // If there are no elements between, return null. 
        // This range is EXCLUSIVE of the start and the end values.

        // Try to quick find start and end indicies using find
        int startIdx = findBS(start);
        int endIdx = findBS(start);

        // If starting index wasn't found, find where the index WOULD be
        if(startIdx == -1) {
            boolean found = false;
            while(startIdx < count && !found) {
                if(orderBy.compare(students[startIdx+1], start) < 0) {
                    startIdx ++;
                } else {
                    found = true;
                }
            }
        }

        // If no values are greater than start, return null
        if(startIdx >= count-1) {
            return null;
        }

        // If ending index wasn't found, find where the index WOULD be
        if(endIdx == -1) {
            boolean found = false;
            while 
        }

        return null;
    }

    // ____________________________________________________
    // SETTERS AND GETTERS
    // ____________________________________________________

    public int count() {
        return count;
    }

    public int capacity() {
        return students.length;
    }

} // end class List
