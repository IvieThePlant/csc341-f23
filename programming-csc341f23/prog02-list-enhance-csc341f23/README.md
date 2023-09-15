### Programming Assignment 02 : LIST Feature Enhancements
#### Due Thursday, September 21 end-of-day
#### Submit a single zipped file to Moodle

In this lab, you will continue your work of the previous programming assignment on the ADT List.

> If your Assignment 02 is not functional, please let Dr. Larson know.

Learning Outcomes:

- Understand and implement the primary operations of a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

1. Complete the methods outlined below. These are in addition to those implemented in Programming Assignment 01.
2. Write tests for replace().
3. Document all code in List with Javadocs and with comments in the code (about every 3-4 lines).

<hr>

#### Javadocs Documentation

1. AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

1. When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser. Look for any missing or unprofessional looking documentation. Do not include implementation details in the documentation.

<hr>

### IMPLEMENTATION

> If your Programming Assignment 01 implementation is not complete, check with Dr. Larson before proceeding. If it is not yet complete, you probably do not want to duplicate the folder before it is finished.

Start the implementation by duplicating the folder prog01-list-csc341f23 in your working directory and renaming it prog02-list-enhancement-csc341f23. Pull the course repo to get 2 files: `StudentListContinued.java` and `TestProg02.java`. 

The first file includes stubs of all the methods that are required for this assignment. 

> Copy the NEW methods into the `StudentList.java` file. Please keep the methods organized, grouping together related behaviors. Setters and getters are typically placed at the bottom of any class file.

Copy over the `TestProg02.java`.

Implement the following methods. As before, the first element is at index 0 and the last is at count-1. When an element is removed, items to the right must be moved over. There should never be any gaps between items in the array.

#### REMOVE Methods

> When you remove an element, you have to shift elements to the left to fill the gap. As you do this, some elements will be left in the array after the count index. That is okay -- as long as the count is maintained properly, those elements will be ignored.

1. `Student remove(int index)` If index is valid, remove that element from the List and return it.

1. `boolean remove(Student student)` Return true if the student was found and removed. False otherwise.

1. `void clearAll()` Remove all elements from the List (changing the length will take care of this).

#### SEARCH Methods

1. `int find(Student student)` Return the index of the student that equals the passed student.

1. `boolean replace(Student s1, Student s2)` Replace student s1 with student s2. Return true of the student was found and replaced, false otherwise.
 
#### ADD Methods

1. `int addAll(Student[] array)` Add to the List as many elements of the array as possible, starting at index 0 of the passed array. Return the total number added to the List.

#### CONVERT Methods

1. `int toArray(Student[] array)`
    - If all of the elements in the List will fit into the array, then place them all and return the number of elements placed in the array.
    - If they do not all fit, do not place any faces in the array and return 0.
    - Assume that the array is empty and start to fill it at index 0.

1. `Student[] sublist(int start, int end)` 
    - If the start or end are not valid indices, return null.
    - Else, Create a new array that is the size of the sublist. Then add all of the elements from start to end (inclusive) into this new List.

<hr>

### UNIT TESTS

In the file `TestProg02.java` in the method `testReplace()` at the bottom of the file, write 4 tests to test the StudentList method `replace(Student s1, Student s2)`. These should cover the following cases:

These are the test cases:
- Student s1 is in the list - somewhere in the middle.
- Student s1 is in the list - at the first element.
- Student s1 is in the list - the last element.
- Student s1 is NOT in the list.


     

