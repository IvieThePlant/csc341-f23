## Lab 6 : Linked List of Students

Due: Tuesday, October 23 end-of-day

In this lab, you will again be creating the ADT List, except this time you will be implementing it using a linked list.


### GENERAL REQUIREMENTS

It is important that you comment your code. The Javadocs has been completed for you.

Keep your code style-compliant.

Keep your code CLEAN and organized.

It is your responsibility to test your code. 

```
Special Constraints: You may not use for loops. Only while loops. 
```

<hr>

#### LIST IMPLEMENTATION

Any method of a List should have the same behavior, regardless if implemented using an array or a linked list.

**Helper Functions**

- `public boolean isEmpty()` determines whether or not there are any items in the List.

- `@Override public String toString()` overrides Object method for printing.

**Constructors**

- `public List()` default constructor.


**Find Methods**

> Use the `equals` method to check for equality.
> Index 0 is the first element in the List.

- `public int find(Student student)` returns index of the first element that equals student or return -1 if not in List.

- `public Student get(int index)` returns array element at that index or null if index is not valid.


**Add Methods**

- `public void add(Student student)` adds that item to the end.

- `public void add(Student student, int index)` adds that student at the stated index or ignores the request if the index is not valid. The index is valid if there is currently a student at that index.


**Remove Methods**

- `public boolean remove(Student item)` Removes the first occurrence that is equal to student (use the `equals` method). Returns true if it was successfully removed, otherwise false.

- `public Student remove(int index)` Removes the student at that index (if the index is valid). Returns the student that was removed or null if nothing was removed.


**Conversion Methods**

- `Student[] toArray()` returns an array that contains the List elements. If the list is empty, return an EMPTY array. 

