
# Programming Assignment 04 : LIST Sorting and Recursive Binary Search

## Due Thursday, October 12 end-of-day (link open until Friday, end-of-day)

## Submit a single zipped file to Moodle

In this lab, you will continue your work of the previous programming assignment on the ADT List and Binary Search. The important distinction is that you will use recursion to implement Binary Search and you will give the user the opportunity to reorder according to a different criteria.

Learning Outcomes:

- Understand how to maintain an ordered list.
- Understand how binary search is significantly more efficient than linear search.
- Be able to implement binary search using recursion.
- Be able to implement a sorting algorithm
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

### Getting Started

General Requirements:

- Complete the methods outlined below. These are in addition to those implemented in Programming Assignment 03.
- Document all code in List with Javadocs and with comments in the code (about every 3-4 lines).
- Code must be STYLE COMPLIANT according to Google style guide.

#### Java Style Compliance

Organizations establish rules about how to style your code. The style rules might discuss whitespace, variable naming conventions, curly brace placement, etc. In this lab (and all labs going forward), your code should be compliant with the Google Java style guide.

<https://google.github.io/styleguide/javaguide.html>

In particular, you should:

- Use camelCase for variable and method names.
- Use capitalized CamelCase for classes.
- Use ALL CAPITALS for constants or enumerated types.
- Do not leave extra whitespace (or extra blank lines except to ease readability)
- Always use curly braces for if-else statements.
- Curly braces for the `else` portion should look like this: `} else {`
- Use @Override where appropriate
- Check error or special conditions FIRST in any method and return. Do not use if-else statements to distinguish an error condition (e.g. invalid index) versus a valid index.

Also make sure your code is CLEAN, nicely organized, and well commented.

- Remove all TODOs, unless it is something you still need to do.
- Keep methods structured in this general order:
  - member variable declarations and definitions
  - constructors
  - helper functions (e.g. toString)
  - primary methods
  - setters and getters
- Group similar methods together.

### IMPLEMENTATION

Start the implementation by duplicating the folder prog03-bst-csc341f23 in your working directory and renaming it prog04-sort-csc341f23.

#### Recursive Binary Search Method

**Binary Search follows a repeated pattern of looking at the middle of a subarray and determining if the element has been found, and if not, looking in a smaller subarray to the right or left of the middle element.**

1. Create the method `int findRecurse(Student student)` Locate the student using the technique of Binary Search. This method must call a function that uses recursion. Return its location (index) or -1 if it is not present.

#### Ordering Methods

1. Create the method `public void reorder(Comparator<Student> order)`, which is a setter for orderBy. ADDITIONALLY, you must reorder the list based on this new Comparator.

1. Create the method `public Student min()` that returns the min value according to the current ordering. DO NOT ITERATE over the list to find this value -- it is not necessary.

1. Create the method `public Student max()` that returns the max value according to the current ordering. DO NOT ITERATE over the list to find this value -- it is not necessary.

1. Create the method `public Student min(Comparator<student> order)` that returns the min value according to the passed Comparator.

1. Create the method `public Student max(Comparator<student> order)` that returns the max value according to the passed Comparator.

#### CONVERT Methods

1. Create the method `public Student[] toArray(Comparator<Student> order)`. Return an array with the values in the List. This array should be ordered (sorted) according to the passed Comparator.

1. Create the method `public Student[] findAll(String major)`. Return all the students in the list who have the specified major.

#### Javadocs Documentation

1. AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

1. When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the Lab02 folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:

  ```java
  mkdir docs
  cd docs
  javadoc ../*.java
  ```

  You can view the results by opening the index.html file in your browser. Look for any missing or unprofessional looking documentation. Do not include implementation details in the documentation.

Note From Ivie: A markdown file linting extension which I have installed detected formatting mistakes within this file, so I went ahead and fixed them. While my linting extension pointed out the mistakes, and provided reference to the formatting rules they were violating, I fixed these mistakes myself, without use of an automated program.
