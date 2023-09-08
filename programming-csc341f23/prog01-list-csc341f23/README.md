### Programming Assignment 01 : Building a LIST Abstract Data Type
#### Due Thursday, September 14 end-of-day
#### Submit a single zipped file to Moodle

In this programming assignment, you will begin to create a LIST Abstract Data Type (ADT) with the same functionality that is provided by the Java ArrayList<>. This will give you insight into how structures for data collections are implemented and how the choice of implementation impacts the efficiency with respect to both time and space.

In addition to learning about the List ADT, you will also be introduced to UNIT TESTING, which is the formal mechanism by which all commercial code is tested. Typically, one uses a formal framework that is built for the language being used. We will use a "homegrown" version for transparency and ease of use.

One distinction between ArrayList<> and what you are developing is the use of _Generics_, which is indicated by the "<>" symbols. This allows you as the user to store any type of object. In our implementation (for now), we will only be storing Student objects.

Look for "TODO" in the code, which highlights what you need to implement.

Learning Outcomes:

- Understand and implement the primary operations that add and find elements in a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

General Requirements:

- Complete the methods as outlined below.
- Run the tests to make sure the code is working.
- Document all code with Javadocs and compile the javadocs.

<hr>

### LISTS

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find, and sort elements. In your reading, they distinguish between a list, bag, and set. I make no such distinctions and refer to all of them as a List, but I will be specific in whether or not those elements are unique (i.e. a set) or in a sorted order. The operators applied to a list must be specified by the user, unlike with queues in which elements are added and removed from specific locations.

It is important to have a shared understanding of the list qualities and how the operators modify the list. For this lab:
- The list may have duplicate elements. 
- The list is not sorted.
- If positional information is not provided, the `add()` method will add after the last element in the list, as long as the list is not full.
- If positional information is provided, the `add()` method will add at the INDEX indicated, shifting elements to make room, as long as the index is valid.

#### Javadocs Documentation

AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:
  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  You can view the results by opening the index.html file in your browser.

#### ESSENTIALS and HELPERS

Implement the following ...

- `StudentList(int capacity)` constructor with a set capacity for data.
- `boolean isFull()` determines whether or not there is capacity for more faces.
- `boolean isEmpty()` determines whether or not there are any faces in the List.
- `boolean isValid(int index)` determines if the given index corresponds to an element stored in the List.

#### ADD Methods

- Implement the add method `boolean add(Student student)`.
    - If the structure is not full, add to the end of the list. (The _end_ of the list refers to the last element in the list.)
    - If the structure is full, ignore the request. Do not add anything to the list.
    - Maintain the count.

- Implement the add method `boolean add(Student student, int index)`.
    - If the index is invalid (i.e. there is not a current element at the specified index), ignore it. Do not add the face to the list.
    - If the structure is not full and the index is valid, add the element at the index indicated.
    - Shift all elements as appropriate BEFORE adding the element to make space for it.
    - If the structure is full, ignore the request. Do not add anything to the list.
    - Maintain the count.

<hr>

#### SEARCH Methods

- Implement the `Student get(int index)` method.
    - If the index is valid, return the element at that index. It should not be removed, just returned.
    - If the index is not valid, <del>print an error message and</del> return null.


- Implement the `Student find(String uname)` method.
    - If the student is in the list, return its index.
    - If the student is not in the list, return -1 (no error message required).

<hr>

#### CONVERT Methods

- Implement `Student[] toArray()`. It creates an array of the size of the number of elements stored. All elements are copied into the array in the order they appear in the List.

<hr>

#### Testing Your Work

Testing is an essentail part of coding. In this assignment, you will use the provided unit tests to ensure your code is working properly.

To run the tests, compile your code and run the TestList.java file. If you see any output on the screen that starts with "ERROR," then your code is wrong (or my tests are wrong, but I did check them, so I think they are good, but you can always ask to be sure!).

```
> javac *.java
> java TestList
```

<hr>

### Questions

Questions related to each programming assignment can be found on Google drive.

They are graded separately from the programming assignment and they are due AFTER the code is due.

<hr>

### Submit Code

Submit Code to Moodle, Turn in Submission Form in Class
Zip the folder and submit via Moodle. You can zip the folder by right clicking the icon and choosing to compress it.

Please complete the programming assignment submission form and hand that in at the next class period.

<hr>

### Assessment

You can earn a maximum of 5 points on this assignment. Here is the breakdown:

1/2 point for turning it in AND it compiles
1/2 point for Javadocs complete AND compiled (i.e. docs folder is submitted)
2 points for passing all the tests of constructor, status, get, and add(student)
2 points for passing all the tests of add(student, index), find, toArray(). 

There is no partial credit for code that is partially complete. A given method is correct only when it passes all the tests for that method. You may earn partial credit for methods that pass all the tests. For example, if you pass all the tests for all but 1 method in the list, you will get partial credit.





