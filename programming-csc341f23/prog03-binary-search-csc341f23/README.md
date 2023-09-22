### Programming Assignment 03 : LIST Binary Search
#### Due Monday, October 2 end-of-day (link open until Tuesday, end-of-day)
#### Submit a single zipped file to Moodle

In this lab, you will continue your work of the previous programming assignment on the ADT List. The important distinction is that the list will now be maintained in order according to the comparator.

Learning Outcomes:

- Understand how to maintain an ordered list.
- Understand how binary search is significantly more efficient than linear search.
- Be able to implement binary search.
- Be able to implement the compareTo method and create a Comparator.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

1. Complete the methods outlined below. These are in addition to those implemented in Programming Assignment 02.
2. Write a comparator for Student that sorts based on name.
3. Write the compareTo method for Student that sorts based on uname.
4. Document all code in List with Javadocs and with comments in the code (about every 3-4 lines).

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

Start the implementation by duplicating the folder prog02-list-csc341f23 in your working directory and renaming it prog03-bst-csc341f23. Pull the course repo to get the file: `binsearch.java`. 

The file includes stubs of all the methods that are required for this assignment. 

> Copy the NEW methods into the `StudentList.java` file. Please keep the methods organized, grouping together related behaviors. Setters and getters are typically placed at the bottom of any class file.

Implement the following methods. As before, the first element is at index 0 and the last is at count-1. When an element is removed, items to the right must be moved over. There should never be any gaps between items in the array.

> IMPORTANTLY, now the list must be maintained in order according to the compare method of the comparator defined for the Student class.

#### Binary Search Method

**Binary Search follows a repeated pattern of looking at the middle of a subarray and determining if the element has been found, and if not, looking in a smaller subarray to the right or left of the middle element.**

1. `int findBS(Student student)` Locate the student using the technique of Binary Search. Return its location (index) or -1 if it is not present.

 
#### ADD Methods

1. The `add(Student)` method needs to be modified so that the order of the list is maintained based on the compare method of the comparator.

**The `add(student, index)` method is no longer viable since the list is ordered. Comment it out.**

#### CONVERT Methods
    
1. `Student[] sublist(Student start, Student end)`
    Create a new array to hold all the elements between start and end. You will have to search the list to determine the start and end index. The order is based on the Comparator. The students do not need to exist in the list! Importantly, you have to determine the size of the array, then iterate over the sublist elements again to put them into the new array (or better yet, use the other sublist method!). If there are no elements between, return null.

	This range is EXCLUSIVE of the start and the end values.

#### Student Comparison

1. Write the compareTo() method for the Student class based on username.

1. Write a Comparator for the Student class based on the name.

<hr>


     

