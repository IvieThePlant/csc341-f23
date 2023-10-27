## Programming Assignem 6 - Binary Search Trees

DUE Thursday, October 26

In this lab, you will again create the Abstract Data Type List, except this time you will use a Binary Search Tree for implementation. The List will be storing elements of type Simple.

Learning Outcomes:
- Understand the structure of a binary tree.
- Understand the structure of a binary search tree.
- Know how to implement a binary search tree.
- Know how to implement a class that uses the Comparator interface.
- Use iteration to traverse a binary search tree.
- Use recursion to traverse a binary search tree.

> If you are searching for an element based on the ordering of the tree, then you can use binary search. However, if you need to access every element in the tree or perform a "linear" search, you must use recursion. This is the ONLY way to traverse the tree (unless you maintain your own stack, which we will not do until a few weeks from now).


<hr>


### General Requirements

Note that in this implementation, you will be using a "dummy" or sentinal node to mark the bottom of the tree. Use the SAME dummy node as both the left and right child of all leaf nodes.



1. `class Node`. Add a default constructor to the Node class.
2. `class Node`. Modify the constructor so that each child points to the dummy node.

1. Implementation for class List
- `void add(Simple value)`

- `String toString()` : Create a string of values in order

- `Simple get(Simple value)` : Use List ordering to find first match. Note that it will only match on the basis of the ordering. 

- `Simple find(String value)`: Use Binary Search to locate an element with the specified value. Return null if not in the List.

- `Simple find(Integer value)`: Use Binary Search to locate an element with the specified value. Return null if not in the List.

- `Simple min()` : based on order of tree

- `Simple max()` : based on order of tree

- `Simple[] toArray()` : place elements in the tree into the array IN SORTED ORDER. You cannot use any Java functions to do this for you. You must declare the array, and individually place each element into the array. **This is a challenging method to write! You have to keep track of where the next element is to be added. It will have to be passed around as you traverse the tree (recursively).

1. Javadocs: complete and polished for `class List`.
1. Code is commented in all methods of `class List`.
1. Code is style compliant.

It is your responsibility to make sure your code is working.

<hr>

### Resources 

- https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
- zyBooks reading assignment #07










